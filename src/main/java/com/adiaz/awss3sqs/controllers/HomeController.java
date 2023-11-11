package com.adiaz.awss3sqs.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.util.List;

@Controller
@Slf4j
public class HomeController {


  private final String profileName;

  @Value("${custom.bucket-name}")
  private final String bucketName;

  private final S3Client s3Client;

  private final String bucketLocation;


  public HomeController(@Value("${cloud.aws.credentials.profile-name}") String  profileName,
                        @Value("${custom.bucket-name}")String bucketName,
                        S3Client s3Client) {
    this.profileName = profileName;
    this.bucketName = bucketName;
    this.s3Client = s3Client;
    String s3Region = this.s3Client
            .getBucketLocation(GetBucketLocationRequest.builder().bucket(bucketName).build())
            .locationConstraintAsString();
    this.bucketLocation = String.format("https://%s.s3.%s.amazonaws.com", bucketName, s3Region);
  }

  @GetMapping
  public ModelAndView home() {
    ListObjectsV2Request listObjectsV2Request = ListObjectsV2Request.builder().bucket(bucketName).build();
    ListObjectsV2Response listObjectsV2Response = s3Client.listObjectsV2(listObjectsV2Request);
    List<S3Object> contents = listObjectsV2Response.contents();
    ModelAndView modelAndView = new ModelAndView("dashboard");
    modelAndView.addObject("message", "Spring Boot with AWS");
    modelAndView.addObject("bucketName", bucketName);
    modelAndView.addObject("availableFiles", contents);
    modelAndView.addObject("bucketLocation", bucketLocation);
    return modelAndView;
  }
}
