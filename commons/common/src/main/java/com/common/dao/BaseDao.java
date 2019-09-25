package com.common.dao;

public interface BaseDao<T> {
	
	Long save(T t);
	
	int update(T t);
	
	int delete(Object id);
}
