/*
 * @Author: Craig Milby 
 * @Date: 2019-05-18 10:23:16 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 11:41:34
 */
package me.cmilby.chessbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.cmilby.chessbackend.domain.user.User;
import me.cmilby.chessbackend.domain.util.ApiResponse;
import me.cmilby.chessbackend.security.CurrentUser;
import me.cmilby.chessbackend.service.UserService;

/**
 * UserController
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping ( "/user/me" )
	public ResponseEntity < ? > me ( @CurrentUser User p_user ) {
		User user = userService.getCurrentUser ( );
		if ( user == null ) {
			return new ResponseEntity <> ( new ApiResponse ( false, "Could not get logged in user" ), HttpStatus.OK );
		}

		return new ResponseEntity <> ( new ApiResponse ( true, "Sucessfuly got logged in user", user ), HttpStatus.OK );
	}
}