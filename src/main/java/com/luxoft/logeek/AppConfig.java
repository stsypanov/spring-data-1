package com.luxoft.logeek;

import com.luxoft.logeek.repository.BaseJpaRepositoryImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseJpaRepositoryImpl.class)
public class AppConfig {
}
