/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:22:20 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 15:19:38
 */
package me.cmilby.chessbackend.repository.user;

import org.apache.ibatis.annotations.Param;

import me.cmilby.chessbackend.domain.user.Role;
import me.cmilby.chessbackend.domain.user.User;
import me.cmilby.chessbackend.repository.annotation.UserRepository;

/**
 * UserDao
 */
@UserRepository
public interface UserDao {

	User getUserWithUsername ( @Param ( "username" ) String p_username );

	Role getRoleWithUsername ( @Param ( "username" ) String p_username );
}