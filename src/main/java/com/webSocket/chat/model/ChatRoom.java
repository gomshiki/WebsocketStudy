package com.webSocket.chat.model;

import com.webSocket.chat.model.ChatMessage.MessageType;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

@Getter
@Setter
public class ChatRoom {

    private String roomId;
    private String name;

    /*
     @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }
    */

    public static ChatRoom create(String name){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }

    /*
        Stomp의 sub/pub 방식을 이용하면 구독자 관리를 알아서 해주므로 세션관리가 필요없음.
        발송 구현도 알아서 해결되므로 매번 클라이언트에게 메시지를 발송하는 구현이 필요없어짐
    */

    /*
    private Set<WebSocketSession> sessions = new HashSet<>();

    public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService service) {
        if (chatMessage.getType().equals(MessageType.ENTER)) {
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + " 님이 입장하셨습니다.");

        }
        sendMessage(chatMessage, service);
    }

    public <T> void sendMessage(T message, ChatService service) {
        sessions.parallelStream().forEach(session -> service.sendMessage(session, message));
    }*/

}
