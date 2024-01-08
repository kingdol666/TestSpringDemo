package com.kingdol.testspringdemo1.proxyDemo.proxyObj;

import com.kingdol.testspringdemo1.proxyDemo.Obj.Fruit;
import com.kingdol.testspringdemo1.proxyDemo.Obj.FruitInterface;

public class FruitProxy extends Fruit implements FruitInterface {
    public FruitProxy() {
        super();
    }

    @Override
    public int hashCode() {
        // 在计算哈希码时，可以综合考虑子类对象的属性来进行计算
        int result = 17;
        result = 31 * result + super.hashCode();
        // 对子类对象的其他属性进行计算
        // ...
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void eat() {
        System.out.println("FruitProxy eat");
        super.eat();
        System.out.println("FruitProxy eat end");
    }

    @Override
    public void getHashCode() {
        System.out.println("FruitProxy getHashCode@" + this.hashCode());
        super.getHashCode();
    }

}
