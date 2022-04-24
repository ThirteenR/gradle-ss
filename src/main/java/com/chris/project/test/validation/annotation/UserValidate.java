package com.chris.project.test.validation.annotation;

import com.chris.project.test.entity.User;
import com.chris.project.test.validation.validator.UserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserValidator.class)
public @interface UserValidate {
    String message() default "测试用户";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[]  value() default {"12"};
}
