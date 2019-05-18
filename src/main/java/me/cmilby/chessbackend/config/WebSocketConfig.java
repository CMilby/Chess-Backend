/*
 * @Author: Craig Milby 
 * @Date: 2019-04-22 15:06:58 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-22 18:08:50
 */
package me.cmilby.chessbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocketConfig
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints ( StompEndpointRegistry registry ) {
		registry.addEndpoint ( "/chess" ).setAllowedOrigins ( "*" ).withSockJS ( );
	}

	@Override
	public void configureMessageBroker ( MessageBrokerRegistry registry ) {
		registry.setApplicationDestinationPrefixes ( "/app" ).enableSimpleBroker ( "/topic", "/queue" );
	}
}