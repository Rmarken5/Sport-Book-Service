package com.ejb.persistence;

import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class PersistenceService
 */
@Stateless(name="PersistenceService")
@LocalBean
public class PersistenceService implements PersistenceServiceLocal {

    
	@PersistenceContext(unitName="Sports-BookEJB")
	private EntityManager em;
	
    public PersistenceService() {
    }
    
    @Override
    public <T> T find(Class<T> clazz, long e) {
    	
    	return (T) em.find(clazz, e);
    }
    
    @Override
    public <T> T find(Class<T> clazz, int e) {
    	
    	return (T) em.find(clazz, e);
    }

	@Override
	public <V, E> List<E> findByQuery(String queryName, Map<String, V> parameters) {
		List<E> results = null;
		Query query = em.createNamedQuery(queryName);
		
		if(!parameters.isEmpty()) {
			for(String key : parameters.keySet()) {
				query.setParameter(key, parameters.get(key));
			}
		}
		results = query.getResultList();
		
		
		return results;
		
		
	}

	
	public EntityManager getEm() {
		return em;
	}
}
