package com.webmaster.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	HomeInterceptor homeInterceptor;
	
	@Autowired
	ProductInterceptor productInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(homeInterceptor);
		registry.addInterceptor(productInterceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}