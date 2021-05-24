package com.gang.mars.validation.http;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/7 9:46
 */
@Data
public class GangMarsResponseEntity<T> {
    private Boolean success;
    private String code;
    private String msg;
    private T t;

}
