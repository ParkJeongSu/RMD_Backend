package com.jspark.rdmbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 클라이언트 구독 주소 (브로커 설정)
        config.enableSimpleBroker("/topic");  // "/topic"으로 메시지 브로드캐스트
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // SockJS를 통한 WebSocket 엔드포인트 설정
        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:82","http://localhost:5173").withSockJS();
    }
}