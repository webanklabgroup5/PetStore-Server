package cn.theproudsoul.fiscopetshop.controller;

import cn.theproudsoul.fiscopetshop.service.TransactionService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@SpringBootApplication
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/transaction", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String transaction(@RequestBody Map<String, String> map, HttpServletRequest request) {
        HttpSession session=request.getSession();
        int role = (int) session.getAttribute("role");
        String user_key = (String) session.getAttribute("user");

        // 调用PetMarket合约接口 buyPet(uint _petId)
        String petId = map.get("petId");
        int result = transactionService.transaction(user_key,petId);
        JSONObject res=new JSONObject();
        res.put("status",result);
        return res.toJSONString();
    }

    @GetMapping(value = "/orders", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String orders(HttpServletRequest request) {
        HttpSession session=request.getSession();
        int role = (int) session.getAttribute("role");
        String user_key = (String) session.getAttribute("user");

        return JSONObject.toJSONString(transactionService.getOrdersByUserId(user_key));
    }

    @GetMapping(value = "/market", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String market(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String uerKey = (String) session.getAttribute("user");

        //Pets pets= transactionService.getPetsOnSell(uerKey);
        //JSONObject res=new JSONObject();
        //res.put("status","1");
        return JSONObject.toJSONString(transactionService.getPetsOnSell(uerKey));
    }

    @PostMapping(value = "/arbitration", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String arbitration(@RequestBody Map<String, String> map, HttpServletRequest request) {
        HttpSession session=request.getSession();
        int role = (int) session.getAttribute("role");
        String user_key = (String) session.getAttribute("user");

        String transactionId = map.get("transaction_id");
        boolean status = transactionService.arbitration(user_key,transactionId);
        JSONObject res=new JSONObject();
        if (status){
            res.put("status","1");
        }else {
            res.put("status","0");
            res.put("error_msg","执行失败，请重试……");
        }
        res.put("status","0");
        return res.toJSONString();
    }

    @PostMapping(value = "/judge", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String judge(@RequestBody Map<String, String> map, HttpServletRequest request) {
        HttpSession session=request.getSession();
        int role = (int) session.getAttribute("role");
        String user_key = (String) session.getAttribute("user");


        JSONObject res=new JSONObject();
        res.put("status","0");
        if (role!=0){
            res.put("error_msg","对不起，您的权限不足……");
            return res.toJSONString();
        }

        String transactionId = map.get("transactionId");
        int result = Integer.parseInt(map.get("result"));

        boolean status = transactionService.judge(user_key,transactionId, result);
        if (status){
            res.put("status","1");
        }else {
            res.put("status","0");
            res.put("error_msg", "执行失败，请重试……");
        }
        return res.toJSONString();
    }
}
