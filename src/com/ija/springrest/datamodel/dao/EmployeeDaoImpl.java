package com.ija.springrest.datamodel.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ija.springrest.datamodel.table.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
    @Qualifier("sessionFactoryBean")
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> findAll() {
		Session session = sessionFactory.openSession();	
		try {
			Query query = session.createQuery("from Employee");
			return query.list();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Employee> findForName(String name) {
		if (name == null) {
			return null;
		}
		Session session = sessionFactory.openSession();		
		try {
			String qryStr = "from Employee A where" +
		               " A.name = :pName";
			Query query = session.createQuery(qryStr)
					.setParameter("pName", name);
			return  query.list();
		} finally {
			session.close();
		}		

	}

	@Override
	public void store(Employee employee) {
		if (employee != null) {
			Session session = sessionFactory.openSession();	
			Transaction tx = session.beginTransaction();
			try {
				session.saveOrUpdate(employee);
				tx.commit();
			} catch (RuntimeException e) {
				tx.rollback();
				throw e;
			}
			finally {
				session.close();
			}
		}
	}

}
