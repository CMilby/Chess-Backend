/*
 * @Author: Craig Milby 
 * @Date: 2019-05-18 09:17:13 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 09:18:17
 */
package me.cmilby.chessbackend.domain.auth;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SignupRequest
 */
public class SignupRequest {

	@JsonProperty ( "Username" )
	@NotBlank
	private String username;

	@JsonProperty ( "Email" )
	@NotBlank
	private String email;

	@JsonProperty ( "Password" )
	@NotBlank
	private String password;

	public String getUsername ( ) {
		return username;
	}

	public void setUsername ( String username ) {
		this.username = username;
	}

	public String getEmail ( ) {
		return email;
	}

	public void setEmail ( String email ) {
		this.email = email;
	}

	public String getPassword ( ) {
		return password;
	}

	public void setPassword ( String password ) {
		this.password = password;
	}
}