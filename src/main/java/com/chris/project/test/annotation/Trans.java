package com.chris.project.test.annotation;

import com.chris.project.test.operation.ITransApi;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Trans {
    String value() default "";
    String beanName() default "transApi";
    Class<? extends ITransApi> operation();
}
