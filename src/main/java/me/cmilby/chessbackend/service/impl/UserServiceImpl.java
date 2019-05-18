/*
 * @Author: Craig Milby 
 * @Date: 2019-05-17 19:27:55 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 10:26:23
 */
package me.cmilby.chessbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.cmilby.chessbackend.domain.auth.SignupRequest;
import me.cmilby.chessbackend.domain.user.User;
import me.cmilby.chessbackend.repository.user.UserDao;
import me.cmilby.chessbackend.service.SecurityService;
import me.cmilby.chessbackend.service.UserService;

/**
 * UserServiceImpl
 */
@Service ( "UserService" )
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SecurityService securityService;

	@Override
	public boolean userWithUsernameExists ( String p_username ) {
		return userDao.userWithUsernameExists ( p_username );
	}

	@Override
	public boolean userWithEmailExists ( String p_email ) {
		return userDao.userWithEmailExists ( p_email );
	}

	@Override
	public boolean isValidPassword ( String p_password ) {
		return true;
	}

	@Override
	public boolean createAccount ( SignupRequest p_signup ) {
		try {
			p_signup.setPassword ( passwordEncoder.encode ( p_signup.getPassword ( ) ) );

			Long nextId = userDao.getMaxId ( ) + 1;

			User user = new User ( p_signup.getUsername ( ), p_signup.getEmail ( ), p_signup.getPassword ( ) );

			userDao.insertUser ( nextId, user );
			userDao.insertUserDefaultRole ( nextId );
		} catch ( Exception ex ) {
			ex.printStackTrace ( );
			return false;
		}

		return true;
	}

	@Override
	public User getUserByUsernameOrEmail ( String p_usernameOrEmail ) {
		User user = userDao.getUserWithUsername ( p_usernameOrEmail );
		if ( user == null ) {
			user = userDao.getUserWithEmail ( p_usernameOrEmail );
		}

		return user;
	}

	@Override
	public User getCurrentUser ( ) {
		User user = getUserByUsernameOrEmail ( securityService.findLoggedInUsername ( ) );
		user.setPassword ( null );
		return user;
	}
}