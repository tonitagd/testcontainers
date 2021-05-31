package com.example.testcontainers.demo.controller;

import com.example.testcontainers.demo.mapper.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private StateMapper mapper;

    @GetMapping("employee/{cde}")
    public Map<String, String> getEmployee(@PathVariable Integer cde) {
      return mapper.getEmployee(cde);
    }
}
