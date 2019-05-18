/*
 * @Author: Craig Milby 
 * @Date: 2019-05-17 23:04:25 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-17 23:06:10
 */
package me.cmilby.chessbackend.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * JwtAuthenticationEntryPoint
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence ( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AuthenticationException e ) throws IOException, ServletException {
		httpServletResponse.sendError ( HttpServletResponse.SC_UNAUTHORIZED, e.getMessage ( ) );
	}
}