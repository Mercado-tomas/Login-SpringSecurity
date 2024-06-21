package com.spring.security.Spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        // rutas publicas
        // mapea las rutas
        registry.addMapping("/**")
                // mapea la ruta del front-end
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET","Post","PUT","DELETE","OPTIONS")
                .allowedHeaders("Origin","Content-Type","Accept","Authorization")
                // devuelve tocken
                .allowCredentials(true)
                .maxAge(3600);
        // rutas privadas
        // mapea la ruta
        registry.addMapping("/auth/**")
                // mapea la ruta del front-end
                .allowedOrigins("http://localhost:8080")
                // metodos http
                .allowedMethods("GET","Post","PUT","DELETE","OPTIONS")
                .allowedHeaders("Origin","Content-Type","Accept","Authorization")
                // NO devulve tocken
                .allowCredentials(false)
                .maxAge(3600);
    }

}
