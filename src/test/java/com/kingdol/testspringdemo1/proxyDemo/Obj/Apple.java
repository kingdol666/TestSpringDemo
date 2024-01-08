package com.kingdol.testspringdemo1.proxyDemo.Obj;

import com.kingdol.testspringdemo1.proxyDemo.Obj.Fruit;

public class Apple extends Fruit implements FruitInterface{
    public Apple() {
        super();
    }

    @Override
    public void eat() {
        System.out.println("Apple eat");
        super.eat();
    }

    @Override
    public void getHashCode() {
        System.out.println("Apple getHashCode@"+hashCode());
        super.getHashCode();
    }

}
