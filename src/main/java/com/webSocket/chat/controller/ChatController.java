package com.webSocket.chat.controller;

import com.webSocket.chat.model.ChatMessage;
import com.webSocket.chat.model.ChatRoom;
import com.webSocket.chat.service.ChatService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
//@RestController
//@RequestMapping("/chat")
public class ChatController {

    // ChatRoomRepository 으로 ChatService 대체

    /*

    private final ChatService chatService;

    @PostMapping
    public ChatRoom createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }
    */

    private final SimpMessageSendingOperations messagingTemplate;

    /**
     * @MessageMapping을 통해 Websocket 으로 들어오는 메시지를 발행 처리
     *
     * client 는  prefix 를 붙여 "/pub/chat/message" 로 발행요청을 하면 Controller 에서 메시지를 받아 처리
     * 메시지가 발행되면 "/sub/chat/room/{roomId}"로 메시지를 Send 하는데
     * 해당 주소를 구독(Subscribe) 하다가 메시지를 전달 받으면 화면에 출력하면 됨
     *
     * "/sub/chat/room/{roomId}" 는 채팅룸을 구분하는 값으로 pub/sub에서 Topic 역할
     * 기존 WebSocketHandler가 했던 역할을 대체하므로 WebSocketHandler는 불필요함.
     *
     */
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.JOIN.equals(message.getType())) {
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
        messagingTemplate.convertAndSend("/sub/chat/room" + message.getRoomId(), message);
    }
}
