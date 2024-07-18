package org.example.websocketbootdemo;

import org.example.websocketbootdemo.config.MyWebSocketHandler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class MessageSender {

    public MessageSender(MyWebSocketHandler webSocketHandler) {
        super();
        this.webSocketHandler = webSocketHandler;
    }

    private final MyWebSocketHandler webSocketHandler;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        String message = "Server time: " + LocalDateTime.now() + ", 准备发射！";
        webSocketHandler.sendMessageToAll(message);
    }
}