package com.ejb.dao;

import java.util.Set;

import javax.ejb.Local;

import com.book.response.TeamResponse;
import com.entity.Team;

@Local
public interface TeamDAOLocal {

	public TeamResponse findTeamById(long id);
	
	public TeamResponse findTeamByScheduleName(Team team);
	
	public TeamResponse findTeamBySpreadName(Team team);
	
	public Set<TeamResponse> findTeamsByOrderedBy(Team.SORT_ORDER SORT_VALUE);
}
