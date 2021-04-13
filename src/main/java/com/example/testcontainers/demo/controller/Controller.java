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

    @GetMapping("state/{cde}")
    public Map<String, String> getState(@PathVariable String cde) {
      return mapper.getState(cde);
    }
}
