package com.chris.project.test.operation.impl;

import com.chris.project.test.operation.ITransApi;
import org.springframework.stereotype.Service;

@Service
public class TransApi implements ITransApi {
    @Override
    public String trans(String an) {
        return "test";
    }
}
