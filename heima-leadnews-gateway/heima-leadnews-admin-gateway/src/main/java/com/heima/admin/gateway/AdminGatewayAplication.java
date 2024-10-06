package com.heima.admin.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class AdminGatewayAplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminGatewayAplication.class,args);
    }
}
