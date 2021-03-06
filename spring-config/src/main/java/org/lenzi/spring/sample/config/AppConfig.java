package org.lenzi.spring.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * Spring project configuration setup
 * 
 * Scan all packages but ignore controller beans. Our MVC setup class will load those.
 * 
 * @see org.lenzi.spring.sample.config.WebMvcConfig
 * 
 * @author slenzi
 */
@Configuration
@ComponentScan(
	basePackages = "org.lenzi.spring.sample",
	excludeFilters = {
		@ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
		@ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION)
	}
)
@Import({
	PropertyConfig.class, PersistenceConfig.class, UploadConfig.class, CxfConfig.class
})
public class AppConfig {

	// PropertyConfig - Setup property access for our properties file under src/main/resource
	
	// PersistenceConfig - Setup entity manager with transaction management for our PostgreSQL database.
	
	// CxfConfig - Setup our JAX-RS service using Apache CXF
	
	// UploadConfig - Initialize Spring's Multipart Resolver bean for processing file uploads.
	
}
