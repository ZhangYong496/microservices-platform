package com.central.log.properties;

import com.zaxxer.hikari.HikariConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 日志数据源配置
 * logType=db时生效(非必须)，如果不配置则使用当前数据源
 *
 * @author AlexZhang
 * @date 2020/2/8
 * <p>
 
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "zlt.audit-log.datasource")
@ConditionalOnClass(HikariConfig.class)
public class LogDbProperties extends HikariConfig {
}
