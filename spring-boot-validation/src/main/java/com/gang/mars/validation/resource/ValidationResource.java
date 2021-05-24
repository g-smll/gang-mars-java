package com.gang.mars.validation.resource;

import com.gang.mars.validation.request.data.ProductData;
import com.gang.mars.validation.request.data.PersonData;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/6 17:11
 */
@RestController
@Validated
public class ValidationResource {

    @RequestMapping("/hello")
    public String hello(){
        return "hello - gang.chen";
    }

    @PostMapping("/person")
    public ResponseEntity<PersonData> postPersonData(@Validated @RequestBody PersonData personData){
        return ResponseEntity.ok().body(personData) ;
    }

    @GetMapping("/get-person")
    public PersonData getPersonData(){
        List<ProductData> list = Collections.singletonList(new ProductData(1, "衣服"));
        return new PersonData(1, "com/gang",list);
    }
}
