package com.example.websockets.websocketdemo.service;

import com.example.websockets.websocketdemo.model.HelloGreetingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class GreetingScheduler {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 4000)
    public void schedule() {
        String time = LocalDateTime.now().toString();
        simpMessagingTemplate.convertAndSend("/topic/greetings", new HelloGreetingMessage("Sending messsage from " +
                "server at time: "+time));
    }
}
