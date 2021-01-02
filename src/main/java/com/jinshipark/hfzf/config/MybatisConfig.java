package com.jinshipark.hfzf.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.jinshipark.hfzf.mapper"})
public class MybatisConfig {

}
