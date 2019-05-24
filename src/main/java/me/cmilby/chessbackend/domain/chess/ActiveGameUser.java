/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 20:02:44 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 20:03:56
 */
package me.cmilby.chessbackend.domain.chess;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * ActiveGameUser
 */
public class ActiveGameUser {

	private String gameId;
	private Long userId;
	private String color;

	public ActiveGameUser ( ) {

	}

	/**
	 * @return the gameId
	 */
	public String getGameId ( ) {
		return gameId;
	}

	/**
	 * @param gameId
	 *                   the gameId to set
	 */
	public void setGameId ( String gameId ) {
		this.gameId = gameId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId ( ) {
		return userId;
	}

	/**
	 * @param playerId
	 *                     the userId to set
	 */
	public void setUserId ( Long userId ) {
		this.userId = userId;
	}

	/**
	 * @return the color
	 */
	public String getColor ( ) {
		return color;
	}

	/**
	 * @param color
	 *                  the color to set
	 */
	public void setColor ( String color ) {
		this.color = color;
	}

	@Override
	public String toString ( ) {
		return "ActiveGameUser [color=" + color + ", gameId=" + gameId + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode ( ) {
		return HashCodeBuilder.reflectionHashCode ( this );
	}

	@Override
	public boolean equals ( final Object obj ) {
		return EqualsBuilder.reflectionEquals ( this, obj );
	}
}