package com.inspired.io.SpringData.JPA_2.Model;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String number;
    private String type;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customerr customerr;
    public PhoneNumber() {
    }

    public PhoneNumber(Integer id, String number, String type) {
        this.id = id;
        this.number = number;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Customerr getCustomerr() {
        return customerr;
    }

    public void setCustomerr(Customerr customerr) {
        this.customerr = customerr;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
