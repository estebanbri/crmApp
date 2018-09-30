package com.crm.configuration;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.crm.entity.Cliente;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.crm.repository") //defino el package-name donde quiero que scanee para encontrar mis @Components (y sus hijos como @Controller por ej) y automaticamente registrarlos como beans en el spring-container.
@PropertySource("classpath:persistence-h2.properties")
public class PersistenceConfiguration {
	@Autowired
	private Environment env;
	
	//h2 console-> localhost:8082
    @Bean(initMethod="start",destroyMethod="stop")
    public org.h2.tools.Server h2WebConsoleServer () throws SQLException {
      return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8082");
    }
    
    // need a helper method 
 	// read environment property and convert to int
 	private int getIntProperty(String propName) 
 	{
 		String propVal = env.getProperty(propName);
 		
 		// now convert to int
 		int intPropVal = Integer.parseInt(propVal);
 		
 		return intPropVal;
 	}	
    
    @Bean
	public DataSource myDataSource() 
    {
		// create connection pool
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		// set the jdbc driver
		try {
			myDataSource.setDriverClass(env.getProperty("jdbc.driverClassName"));		
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	
		// set database connection props
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.username"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));		
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return myDataSource;
	}
	
	private Properties getHibernateProperties()
	{
		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		props.setProperty("hibernate.ddl-auto", env.getProperty("hibernate.ddl-auto"));
		props.setProperty("hibernate.generate-ddl", env.getProperty("hibernate.generate-ddl"));
		
		return props;				
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setAnnotatedClasses(Cliente.class);
		return sessionFactory;
	}
	
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) 
	{
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
    

}
