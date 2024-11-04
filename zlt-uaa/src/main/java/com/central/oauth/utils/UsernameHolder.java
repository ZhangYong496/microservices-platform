package com.central.oauth.utils;

/**
 * @author AlexZhang
 * @version 1.0
 * @date 2021/10/22
 * <p>
 
 */
public class UsernameHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal();

    public static String getContext() {
        return contextHolder.get();
    }

    public static void setContext(String username) {
        contextHolder.set(username);
    }

    public static void clearContext() {
        contextHolder.remove();
    }
}
