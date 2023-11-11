package com.adiaz.awss3sqs.listeners;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueueListener {

  @SqsListener(value = "my_queue")
  public void listen(String message) {
    log.info("message received {}", message);
  }
}
