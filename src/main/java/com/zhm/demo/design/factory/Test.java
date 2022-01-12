package com.zhm.demo.design.factory;

/**
 * 总结：简单工厂是只有一个工厂，工厂模式是将工厂进行抽象，可以创造无数个工厂创建不同的对象
 */
public class Test {
    public static void main(String[] args) {
        MyFactory myFactory = new MyFactory();
        User userOne = myFactory.createUser("UserOne");
    }
}
