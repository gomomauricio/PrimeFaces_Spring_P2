package com.bita.dao;

import java.io.Serializable;
import java.sql.Connection;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public abstract class DBGenericDAO implements Serializable {		
	private static final long serialVersionUID = 1L;
	
	@Autowired
   @Qualifier("DBSessionFactory")
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
        return sessionFactory;    
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;    
    }
    
    public Connection getConnection() {
		return ((SessionImpl) (sessionFactory.getCurrentSession())).connection();
	}        
}
