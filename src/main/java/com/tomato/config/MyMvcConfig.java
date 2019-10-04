package com.tomato.config;

import com.tomato.component.LoginHandlerIntercep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//实现WebMvcConfigurer接口可以来扩展SpringMVC的功能
//@EnbleWebMVC 不要接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //所有的webMvcConfigurer组件都会一起起作用
    @Bean//将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("main");
            }
        };
        return webMvcConfigurer;
    }

//    @Bean
//    public LocaleResolver localeResolver(){
//        return new NativeLocaleResolver();
//    }


    //重写addInterceptors这个方法来添加自定义的拦截器。
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerIntercep())
                /*
                    addInterceptor用于添加你自定义的拦截器实例
                    addPathPatterns用于添加要拦截的url,可以写多个。
                    excludePathPatterns用于添加不需要拦截的url,可以写多个。
                * */
                .addPathPatterns("/**")
                .excludePathPatterns("/","/user/login","/login.html","/user/regist","register.html","register","/send","/user/doRegist")
                //忽略静态资源的路径前缀
                .excludePathPatterns("/public/**","/resources/**","/static/**");
    }
    //因为自定义的拦截器拦截了所有的路径，所以首先我们需要重写addResourceHandlers()方法，
    // 指定静态资源的访问路径前缀以及静态资源所处路径：
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/resources/**","/public/**","/static/**")
                .addResourceLocations("classpath:/resources/","classpath:/public/","classpath:/static/");

    }
}
