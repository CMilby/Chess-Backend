/*
 * @Author: Craig Milby 
 * @Date: 2019-05-19 11:19:57 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-19 11:26:01
 */
package me.cmilby.chessbackend.service;

import me.cmilby.chessbackend.domain.user.User;

/**
 * ChessGameServie
 */
public interface ChessGameService {

	String createNewGame ( User p_user );

	void addUserToGame ( String p_gameId, User p_user, String p_color );

	void addUserByUsernameToGame ( String p_gameId, String p_username, String p_color );
}