// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2018. For more information see LICENSE

package com.example.testcontainers.demo;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.example.testcontainers.demo.*")
@MapperScan(value = {"com.example.testcontainers.demo.mapper"}, sqlSessionFactoryRef = "sqlSessionFactorySvc")
public class DemoConfiguration {

  @Autowired
  private DataSource dataSource;

  @Bean
  public SqlSessionFactoryBean sqlSessionFactorySvc() {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    return sessionFactory;
  }
}
