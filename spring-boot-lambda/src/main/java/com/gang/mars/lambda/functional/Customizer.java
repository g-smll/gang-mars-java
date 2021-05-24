package com.gang.mars.lambda.functional;

@FunctionalInterface
public interface Customizer<T> {
    public void Customizer(T t);

    static <T> Customizer<T> withDefaults(){
        return t -> {};
    }
}
