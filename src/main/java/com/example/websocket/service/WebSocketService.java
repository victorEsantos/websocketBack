package com.example.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    private SimpMessagingTemplate template;

    @Autowired
    public WebSocketService(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Async
    public void execute() {
        for (int i = 0; i < 10; i++) {
            template.convertAndSend("/statusProcessor", "Message " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
