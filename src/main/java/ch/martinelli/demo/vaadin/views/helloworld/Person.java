package ch.martinelli.demo.vaadin.views.helloworld;

import java.math.BigDecimal;

public class Person {

    private String name;
    private BigDecimal salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
