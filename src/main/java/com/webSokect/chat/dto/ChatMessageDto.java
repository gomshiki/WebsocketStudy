package com.webSokect.chat.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDto {

    // 메세지 타입 : 입장, 채팅

    public enum MessageType {
        ENTER, TALK
    }

    private MessageType messageType; // 메세지 타입
    private Long chatRoomId; // 방 번호
    private Long senderId; // 채팅 송신자
    private String message; // 메세지

}
