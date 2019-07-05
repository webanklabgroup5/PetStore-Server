package cn.theproudsoul.fiscopetshop.controller;

import cn.theproudsoul.fiscopetshop.constants.JSONReturn;
import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.entity.ReturnJson;
import cn.theproudsoul.fiscopetshop.service.PetService;
import cn.theproudsoul.fiscopetshop.service.impl.ContractService;
import cn.theproudsoul.fiscopetshop.service.impl.PetStoreService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PetController {

    private final PetService petService;
    private final PetStoreService petStoreService;
    private final ContractService contractService;
    private String basePath="D:\\academic\\shixun\\PetStore-Server\\pic\\"; // 图片储存根目录
    // private String basePath="/home/petshop/pet/"; // 图片储存根目录
    private String accessUrl = "http://ali.theproudsoul.cn:22222/petshop/pet/";

    public PetController(PetService petService, PetStoreService petStoreService, ContractService contractService) {
        this.petService = petService;
        this.petStoreService = petStoreService;
        this.contractService = contractService;
    }

    @PostMapping(value = "/petadd", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String petAdd(@RequestBody Map<String, String> map, HttpServletRequest request) {
        // 调用PetMarket合约接口 buyPet(uint _petId)
        String name = map.get("name");
        int species = Integer.parseInt(map.get("species"));
        String photo = map.get("photo");
        String birthday = map.get("birthday");
        String description = map.get("description");
        System.out.println("name:"+name+",photo:"+photo+"");

        boolean status = false;
        try {
            status = petService.petAdd(name,species,photo,birthday,description);
        } catch (Exception e) {
            log.error("添加宠物失败！");
            e.printStackTrace();
        }
        JSONObject res=new JSONObject();
        if (status){
            res.put("status",1);
        }else {
            return JSONReturn.EXECUTION_FAILED();
        }
        return res.toJSONString();
    }

    @PostMapping(value = "/petstatus", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String petStatus(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
        String actionS = map.get("action");
        String petId = map.get("pet_id");
        if (petId==null||actionS==null){
            return JSONReturn.INSUFFICIENT_ARGUMENTS();
        }
        int action = Integer.parseInt(actionS);
        JSONObject res=new JSONObject();
        boolean status;
        if (action==1){
            // 上架
            String remark = map.get("remark");
            if (remark==null) remark="";
            String priceS = map.get("price");
            int price = 0;
            if (priceS!=null)
                price = Integer.parseInt(priceS);

            status = petService.petOn(petId, price, remark);
        } else if (action==0) {
            status = petService.petDown(petId);
        } else {
            return JSONReturn.INSUFFICIENT_ARGUMENTS();
        }
        if (status){
            res.put("status",1);
        }else {
            return JSONReturn.EXECUTION_FAILED();
        }
        return res.toJSONString();
    }

    @GetMapping(value = "/market/petlist", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String petsOnSell(@RequestParam(value="limit",required = false,defaultValue = "10") int limit,
                          @RequestParam(value="offset",required = false,defaultValue = "0") int offset){
        // 获取销售中的宠物
        // 需要owner基本信息
        List<Pet> petList = petService.getPetsOnSale();
        JSONObject res = new JSONObject();
        int total = petList.size();
        res.put("total",total);
        res.put("status",1);
        if (total==0){
            res.put("pet_list",new JSONArray());
            return res.toJSONString();
        } else if (offset>=total){
            return JSONReturn.NOTFOUND();
        }
        if (limit+offset>=total)
            limit=total-offset;

        JSONArray petListJson = petStoreService.petsJson(petList,offset,limit);
        res.put("pet_list",petListJson);
        return res.toJSONString();
    }

    @PostMapping(value = "/upload", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String upload(@RequestParam("photo") MultipartFile file, HttpServletRequest request) throws IOException {
        JSONObject res = new JSONObject();
        if (file.isEmpty()) {
//            res.put("status",0);
//            res.put("error_msg","文件不能为空");
            return JSONReturn.INSUFFICIENT_ARGUMENTS();
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传的后缀名为：" + suffixName);

        long now=System.currentTimeMillis();
        String filePath = basePath;
        File dest = new File(filePath + now +suffixName);
        System.out.println("上传文件的文件夹位置为 "+filePath);
        System.out.println("fileName："+file.getOriginalFilename());

        try {
            file.transferTo(dest);
            log.info("上传成功后的文件路径：" + filePath + fileName);
            res.put("status",1);
            res.put("url",accessUrl + now+suffixName);
            return res.toJSONString();
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        return JSONReturn.EXECUTION_FAILED();
    }

    @GetMapping(value = "/petlist", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String petList(@RequestParam(value="limit",required = false,defaultValue = "10") int limit,
                          @RequestParam(value="offset",required = false,defaultValue = "0") int offset){

        if (!contractService.isAdmin())
            return JSONReturn.PERMISSIONDENIED();
        List<Pet> petList = petService.getPetList();
        JSONObject res = new JSONObject();
        int total = petList.size();
        res.put("total",total);
        if (total==0){
            res.put("pet_list",new JSONArray());
        } else if (offset>=total){
            return JSONReturn.NOTFOUND();
        }
        if (limit+offset>=total)
            limit=total-offset;

        res.put("status",1);
        JSONArray petListJson = petStoreService.petsJson(petList,offset,limit);
        res.put("pet_list",petListJson);
        return res.toJSONString();
    }

    @GetMapping(value = "/user/petlist", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String selfPetList(@RequestParam(value="limit",required = false,defaultValue = "10") int limit,
                          @RequestParam(value="offset",required = false,defaultValue = "0") int offset){

        List<Pet> petList = petService.getMyPets();
        JSONObject res = new JSONObject();
        int total = petList.size();
        res.put("total",total);
        res.put("status",1);
        if (total==0){
            res.put("pet_list",new JSONArray());
            return res.toJSONString();
        } else if (offset>=total){
            return JSONReturn.NOTFOUND();
        }
        if (limit+offset>=total)
            limit=total-offset;


        JSONArray petListJson = petStoreService.petsJson(petList,offset,limit);
        res.put("pet_list",petListJson);
        return res.toJSONString();
    }
}
