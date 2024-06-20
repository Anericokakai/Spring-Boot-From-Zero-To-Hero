package com.d3f4ult.websockets.chats.controller;

import com.d3f4ult.websockets.chats.dto.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
@Autowired
private SimpMessagingTemplate simpMessagingTemplate;
//  Send message   method
    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public ChatMessage sendMessage(@Payload ChatMessage message){
return  message;
    }
@MessageMapping("/private-message")
    public  ChatMessage addUser(@Payload ChatMessage message){
        simpMessagingTemplate.convertAndSendToUser(message.getSender(),"/private",message);
    System.out.println(message.toString());
        return  message;
    }

}
