package com.inspired.io.SpringData.JPA_2.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
//    @TableGenerator(
//            name="employee_gen",
//            table = "id_gen",
//            pkColumnName = "gen_name",
//            valueColumnName = "gen_val"
//    )

//    @GeneratedValue(strategy = GenerationType.TABLE, generator="employee_gen")

    @GenericGenerator(name="emp_id", strategy = "com.inspired.io.SpringData.JPA_2.Model.CustomRandomGenerator")
    @GeneratedValue(generator = "emp_id")
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private Integer id;
    private String name;

    public Employee() {
    }

    public Employee(String name) {

        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
