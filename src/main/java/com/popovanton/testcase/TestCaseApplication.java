package com.popovanton.testcase;

import com.popovanton.testcase.parser.DataImporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.popovanton"})
public class TestCaseApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestCaseApplication.class, args);

    
    }

}
