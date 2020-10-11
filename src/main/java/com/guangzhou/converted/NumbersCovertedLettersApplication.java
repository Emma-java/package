package com.guangzhou.converted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.guangzhou.*")
public class NumbersCovertedLettersApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumbersCovertedLettersApplication.class, args);
    }
}
