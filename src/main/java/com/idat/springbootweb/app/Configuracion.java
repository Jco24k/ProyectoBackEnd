package com.idat.springbootweb.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin(origins = {"http://localhost:4200"})
@Configuration
public class Configuracion {
	@Bean
	public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {

               @Override

               public void addCorsMappings(CorsRegistry registry) {

                       registry.addMapping("/**")

                       .allowedOrigins("http://localhost:4200");

               }

        };

}
}
