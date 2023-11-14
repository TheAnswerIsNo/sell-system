package com.wait.sellsystem.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 天
 *
 * @description: flyway auto configuration
 */
@Configuration // 配置注解
@PropertySource("classpath:application.yml")
@ComponentScan
@AutoConfigureBefore({FlywayAutoConfiguration.class})
@ImportAutoConfiguration({FlywayAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class FlywayConfig{
}