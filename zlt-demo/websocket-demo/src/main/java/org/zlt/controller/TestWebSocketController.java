package org.zlt.controller;

import com.central.oauth2.common.config.WcAuthConfigurator;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author AlexZhang
 * @date 2022/5/8
 * <p>
 
 */
@Slf4j
@Component
@ServerEndpoint(value = "/websocket/test", configurator = WcAuthConfigurator.class)
public class TestWebSocketController {
    @OnOpen
    public void onOpen(Session session) throws IOException {
        session.getBasicRemote().sendText("TestWebSocketController-ok");
    }
}
