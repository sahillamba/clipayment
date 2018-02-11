package com.coviam.payment.dto;


import java.io.Serializable;

public class PassengerDTO implements Serializable {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerDTO that = (PassengerDTO) o;

        if (!name.equals(that.name)) return false;
        return age.equals(that.age);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PassengerDTO{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
