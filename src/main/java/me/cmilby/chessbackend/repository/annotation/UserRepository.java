/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:40:03 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 14:40:24
 */
package me.cmilby.chessbackend.repository.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Repository;

/**
 * UserRepository
 */
@Retention ( RetentionPolicy.RUNTIME )
@Target ( { ElementType.TYPE } )
@Documented
@Repository
public @interface UserRepository {

}