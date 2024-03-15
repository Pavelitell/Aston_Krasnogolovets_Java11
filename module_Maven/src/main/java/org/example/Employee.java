package org.example;

public class Employee {
    private String name;
    private String jobTitle;
    private String email;
    private String number;
    private int salary;
    private int age;


    public Employee() {
        this.name = "Владимир";
        this.jobTitle = "Инженер";
        this.email = "um@yandex.ru";
        this.number = "89995438865";
        this.salary = 100000;
        this.age = 25;
    }

    @Override
    public String toString() {
        return "employee{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }


}


