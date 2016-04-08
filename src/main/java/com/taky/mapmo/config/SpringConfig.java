package com.taky.mapmo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private DefaultTemplateResolverConfiguration TemplateResolver;
	
	@Bean
	public SpringTemplateEngine templateEngine() {
		// 디폴트 view resolver 전달, sec사용을 위함
		// http://stackoverflow.com/questions/18309864/secauthorize-and-secauthentication-annotations-dont-work
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(TemplateResolver.defaultTemplateResolver());
		templateEngine.addDialect(new SpringSecurityDialect());
		return templateEngine;
	}
}
