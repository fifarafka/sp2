package com.myWallet;

import java.util.HashMap;  

import javax.persistence.EntityManagerFactory;  
import javax.sql.DataSource;  
  
import org.hibernate.cfg.AvailableSettings;  
import org.springframework.beans.factory.annotation.Qualifier;  
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;  
import org.springframework.boot.context.properties.ConfigurationProperties;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.context.annotation.Primary;  
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;  
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;  
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;  
import org.springframework.transaction.PlatformTransactionManager;  
import org.springframework.transaction.annotation.EnableTransactionManagement;  

@Configuration  
@EnableJpaRepositories
@EnableTransactionManagement  
public class MyWalletAppConfig {  
  
    private static final String TRANSACTION_MANAGER = "transactionManager";  
    private static final String ENTITY_MANAGER_FACTORY = "entityManagerFactory";  
    private static final String DATA_SOURCE = "dataSource";  
    private static final String CORE_DATA_SOURCE = "core.datasource";  
  
    @Primary  
    @Bean(name = DATA_SOURCE)  
    @ConfigurationProperties(prefix = CORE_DATA_SOURCE)  
    public DataSource dataSource() {  
        return DataSourceBuilder.create().build();  
    }  
  
    @Primary  
    @Bean(name = ENTITY_MANAGER_FACTORY)  
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(DATA_SOURCE) DataSource dataSource, Environment env) {  
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();  
        em.setDataSource(dataSource);  
        em.setPackagesToScan("com.myWallet.repositories");  
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();  
        em.setJpaVendorAdapter(jpaVendorAdapter);  
        HashMap<String, Object> properties = new HashMap<String, Object>();  
        properties.put(AvailableSettings.HBM2DDL_AUTO, env.getProperty("core.jpa.hibernate.hbm2ddl.auto"));  
        properties.put(AvailableSettings.DIALECT, env.getProperty("core.jpa.hibernate.dialect"));  
        properties.put("org.hibernate.envers.audit_strategy", env.getProperty("core.jpa.hibernate.envers.audit_strategy"));  
        properties.put("org.hibernate.envers.default_schema", env.getProperty("core.jpa.hibernate.envers.default_schema"));  
        properties.put("org.hibernate.envers.global_with_modified_flag", env.getProperty("core.jpa.hibernate.envers.global_with_modified_flag"));  
        properties.put("hibernate.ejb.naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringNamingStrategy");  
        properties.put("hibernate.listeners.envers.autoRegister", false);  
        em.setJpaPropertyMap(properties);  
        em.setPersistenceUnitName("default");  
        em.afterPropertiesSet();  
        return em;  
    }  
  
    @Primary  
    @Bean(name = TRANSACTION_MANAGER)  
    public PlatformTransactionManager transactionManager(@Qualifier(ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {  
        return new JpaTransactionManager(entityManagerFactory);  
    }  

}
