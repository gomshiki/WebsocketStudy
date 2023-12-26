package com.webSocket.chat.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


/**
 * Websocket에 접속하기 위한 endpoint 를 "/ws/chat"로 설정하고 도메인이 다른 서버도 접속가능하도록 CORS : setAllowedOrigins("*")
 * 설정 추가.
 * <p>
 * 클라이언트는 ws://localhost:8080/ws/chat 으로 커넥션을 연결.
 */
/*
@RequiredArgsConstructor
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final WebSocketHandler webSocketHandler;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
    }
}*/


/**
 * Stomp 를 사용하기 위해
 *
 * 1. @EnableWebSocketMessageBroker 선언
 *
 * 2. WebSocketMessageBrokerConfigurer 상속받음
 *
 * 3. configureMessageBroker 구현
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/sub");
        config.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("*").withSockJS();
    }

}