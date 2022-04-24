package com.chris.project.test.validation.validator;

import com.chris.project.test.validation.annotation.UserValidate;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserValidator implements ConstraintValidator<UserValidate, String> {
    UserValidate userValidate;

    @Override
    public void initialize(UserValidate userValidate) {
        this.userValidate = userValidate;
    }
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        userValidate.value();
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.userValidate);
        Field value = null;
        try {
            value = invocationHandler.getClass().getDeclaredField("memberValues");
            value.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>) value.get(invocationHandler);
            String[] val = (String[]) memberValues.get("value");
            memberValues.put("value", new String[]{"123", "nihaoyyy"});
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return StringUtils.equals(s, "123");
    }
}
