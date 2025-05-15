package com.ssafy.bjh.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ssafy.bjh.model.dao")
@Configuration
public class MyBatisConfig {
}
