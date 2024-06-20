package com.d3f4ult.websockets.config;

import com.d3f4ult.websockets.chats.dto.ChatMessage;
import com.d3f4ult.websockets.chats.dto.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketConnectionListener {
    private  final SimpMessageSendingOperations messageSendingOperations;
@EventListener
    public  void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
    StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());
    String  username= (String) headerAccessor.getSessionAttributes().get("username");

    if(username!=null){
        log.info("user Disconnected :{}",username);
        var chatMessage= ChatMessage.builder().messageType(MessageType.LEAVE)
                .sender(username).build();
//        inform users that a user has left the chat
messageSendingOperations.convertAndSend("/topic/bublic",chatMessage);
    }

    }

}
