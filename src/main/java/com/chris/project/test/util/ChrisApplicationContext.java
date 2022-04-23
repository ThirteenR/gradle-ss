package com.chris.project.test.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ChrisApplicationContext implements ApplicationContextAware {
    private static ApplicationContext context;
    private static Environment env;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ChrisApplicationContext.context = applicationContext;
        ChrisApplicationContext.env = applicationContext.getEnvironment();
    }

    public static ApplicationContext context() {
        return context;
    }

    public static <T> T getBean(String beanName, Class<T> type){
        return context.getBean(beanName, type);
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static Environment env() {
        return env;
    }
}
