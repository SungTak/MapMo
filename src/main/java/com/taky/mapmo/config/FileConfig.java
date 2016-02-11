package com.taky.mapmo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class FileConfig {
	/**
	 * file upload resolver..
	 * - http://stackoverflow.com/questions/25830503/spring-mvc-http-status-400-required-multipartfile-parameter-file-is-not-pre
	 * - http://java.ihoney.pe.kr/351
	 * - CommonsMultipartResolver쓰면 안된다.
	 * @return
	 */
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
		return resolver;
	}
}
