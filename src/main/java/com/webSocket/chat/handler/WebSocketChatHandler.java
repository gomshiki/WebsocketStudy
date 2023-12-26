package com.webSocket.chat.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webSocket.chat.model.ChatMessage;
import com.webSocket.chat.model.ChatRoom;
import com.webSocket.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * ChatController 가 WebSocketChatHandler 역할을 대신함 사유 : Stomp 사용
 */
/*


// 여러 클라이언트가 발송항 메시지를 받아 처리하는 handler
@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketChatHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload {}", payload);
        // 고도화로 인한 삭제항목
//        TextMessage textMessage = new TextMessage("Welcome Chatting Server");
//        session.sendMessage(textMessage);

        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
        room.handleActions(session, chatMessage, chatService);
    }

}*/
