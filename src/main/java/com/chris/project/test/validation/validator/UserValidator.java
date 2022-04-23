package com.chris.project.test.validation.validator;

import com.chris.project.test.validation.annotation.UserValidate;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ClockProvider;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Clock;

public class UserValidator implements ConstraintValidator<UserValidate, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.equals(s, "123");
    }
}
