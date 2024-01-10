package com.example.QuickStart.app;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

@Log
@SpringBootApplication
public class QuickStartAppApplication implements CommandLineRunner {

	private final DataSource dataSource;
	private static final Logger log = LoggerFactory.getLogger(QuickStartAppApplication.class);

	public QuickStartAppApplication(DataSource dataSource){
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(QuickStartAppApplication.class, args);
	}

	@Override
	public void run(String ... args) {
		log.info("DataSource: "+ dataSource.toString());


	}

}
