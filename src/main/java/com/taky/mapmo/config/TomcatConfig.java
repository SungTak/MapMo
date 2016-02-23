package com.taky.mapmo.config;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {
	private static final int HTTPS_PORT = 8443;
	private static final String KEYSTORE_PATH = "C:/Program Files/Java/jdk1.8.0_45/bin/keystore.p12";
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		
		TomcatEmbeddedServletContainerFactory tomcat =  new TomcatEmbeddedServletContainerFactory() {
			private Logger logger = LoggerFactory.getLogger(this.getClass());	

			// 이미지 저장 논리 경로 설정
			// http://stackoverflow.com/questions/25995635/can-i-enable-the-tomcat-manager-app-for-spring-boots-embedded-tomcat
			// http://tibang.tistory.com/626
			@Override
			protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
				try {
					File file = new File(System.getProperty("user.home") + "/static/image/upload");
					if (file.isDirectory() == false) {
						file.mkdirs();
					}
					logger.debug(file.getAbsolutePath());
					logger.debug(tomcat.getHost().getAppBaseFile().getAbsolutePath());
					
					tomcat.addWebapp("/static/image", file.getAbsolutePath());
					
				} catch (ServletException e) {
					logger.error("### 톰캣의 URL 물리 경로를 찾지 못했습니다!", e);
				}
				
				return super.getTomcatEmbeddedServletContainer(tomcat);
			}

			// HTTPS 세팅
			// http://hellowk1.blogspot.kr/2015/04/spring-tomcat-https.html
			// https://www.drissamri.be/blog/java/enable-https-in-spring-boot/
			@Override
			protected void postProcessContext(Context context) {
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");

				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				securityConstraint.addCollection(collection);
				
				context.addConstraint(securityConstraint);
			}
		};
		
		tomcat.addAdditionalTomcatConnectors(initHttpConnector());
		tomcat.setPort(HTTPS_PORT);
//		tomcat.addAdditionalTomcatConnectors(createSslConnector()); // Properties 자바 버전, port 중복 수행 해결을 위해 tomcat.setPort(0)
		return tomcat;
	}
	
	// HTTPS 세팅
	private Connector initHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(HTTPS_PORT);
		return connector;
	}
	
	// https://www.lesstif.com/pages/viewpage.action?pageId=20775436
	// http://stackoverflow.com/questions/19613562/how-can-i-specify-my-keystore-file-with-spring-boot-and-tomcat
//	private Connector createSslConnector() {
//	    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//	    Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
//	    File keystore = new File(KEYSTORE_PATH);
//		File truststore = new File(KEYSTORE_PATH);
//		connector.setScheme("https");
//		connector.setSecure(true);
//		connector.setPort(HTTPS_PORT);
//		protocol.setSSLEnabled(true);
//		protocol.setKeystoreFile(keystore.getAbsolutePath());
//		protocol.setKeystorePass("20072725");
//		protocol.setTruststoreFile(truststore.getAbsolutePath());
//		protocol.setTruststorePass("20072725");
//		protocol.setKeyAlias("tomcat");
//		return connector;
//	}
}
