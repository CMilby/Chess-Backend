/*
 * @Author: Craig Milby 
 * @Date: 2019-05-17 20:29:50 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 11:36:00
 */
package me.cmilby.chessbackend.service;

/**
 * SecurityService
 */
public interface SecurityService {

	String findLoggedInUsername ( );

	String autoLogin ( String p_usernameOrEmail, String p_password );
}