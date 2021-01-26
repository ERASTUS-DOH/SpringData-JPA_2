package com.inspired.io.SpringData.JPA_2.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customerr")
public class Customerr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "customerr", cascade = CascadeType.ALL)
    private Set<PhoneNumber> numbers;

    public Customerr() {
        
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

    public Set<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Customerr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
