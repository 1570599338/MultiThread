package com.lquan.test;

/**
 * @author lquan
 * @create 2022- 11-23 下午11:53
 * @description
 */
public class TestStu {

    public static void main(String[] args) {

        Student student = new Student();
        student.setId(0);
        student.setName("TOM");
        student.setAge(10);

        fun1(student);
        


    }

    public static void fun1(Student student) {
        System.out.println("student1 = " + student);
        fun2(student);
    }

    public static void fun2(Student student) {
        System.out.println("student2 = " + student);
        fun3(student);
    }

    public static void fun3(Student student) {
        System.out.println("student3 = " + student);
        fun4(student);
    }

    public static void fun4(Student student) {
        System.out.println("student4 = " + student);
    }
}
