package com.iig.gcp.jlogger.util;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.iig.gcp.jlogger.repository",entityManagerFactoryRef = "entityManagerFactory")
public class DBConnection {	

	@Autowired
    private DataSource dataSource;
	
	
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernatehbm2ddlauto;
	
	
	@Value("${hibernate.show_sql}")
	private String hibernateshowsql;

	
	 public Properties hibernateProperties() {
		    Properties props = new Properties();
		    props.put("hibernate.dialect",hibernateDialect);
			props.put("hibernate.hbm2ddl.auto",hibernatehbm2ddlauto);
			props.put("hibernate.show_sql",hibernateshowsql);
			
		    return props;
	 }

	 
	 @Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource);
	      em.setPackagesToScan(new String[] { "com.iig.gcp.jlogger.entity" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(hibernateProperties());
	 
	      return em;
	   }
	 
	 @Bean
	 public PlatformTransactionManager transactionManager(EntityManagerFactory em) {
	     JpaTransactionManager transactionManager = new JpaTransactionManager();
	     transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	  
	     return transactionManager;
	 }
	 
	  @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	

	
	 
}
