/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:34:01 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 14:35:08
 */
package me.cmilby.chessbackend.repository.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Repository;

/**
 * ExternalRepository
 */
@Retention ( RetentionPolicy.RUNTIME )
@Target ( { ElementType.TYPE } )
@Documented
@Repository
public @interface ChessRepository {

}