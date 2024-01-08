package com.kingdol.testspringdemo1.proxyDemo;

import com.kingdol.testspringdemo1.proxyDemo.Obj.Apple;
import com.kingdol.testspringdemo1.proxyDemo.proxyObj.FruitProxy;
import com.kingdol.testspringdemo1.singletontest.s.People;

public class ProxyTest {
    public static void main(String[] args) {
        try {
            FruitProxy fruitProxy = new FruitProxy();
            fruitProxy.eat();
            boolean equals = fruitProxy.equals(new People());
            System.out.println(equals);
            fruitProxy.getHashCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

