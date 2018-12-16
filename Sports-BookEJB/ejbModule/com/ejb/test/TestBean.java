package com.ejb.test;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entity.Team;

/**
 * Session Bean implementation class TestBean
 */
@Stateless(name = "TestBeanImpl")
@LocalBean
public class TestBean implements TestBeanLocal {

	@PersistenceContext(unitName="Sports-BookEJB")
	private EntityManager em;
	
    public TestBean() {

    }
    
    @Override
    public Team getTeam() {
    	Team team = em.find(Team.class, 1L);
    	
    	return team;
    }

}
