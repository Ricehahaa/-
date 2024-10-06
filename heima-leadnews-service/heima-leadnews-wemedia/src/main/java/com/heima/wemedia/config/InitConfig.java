package com.heima.wemedia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//TODO 用于扫描熔断的bean
@ComponentScan("com.heima.apis.article.fallback")
public class InitConfig {
}