package com.kingdol.testspringdemo1.testFactoryDemo.factory;

import com.kingdol.testspringdemo1.testBuilderDemo.Entity.Student;
import com.kingdol.testspringdemo1.testFactoryDemo.entity.StudentEntity;

public class StudentFactory {
    public StudentEntity createStudentEntity(Student student){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        return studentEntity;
    }
}
