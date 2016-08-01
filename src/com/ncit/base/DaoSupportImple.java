package com.ncit.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

//@Transactional注解可以被继承
//@Transactional注解对父类中声明的方法无效
@Transactional
@SuppressWarnings("unchecked")
public class DaoSupportImple<T> implements DaoSupport<T>{

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	
	public DaoSupportImple() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		System.out.println("clazz ---> " + clazz);
	}
	
	protected  Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(int id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(int id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
//		if (ids == null || ids.length == 0) {
//			return Collections.EMPTY_LIST;
//		} else {
//			return getSession().createQuery(//
//					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
//					.setParameterList("ids", ids)//
//					.list();
//		}
		return null;
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

}
