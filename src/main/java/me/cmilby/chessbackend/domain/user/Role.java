/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 15:15:36 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 15:16:58
 */
package me.cmilby.chessbackend.domain.user;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Role
 */
public class Role {

	private Integer roleId;
	private String name;

	public Role ( ) {

	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId ( ) {
		return roleId;
	}

	/**
	 * @param roleId
	 *                   the roleId to set
	 */
	public void setRoleId ( Integer roleId ) {
		this.roleId = roleId;
	}

	/**
	 * @return the name
	 */
	public String getName ( ) {
		return name;
	}

	/**
	 * @param name
	 *                 the name to set
	 */
	public void setName ( String name ) {
		this.name = name;
	}

	@Override
	public String toString ( ) {
		return "Role [name=" + name + ", roleId=" + roleId + "]";
	}

	@Override
	public int hashCode ( ) {
		return HashCodeBuilder.reflectionHashCode ( this );
	}

	@Override
	public boolean equals ( Object obj ) {
		return EqualsBuilder.reflectionEquals ( this, obj );
	}
}