package com.websystique.springmvc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.websystique.springmvc.model.Employee;

public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) hibernateTemplate.get(persistentClass, key);
	}

	/*public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}*/
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	
	
	//Select all Values
	@SuppressWarnings("unchecked")
	public List<Employee> getResults(){
		return (List<Employee>) hibernateTemplate.loadAll(persistentClass);
	}
	
	//Select Some Values
	@SuppressWarnings("unchecked")
	public List<Employee> findBySSN(String ssn){
		return (List<Employee>) hibernateTemplate.find("from Employee e where e.ssn=?",ssn);
	}

	public void persist(T entity) {
		hibernateTemplate.save(entity);
	}

	public void delete(T entity) {
		hibernateTemplate.delete(entity);
		
	}

}
