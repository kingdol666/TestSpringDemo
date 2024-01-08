package com.kingdol.testspringdemo1.singletontest;

import com.kingdol.testspringdemo1.singletontest.entity.SingleModel;
import com.kingdol.testspringdemo1.singletontest.s.People;

public class Test1 {
    public static void main(String[] args) {
        SingleModel singleModel = new SingleModel();
        People people1 = singleModel.getPeople();
        People people2 = singleModel.getPeople();
        if (people1 == people2) {
            System.out.println("people1 == people2");
        } else {
            System.out.println("people1 != people2");
        }
        people1.test();
        people2.test();
    }
}
