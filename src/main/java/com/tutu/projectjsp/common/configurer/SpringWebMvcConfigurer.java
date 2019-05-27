package com.tutu.projectjsp.common.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tutu.projectjsp.common.interceptor.AccessInfoInterceptor;
import com.tutu.projectjsp.common.interceptor.LoginInterceptor;

/**
 * 
 * FileName:    SpringWebMvcConfigurer.java  
 * @author:     tutu 
 * @version:    1.0  
 * @date:   	2017年7月29日 下午10:10:14
 */
@Configuration
public class SpringWebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    AccessInfoInterceptor accessInfoInterceptor;
    @Autowired
    LoginInterceptor loginInterceptor;
    
    /**
     * 
     * @param registry
     * @author:	tutu
     * @date:	2017年6月22日 下午4:17:30
     */
    public void addInterceptors(InterceptorRegistry registry) {
        //登录拦截器
        InterceptorRegistration loginInterceptor = registry.addInterceptor(this.loginInterceptor);        
        //排除配置
        loginInterceptor.excludePathPatterns("/error");//
        //loginInterceptor.excludePathPatterns("/login/**");//登录
        //拦截配置
        loginInterceptor.addPathPatterns("/**");
        
        //访问信息拦截器
        InterceptorRegistration accessInfoInterceptor = registry.addInterceptor(this.accessInfoInterceptor);        
        //排除配置
        accessInfoInterceptor.excludePathPatterns("/error");//
        accessInfoInterceptor.excludePathPatterns("/promptmessage/removemessage");//清除提示消息
        accessInfoInterceptor.excludePathPatterns("/layui/upload");//
        //拦截配置
        accessInfoInterceptor.addPathPatterns("/**");
        
    }
}
