package com.central.oauth2.common;

import com.central.oauth2.common.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * 鉴权自动配置
 *
 * @author AlexZhang
 * @version 1.0
 * @date 2021/7/24
 * <p>

 */
@EnableConfigurationProperties({SecurityProperties.class})
@ComponentScan
public class AuthClientAutoConfiguration {
}
