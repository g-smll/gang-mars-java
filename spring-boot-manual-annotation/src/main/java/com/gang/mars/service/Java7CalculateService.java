package com.gang.mars.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/21 9:06
 */
@Service
@Profile("Java7")
public class Java7CalculateService implements CalculateService{
    @Override
    public Integer sum(Integer... values) {
        int sum = 0;
        for (int i = 0; i< values.length; i++){
            sum+= values[i];
        }
        return sum;
    }
}
