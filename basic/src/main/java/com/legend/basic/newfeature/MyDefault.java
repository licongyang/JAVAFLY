package com.legend.basic.newfeature;

/**
 * jdk8 使用两个新概念拓展了接口的含义：默认方法和静态方法
 * 默认方法使得开发者可以在不破坏二进制兼容性的前提下，往现存接口中添加新的方法
 * 即不强制哪些实现了该接口的类也同时实现这个新加的方法
 * 目的：为了解决接口的修改与现有的实现不兼容的问题
 */

public class MyDefault {
    interface Vehicle {
        default void print(){
            System.out.println("我是一辆车");
        }

        static void blowHorn(){
            System.out.println("按喇叭！！！");
        }
    }

    interface FourWheeler{
        default void print(){
            System.out.println("我是一辆四轮车！");
        }
    }

    static class Car implements Vehicle, FourWheeler{

        @Override
        public void print() {
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.blowHorn();
            System.out.println("我是一辆汽车");
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}
