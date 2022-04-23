package com.chris.project.test.validation.validator;

import com.chris.project.test.entity.BaseEntity;
import com.chris.project.test.entity.ManEntity;
import com.chris.project.test.validation.message.I18nMessageInterpolator;
import org.hibernate.validator.HibernateValidator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.*;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class BeanValidator {
    //校验工厂
    private static final ValidatorFactory validatorFactory;
    static {
        validatorFactory = Validation
                .byProvider(HibernateValidator.class)
                .configure()
                .messageInterpolator(new I18nMessageInterpolator())
                .failFast(true)
                .buildValidatorFactory();
    }
    /**
     * @Description: 校验返回提示信息
     * @param t t
     * @param groups groups
     * @return 提示信息拼接字符串
     */
    public static <T> String validate(T t, Class<?>... groups) {
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> validate = validator.validate(t, groups);
        if (validate.isEmpty()) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();
            for (ConstraintViolation<T> violation : validate) {
                System.out.println(violation.getPropertyPath().toString());
                sb.append(violation.getMessage()).append(";");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ManEntity manEntity = new ManEntity();
        manEntity.setBaseEntity(new BaseEntity());
        String validate = validate(manEntity);
        System.out.println(validate);
    }
}
