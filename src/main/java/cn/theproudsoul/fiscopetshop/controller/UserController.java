package cn.theproudsoul.fiscopetshop.controller;

import cn.theproudsoul.fiscopetshop.entity.Applicant;
import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.entity.User;
import cn.theproudsoul.fiscopetshop.service.UserService;
import cn.theproudsoul.fiscopetshop.service.impl.ContractService;
import cn.theproudsoul.fiscopetshop.service.impl.PetStoreService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class UserController{

	private final UserService userService;

	private final PetStoreService petStoreService;

	private final ContractService contractService;

    public UserController(UserService userService, PetStoreService petStoreService, ContractService contractService) {
        this.userService = userService;
        this.petStoreService = petStoreService;
        this.contractService = contractService;
    }

    @PostMapping(value = "/login",consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
 	@ResponseBody
 	public String login(@RequestBody Map<String, String> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
 		String userType = map.get("type");
 		String userName=map.get("user_name");
		String password=map.get("password");
		JSONObject res=new JSONObject();
		if (userType==null||userName==null||password==null){
			res.put("status","0");
			res.put("error_msg", "缺少参数……");
		}

 		//登录操作checkPassword
 		long id= userService.checkPassword(Integer.parseInt(userType),userName,password);

 		if(id!=-1) {
 			res.put("status", "1");
 			User user = userService.getUserById(String.valueOf(id));
			JSONObject userObject =petStoreService.userJSON(user);
			userObject.put("id",id);
 			userObject.put("user_name",userName);
			//userObject.put("credit",user.getCredit());
			userObject.put("type", userType);
			List<Pet> petList = userService.getPetListByUserName(userName);
			JSONArray petListJson = petStoreService.petsJson(petList,0,10);
			userObject.put("pet_list",petListJson);
			res.put("user",userObject);
			contractService.setCredentials(user.getUserKey());
		} else {
 			res.put("status", "0");
 			res.put("error_msg","用户名或密码错误");
		}
 		return res.toJSONString();
 	}

 	@GetMapping(value = "/test")
	@ResponseBody
	public String test(HttpServletRequest request, HttpSession session) throws Exception {
        System.out.println(session.getId());
    	return contractService.getAccountContract().myAddress().send();
	}

 	@GetMapping(value = "/userlist", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userList(@RequestParam(value="limit",required = false,defaultValue = "10") int limit,
						   @RequestParam(value="offset",required = false,defaultValue = "0") int offset){
		// 这里没有写limit哦
    	List<User> userList = userService.userList();
		JSONObject res = new JSONObject();
		res.put("status","1");
		JSONArray array = new JSONArray();
		for(User user:userList){
			JSONObject userJson = new JSONObject();
			userJson.put("user_id",user.getId());
			userJson.put("user_name",user.getUserName());
			userJson.put("credit",user.getCredit());

			List<Pet> petList = userService.getPetListByUserName(user.getUserName());
			JSONArray petListJson = petStoreService.petsJson(petList,offset,limit);
			userJson.put("pet_list",petListJson);
		}
		res.put("user_list",array);
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

 	@GetMapping(value = "/userinfo",  produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userInfo(@RequestParam(value="user_id")String id, HttpServletRequest request) throws Exception {
		JSONObject res=new JSONObject();
		User user = userService.getUserById(id);
		if (user==null){
			res.put("status","0");
			res.put("error_msg","找不到该用户");
		}else {
			res.put("status","1");
			res.put("user_name",user.getUserName());
			res.put("credit",user.getCredit());
			// 获取用户宠物列表
			List<Pet> petList = userService.getPetListByUserId(id);
		}
		return res.toJSONString();
	}

 	@PostMapping(value = "/useraudit", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userAudit(@RequestBody Map<String, String> map, HttpServletRequest request){
		// 验证管理员身份
		JSONObject res=new JSONObject();
		int action = Integer.parseInt(map.get("action"));
		String applyId = map.get("apply_id");
		boolean isAgree = false;
		if (action==1) isAgree = true;
		int status = userService.auditUser(applyId, isAgree);
			if (status==1){
				res.put("status", "1");
			}else if (status==0){
				res.put("status",0);
				res.put("error_msg", "用户名已存在");
			} else {
				res.put("status",0);
				res.put("error_msg", "无法查找到申请信息");
			}
		return res.toJSONString();
	}

	@PostMapping(value = "/userapply", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userApply(@RequestBody Map<String, String> map, HttpServletRequest request){

		String userName = map.get("user_name");
		String password = map.get("password");
		int credit = Integer.parseInt(map.get("credit"));
		int status = userService.applyUser(userName,password,credit);
		JSONObject res=new JSONObject();
		if (status==1){
			res.put("status", 1);
		}

		return res.toJSONString();
	}

	@GetMapping(value = "/applylist", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String applyList(@RequestParam(value="limit",required = false,defaultValue = "10") int limit,
							@RequestParam(value="offset",required = false,defaultValue = "0") int offset){
		// 权限验证！！！！！！！！
    	List<Applicant> applicantList = userService.applyUserList();
		JSONObject res=new JSONObject();
		int total = applicantList.size();

		res.put("total",Integer.toString(total));
		if (total==0){
			res.put("status","1");
			res.put("apply_list","[]");
		} else if (total<=offset){
			res.put("status","0");
			res.put("error_msg","再怎么找也没有了哦~");
		} else if(offset+limit>=total){
			res.put("status","1");
			JSONArray array = new JSONArray();
			for (int i = offset; i < total; i ++){
				JSONObject xxx = new JSONObject();
				xxx.put("user_name",applicantList.get(i).getUserName());
				xxx.put("credit",applicantList.get(i).getCredit());
				array.add(xxx);
			}
			res.put("apply_list",array);
		}
		return res.toJSONString();
	}

	@GetMapping(value = "/user/petlist", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String userPetList(@RequestParam(value = "user_id") String userId,
							  @RequestParam(value="limit",required = false,defaultValue = "10") int limit,
							  @RequestParam(value="offset",required = false,defaultValue = "0") int offset){
		List<Pet> petList = userService.getPetListByUserId(userId);
		JSONObject res = new JSONObject();
		res.put("status","1");
		JSONArray petListJson = petStoreService.petsJson(petList,offset,limit);
		res.put("pet_list",petListJson);
		return res.toJSONString();
	}

	@GetMapping(value = "/market/userlist", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String sellers(@RequestParam(value="limit",required = false,defaultValue = "10") int limit,
						  @RequestParam(value="offset",required = false,defaultValue = "0") int offset){
		// 获取卖家
		JSONObject res = new JSONObject();
		return res.toJSONString();

	}
}