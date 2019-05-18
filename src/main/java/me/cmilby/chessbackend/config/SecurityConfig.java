/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 13:51:05 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 12:05:02
 */
package me.cmilby.chessbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
// import org.springframework.security.oauth2.provider.token.TokenStore;
// import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
// import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import me.cmilby.chessbackend.security.JwtAuthenticationFilter;
import me.cmilby.chessbackend.service.impl.UserDetailsService;

/**
 * SecurityConfiguration
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity ( prePostEnabled = true, jsr250Enabled = true, securedEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value ( "${security.signing-key}" )
	private String signingKey;

	@Value ( "${security.encoding-strength}" )
	private Integer encodingStrength;

	@Value ( "${security.security-realm}" )
	private String securityRealm;

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter ( ) {
		return new JwtAuthenticationFilter ( );
	}

	@Bean ( BeanIds.AUTHENTICATION_MANAGER )
	@Override
	public AuthenticationManager authenticationManager ( ) throws Exception {
		return super.authenticationManager ( );
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder ( ) {
		return new BCryptPasswordEncoder ( encodingStrength );
	}

	@Override
	public void configure ( AuthenticationManagerBuilder auth ) throws Exception {
		auth.userDetailsService ( userDetailsService ).passwordEncoder ( passwordEncoder ( ) );
	}

	@Override
	public void configure ( HttpSecurity httpSecurity ) throws Exception {
		httpSecurity.sessionManagement ( ).sessionCreationPolicy ( SessionCreationPolicy.STATELESS ).and ( )
				.httpBasic ( ).realmName ( securityRealm ).and ( ).csrf ( ).disable ( );

		// httpSecurity.cors ( ).and ( ).csrf ( ).disable ( ).exceptionHandling ( )
		// .authenticationEntryPoint ( unauthroizedHandler ).and ( ).sessionManagement (
		// )
		// .sessionCreationPolicy ( SessionCreationPolicy.STATELESS ).and (
		// ).authorizeRequests ( )
		// .antMatchers ( "/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg",
		// "/**/*.jpg", "/**/*.html",
		// "/**/*.css", "/**/*.js" )
		// .permitAll ( ).antMatchers ( "/auth/**" ).permitAll ( )
		// .antMatchers ( "/user/checkUsernameAvailability",
		// "/user/checkEmailAvailability", "/user/me" )
		// .permitAll ( ).antMatchers ( HttpMethod.GET, "/users/**" ).permitAll (
		// ).anyRequest ( )
		// .authenticated ( );

		// httpSecurity.csrf ( ).disable ( ).exceptionHandling ( )
		// .authenticationEntryPoint ( unauthroizedHandler ).and ( ).sessionManagement (
		// )
		// .sessionCreationPolicy ( SessionCreationPolicy.STATELESS );

		httpSecurity.addFilterBefore ( jwtAuthenticationFilter ( ), UsernamePasswordAuthenticationFilter.class );
	}

	// @Bean
	// public JwtAccessTokenConverter accessTokenConverter ( ) {
	// JwtAccessTokenConverter converter = new JwtAccessTokenConverter ( );
	// converter.setSigningKey ( signingKey );
	// return converter;
	// }

	// @Bean
	// public TokenStore tokenStore ( ) {
	// return new JwtTokenStore ( accessTokenConverter ( ) );
	// }

	// @Bean
	// @Primary
	// public DefaultTokenServices tokenServices ( ) {
	// DefaultTokenServices defaultTokenServices = new DefaultTokenServices ( );
	// defaultTokenServices.setTokenStore ( tokenStore ( ) );
	// defaultTokenServices.setSupportRefreshToken ( true );
	// return defaultTokenServices;
	// }
}