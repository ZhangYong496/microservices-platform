package com.central.log.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 日志链路对象
 *
 * @author AlexZhang
 * @version 1.0
 * @date 2022/1/27
 * <p>
 
 */
@Setter
@Getter
public class TraceLog {
    private String spanId;
    private String parentId;
    private String appName;
    private String serverIp;
    private String serverPort;
}
