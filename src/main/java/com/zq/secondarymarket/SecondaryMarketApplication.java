package com.zq.secondarymarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.zq.secondarymarket")
@ImportResource({"classpath:/META-INF/spring/secondary-market-service-spring.xml"})
@Configuration
public class SecondaryMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondaryMarketApplication.class, args);
        System.out.println("服务启动......");
    }
}
