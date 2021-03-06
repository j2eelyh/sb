package com.vic.sb03.conf;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Data
@Component //加上此annotation才能找到，@Configuration也可以
//@EnableConfigurationProperties({Shaver.class}) //启动时找不到bean
/**
 * 如果没有前缀，不用写此注解
 */
@ConfigurationProperties(prefix = "shaver")
/*
1. 此注解默认在resources目录下找指定文件，找不到报错
2. 如果将此文件放在resources/conf目录，需要配置路径为classpath:config/shaver.properties
 */
@PropertySource("shaver.properties")
//@PropertySource("classpath:config/shaver.properties")
public class Shaver {

    private String shaverName;

    private String size;

    @PostConstruct
    public void init() {
        log.info("init Shaver: {}", this);
    }
}
