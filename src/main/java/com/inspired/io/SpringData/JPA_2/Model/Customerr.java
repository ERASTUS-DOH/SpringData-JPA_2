package com.inspired.io.SpringData.JPA_2.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customerr")
public class Customerr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "customerr", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public void addPhoneNumber(PhoneNumber number){
        if(number != null){
            if(numbers == null){
                numbers = new HashSet<>();
            }
            number.setCustomerr(this);
            numbers.add(number);
        }

    }

    @Override
    public String toString() {
        return "Customerr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
