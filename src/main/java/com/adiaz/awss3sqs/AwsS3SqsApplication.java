package com.adiaz.awss3sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class AwsS3SqsApplication {

  public static void main(String[] args) {
    SpringApplication.run(AwsS3SqsApplication.class, args);
  }
}