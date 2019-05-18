/*
 * @Author: Craig Milby 
 * @Date: 2019-05-18 11:40:10 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 12:03:29
 */
package me.cmilby.chessbackend.security;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

/**
 * CurrentUser
 */
@Target ( { ElementType.PARAMETER, ElementType.TYPE } )
@Retention ( RetentionPolicy.RUNTIME )
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}