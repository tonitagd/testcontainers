package com.example.testcontainers.demo.inmemory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.testcontainers.demo.DemoApplication;
import com.example.testcontainers.demo.controller.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest(classes = {DemoApplication.class, H2JpaConfig.class})
@AutoConfigureTestDatabase
public class InMemoryDbTest {

  @Autowired
  private Controller controller;

  @Test
  public void contextLoads() {
    Map<String, String> employee = controller.getEmployee(450);

    assertNotNull(employee);
    assertEquals("Steward", employee.get("JobTitle"));
    assertEquals("Kirsten_Grant6015@corti.com", employee.get("EmailAddress"));
    assertEquals("Kirsten Grant", employee.get("FirstNameLastName"));
  }

  @Test
  public void contextLoads2() {
    Map<String, String> zdr = controller.getEmployee(45);

    assertNotNull(zdr);
    assertEquals("Webmaster", zdr.get("JobTitle"));
    assertEquals("Denny_Connor9173@bauros.biz", zdr.get("EmailAddress"));
    assertEquals("Denny Connor", zdr.get("FirstNameLastName"));
  }
}
