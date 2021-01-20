package com.inspired.io.SpringData.JPA_2.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
public class CreditCard extends Payment{
    private String creditCardNumber;

    public String getCreditCardDetails() {
        return creditCardNumber;
    }

    public void setCreditCardDetails(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
