package com.simple.ecommerce.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.simple.ecommerce.postgres.repository",
        entityManagerFactoryRef = "pgEntityManagerFactory",
        transactionManagerRef = "pgTransactionManager"
)
public class PostgresConfig {

    @Value("${pg.jpa.properties.hibernate.hbm2ddl.auto}")
    private String auto;

    @Value("${pg.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Bean
    @ConfigurationProperties(prefix = "pg.datasource")
    public DataSource pgDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean pgEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", false);
        properties.put("hibernate.hbm2ddl.auto", auto);
        properties.put("hibernate.dialect", dialect);
        return builder
                .dataSource(pgDataSource())
                .packages("com.simple.ecommerce.postgres.entity")
                .persistenceUnit("pg")
                .properties(properties)
                .build();
    }

    @Bean
    public PlatformTransactionManager pgTransactionManager(
            @Qualifier("pgEntityManagerFactory") EntityManagerFactory pgEntityManagerFactory) {
        return new JpaTransactionManager(pgEntityManagerFactory);
    }

}
