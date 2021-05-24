package com.gang.mars.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/21 9:07
 */
@Service
@Profile("Java8")
public class Java8CalculateService implements CalculateService{
    @Override
    public Integer sum(Integer... values) {
        int sum = Stream.of(values).reduce(0,Integer::sum);
        return sum;
    }
}
