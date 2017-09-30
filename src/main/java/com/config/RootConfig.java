package com.work1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by yking on 2017/9/28.
 */
@Configuration
@ComponentScan(basePackages = {"com.work1.controller"},excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = EnableWebMvc.class)})
public class RootConfig {
}
