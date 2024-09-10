package com.pack.AadharConfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import jakarta.persistence.EntityManagerFactory;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "localContainerEntityManagerBean",
//						transactionManagerRef = "transactionManagerBean",
//						basePackages = "com.pack.aadharrepository.AadharRepository"
//						)
//public class AadharConfiguration 
//{
//	@Bean(name = "dataSource")
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource datasource()
//	{
//		return DataSourceBuilder.create().build();
//	}
//	
//	@Bean(name = "localContainerEntityManagerBean")
//	public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder
//			, @Qualifier("dataSource") DataSource dataSource)
//	{
//		return entityManagerFactoryBuilder
//				.dataSource(dataSource)
//				.packages("com.pack.entity.Aadhar")
//				.persistenceUnit("Aadhar")
//				.build();
//	}
//	
//	@Bean(name = "transactionManagerBean")
//	public PlatformTransactionManager platformTransactionManager(@Qualifier("localContainerEntityManagerBean") EntityManagerFactory entityManagerFactory)
//	{
//		return new JpaTransactionManager(entityManagerFactory);
//	}
//}


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//// Configuration class for configuring the second database
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "secondEntityMangerFactoryBean",
//        basePackages = {"com.pack.aadharrepository.AadharRepository"},
//        transactionManagerRef = "secondTransactionManager"
//)
//public class AadharConfiguration {
//
//    @Autowired
//    private Environment environment;
//
//    // Configuring the data source for the second database
//    @Bean(name = "secondDataSource")
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(environment.getProperty("second.datasource.url"));
//        dataSource.setDriverClassName(environment.getProperty("second.datasource.driver-class-name"));
//        dataSource.setUsername(environment.getProperty("second.datasource.username"));
//        dataSource.setPassword(environment.getProperty("second.datasource.password"));
//
//        return dataSource;
//    }
//
//    // Configuring the entity manager factory for the second database
//    @Bean(name = "secondEntityMangerFactoryBean")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        bean.setDataSource(dataSource());
//        bean.setPackagesToScan("com.pack.entity.Aadhar");
//
//        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        bean.setJpaVendorAdapter(adapter);
//
//        Map<String,String> props = new HashMap<>();
//        props.put("hibernate.hbm2ddl.auto","update");
//        bean.setJpaPropertyMap(props);
//
//        return bean;
//    }
//
//    // Configuring the platform transaction manager for the second database
//    @Bean(name = "secondTransactionManager")
//    public PlatformTransactionManager transactionManager(){
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return manager;
//    }
//}



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.pack.aadharrepository",
    entityManagerFactoryRef = "oracleEntityManagerFactory",
    transactionManagerRef = "oracleTransactionManager"
)
public class AadharConfiguration {

    @Bean(name = "oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oracleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(
            @Qualifier("oracleDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.pack.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean(name = "oracleTransactionManager")
    public PlatformTransactionManager oracleTransactionManager(
            @Qualifier("oracleEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
