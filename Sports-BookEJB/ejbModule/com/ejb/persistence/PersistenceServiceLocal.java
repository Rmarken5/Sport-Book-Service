package com.ejb.persistence;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface PersistenceServiceLocal {

	public <T> T find(Class<T> clazz, int e);

	public <T> T find(Class<T> clazz, long e);
	
	public <V, E> List<E> findByQuery(String query, Map<String,V> parameters);
}
