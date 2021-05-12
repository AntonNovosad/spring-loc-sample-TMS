package org.example;

import org.example.calculator.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class RootConfiguration {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
