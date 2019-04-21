/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 18:55:42 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 18:57:18
 */
package me.cmilby.chessbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api ( ) {
		return new Docket ( DocumentationType.SWAGGER_2 ).select ( ).apis ( RequestHandlerSelectors.any ( ) )
				.paths ( PathSelectors.any ( ) ).build ( ).pathMapping ( "/" ).useDefaultResponseMessages ( true )
				.apiInfo ( getApiInfo ( ) );
	}

	private ApiInfo getApiInfo ( ) {
		return new ApiInfoBuilder ( ).title ( "Chess" ).build ( );
	}
}