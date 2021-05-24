package com.gang.mars.validation.request.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/7 9:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Null(message = "主键必为空")
    private Integer id;
    @NotNull(message = "父亲主键不能为空")
    private Integer parentId;
    @NotBlank(message = "用户名字不能为空")
    private String name;
    @PastOrPresent(message = "创建时间不能为空")
    private LocalDateTime createTime;
}
