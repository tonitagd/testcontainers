package com.example.testcontainers.demo;

import org.junit.Rule;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {

  static class Initializer implements
      ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Rule
    public static OracleContainer oracle = new OracleContainer("zion_oracle")
        .withPassword("zion_uploader")
        .withUsername("ZION_UPLOADER")
        .withExposedPorts(1521);

    private static void startContainers() {
      Startables.deepStart(Stream.of(oracle)).join();
    }

    private static Map<String, String> createConnectionConfiguration() {
      Map<String, String> properties = new HashMap<>();
      properties.put("spring.datasource.url", oracle.getJdbcUrl());
      properties.put("spring.datasource.username", oracle.getUsername());
      properties.put("spring.datasource.password", oracle.getPassword());
//      properties.put("spring.liquibase.enabled", "false");
      return properties;
    }


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

      startContainers();

      ConfigurableEnvironment environment = applicationContext.getEnvironment();

      MapPropertySource testcontainers = new MapPropertySource(
          "testcontainers",
          (Map) createConnectionConfiguration()
      );

      environment.getPropertySources().addFirst(testcontainers);
    }
  }
}
