/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:33:02 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 14:41:19
 */
package me.cmilby.chessbackend.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.cmilby.chessbackend.repository.annotation.ChessRepository;
import me.cmilby.chessbackend.repository.annotation.UserRepository;

/**
 * MyBatisConfig
 */
@Configuration
public class MyBatisConfig {

	@MapperScan ( basePackages = {
			"me.cmilby.chessbackend.repository.chess" }, sqlSessionTemplateRef = "chessSqlSessionTemplate", annotationClass = ChessRepository.class )
	public class ChessRepositoryConfig {

		@Bean ( name = "chessSqlSessionTemplate" )
		public SqlSessionTemplate chessSqlSessionTemplate (
				@Qualifier ( "chessDataSource" ) DataSource chessDataSource ) throws Exception {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean ( );
			sqlSessionFactoryBean.setDataSource ( chessDataSource );

			final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject ( );

			sqlSessionFactory.getConfiguration ( ).setAutoMappingBehavior ( AutoMappingBehavior.FULL );
			sqlSessionFactory.getConfiguration ( ).setMapUnderscoreToCamelCase ( true );

			final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate ( sqlSessionFactory );
			return sqlSessionTemplate;
		}
	}

	@MapperScan ( basePackages = {
			"me.cmilby.chessbackend.repository.user" }, sqlSessionTemplateRef = "userSqlSessionTemplate", annotationClass = UserRepository.class )
	public class UserRepositoryConfig {

		@Bean ( name = "userSqlSessionTemplate" )
		public SqlSessionTemplate chessSqlSessionTemplate ( @Qualifier ( "userDataSource" ) DataSource chessDataSource )
				throws Exception {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean ( );
			sqlSessionFactoryBean.setDataSource ( chessDataSource );

			final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject ( );

			sqlSessionFactory.getConfiguration ( ).setAutoMappingBehavior ( AutoMappingBehavior.FULL );
			sqlSessionFactory.getConfiguration ( ).setMapUnderscoreToCamelCase ( true );

			final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate ( sqlSessionFactory );
			return sqlSessionTemplate;
		}
	}
}