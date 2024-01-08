package com.kingdol.testspringdemo1.singletontest.entity;

import com.kingdol.testspringdemo1.singletontest.s.People;

public class SingleModel {
    private People people = null;

    public SingleModel() {
    }

    public People getPeople() {
        if (people == null) {
            people = new People();
        }
        return people;
    }
}
