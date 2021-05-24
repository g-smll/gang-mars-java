package com.gang.mars.security.config;

/**
 * @author gang.chen
 * @description
 * @time 2021/1/5 11:21
 */
@FunctionalInterface
public interface GangMarsCustomizer<T> {

    /**
     * Performs the customizations on the input argument.
     * @param t the input argument
     */
    void GangMarsCustomizer(T t);

    /**
     * Returns a {@link GangMarsCustomizer} that does not alter the input argument.
     * @return a {@link GangMarsCustomizer} that does not alter the input argument.
     */
    static <T> GangMarsCustomizer<T> withDefaults() {
        return (t) -> {
        };
    }
}
