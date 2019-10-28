package be.afelio.software_academy.spring_jpa.example.dvdrental.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.afelio.software_academy.spring_jpa.example.dvdrental.utils.DBTestUtils;

@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan({"be.afelio.software_academy.pco.spring_jpa.example.dvdrental"})
@EnableJpaRepositories("be.afelio.software_academy.pco.spring_jpa.example.dvdrental.spring_repositories")
@EnableTransactionManagement
public class ApplicationConfig {

    @Autowired
    Environment environment;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl(environment.getProperty("database.url"));
        datasource.setUsername(environment.getProperty("database.user"));
        datasource.setPassword(environment.getProperty("database.password"));
        datasource.setDriverClassName(environment.getProperty("database.driver"));
        return datasource;
    }

    @Bean
    DBTestUtils createDBTestUtils() {
    	return new DBTestUtils(dataSource());
    }
    
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
        emf.setPackagesToScan("be.afelio.software_academy.pco.spring_jpa.example.dvdrental.entities");
        Properties properties = new Properties();
        properties.setProperty("eclipselink.logging.level", "FINE");
        properties.setProperty("eclipselink.weaving", "false");
        emf.setJpaProperties(properties);
        return emf;
    }

    @Bean
    JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
