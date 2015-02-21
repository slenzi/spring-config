package org.lenzi.spring.sample.properties;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Global spring managed application properties for data transfer.
 *
 * @see oorg.lenzi.spring.sample.config.PropertyConfig
 * 
 * @author slenzi
 */
@Component(value="MyAppProperties")
@Scope("singleton")
public class ManagedProperties {

	@Autowired
	Environment env;
	
	@Value( "${application.title}" )
	private String appTitle = null;
	
	@Value( "${database.driver}" )
	private String databaseDriver = null;
	
	@Value( "${database.url}" )
	private String databaseUrl = null;
	
	@Value( "${database.user}" )
	private String databaseUser = null;
	
	@Value( "${database.password}" )
	private String databasePassword = null;

	/**
	 * @return the env
	 */
	public Environment getEnv() {
		return env;
	}
	
	/**
	 * Get a specific property
	 */
	public String getProperty(String name) {
		return env.getProperty(name);
	}
	
	/**
	 * @return the appTitle
	 */
	public String getAppTitle() {
		return appTitle;
	}

	/**
	 * @return the databaseDriver
	 */
	public String getDatabaseDriver() {
		return databaseDriver;
	}

	/**
	 * @return the databaseUrl
	 */
	public String getDatabaseUrl() {
		return databaseUrl;
	}

	/**
	 * @return the databaseUser
	 */
	public String getDatabaseUser() {
		return databaseUser;
	}

	/**
	 * @return the databasePassword
	 */
	public String getDatabasePassword() {
		return databasePassword;
	}

}