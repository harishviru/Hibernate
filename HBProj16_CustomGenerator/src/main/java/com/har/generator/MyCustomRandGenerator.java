package com.har.generator;
import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyCustomRandGenerator implements IdentifierGenerator {

	public MyCustomRandGenerator() {
		System.out.println("MyCustomRandGenerator-0-param constructor");
	}
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("MyCustomRandGenerator.generate()");
		 Random random = new Random();
		 int randomInt = random.nextInt(10000);
		return new Integer(randomInt);
	}

}
