/*
 * @Author: Craig Milby 
 * @Date: 2019-04-22 15:03:11 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-22 18:09:15
 */
package me.cmilby.chessbackend.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * ChessSocketController
 */
@Controller
public class ChessSocketController {

	@MessageMapping ( "/chess/{gameId}" )
	@SendTo ( "/topic/chess/update/{gameId}" )
	public String test ( @DestinationVariable String gameId, String p_message ) throws Exception {
		return gameId + " " + p_message.toUpperCase ( );
	}
}