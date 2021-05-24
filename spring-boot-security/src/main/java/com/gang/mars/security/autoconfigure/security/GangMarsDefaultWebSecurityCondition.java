package com.gang.mars.security.autoconfigure.security;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/4 18:41
 */
public class GangMarsDefaultWebSecurityCondition extends AllNestedConditions {
    public GangMarsDefaultWebSecurityCondition(ConfigurationPhase configurationPhase) {
        super(configurationPhase);
    }
}
