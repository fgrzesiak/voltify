package com.example.lager.adapter.secondary.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class CustomDataSourceConfiguration {
/*
	@Bean
    public DataSource getDataSource() {
		
		String url = System.getenv("SPRING_DATASOURCE_URL");    
				
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
      
        return dataSourceBuilder.build();
    }
	
	 @Lazy
	    @Qualifier("customJdbcTemplate")
	    @Bean
	    public JdbcTemplate customArtikelJdbcTemplate() {
	        return new JdbcTemplate(customDataSource());
	    }
	    */
}
