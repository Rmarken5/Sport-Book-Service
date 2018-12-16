package com.ejb.test;

import javax.ejb.Local;

import com.entity.Team;

@Local
public interface TestBeanLocal {

	public Team getTeam();
	
}
