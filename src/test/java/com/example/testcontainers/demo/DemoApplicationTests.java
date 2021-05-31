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
    Map<String, String> employee = controller.getEmployee(450);

    assertNotNull(employee);
    assertEquals("Steward", employee.get("JobTitle"));
    assertEquals("Kirsten_Grant6015@corti.com", employee.get("EmailAddress"));
    assertEquals("Kirsten Grant", employee.get("FirstNameLastName"));
  }

}
