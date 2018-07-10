package com.luxoft.logeek;

import com.luxoft.logeek.repository.BaseJpaRepositoryImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
        repositoryBaseClass = BaseJpaRepositoryImpl.class,
        basePackages = "com.luxoft.logeek.repository"
)
@EntityScan(basePackages = "com.luxoft.logeek.entity")
public class AppConfig {
}
