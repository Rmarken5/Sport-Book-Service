package com.ejb.dao;

import javax.ejb.Local;

import com.entity.Team;

@Local
public interface TeamDAOLocal {

	public Team findTeamById(long id);
	
}
