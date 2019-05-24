/*
 * @Author: Craig Milby 
 * @Date: 2019-04-22 15:03:11 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-22 18:09:15
 */
package me.cmilby.chessbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import me.cmilby.chessbackend.security.JwtTokenProvider;
import me.cmilby.chessbackend.service.ChessGameService;

/**
 * ChessSocketController
 */
@Controller
public class ChessSocketController {

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private ChessGameService chessGameService;

	@MessageMapping ( "/chess/game/join/{gameId}" )
	@SendTo ( "/topic/chess/game/{gameId}/join" )
	public String joinGame ( @DestinationVariable ( "gameId" ) String p_gameId, String p_token ) {
		String username = tokenProvider.getUsernameFromJWT ( p_token );
		chessGameService.addUserByUsernameToGame ( p_gameId, username, "dark" );
		return "success";
	}

	@MessageMapping ( "/chess/game/update/{gameId}" )
	@SendTo ( "/topic/chess/game/{gameId}/update" )
	public String updateGame ( @DestinationVariable ( "gameId" ) String p_gameId, String p_message ) {
		System.out.println ( p_message );
		return "";
	}
}