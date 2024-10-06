package com.heima.utils.thread;


import com.heima.model.user.pojos.AdUser;


public class AdminThreadLocalUtil {

    private final static ThreadLocal<AdUser> WM_USER_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 添加用户
     * @param adUser
     */
    public static void  setUser(AdUser adUser){
        WM_USER_THREAD_LOCAL.set(adUser);
    }

    /**
     * 获取用户
     */
    public static AdUser getUser(){
        return WM_USER_THREAD_LOCAL.get();
    }

    /**
     * 清理用户
     */
    public static void clear(){
        WM_USER_THREAD_LOCAL.remove();
    }
}