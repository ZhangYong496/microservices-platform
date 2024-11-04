package com.central.common.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.central.common.model.LoginAppUser;

/**
 * 登录用户holder
 *
 * @author AlexZhang
 * @date 2022/6/26
 * <p>
 
 */
public class LoginUserContextHolder {
    private static final ThreadLocal<LoginAppUser> CONTEXT = new TransmittableThreadLocal<>();

    public static void setUser(LoginAppUser user) {
        CONTEXT.set(user);
    }

    public static LoginAppUser getUser() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}