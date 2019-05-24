/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:45:54 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-19 11:32:01
 */
package me.cmilby.chessbackend.repository.chess;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.cmilby.chessbackend.domain.chess.ActiveGame;
import me.cmilby.chessbackend.domain.chess.ActiveGameUser;
import me.cmilby.chessbackend.repository.annotation.ChessRepository;

/**
 * ChessDao
 */
@ChessRepository
public interface ChessDao {

	void addActiveGame ( @Param ( "id" ) String p_id );

	boolean activeGameWithIdExists ( @Param ( "id" ) String p_id );

	void addUserToActiveGame ( @Param ( "gameId" ) String p_gameId, @Param ( "userId" ) Long p_userId );

	boolean playerIsInActiveGame ( @Param ( "gameId" ) String p_gameId, @Param ( "userId" ) Long p_userId );

	List < ActiveGame > getJoinableActiveGames ( );

	List < ActiveGameUser > getAllActiveGameUsers ( );
}