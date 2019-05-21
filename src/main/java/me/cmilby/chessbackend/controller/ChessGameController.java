/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 19:12:11 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-19 11:42:33
 */
package me.cmilby.chessbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import me.cmilby.chessbackend.domain.user.User;
import me.cmilby.chessbackend.domain.util.ApiResponse;
import me.cmilby.chessbackend.service.ChessGameService;
import me.cmilby.chessbackend.service.UserService;

/**
 * ChessGameController
 */
@RestController
public class ChessGameController {

	@Autowired
	private ChessGameService chessGameService;

	@Autowired
	private UserService userService;

	@PostMapping ( "/game/create/url" )
	public ResponseEntity < ? > sendGameCreationRequest ( ) {
		User currentUser = userService.getCurrentUser ( );

		String gameId = null;
		if ( ( gameId = chessGameService.createNewGame ( currentUser ) ) != null ) {
			return new ResponseEntity <> ( new ApiResponse ( true, "Game created", gameId ), HttpStatus.OK );
		}

		return new ResponseEntity <> ( new ApiResponse ( false, "Could not create game" ), HttpStatus.OK );
	}
}