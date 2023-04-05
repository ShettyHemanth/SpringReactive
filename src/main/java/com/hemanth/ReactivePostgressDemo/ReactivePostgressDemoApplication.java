package com.hemanth.ReactivePostgressDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories("com.hemanth.ReactivePostgressDemo.repository")
public class ReactivePostgressDemoApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ReactivePostgressDemoApplication.class, args);
	}

}
