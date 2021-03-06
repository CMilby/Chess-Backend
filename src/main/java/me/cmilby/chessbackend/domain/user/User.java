/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 15:03:31 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-19 11:31:35
 */
package me.cmilby.chessbackend.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * User
 */
public class User {

	@JsonIgnore
	private Long id;

	@JsonProperty ( "Username" )
	private String username;

	@JsonProperty ( "Email" )
	private String email;

	@JsonProperty ( "Password" )
	private String password;

	@JsonProperty ( value = "FirstName", required = false )
	private String firstName;

	@JsonProperty ( value = "LastName", required = false )
	private String lastName;

	@JsonIgnore
	private List < GrantedAuthority > authorities;

	public User ( ) {

	}

	public User ( String p_username, String p_email, String p_password ) {
		this.username = p_username;
		this.email = p_email;
		this.password = p_password;
	}

	public Long getId ( ) {
		return id;
	}

	public void setId ( Long id ) {
		this.id = id;
	}

	public String getEmail ( ) {
		return email;
	}

	public void setEmail ( String email ) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername ( ) {
		return username;
	}

	/**
	 * @param username
	 *                     the username to set
	 */
	public void setUsername ( String username ) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword ( ) {
		return password;
	}

	/**
	 * @param password
	 *                     the password to set
	 */
	public void setPassword ( String password ) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName ( ) {
		return firstName;
	}

	/**
	 * @param firstName
	 *                      the firstName to set
	 */
	public void setFirstName ( String firstName ) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName ( ) {
		return lastName;
	}

	/**
	 * @param lastName
	 *                     the lastName to set
	 */
	public void setLastName ( String lastName ) {
		this.lastName = lastName;
	}

	/**
	 * @return the authorities
	 */
	public List < GrantedAuthority > getAuthorities ( ) {
		return authorities;
	}

	/**
	 * @param authorities
	 *                        the authorities to set
	 */
	public void setAuthorities ( List < GrantedAuthority > authorities ) {
		this.authorities = authorities;
	}

	/**
	 * @param p_authorites
	 *                         the authorities to set
	 */
	public void setAuthorities ( String... p_authorities ) {
		authorities = new ArrayList <> ( p_authorities.length );
		for ( String auth : p_authorities ) {
			authorities.add ( new SimpleGrantedAuthority ( auth ) );
		}
	}

	@Override
	public String toString ( ) {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", username="
				+ username + ", id=" + id + "]";
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