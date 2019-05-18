/*
 * @Author: Craig Milby 
 * @Date: 2019-05-17 23:19:56 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 12:07:56
 */
package me.cmilby.chessbackend.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import me.cmilby.chessbackend.service.impl.UserDetailsService;

/**
 * JwtAuthenticationFilter
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserDetailsService userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger ( JwtAuthenticationFilter.class );

	@Override
	public void doFilterInternal ( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain )
			throws ServletException, IOException {
		try {
			String jwt = getJwtFromRequest ( request );
			if ( StringUtils.hasText ( jwt ) && tokenProvider.validateToken ( jwt ) ) {
				String username = tokenProvider.getUsernameFromJWT ( jwt );

				UserDetails userDetails = userDetailsService.loadUserByUsername ( username );
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken ( userDetails, null,
						userDetails.getAuthorities ( ) );
				auth.setDetails ( new WebAuthenticationDetailsSource ( ).buildDetails ( request ) );

				SecurityContextHolder.getContext ( ).setAuthentication ( auth );
			}
		} catch ( Exception ex ) {
			logger.error ( "Could not set user auth in security context", ex );
		}

		filterChain.doFilter ( request, response );
	}

	private String getJwtFromRequest ( HttpServletRequest request ) {
		String bearerToken = request.getHeader ( "Authorization" );
		if ( StringUtils.hasText ( bearerToken ) && bearerToken.startsWith ( "Bearer " ) ) {
			return bearerToken.substring ( 7, bearerToken.length ( ) );
		}

		return null;
	}
}