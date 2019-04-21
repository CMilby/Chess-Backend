/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:16:13 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 18:44:02
 */
package me.cmilby.chessbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * ResourceServerConfig
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value ( "${security.jwt.resource-ids}" )
	private String resourceIds;

	@Autowired
	private ResourceServerTokenServices tokenServices;

	@Override
	public void configure ( ResourceServerSecurityConfigurer resources ) throws Exception {
		resources.resourceId ( resourceIds ).tokenServices ( tokenServices );
	}

	@Override
	public void configure ( HttpSecurity http ) throws Exception {
		http.requestMatchers ( ).and ( ).authorizeRequests ( ).antMatchers ( "/api-docs/**" ).permitAll ( )
				.antMatchers ( "/api/**" ).authenticated ( );
	}
}