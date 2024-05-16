package com.config;

//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(2)
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                WebSecurityConfig.class, AppConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                WebSecurityConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/"
        };
    }
}


//public class MvcWebApplicationInitializer extends
//        AbstractSecurityWebApplicationInitializer {
//
//    public MvcWebApplicationInitializer() {
//
//        super(WebSecurityConfig.class);
//    }
//}