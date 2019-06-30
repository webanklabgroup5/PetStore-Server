package cn.theproudsoul.fiscopetshop.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PetshopController{
    @GetMapping("/")  
    @ResponseBody
    public String index() {
        return "Hello World!";
    }


//     @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
// 	@ResponseBody
// 	public String login(@RequestBody Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
// //		response.setHeader("Access-Control-Allow-Origin", "127.0.0.1:3000");//跨域访问
// 		String orgID=map.get("orgID");
// 		String orgName=map.get("orgName");
// 		String password=map.get("password");
		
// 		//登录操作checkPasswordByorgID
// 		int isSuccess=iouLimitEntityService.checkPasswordByorgID(password, orgID, orgName);
		
// 		JSONObject res=new JSONObject();
// 		if(isSuccess==1) {
// 			res.put("status", "1");
// 			HttpSession session=request.getSession();
// 			session.setAttribute("orgID", orgID);
// 		}
// 		else 
// 			res.put("status", isSuccess);
// 		return res.toJSONString();
// 	}
}