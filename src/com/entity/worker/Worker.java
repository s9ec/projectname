package com.entity.worker;

public class Worker {
    private int id;
    private String name;
    private String gender;
    private int age;
    private int base_salary;
    private int bonus;
    private int final_salary;
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(int base_salary) {
        this.base_salary = base_salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFinal_salary() {
        return final_salary;
    }

    public void setFinal_salary(int final_salary) {
        this.final_salary = final_salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", base_salary=" + base_salary +
                ", bonus=" + bonus +
                ", final_salary=" + final_salary +
                '}';
    }
}
