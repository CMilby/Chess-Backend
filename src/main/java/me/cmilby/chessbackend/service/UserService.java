/*
 * @Author: Craig Milby 
 * @Date: 2019-05-17 19:27:38 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 10:25:01
 */
package me.cmilby.chessbackend.service;

import me.cmilby.chessbackend.domain.auth.SignupRequest;
import me.cmilby.chessbackend.domain.user.User;

/**
 * UserService
 */
public interface UserService {

	boolean userWithUsernameExists ( String p_username );

	boolean userWithEmailExists ( String p_email );

	boolean isValidPassword ( String p_password );

	boolean createAccount ( SignupRequest p_signup );

	User getUserByUsernameOrEmail ( String p_usernameOrEmail );

	User getCurrentUser ( );
}