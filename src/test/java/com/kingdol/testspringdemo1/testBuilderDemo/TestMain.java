package com.kingdol.testspringdemo1.testBuilderDemo;


import com.kingdol.testspringdemo1.testBuilderDemo.Entity.Student;
import com.kingdol.testspringdemo1.testBuilderDemo.build.StudentBuilder;

public class TestMain {
    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        Student kingdol = studentBuilder.setAge(18)
                .setId(1L)
                .setName("kingdol")
                .build();
        System.out.println(kingdol);
    }
}
