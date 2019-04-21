/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 20:01:03 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 20:04:45
 */
package me.cmilby.chessbackend.domain.chess;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * ActiveGame
 */
public class ActiveGame {

	private String id;
	private Date startDttm;
	private String gameFormat;
	private String currentMove;

	private List < ActiveGamePlayer > players;

	public ActiveGame ( ) {

	}

	/**
	 * @return the id
	 */
	public String getId ( ) {
		return id;
	}

	/**
	 * @param id
	 *               the id to set
	 */
	public void setId ( String id ) {
		this.id = id;
	}

	/**
	 * @return the startDttm
	 */
	public Date getStartDttm ( ) {
		return startDttm;
	}

	/**
	 * @param startDttm
	 *                      the startDttm to set
	 */
	public void setStartDttm ( Date startDttm ) {
		this.startDttm = startDttm;
	}

	/**
	 * @return the gameFormat
	 */
	public String getGameFormat ( ) {
		return gameFormat;
	}

	/**
	 * @param gameFormat
	 *                       the gameFormat to set
	 */
	public void setGameFormat ( String gameFormat ) {
		this.gameFormat = gameFormat;
	}

	/**
	 * @return the currentMove
	 */
	public String getCurrentMove ( ) {
		return currentMove;
	}

	/**
	 * @param currentMove
	 *                        the currentMove to set
	 */
	public void setCurrentMove ( String currentMove ) {
		this.currentMove = currentMove;
	}

	/**
	 * @return the players
	 */
	public List < ActiveGamePlayer > getPlayers ( ) {
		return players;
	}

	/**
	 * @param players
	 *                    the players to set
	 */
	public void setPlayers ( List < ActiveGamePlayer > players ) {
		this.players = players;
	}

	@Override
	public String toString ( ) {
		return "ActiveGame [currentMove=" + currentMove + ", gameFormat=" + gameFormat + ", id=" + id + ", players="
				+ players + ", startDttm=" + startDttm + "]";
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