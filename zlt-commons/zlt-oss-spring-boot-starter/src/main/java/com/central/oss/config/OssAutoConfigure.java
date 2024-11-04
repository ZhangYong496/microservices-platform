package com.central.oss.config;

import com.central.oss.properties.FileServerProperties;
import com.central.oss.template.FdfsTemplate;
import com.central.oss.template.S3Template;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * @author AlexZhang
 * @date 2021/2/13
 * <p>
 
 */
@EnableConfigurationProperties(FileServerProperties.class)
@Import({FdfsTemplate.class, S3Template.class})
public class OssAutoConfigure {

}
