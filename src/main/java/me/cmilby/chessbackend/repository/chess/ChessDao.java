/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:45:54 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 20:05:17
 */
package me.cmilby.chessbackend.repository.chess;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.cmilby.chessbackend.domain.chess.ActiveGame;
import me.cmilby.chessbackend.repository.annotation.ChessRepository;

/**
 * ChessDao
 */
@ChessRepository
public interface ChessDao {

	void addActiveGame ( @Param ( "id" ) String p_id );

	List < ActiveGame > getJoinableActiveGames ( );
}