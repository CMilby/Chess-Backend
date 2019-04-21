/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 13:51:09 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 14:49:06
 */
package me.cmilby.chessbackend.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * DBConfig
 */
@Configuration
public class DBConfig {

	@Bean
	@Primary
	public DataSource userDataSource ( ) {
		return new EmbeddedDatabaseBuilder ( ).setType ( EmbeddedDatabaseType.HSQL ).setName ( "dev-user" )
				.addScript ( "classpath:database/user-schema.sql" ).addScript ( "classpath:database/user-data.sql" )
				.build ( );
	}

	@Bean
	public DataSource chessDataSource ( ) {
		return new EmbeddedDatabaseBuilder ( ).setType ( EmbeddedDatabaseType.HSQL ).setName ( "dev-chess" )
				.addScript ( "classpath:database/chess-schema.sql" ).addScript ( "classpath:database/chess-data.sql" )
				.build ( );
	}
}