/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 19:12:11 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 20:16:54
 */
package me.cmilby.chessbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.cmilby.chessbackend.repository.chess.ChessDao;
import me.cmilby.chessbackend.util.RandomUtil;

/**
 * ChessGameController
 */
@RestController
@RequestMapping ( "/play" )
public class ChessGameController {

	@Autowired
	private ChessDao chessDao;

	@PostMapping ( "/send-game-creation-request" )
	public String sendGameCreationRequest ( ) {
		String gameId = RandomUtil.randomBase64 ( );
		chessDao.addActiveGame ( gameId );
		return gameId;
	}

	@PostMapping ( "/join/{id}" )
	public String joinGame ( @PathVariable ( "id" ) String p_gameId ) {
		return "success";
	}
}