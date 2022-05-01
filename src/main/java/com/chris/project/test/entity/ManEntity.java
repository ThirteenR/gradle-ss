package com.chris.project.test.entity;

import com.chris.project.test.annotation.Trans;
import com.chris.project.test.operation.ITransApi;
import com.chris.project.test.validation.annotation.UserValidate;
import com.chris.project.test.validation.group.AgreeGroup;
import com.chris.project.test.validation.group.RejectGroup;
import com.chris.project.test.validation.group.SaveValidate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
public class ManEntity{
    @AssertFalse(message = "只能为false", groups = RejectGroup.class)
    @AssertTrue(message = "只能为true", groups = AgreeGroup.class)
    private boolean agree;
    @DecimalMax("2")
    private String decimal;
    @DecimalMin("2")
    private String decimal1;
    @Digits(integer = 3, fraction = 2)
    private String decimal2;
    @Future
    private Date future;
    @Past
    private Date past;
    @Max(4)
    private String max;
    @Min(4)
    private String min;
    @Size(min = 1, max = 5)
    private List<String> list;
    @Length(min = 1, max = 5)
    private String length;
    @Range(min = 1, max = 100)
    private String range;
    @Trans(beanName = "transApi", operation = ITransApi.class)
    @NotEmpty(message = "{0}你你你")
    private String aex;
    @NotEmpty(message = "{0}你好呀")
    private String name;
    @UserValidate(message = "{value},好的呢", groups = SaveValidate.class)
    private String job;

    @Valid
    private BaseEntity baseEntity;
}
