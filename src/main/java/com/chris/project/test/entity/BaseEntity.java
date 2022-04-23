package com.chris.project.test.entity;


import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class BaseEntity implements Serializable {
    @NotEmpty(message = "测试不能为空")
    private String name;
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
