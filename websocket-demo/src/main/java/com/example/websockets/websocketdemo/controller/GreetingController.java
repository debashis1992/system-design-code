package com.example.websockets.websocketdemo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.websockets.websocketdemo.model.HelloGreetingMessage;
import com.example.websockets.websocketdemo.model.HelloMessage;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public HelloGreetingMessage greetUser(HelloMessage message) {
		return new HelloGreetingMessage("Hello "+message+"!");
	}
	
}
