package com.central.common.config;

import com.central.common.utils.PwdEncoderUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码加密配置类
 *
 * @author AlexZhang
 * <p>
 
 */
public class DefaultPasswordConfig {
	@Bean
	@ConditionalOnMissingBean
	public PasswordEncoder passwordEncoder() {
		return PwdEncoderUtil.getDelegatingPasswordEncoder("bcrypt");
	}
}
