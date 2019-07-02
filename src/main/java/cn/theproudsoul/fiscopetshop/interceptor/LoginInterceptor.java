package cn.theproudsoul.fiscopetshop.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.theproudsoul.fiscopetshop.entity.ReturnJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import util.MySessionContext;

/**
 * 登录认证的拦截器
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor{

    /**
     * Handler执行完成之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exc)
            throws Exception {

    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * Handler执行之前调用这个方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");//跨域访问
        ReturnJson returnJson = new ReturnJson();

        //说明是登录请求，无需拦截
        if(request.getRequestURI().contains("login")) {
            returnJson.setSuccess(true);
            returnJson.setMessage("登录请求成功");

            return true;
        }

        //说明是登出请求，无需拦截
        if(request.getRequestURI().contains("logout")) {
            returnJson.setSuccess(true);
            returnJson.setMessage("登出请求成功");

            return true;
        }

        String token = request.getParameter("token");
        if(token == null) {
            String data = request.getParameter("data");
            token = (String)JSON.parseObject(data).get("token");
        }

        if(token == null){

            returnJson.setSuccess(false);
            returnJson.setMessage("登录验证失败，缺少token");

            dealJsonReturn(request, response, returnJson.toJSON());

            return false;
        }

        String sessionId = request.getParameter("sessionId");
        if(sessionId == null) {
            String data = request.getParameter("data");
            sessionId = (String)JSON.parseObject(data).get("sessionId");
        }

        HttpSession session = MySessionContext.getSession(sessionId);

        if(session == null || session.getAttribute(sessionId) == null) {
            returnJson.setSuccess(false);
            returnJson.setMessage("登录验证失败，已登出");

            dealJsonReturn(request, response, returnJson.toJSON());

            return false;
        }

        String tokenAndDateTime = (String)session.getAttribute(sessionId);

        String[] tokenAndDateTimeArray = tokenAndDateTime.split(",");
        String tokenStorage = tokenAndDateTimeArray[0];

        if(tokenStorage == null || token == null || !tokenStorage.equals(token)) {
            returnJson.setSuccess(false);
            returnJson.setMessage("登录验证失败，token不匹配");

            dealJsonReturn(request, response, returnJson.toJSON());

            return false;
        }

        String dateTimeStr = tokenAndDateTimeArray[1];
        Long dateTime = Long.parseLong(dateTimeStr);
        Long before5 = new Timestamp(System.currentTimeMillis()).getTime() - 300000;//5分钟为超时时间
        if(dateTime < before5) {
            returnJson.setSuccess(false);
            returnJson.setMessage("登录验证失败，已超时");

            dealJsonReturn(request, response, returnJson.toJSON());

            return false;
        }

        //returnJson.setSuccess(true);
        //returnJson.setMessage("登录验证成功");

        //更新token以及token的时间
        //String newToken = Token.getToken();
        session.setAttribute(sessionId, token + "," + new Timestamp(System.currentTimeMillis()).getTime());
        //更新Token，防止重复提交
        //response.setHeader("token", newToken);

        //dealJsonReturn(request, response, returnJson.toJSON());

        return true;
    }

    /**
     * 处理json返回
     * @param request
     * @param response
     * @param json
     */
    public void dealJsonReturn(HttpServletRequest request, HttpServletResponse response, String json){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException ex) {
            log.error("response error",ex);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
