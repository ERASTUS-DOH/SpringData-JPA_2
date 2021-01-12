package com.inspired.io.SpringData.JPA_2.Model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.util.Random;

public class CustomRandomGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object obj) throws HibernateException {
        int id = 0;
        Random random = new Random();
        id = random.nextInt(100000);
        return new Integer(id);
    }
}
