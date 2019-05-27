package com.tutu.projectjsp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * FileName:    WebStartApplication.java  
 * @author:     tutu 
 * @version:    1.0  
 * @date:   	2017年7月29日 下午6:06:06
 */
public class WebStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(SeleniumUiApplication.class);
        return super.configure(builder);
    }

}