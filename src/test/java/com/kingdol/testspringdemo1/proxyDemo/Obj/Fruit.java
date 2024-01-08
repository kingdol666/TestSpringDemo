package com.kingdol.testspringdemo1.proxyDemo.Obj;

public class Fruit implements FruitInterface{
    public Fruit() {
    }

    /**
     * 重写equals方法
     * 判断obj是否是Fruit对象 instanseof 判断是否是Fruit类或者子类
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fruit) {
            System.out.println("Fruit equals");
            return true;
        }
        return false;
    }

    public void eat() {
        System.out.println("Fruit eat");
    }

    @Override
    public void getHashCode() {
        System.out.println("Fruit hashCode@"+hashCode());
    }
}
