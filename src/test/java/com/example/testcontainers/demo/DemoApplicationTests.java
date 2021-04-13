package com.example.testcontainers.demo;

import com.example.testcontainers.demo.controller.Controller;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class DemoApplicationTests extends AbstractIntegrationTest {

  @Autowired
  private Controller controller;

  @Test
  void contextLoads() {
    Map<String, String> zdr = controller.getState("ZDR");

    assertNotNull(zdr);
    assertEquals("ZDR", zdr.get("cde"));
    assertEquals("Zdrastiii", zdr.get("description"));
    assertEquals("UK", zdr.get("county_cde"));
  }

}
