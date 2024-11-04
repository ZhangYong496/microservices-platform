package com.central.common.filter;

import com.central.common.context.LoginUserContextHolder;
import com.central.common.model.LoginAppUser;
import com.central.common.utils.LoginUserUtils;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 获取当前登录人过滤器
 *
 * @author AlexZhang
 * @date 2022/6/26
 * <p>
 
 */
@ConditionalOnClass(Filter.class)
@Order
public class LoginUserFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        try {
            LoginAppUser user = LoginUserUtils.getCurrentUser(request, false);
            LoginUserContextHolder.setUser(user);
            filterChain.doFilter(request, response);
        } finally {
            LoginUserContextHolder.clear();
        }
    }
}
