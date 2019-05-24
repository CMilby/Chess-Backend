/*
 * @Author: Craig Milby 
 * @Date: 2019-05-17 19:26:33 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 11:36:12
 */
package me.cmilby.chessbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.cmilby.chessbackend.domain.auth.SigninRequest;
import me.cmilby.chessbackend.domain.auth.SignupRequest;
import me.cmilby.chessbackend.domain.user.User;
import me.cmilby.chessbackend.domain.util.ApiResponse;
import me.cmilby.chessbackend.service.UserService;
import me.cmilby.chessbackend.service.SecurityService;

/**
 * AuthController
 */
@RestController
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@PostMapping ( "/auth/signup" )
	public ResponseEntity < ? > signup ( @RequestBody SignupRequest p_signup ) {
		if ( userService.userWithUsernameExists ( p_signup.getUsername ( ) ) ) {
			return new ResponseEntity <> ( new ApiResponse ( false, "Username already in use" ),
					HttpStatus.BAD_REQUEST );
		}

		if ( userService.userWithEmailExists ( p_signup.getEmail ( ) ) ) {
			return new ResponseEntity <> ( new ApiResponse ( false, "Email already in use" ), HttpStatus.BAD_REQUEST );
		}

		if ( !userService.createAccount ( p_signup ) ) {
			return new ResponseEntity <> ( new ApiResponse ( false, "Internal Server Error Creating Account" ),
					HttpStatus.INTERNAL_SERVER_ERROR );
		}

		return ResponseEntity.ok ( ).body ( "User registered successfully" );
	}

	@PostMapping ( "/auth/signin" )
	public ResponseEntity < ? > signin ( @RequestBody SigninRequest p_signin ) {
		String jwtToken = null;
		if ( ( jwtToken = securityService.autoLogin ( p_signin.getUsernameOrEmail ( ),
				p_signin.getPassword ( ) ) ) != null ) {
			User user = userService.getUserByUsernameOrEmail ( p_signin.getUsernameOrEmail ( ) );
			return new ResponseEntity <> ( new ApiResponse ( true, jwtToken, user ), HttpStatus.OK );
		}

		return new ResponseEntity <> ( new ApiResponse ( false, "Unable to signin user" ), HttpStatus.OK );
	}
}