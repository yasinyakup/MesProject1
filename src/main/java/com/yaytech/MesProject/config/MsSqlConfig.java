package com.yaytech.MesProject.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({"classpath:db.properties"})
@EnableJpaRepositories(
        basePackages =  "com.yaytech.MesProject.repo.mssql",
        entityManagerFactoryRef = "mssqlEntityManager",
        transactionManagerRef = "mssqlTransactionManager")
public class MsSqlConfig {

    @Autowired
    Environment env;


    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource-mssql")
    public DataSourceProperties mssqlDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "mssqlDataSource")
    @Primary
    public DataSource mssqlDataSource(@Qualifier("mssqlDataSourceProperties") DataSourceProperties mssqlDataSourceProperties) {
        return mssqlDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    // productEntityManager bean
    @Bean(name = "mssqlEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean mssqlEntityManager(EntityManagerFactoryBuilder postgresEntityManagerFactoryBuilder, @Qualifier("mssqlDataSource") DataSource mssqlDataSource) {

        HashMap<String, Object> hibernateProperties = new HashMap<>();
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");

        return postgresEntityManagerFactoryBuilder
                .dataSource(mssqlDataSource)
                .packages("com.yaytech.MesProject.model.mssql")
                .persistenceUnit("mssqlDataSource")
                .properties(hibernateProperties)
                .build();
    }
    // productTransactionManager bean
    @Bean
    @Primary
    public PlatformTransactionManager mssqlTransactionManager(@Qualifier("mssqlEntityManager") EntityManagerFactory mssqlEntityManager) {

        return new JpaTransactionManager(mssqlEntityManager);
    }
}
