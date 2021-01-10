package com.jinshipark.hfzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HfzfApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HfzfApiApplication.class, args);
    }

}
