package com.gang.mars.validation.request.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/6 17:26
 */
@Data
@AllArgsConstructor
public class ProductData {
    private Integer id;
    @NotBlank(message = "产品名称不能为空")
    private String name;
}
