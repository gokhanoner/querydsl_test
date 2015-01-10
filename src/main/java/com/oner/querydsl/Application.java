package com.oner.querydsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.query.QueryDslJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public QueryDslJdbcTemplate queryDslJdbcTemplate(JdbcTemplate jdbcTemplate) {
		return new QueryDslJdbcTemplate(jdbcTemplate);
	}

}
