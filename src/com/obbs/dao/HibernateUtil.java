package com.obbs.dao;

import org.hibernate.*;

import org.hibernate.cfg.*;

public class HibernateUtil {

	private static final SessionFactory SESSIONFACTORY;
	static {
		try {
			SESSIONFACTORY = new Configuration().configure().buildSessionFactory();

		} catch (Throwable ex) {

			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSIONFACTORY;
	}

}
