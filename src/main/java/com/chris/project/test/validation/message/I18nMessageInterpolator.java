package com.chris.project.test.validation.message;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

public class I18nMessageInterpolator extends ResourceBundleMessageInterpolator {

    @Override
    public String interpolate(String message, Context context) {
        return super.interpolate(message, context);
    }
}
