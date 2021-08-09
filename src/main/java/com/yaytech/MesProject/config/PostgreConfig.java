package com.yaytech.MesProject.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({"classpath:db.properties"})
@EnableJpaRepositories(
        basePackages = "com.yaytech.MesProject.repo.postgres",
        transactionManagerRef = "postgresTransactionManager",
        entityManagerFactoryRef = "postgresEntityManager"
        )
public class PostgreConfig {
    @Autowired
    Environment env;

    @Bean(name = "postgresDataSourceProperties")
    @Qualifier("postgresDataSourceProperties")
    @ConfigurationProperties(prefix="spring.datasource-postgres")
    public DataSourceProperties postgresDataSourceProperties(){
        return new DataSourceProperties();
    }


    @Bean(name = "postgresDataSource")
    @Qualifier("postgresDataSource")
    public DataSource postgresDataSource(@Qualifier("postgresDataSourceProperties") DataSourceProperties postgresDataSourceProperties) {
        return postgresDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    // postgresEntityManager
    @Bean(name = "postgresEntityManager")
    @Qualifier("postgresEntityManager")
    public LocalContainerEntityManagerFactoryBean postgresEntityManager( EntityManagerFactoryBuilder postgresEntityManagerFactoryBuilder,
            @Qualifier("postgresDataSource") DataSource postgresDataSource) {


        HashMap<String, Object> hibernateProperties = new HashMap<>();
        hibernateProperties.put("hibernate.hbm2ddl.auto", "none");

        return postgresEntityManagerFactoryBuilder
                .dataSource(postgresDataSource)
                .packages("com.yaytech.MesProject.model.postgres")
                .persistenceUnit("postgresDataSource")
                .properties(hibernateProperties)
                .build();


    }
    // postgresTransactionManager
    @Bean(name = "postgresTransactionManager")
    @Qualifier("postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManager") EntityManagerFactory postgresEntityManager) {

       return new JpaTransactionManager(postgresEntityManager);
    }
}
