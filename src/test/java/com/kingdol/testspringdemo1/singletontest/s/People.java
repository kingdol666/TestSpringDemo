package com.kingdol.testspringdemo1.singletontest.s;

public class People {
    public People() {
    }

    public void test() {
        System.out.println("people test@" + this.hashCode());
    }
}
