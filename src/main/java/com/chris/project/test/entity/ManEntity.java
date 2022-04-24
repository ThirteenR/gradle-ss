package com.chris.project.test.entity;

import com.chris.project.test.annotation.Trans;
import com.chris.project.test.operation.ITransApi;
import com.chris.project.test.validation.annotation.UserValidate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
public class ManEntity{
    @Trans(beanName = "transApi", operation = ITransApi.class)
    @NotEmpty(message = "{0}你你你")
    private String aex;
    @NotEmpty(message = "{0}你好呀")
    private String name;
    @UserValidate(message = "{value},好的呢")
    private String job;

    @Valid
    private BaseEntity baseEntity;
}
