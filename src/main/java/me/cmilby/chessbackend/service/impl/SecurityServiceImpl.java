/*
 * @Author: Craig Milby 
 * @Date: 2019-05-17 20:28:33 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 11:37:57
 */
package me.cmilby.chessbackend.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import me.cmilby.chessbackend.security.JwtTokenProvider;
import me.cmilby.chessbackend.service.SecurityService;

/**
 * SecurityServiceImpl
 */
@Service ( "SecurityService" )
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenProvider tokenProvider;

	private final Logger logger = LoggerFactory.getLogger ( SecurityServiceImpl.class );

	@Override
	public String findLoggedInUsername ( ) {
		Object principal = SecurityContextHolder.getContext ( ).getAuthentication ( ).getPrincipal ( );

		if ( principal instanceof org.springframework.security.core.userdetails.User ) {
			return ( ( org.springframework.security.core.userdetails.User ) principal ).getUsername ( );
		}

		return null;
	}

	@Override
	public String autoLogin ( String p_usernameOrEmail, String p_password ) {
		try {
			UserDetails userDetails = userDetailsService.loadUserByUsername ( p_usernameOrEmail );
			if ( userDetails == null ) {
				return null;
			}

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken (
					userDetails, p_password, userDetails.getAuthorities ( ) );

			Authentication auth = authenticationManager.authenticate ( usernamePasswordAuthenticationToken );
			if ( usernamePasswordAuthenticationToken.isAuthenticated ( ) ) {
				SecurityContextHolder.getContext ( ).setAuthentication ( auth );
			}

			return tokenProvider.generateToken ( SecurityContextHolder.getContext ( ).getAuthentication ( ) );
		} catch ( AuthenticationException ex ) {
			logger.error ( ex.getMessage ( ) );
			return null;
		} catch ( Exception ex ) {
			logger.error ( ex.getMessage ( ) );
			return null;
		}
	}
}