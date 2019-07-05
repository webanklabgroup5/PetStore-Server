package cn.theproudsoul.fiscopetshop.constants;


import com.alibaba.fastjson.JSONObject;

public class JSONReturn {

    public static final String NOTFOUND(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",0);
        jsonObject.put("error_msg","再怎么找也找不到了哦~");
        return jsonObject.toJSONString();
    }
    public static final String PERMISSIONDENIED(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",0);
        jsonObject.put("error_msg","对不起，您的权限不足~");
        return jsonObject.toJSONString();
    }
    public static final String EXECUTION_FAILED(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",0);
        jsonObject.put("error_msg","执行错误，请重试！");
        return jsonObject.toJSONString();
    }
    public static final String INSUFFICIENT_ARGUMENTS(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",0);
        jsonObject.put("error_msg","输入参数不足");
        return jsonObject.toJSONString();
    }
}
