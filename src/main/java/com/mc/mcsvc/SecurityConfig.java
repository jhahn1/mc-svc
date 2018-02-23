package com.mc.mcsvc;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jhahn on 2/23/18.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value(value = "${auth0.apiAudience}")
	private String apiAudience;
	@Value(value = "${auth0.issuer}")
	private String issuer;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		JwtWebSecurityConfigurer
				.forRS256(apiAudience, issuer)
				.configure(http)
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/nonsecure").permitAll()
				.antMatchers(HttpMethod.GET, "/challenge/**").hasAuthority("create:challenge")
				.anyRequest().authenticated();
	}

}