package com.kingdol.testspringdemo1.testBuilderDemo.build;

import com.kingdol.testspringdemo1.testBuilderDemo.Entity.Student;

public class StudentBuilder {
    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public StudentBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Student build() {
        return new Student(id, name, age);
    }
}
