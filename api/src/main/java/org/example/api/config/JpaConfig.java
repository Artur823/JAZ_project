package org.example.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.example.core.repository")
@EntityScan(basePackages = "org.example.core.model") // Это указывает на место, где сканируются ваши сущности
public class JpaConfig {
}
