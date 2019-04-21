/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 13:51:14 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 18:33:53
 */
package me.cmilby.chessbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping ( "/test" )
public class TestController {

	@GetMapping ( value = "/test.json" )
	@PreAuthorize ( "hasAuthority('ADMIN') or hasAuthority('USER')" )
	public String test ( ) {
		return "[{\"data1\":1,\"data2\":\"test2\"},{\"data1\":5,\"data2\":\"test7\"}]";
	}
}