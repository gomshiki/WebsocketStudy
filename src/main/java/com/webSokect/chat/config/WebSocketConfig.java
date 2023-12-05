package com.webSokect.chat.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private WebSocketHandler webSocketHandler;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //'/아무거나해요' 이부분은 나중에 서버 세팅을 끝난 후 실제로 테스트해볼때 정해지는 url 입니다.
        //  setAllowedOrigins("*") 는 웹소켓 cors 정책으로 인해, 허용 도메인을 지정해줘야합니다
        registry.addHandler(webSocketHandler, "/아무거나해요").setAllowedOrigins("*");
    }
}
