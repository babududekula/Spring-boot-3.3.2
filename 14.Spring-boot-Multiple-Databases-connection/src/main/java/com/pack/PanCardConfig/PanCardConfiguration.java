package com.pack.PanCardConfig;
//
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
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//							entityManagerFactoryRef = "localContainerEntityManagerFactoryBean",
//							transactionManagerRef = "platformTransactionManagerBean",
//							basePackages = "com.pack.panrepository.PanCardRepository"
//						)
//public class PanCardConfiguration 
//{
//	@Bean(name = "datasourceBean")
//	@ConfigurationProperties(prefix = "spring.datasource.h2")
//	public DataSource dataSource()
//	{
//		return DataSourceBuilder.create().build();
//	}
//	
//	@Bean(name = "localContainerEntityManagerFactoryBean")
//	public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean( EntityManagerFactoryBuilder entityManagerFactoryBuilder
//			, @Qualifier("datasourceBean") DataSource dataSource
//			)
//	{
//		return entityManagerFactoryBuilder
//				.dataSource(dataSource)
//				.packages("com.pack.pojo.PanCard")
//				.persistenceUnit("PanCard")
//				.build();
//	}
//	
//	@Bean(name = "platformTransactionManagerBean")
//	public PlatformTransactionManager platformTransactionManager(@Qualifier("localContainerEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory)
//	{
//		return new JpaTransactionManager(entityManagerFactory);
//	}
//}


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

//import java.util.HashMap;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
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
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "firstEntityMangerFactoryBean",
//        basePackages = {"com.pack.panrepository.PanCardRepository"},
//        transactionManagerRef = "firstTransactionManager"
//)
//public class PanCardConfiguration {
//
//    @Autowired
//    private Environment environment;
//
//    // Configuring the datasource
//    @Bean(name = "firstDataSource")
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
//        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
//        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
//
//        return dataSource;
//    }
//
//    // Configuring the entity manager factory
//    @Bean(name = "firstEntityMangerFactoryBean")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        bean.setDataSource(dataSource());
//        bean.setPackagesToScan("com.pack.pojo");
//
//        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        bean.setJpaVendorAdapter(adapter);
//
//        Map<String,String> props = new HashMap<>();
//        props.put("hibernate.show_sql","true");
//        props.put("hibernate.hbm2ddl.auto","update");
//        bean.setJpaPropertyMap(props);
//
//        return bean;
//    }
//
//    // Configuring the platform transaction manager
//    @Bean(name = "firstTransactionManager")
//    public PlatformTransactionManager transactionManager(){
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return manager;
//    }
//}
//



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
    basePackages = "com.pack.userrepository",
    entityManagerFactoryRef = "mysqlEntityManagerFactory",
    transactionManagerRef = "mysqlTransactionManager"
)
public class PanCardConfiguration {

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.h2")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            @Qualifier("mysqlDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.pack.userentity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
