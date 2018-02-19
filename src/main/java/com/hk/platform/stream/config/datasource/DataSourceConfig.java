package com.hk.platform.stream.config.datasource;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.EmptyInterceptor;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
public class DataSourceConfig {
	@Bean
	@Primary
    @ConfigurationProperties(prefix="datasource.db-api")
    public BasicDataSource apiDataSource() {
		BasicDataSource ds =  (BasicDataSource) DataSourceBuilder.create().type(BasicDataSource.class).build();
        return ds;
    }

    /*@Bean
    @ConfigurationProperties(prefix="second.datasource")
    public DataSource secondDataSource() {
        DataSource ds =  DataSourceBuilder.create().build();
        return ds;
    }*/
	
	@Bean
	  public LocalSessionFactoryBean apiSessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	    sessionFactoryBean.setDataSource(apiDataSource());
	    sessionFactoryBean.setPackagesToScan("com.hk");
	    sessionFactoryBean.setEntityInterceptor(EmptyInterceptor.INSTANCE);
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
	    hibernateProperties.put("hibernate.show_sql", "false");
	    hibernateProperties.put("hibernate.connection.release_mode","on_close");
	    hibernateProperties.put("hibernate.connection.isolation","2");
	    hibernateProperties.put("hibernate.bytecode.use_reflection_optimizer", "true");
	    sessionFactoryBean.setHibernateProperties(hibernateProperties);
	    
	    return sessionFactoryBean;
	  }
	
	@Bean
	  public HibernateTemplate hibernateTemplate() {
	    HibernateTemplate template = new HibernateTemplate();
	    template.setSessionFactory(apiSessionFactory().getObject());
	    return template;
	  }
	
	@Bean
	@Qualifier(value = "entityManager")
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
	    return entityManagerFactory.createEntityManager();
	}

}
