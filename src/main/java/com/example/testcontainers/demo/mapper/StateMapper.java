package com.example.testcontainers.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface StateMapper {
  Map<String, String> getEmployee(int cde);
}
