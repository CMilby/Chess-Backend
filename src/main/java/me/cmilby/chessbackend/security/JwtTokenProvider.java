/*
 * @Author: Craig Milby 
 * @Date: 2019-05-17 23:13:12 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-17 23:30:32
 */
package me.cmilby.chessbackend.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * JwtTokenProvider
 */
@Component
public class JwtTokenProvider {

	@Value ( "${security.jwt.client-secret}" )
	private String jwtSecret;

	private static final Logger logger = LoggerFactory.getLogger ( JwtTokenProvider.class );

	public String generateToken ( Authentication auth ) {
		User user = ( User ) auth.getPrincipal ( );

		return Jwts.builder ( ).setSubject ( user.getUsername ( ) ).setIssuedAt ( new Date ( ) )
				.signWith ( SignatureAlgorithm.HS512, jwtSecret ).compact ( );
	}

	public String getUsernameFromJWT ( String token ) {
		Claims claims = Jwts.parser ( ).setSigningKey ( jwtSecret ).parseClaimsJws ( token ).getBody ( );
		return claims.getSubject ( );
	}

	public boolean validateToken ( String authToken ) {
		try {
			Jwts.parser ( ).setSigningKey ( jwtSecret ).parseClaimsJws ( authToken );
			return true;
		} catch ( SignatureException ex ) {
			logger.error ( "Invalid JWT Signature", ex );
		} catch ( MalformedJwtException ex ) {
			logger.error ( "Invalid JWT Token", ex );
		} catch ( ExpiredJwtException ex ) {
			logger.error ( "Expired JWT Token", ex );
		} catch ( UnsupportedJwtException ex ) {
			logger.error ( "Unsupported JWT Token", ex );
		} catch ( IllegalArgumentException ex ) {
			logger.error ( "JWT Claims String is empty", ex );
		}

		return false;
	}
}