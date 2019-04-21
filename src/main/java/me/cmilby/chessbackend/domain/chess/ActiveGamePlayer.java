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
 * ActiveGamePlayer
 */
public class ActiveGamePlayer {

	private Integer gameId;
	private Integer playerId;
	private String color;

	public ActiveGamePlayer ( ) {

	}

	/**
	 * @return the gameId
	 */
	public Integer getGameId ( ) {
		return gameId;
	}

	/**
	 * @param gameId
	 *                   the gameId to set
	 */
	public void setGameId ( Integer gameId ) {
		this.gameId = gameId;
	}

	/**
	 * @return the playerId
	 */
	public Integer getPlayerId ( ) {
		return playerId;
	}

	/**
	 * @param playerId
	 *                     the playerId to set
	 */
	public void setPlayerId ( Integer playerId ) {
		this.playerId = playerId;
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
		return "ActiveGamePlayer [color=" + color + ", gameId=" + gameId + ", playerId=" + playerId + "]";
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