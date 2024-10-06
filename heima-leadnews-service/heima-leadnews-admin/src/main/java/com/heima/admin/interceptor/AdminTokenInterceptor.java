package com.heima.admin.interceptor;

import com.heima.model.user.pojos.AdUser;
import com.heima.utils.thread.AdminThreadLocalUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminTokenInterceptor implements HandlerInterceptor {

    //把用户信息存入线程
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader("userId");
        if(userId != null){
            AdUser adUser = new AdUser();
            adUser.setId(Integer.valueOf(userId));
            AdminThreadLocalUtil.clear();
            AdminThreadLocalUtil.setUser(adUser);
        }
        return true;
    }

    /**
     * 清理线程数据
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AdminThreadLocalUtil.clear();
    }

}
