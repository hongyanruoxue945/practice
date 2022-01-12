package com.zhm.demo.design.factory;

public class MyFactory extends AbstractFactory{

    @Override
    public User createUser(String num) {
        User user = null;
        if("UserOne".equals(num)){
            user = new UserOne();
        }else if("UserTwo".equals(num)){
            user = new UserTwo();
        }
        return user;
    }
}
