package org.zlt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author AlexZhang
 * @date 2020/1/30
 * <p>
 
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WebDubboApp {
    public static void main(String[] args) {
        SpringApplication.run(WebDubboApp.class, args);
    }
}
