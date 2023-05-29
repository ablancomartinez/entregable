package com.example.demo.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableJpaRepositories (basePackages = "com.example.demo.repository.jpa")
public class JpaConfig {
	@Autowired
	private Environment env;
	
	@Value("spring.datasource.url")
	private String url;
	
	@Value("spring.datasource.username")
	private String username;
	

	public JpaConfig() {
		super();
	}

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setDriverClassName("org.postgresql.Driver");
		 dataSource.setUrl(env.getProperty("spring.datasource.url"));
		//dataSource.setUrl(url);
		 dataSource.setUsername(env.getProperty("spring.datasource.username"));
		//dataSource.setUsername(username);
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.example.demo.entidades" });
		
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		 JpaTransactionManager transactionManager = new JpaTransactionManager();
		
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return properties;
	}

}
