package com.proship.omrs;

import com.proship.omrs.config.AuthServerOAuth2Config;
import com.proship.omrs.config.ResourceServerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import javax.sql.DataSource;

@SpringBootApplication
public class OmrsApplication {


	public static void main(String[] args) {
		SpringApplication.run(
				new Class[]{OmrsApplication.class, AuthServerOAuth2Config.class,
						ResourceServerConfiguration.class, WebConfiguration.class },
				args);
	}
	
	
}
