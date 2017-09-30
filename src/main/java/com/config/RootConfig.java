package com.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * Created by yking on 2017/9/28.
 */
@Configuration
@ComponentScan(basePackages = {"com.config"},excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = EnableWebMvc.class)})
public class RootConfig {
    public DataSource dataSource(){
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("654321");
        return dataSource;
    }
    @Bean
    public DataSource standaloneDataSource(){
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("classpath:sql/schema.sql")
                .addScript("classpath:sql/add-data.sql")
                .build();
    }
}
