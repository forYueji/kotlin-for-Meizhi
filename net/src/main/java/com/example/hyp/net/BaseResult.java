package com.example.hyp.net;

import java.util.List;

public class BaseResult<T> {

    public String code = "0";

    public String message;

    public List<T> results;
}
