package com.webtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebTestApplication {
	private final static Logger logger = LoggerFactory.getLogger(WebTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebTestApplication.class, args);
        logger.info("WebTestApplication is success!");
    }
}
