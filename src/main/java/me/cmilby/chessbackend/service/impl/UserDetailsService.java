/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:23:11 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 19:06:17
 */
package me.cmilby.chessbackend.service.impl;

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

	@Override
	public UserDetails loadUserByUsername ( String p_username ) throws UsernameNotFoundException {
		User user = userDao.getUserWithUsername ( p_username );
		if ( user == null ) {
			throw new UsernameNotFoundException ( p_username );
		}

		user.setAuthorities ( userDao.getRoleWithUsername ( p_username ).getName ( ) );
		return new org.springframework.security.core.userdetails.User ( user.getUsername ( ), user.getPassword ( ),
				user.getAuthorities ( ) );
	}
}