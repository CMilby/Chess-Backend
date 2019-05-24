/*
 * @Author: Craig Milby 
 * @Date: 2019-05-19 11:20:13 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-19 11:33:01
 */
package me.cmilby.chessbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import me.cmilby.chessbackend.domain.user.User;
import me.cmilby.chessbackend.repository.chess.ChessDao;
import me.cmilby.chessbackend.repository.user.UserDao;
import me.cmilby.chessbackend.service.ChessGameService;
import me.cmilby.chessbackend.util.RandomUtil;

/**
 * ChessGameServiceImpl
 */
@Service ( "ChessGameService" )
public class ChessGameServiceImpl implements ChessGameService {

	@Value ( "${game.id-length}" )
	private int gameIdLength;

	@Autowired
	private ChessDao chessDao;

	@Autowired
	private UserDao userDao;

	@Override
	public String createNewGame ( User p_user ) {
		String gameId = RandomUtil.randomAlphanumeric ( gameIdLength );
		while ( chessDao.activeGameWithIdExists ( gameId ) ) {
			gameId = RandomUtil.randomAlphanumeric ( gameIdLength );
		}

		chessDao.addActiveGame ( gameId );
		return gameId;
	}

	@Override
	public void addUserToGame ( String p_gameId, User p_user, String p_color ) {
		chessDao.addUserToActiveGame ( p_gameId, p_user.getId ( ) );
	}

	@Override
	public void addUserByUsernameToGame ( String p_gameId, String p_username, String p_color ) {
		User user = userDao.getUserWithUsername ( p_username );
		addUserToGame ( p_gameId, user, p_color );
	}

	@Override
	public boolean isPlayerAlreadyInGame ( String p_gameId, Long p_userId ) {
		return chessDao.playerIsInActiveGame ( p_gameId, p_userId );
	}
}