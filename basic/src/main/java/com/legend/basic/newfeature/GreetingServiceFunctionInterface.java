package com.legend.basic.newfeature;

/**
 *  函数接口指的是一个有且仅有一个抽象方法，但可以有多个非抽象方法的接口
 *  只要接口中添加一个函数，则该接口就不再是函数式接口进而导致编译失败
 *  提供@FunctionalInterface
 */
@FunctionalInterface
public interface GreetingServiceFunctionInterface {

    void sayMessage(String message);
}
