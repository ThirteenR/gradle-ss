package com.chris.project.test.util;

import com.chris.project.test.annotation.Trans;
import com.chris.project.test.operation.ITransApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

public abstract class ObjectParser {
    public static <T> T parse(T t) {
        ReflectionUtils.doWithFields(t.getClass(), field -> {
            Trans annotation = field.getAnnotation(Trans.class);
            if (annotation == null) {
                return;
            }
            String value = annotation.value();
            field.setAccessible(true);
            Object o = field.get(t);
            if (StringUtils.isEmpty(value)) {
                String beanName = annotation.beanName();
                Class<? extends ITransApi> operation = annotation.operation();
                ITransApi bean = ChrisApplicationContext.context().getBean(beanName, operation);
                String trans = bean.trans((String) o);
                field.set(t, trans);
            } else {
                field.set(t, value);
            }
        });
        return t;
    }
}
