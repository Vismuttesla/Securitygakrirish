package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
     resources.resourceId("api");

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
     http.requestMatchers()
             .and()
             .authorizeRequests()
             .antMatchers("/**").authenticated()
             .antMatchers(HttpMethod.GET, "/api/v1/category","/api/v1/category/{id}").permitAll()
             .antMatchers("/","swagger-ui.html","/webjars/**","/swagger-resources/**","/doc/**")
             .permitAll();


         }
}
