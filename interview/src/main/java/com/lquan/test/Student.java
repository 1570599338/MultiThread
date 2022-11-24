package com.lquan.test;

/**
 * The type Student.
 *
 * @author lquan
 * @create 2022 - 11-23 下午11:12
 * @description
 */
public class Student {
    /**
     * id : 1
     * name : TOM
     * age : 13
     *  {"id":1,"name":"TOM","age":13}
     */

    private int id;
    private String name;
    private int age;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }


    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }



}
