package com.gang.mars.validation.request.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/6 17:12
 */
@Data
@AllArgsConstructor
public class PersonData {
    private Integer id;
    @NotBlank(message = "邮件不能为空")
    private String email;

    @Valid
    List<ProductData> list;

}
