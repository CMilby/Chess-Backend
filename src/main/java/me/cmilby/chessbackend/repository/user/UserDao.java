/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:22:20 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 09:25:02
 */
package me.cmilby.chessbackend.repository.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.cmilby.chessbackend.domain.user.Role;
import me.cmilby.chessbackend.domain.user.User;
import me.cmilby.chessbackend.repository.annotation.UserRepository;

/**
 * UserDao
 */
@UserRepository
public interface UserDao {

	List < User > getAllUsers ( );

	User getUserWithUsername ( @Param ( "username" ) String p_username );

	User getUserWithEmail ( @Param ( "email" ) String p_email );

	Role getRoleWithUsername ( @Param ( "username" ) String p_username );

	boolean userWithUsernameExists ( @Param ( "username" ) String p_username );

	boolean userWithEmailExists ( @Param ( "email" ) String p_email );

	Long getMaxId ( );

	void insertUser ( @Param ( "id" ) Long p_id, @Param ( "user" ) User p_user );

	void insertUserDefaultRole ( @Param ( "id" ) Long p_id );
}