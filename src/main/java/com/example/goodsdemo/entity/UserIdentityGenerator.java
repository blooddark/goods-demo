package com.example.goodsdemo.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IncrementGenerator;

import java.io.Serializable;
import java.util.UUID;

public class UserIdentityGenerator extends IncrementGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sessionImplementor, Object object) throws HibernateException {
        Serializable id = sessionImplementor.getEntityPersister(null, object)
                .getClassMetadata().getIdentifier(object, sessionImplementor);
        return id != null ? id : UUID.randomUUID().toString().replace("-","");
    }
}
