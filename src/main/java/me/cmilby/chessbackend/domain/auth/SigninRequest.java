/*
 * @Author: Craig Milby 
 * @Date: 2019-05-18 09:16:00 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 09:20:30
 */
package me.cmilby.chessbackend.domain.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SigninRequest
 */
public class SigninRequest {

	@JsonProperty ( "UsernameOrEmail" )
	private String usernameOrEmail;

	@JsonProperty ( "Password" )
	private String password;

	public SigninRequest ( ) {

	}

	public SigninRequest ( String usernameOrEmail, String password ) {
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}

	public String getUsernameOrEmail ( ) {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail ( String usernameOrEmail ) {
		this.usernameOrEmail = usernameOrEmail;
	}

	public String getPassword ( ) {
		return password;
	}

	public void setPassword ( String password ) {
		this.password = password;
	}
}