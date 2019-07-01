package cn.theproudsoul.fiscopetshop.controller;

import cn.theproudsoul.fiscopetshop.entity.User;
import cn.theproudsoul.fiscopetshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@SpringBootApplication
@RestController
public class PetshopController{

	@Autowired
	private UserService userService;

//    @GetMapping("/")
//    @ResponseBody
//    public String index() {
//        return "Hello World!";
//    }


    @PostMapping(value = "/login",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
 	@ResponseBody
 	public String login(@RequestBody Map<String, String> map, HttpServletRequest request, HttpServletResponse response) throws JSONException {
 //		response.setHeader("Access-Control-Allow-Origin", "127.0.0.1:3000");//跨域访问
 		String userType = map.get("type");
 		String user_key=map.get("user_key");

 		//登录操作checkPassword
 		int isSuccess= userService.checkPassword(Integer.parseInt(userType),user_key);
		
 		JSONObject res=new JSONObject();
 		if(isSuccess==0) {
 			res.put("status", "0");
 			HttpSession session=request.getSession();
 			session.setAttribute("user", user_key);
			session.setAttribute("role", userType);
 		}
 		else
 			res.put("status", isSuccess);
 		return res.toJSONString();
 	}

 	@GetMapping("/")
	@ResponseBody
	public String home(HttpServletRequest request){
		HttpSession session=request.getSession();
		JSONObject res=new JSONObject();
		int role = (int) session.getAttribute("role");
		String user_key = (String) session.getAttribute("user");
		if (role==0){
			res.toJSONString(userService.getAdminByKey(user_key));
		}else {
			res.toJSONString(userService.getUserByKey(user_key));
		}
		return res.toJSONString();
	}

 	@PostMapping(value = "/useradd", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userAdd(@RequestBody Map<String, String> map, HttpServletRequest request){
		// 验证管理员身份
		HttpSession session=request.getSession();
		JSONObject res=new JSONObject();
		if((int) session.getAttribute("role") == 1){
			res.put("status", "1");
			res.put("error_msg", "权限不足");
		}else {
			String userName = map.get("user");
			String credit=map.get("credit");
			// 生成用户addUser，用cookie把？
			String user = userService.addUser(userName,Integer.parseInt(credit));
			if (user==null){
				res.put("status", "1");
			}else {
				res.put("status","0");
				res.put("user_key", user);
			}
		}
		return res.toJSONString();
	}
}