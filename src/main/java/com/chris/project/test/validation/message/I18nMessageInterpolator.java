package com.chris.project.test.validation.message;

import org.apache.logging.log4j.message.Message;
import org.hibernate.validator.messageinterpolation.AbstractMessageInterpolator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

import javax.validation.MessageInterpolator;
import java.text.MessageFormat;
import java.util.Locale;

public class I18nMessageInterpolator implements MessageInterpolator {

    @Override
    public String interpolate(String message, Context context) {
        Object validatedValue = context.getValidatedValue();
        return MessageFormat.format(message, "123");
    }

    @Override
    public String interpolate(String s, Context context, Locale locale) {
        return null;
    }
}
