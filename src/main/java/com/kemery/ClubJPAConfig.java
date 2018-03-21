package com.kemery;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class ClubJPAConfig {

	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/club294?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		
		factoryBean.setPersistenceProviderClass(HibernatePersistence.class);
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.kemery");
		factoryBean.setJpaPropertyMap(jpaProperties());
		return factoryBean;
	}
	
	
	private Map<String, ?> jpaProperties() {
		
		Map<String, String> jpaPropertiesMap = new HashMap<String, String>();
		jpaPropertiesMap.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return jpaPropertiesMap;
		
	}
	
	
	@Bean
	public MemberDaoImpl memberDao() {
		MemberDaoImpl dao = new MemberDaoImpl();
		return dao;
	}
	
	
	
}
