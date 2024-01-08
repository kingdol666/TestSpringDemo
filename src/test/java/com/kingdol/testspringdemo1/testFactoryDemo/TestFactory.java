package com.kingdol.testspringdemo1.testFactoryDemo;

import com.kingdol.testspringdemo1.testBuilderDemo.build.StudentBuilder;
import com.kingdol.testspringdemo1.testFactoryDemo.entity.StudentEntity;
import com.kingdol.testspringdemo1.testFactoryDemo.factory.StudentFactory;

public class TestFactory {
    public static void main(String[] args) {
        StudentFactory studentFactory = new StudentFactory();
        StudentEntity Student1 = studentFactory.createStudentEntity(new StudentBuilder().setAge(18).setName("张三").setId(1L).build());
        System.out.println(Student1);
    }
}
