package cn.theproudsoul.fiscopetshop.controller;

import cn.theproudsoul.fiscopetshop.entity.Order;
import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.entity.User;
import cn.theproudsoul.fiscopetshop.service.TransactionService;
import cn.theproudsoul.fiscopetshop.service.impl.PetStoreService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired private PetStoreService petStoreService;

    @PostMapping(value = "/purchase", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String purchase(@RequestBody Map<String, String> map, HttpServletRequest request) {
        String petId = map.get("pet_id");
        int result = transactionService.transaction(petId);
        JSONObject res=new JSONObject();
        res.put("status",result);
        return res.toJSONString();
    }

    @GetMapping(value = "/arbitrationlist", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String arbitrationList(@RequestParam(value="limit",required = false,defaultValue = "10") int limit,
                                  @RequestParam(value="offset",required = false,defaultValue = "0") int offset){
        List<Order> arbitrationList =transactionService.arbitrationList();
        JSONObject res=new JSONObject();
        int total = arbitrationList.size();

        res.put("total",total);
        if (total==0){
            res.put("status",1);
            res.put("arbitration_list",new JSONArray());
        }else if (total<=offset){
            res.put("status",0);
            res.put("error_msg","再怎么找也没有了哦~");
        } else if(offset+limit>=total){
            limit = total-offset;
            res.put("status",1);
            JSONArray arbitrationsJson = petStoreService.ordersJson(arbitrationList,offset,limit);
            res.put("arbitration_list",arbitrationsJson);
        } else {
            res.put("status",1);
            JSONArray arbitrationsJson = petStoreService.ordersJson(arbitrationList,offset,limit);
            res.put("arbitration_list",arbitrationsJson);
        }
        return res.toJSONString();
    }

    @PostMapping(value = "/judge", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String judge(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
        JSONObject res = new JSONObject();
        if (!petStoreService.isAdmin()){
            res.put("status", 0);
            res.put("error_msg", "权限不足！");
        }else {
            int action = Integer.parseInt(map.get("action"));
            if (action!=0&&action!=1){
                res.put("status", 0);
                res.put("error_msg", "参数错误！");
            }else {
                String arbitrationId= map.get("arbitration_id");
                if(transactionService.judge(arbitrationId, action))
                    res.put("status", 1);
            }
        }
        return res.toJSONString();
    }

    @PostMapping(value = "/arbitration", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String arbitration(@RequestBody Map<String, String> map, HttpServletRequest request){
        String tradeId = map.get("trade_id");
        JSONObject res = new JSONObject();
        if (transactionService.arbitration(tradeId)){
            res.put("status", 1);
        }else {
            res.put("status", 0);
            res.put("error_msg", "执行失败，请重试……");
        }
        return res.toJSONString();
    }

    @GetMapping(value = "/tradelist", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String tradeList(@RequestParam(value="limit",required = false,defaultValue = "10") int limit,
                           @RequestParam(value="offset",required = false,defaultValue = "0") int offset){
        JSONObject res = new JSONObject();
        List<Order> orderList= transactionService.getAllOrders();
        int total = orderList.size();
        res.put("total",total);
        if (total==0){
            res.put("status",1);
            res.put("trade_list", new JSONArray());
        } else if (offset>total){
            res.put("status",0);
            res.put("error_msg","再怎么找也没有了哦");
            return res.toJSONString();
        }
        if (limit+offset>total)
            limit=total-offset;
        res.put("status",1);
        JSONArray tradeListJson = petStoreService.ordersJson(orderList,offset,limit);

        res.put("status",1);
        res.put("trade_list",tradeListJson);
        return res.toJSONString();
    }

    @GetMapping(value = "/user/tradelist", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String userTradeList(@RequestParam(value = "user_id") String userId,
                                @RequestParam(value="limit",required = false,defaultValue = "10") int limit,
                                @RequestParam(value="offset",required = false,defaultValue = "0") int offset){
        List<Order> orderList = transactionService.getOrders();

        JSONObject res = new JSONObject();
        int total = orderList.size();
        res.put("total",total);
        if (total==0){
            res.put("pet_list",new JSONArray());
        }else if (offset>total){
            res.put("status",0);
            res.put("error_msg","再怎么找也没有了哦");
            return res.toJSONString();
        }
        if (limit+offset>total)
            limit=total-offset;
        res.put("status",1);
        JSONArray petListJson = petStoreService.ordersJson(orderList,offset,limit);
        res.put("pet_list",petListJson);
        return res.toJSONString();
    }

}
