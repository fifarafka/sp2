package com.myWallet;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
    
    @Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.exposedHeaders("Access-Control-Allow-Origin:*")
			.allowedHeaders("Access-Control-Allow-Origin:*")
			.allowedOrigins("http://localhost:9000");
	}
}
