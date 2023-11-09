package com.adiaz.awss3sqs.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class HomeController {

  @Value("${cloud.aws.credentials.profile-name}")
  String profileName;

  @GetMapping("/hello")
  public ModelAndView home() {
    log.info("profileName -> {}", profileName);
    return new ModelAndView("hello");
  }


}
