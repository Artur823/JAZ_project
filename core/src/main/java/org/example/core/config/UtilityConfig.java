package org.example.core.config;

import com.example.utils.NumberUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для регистрации утилитарных классов.
 */
@Configuration
public class UtilityConfig {

    /**
     * Регистрируем кастомный бин NumberUtils.
     *
     * @return Экземпляр NumberUtils.
     */
    @Bean
    public NumberUtils numberUtils() {
        return new NumberUtils();
    }
}