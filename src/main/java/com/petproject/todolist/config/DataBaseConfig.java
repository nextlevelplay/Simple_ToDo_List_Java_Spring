package com.petproject.todolist.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement   // USE COMMENT TO SWITCH JDBC TEMPLATE REPOSITORY
//@ComponentScan(basePackages = "com.petproject")  // USE UNCOMMENT TO SWITCH JDBC TEMPLATE REPOSITORY
@PropertySource("classpath:application.properties")
public class DataBaseConfig {


    // Old style set Values into DataSource FOR JDBC TEMPLATE REPOSITORY
//    @Value("${database.url}")
//    private String databaseUrl;
//    @Value("${database.driver}")
//    private String databaseDriver;
//    @Value("${database.user}")
//    private String databaseUser;
//    @Value("${database.password}")
//    private String databasePassword;



    // Bean FOR HIBERNATE REPOSITORY
    @Bean
    public SessionFactory sessionFactory(DataSource dataSource,
                                         @Value("${hibernate.hbm2ddl.auto}") String ddl,
                                         @Value("${hibernate.dialect}") String dialect,
                                         @Value("${hibernate.package.scan}") String packageScan
    ) throws IOException {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(packageScan);
        var hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto",ddl);
        hibernateProperties.setProperty("hibernate.dialect",dialect);
        sessionFactory.setHibernateProperties(hibernateProperties);
        sessionFactory.afterPropertiesSet();
        return sessionFactory.getObject();
    }

    // Bean FOR HIBERNATE REPOSITORY
    @Bean
    public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        var transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    // Bean FOR HIBERNATE REPOSITORY
    // OLD VERSION! Properties witout application.properties (Already set into sessionFactory Bean)
//    @Bean
//    private final Properties hibernateProperties() {
//        var hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","create-drop");
//        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
//        return hibernateProperties;
//    }

    @Bean
    public DataSource dataSource(
            @Value("${database.url}") String databaseUrl,
            @Value("${database.driver}") String databaseDriver,
            @Value("${database.user}") String databaseUser,
            @Value("${database.password}") String databasePassword
    ) {
        var dataSource = new BasicDataSource();
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUser);
        dataSource.setPassword(databasePassword);
        dataSource.setDriverClassName(databaseDriver);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
