package com.nagarro.nagp.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfiguration {

  @Value("${app.message}")
  String applicationName;

  @PostConstruct
  public void initializeApplication() {
    log.info("Running Environment   : {} " + applicationName);

  }


}
