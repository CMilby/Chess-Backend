/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:23:11 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 09:59:57
 */
package me.cmilby.chessbackend.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import me.cmilby.chessbackend.domain.user.User;
import me.cmilby.chessbackend.repository.user.UserDao;

/**
 * UserDetailsService
 */
@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserDao userDao;

	private final Logger logger = LoggerFactory.getLogger ( UserDetailsService.class );

	@Override
	public UserDetails loadUserByUsername ( String p_usernameOrEmail ) throws UsernameNotFoundException {
		User user = userDao.getUserWithUsername ( p_usernameOrEmail );
		if ( user == null ) {
			user = userDao.getUserWithUsername ( p_usernameOrEmail );
			if ( user == null ) {
				// throw new UsernameNotFoundException ( p_usernameOrEmail );

				logger.info ( "Username or Email Not Found: " + p_usernameOrEmail );
				return null;
			}
		}

		user.setAuthorities ( userDao.getRoleWithUsername ( user.getUsername ( ) ).getName ( ) );
		return new org.springframework.security.core.userdetails.User ( user.getUsername ( ), user.getPassword ( ),
				user.getAuthorities ( ) );
	}
}