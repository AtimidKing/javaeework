package com.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by yking on 2017/9/28.
 */
public class WebInitialization extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        //    @Override
//    protected Filter[] getServletFilters() {
//        DelegatingFilterProxy delegatingFilterProxy=new DelegatingFilterProxy("shiroFilter");
//        delegatingFilterProxy.setTargetFilterLifecycle(true);
//        return new Filter[]{delegatingFilterProxy};
//    }
        DelegatingFilterProxy delegatingFilterProxy=new DelegatingFilterProxy("shiroFilter");
        delegatingFilterProxy.setTargetFilterLifecycle(true);
        return new Filter[]{new CharacterEncodingFilter("UTF-8",true),delegatingFilterProxy};
    }
}
