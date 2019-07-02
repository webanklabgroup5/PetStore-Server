package cn.theproudsoul.fiscopetshop.controller;

import cn.theproudsoul.fiscopetshop.service.PetService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@SpringBootApplication
@RestController
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping(value = "/petadd", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String petAdd(@RequestBody Map<String, String> map, HttpServletRequest request) {
        HttpSession session=request.getSession();
        int role = (int) session.getAttribute("role");
        String user_key = (String) session.getAttribute("user");

        // 调用PetMarket合约接口 buyPet(uint _petId)
        String name = map.get("name");
        int species = Integer.parseInt(map.get("species"));
        String photo = map.get("photo");
        String birthday = map.get("birthday");
        String description = map.get("description");
        boolean status = petService.petAdd(user_key,name,species,photo,birthday,description);
        JSONObject res=new JSONObject();
        if (status){
            res.put("status","1");
        }else {
            res.put("status","0");
            res.put("error_msg","执行失败，请重试……");
        }

        return res.toJSONString();
    }

    @PostMapping(value = "/peton", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String petOn(@RequestBody Map<String, String> map, HttpServletRequest request) {
        HttpSession session=request.getSession();
        int role = (int) session.getAttribute("role");
        String user_key = (String) session.getAttribute("user");

        String id = map.get("id");
        int price = Integer.parseInt(map.get("price"));
        boolean status = petService.petOn(user_key, id, price);
        JSONObject res=new JSONObject();
        if (status){
            res.put("status","1");
        }else {
            res.put("status","0");
            res.put("error_msg","执行失败，请重试……");
        }
        return res.toJSONString();
    }

    @PostMapping(value = "/petdown", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String petDown(@RequestBody Map<String, String> map, HttpServletRequest request) {
        HttpSession session=request.getSession();
        int role = (int) session.getAttribute("role");
        String user_key = (String) session.getAttribute("user");

        // 调用PetMarket合约接口 buyPet(uint _petId)
        String id = map.get("id");
        boolean status = petService.petDown(user_key,id);
        JSONObject res=new JSONObject();
        if (status){
            res.put("status","1");
        }else {
            res.put("status","0");
            res.put("error_msg","执行失败，请重试……");
        }
        return res.toJSONString();
    }

}
