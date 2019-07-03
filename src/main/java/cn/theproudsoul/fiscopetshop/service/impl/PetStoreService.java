package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.Order;
import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.entity.PetExtra;
import cn.theproudsoul.fiscopetshop.entity.User;
import cn.theproudsoul.fiscopetshop.repository.PetExtraRepository;
import cn.theproudsoul.fiscopetshop.repository.UserRepository;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.tuples.generated.Tuple7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PetStoreService {
    @Autowired
    private ContractService contractService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PetExtraRepository petExtraRepository;

    public boolean isAdmin() throws Exception {
        if (contractService.getAccountContract().isAdmin().send().isStatusOK())
            return true;
        else {
            log.info("不是管理员用户");
            return false;
        }
    }


    public User getUserInfoByAddress(String address){
        User user = userRepository.findByAddress(address);
        try {
            user.setCredit(contractService.getAccountContract().balanceOf(address).send().intValue());
        } catch (Exception e) {
            log.info("根据地址获取用户积分失败！");
        }
        return user;
    }

    public Order getOrderByOrderId(String orderIndex){
        Order order = new Order();
        order.setId(orderIndex);
        try {
            Tuple7<String, String, BigInteger, BigInteger, BigInteger, String, String> order_tuple = contractService.getTransactionContract().getRecordById(new BigInteger(orderIndex)).send();
            order.setPet(getPetByPetId(String.valueOf(order_tuple.getValue3())));
            order.setPrice(order_tuple.getValue4().intValue());

            order.setSeller(getUserInfoByAddress(order_tuple.getValue2()));
            order.setBuyer(getUserInfoByAddress(order_tuple.getValue1()));
            order.setStatus(order_tuple.getValue5().intValue());
            order.setDate(order_tuple.getValue6());
        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    public List<Order> getOrdersByOrderId(List<BigInteger> orderIndex){
        List<Order> orderList = new ArrayList<>();
        for(BigInteger i: orderIndex){

            orderList.add(getOrderByOrderId(String.valueOf(i)));
        }
        return orderList;
    }

    public Pet getPetByPetId(String petIndex){
        Pet pet = new Pet();
        pet.setPetId(petIndex);
        try {
            Tuple7<Boolean, BigInteger, BigInteger, String, String, String, String> pet_tuple = contractService.getPetMarketContract().getPetById(new BigInteger(petIndex)).send();
            pet.setBirthday(pet_tuple.getValue5());
            pet.setName(pet_tuple.getValue4());
            pet.setStatus(pet_tuple.getValue1());
            pet.setPrice(pet_tuple.getValue3().intValue());
            pet.setUpTime(pet_tuple.getValue7());
            pet.setDescription(pet_tuple.getValue6());
            pet.setSpecies(pet_tuple.getValue2().intValue());
            PetExtra petExtra = petExtraRepository.findByPetName(pet_tuple.getValue4());
            pet.setImgUrl(petExtra.getImgUrl());
            pet.setRemark(petExtra.getRemark());
            // 获取owner地址
            String ownerAddress = contractService.getPetMarketContract().petOwner(new BigInteger(petIndex)).send();
            if (ownerAddress!=null){
                User owner = userRepository.findByAddress(ownerAddress);
                owner.setCredit(contractService.getAccountContract().balanceOf(ownerAddress).send().intValue());
                pet.setOwner(owner);
            } else {
                log.info("宠物主人查找失败");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return pet;
    }

    public List<Pet> getPetsByPetId(List<BigInteger> petIndex){
        List<Pet> petList = new ArrayList<>();
        for(BigInteger i: petIndex){
            petList.add(getPetByPetId(String.valueOf(i)));
        }
        return petList;
    }

    public JSONObject userJSON(User user) {
        JSONObject userJSON = new JSONObject();
        userJSON.put("id",user.getId());
        userJSON.put("name", user.getUserName());
        userJSON.put("credit",user.getCredit());

        return userJSON;
    }

    public JSONObject petJson(Pet pet){
        JSONObject petJson = new JSONObject();
        petJson.put("id",pet.getPetId());
        petJson.put("name",pet.getName());
        petJson.put("species",String.valueOf(pet.getSpecies()));
        petJson.put("status",String.valueOf(pet.isStatus()));
        if (pet.isStatus()){
            petJson.put("price", String.valueOf(pet.getPrice()));
            petJson.put("up_time",pet.getUpTime());
            petJson.put("remark",pet.getRemark());
        }
        petJson.put("birthday",pet.getBirthday());
        petJson.put("description",pet.getDescription());
        petJson.put("img_url",pet.getImgUrl());

        User owner = pet.getOwner();
        JSONObject ownerJSON = userJSON(owner);
        petJson.put("owener",ownerJSON);
        return petJson;
    }

    public JSONArray petsJson(List<Pet> petList, int offset, int limit) {

        JSONArray petListJson = new JSONArray();
        if (petList==null) return petListJson;
        for (int i = offset; i < offset+limit; i ++){
            petListJson.add(petList.get(i));
        }
        return petListJson;
    }

    public JSONObject orderJson(Order order){
        JSONObject orderJson = new JSONObject();
        orderJson.put("id",order.getId());
        orderJson.put("buyer",userJSON(order.getBuyer()));
        orderJson.put("seller",userJSON(order.getSeller()));
        orderJson.put("date",order.getDate());
        orderJson.put("price",order.getPrice());
        orderJson.put("status",order.getStatus());
        Pet pet = order.getPet();
        JSONObject petJson = petJson(pet);
        orderJson.put("pet",petJson);
        return orderJson;
    }

    public JSONArray ordersJson(List<Order> orderList, int offset, int limit) {
        JSONArray ordersJson = new JSONArray();
        for (int i = offset; i < offset+limit; i ++){
            ordersJson.add(orderJson(orderList.get(i)));
        }
        return ordersJson;
    }
}
