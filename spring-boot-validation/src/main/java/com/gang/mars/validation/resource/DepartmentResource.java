package com.gang.mars.validation.resource;

import com.gang.mars.validation.request.data.Department;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/7 9:10
 */
@RestController
@Validated
public class DepartmentResource {

    @PostMapping("/add")
    public String add(@RequestBody @Valid Department department){
        return "ok";
    }

    @GetMapping("/get")
    public Department get(){
        return new Department(1,2,"gang.chen", LocalDateTime.now());
    }
}
