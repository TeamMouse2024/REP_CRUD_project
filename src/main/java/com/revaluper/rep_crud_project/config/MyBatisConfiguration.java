package com.revaluper.rep_crud_project.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.revaluper.rep_crud_project" , annotationClass = Mapper.class)
public class MyBatisConfiguration {
}
