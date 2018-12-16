package com.ejb.dao;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ejb.persistence.PersistenceService;
import com.entity.Team;

/**
 * Session Bean implementation class TeamDAO
 */
@Stateless(mappedName = "TeamDAO")
@LocalBean
public class TeamDAO implements TeamDAOLocal {

	
	@EJB(name = "PersistenceUnit")
	private PersistenceService persistenceService;
    /**
     * Default constructor. 
     */
    public TeamDAO() {
    	
    }

	@Override
	public Team findTeamById(long id) {
		Team team = null;
		team = persistenceService.find(Team.class, id);
		
		return team;
	}

    
    
}
