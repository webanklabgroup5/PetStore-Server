package cn.theproudsoul.fiscopetshop.controller;

import cn.theproudsoul.fiscopetshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@SpringBootApplication
@RestController
public class UserController{

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
 		String userType = map.get("type");
 		String userName=map.get("user_name");
		String passwd=map.get("passwd");

 		//登录操作checkPassword
 		int isSuccess= userService.checkPassword(Integer.parseInt(userType),userName,passwd);
		
 		JSONObject res=new JSONObject();
 		if(isSuccess==0) {
 			res.put("status", "0");
 			HttpSession session=request.getSession();
 			session.setAttribute("user", userName);
			session.setAttribute("role", userType);
 		}
 		else
 			res.put("status", isSuccess);
 		return res.toJSONString();
 	}

	@RequestMapping(value = "/logout", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session=request.getSession();
		session.invalidate();

		JSONObject res=new JSONObject();
		res.put("status", "1");
		return res.toJSONString();
	}

 	@GetMapping(value = "/",  produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String home(HttpServletRequest request) throws Exception {
		HttpSession session=request.getSession();
		JSONObject res=new JSONObject();
		int role = (int) session.getAttribute("role");
		if (role==0){
			res.toJSONString(userService.getAdmin());
		}else {
			res.toJSONString(userService.getUserInfo());
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
			String userName = map.get("user_name");
			String passwd = map.get("passwd");
			String credit=map.get("credit");
			// 生成用户addUser，用cookie把？
			String user = userService.addUser(userName,passwd,Integer.parseInt(credit));
			if (user==null){
				res.put("status", 1);
			}else {
				res.put("status",0);
				res.put("user_key", user);
			}
		}
		return res.toJSONString();
	}
}