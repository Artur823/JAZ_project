package org.example.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Разрешает доступ ко всем маршрутам
                .allowedOrigins("http://localhost:8080")  // Укажите ваш фронтенд домен
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Разрешенные методы
                .allowedHeaders("*")  // Разрешить все заголовки
                .allowCredentials(true);  // Разрешить отправку куки
    }
}
