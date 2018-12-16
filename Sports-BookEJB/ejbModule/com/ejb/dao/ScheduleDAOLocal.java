package com.ejb.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.book.response.ScheduleResponse;
import com.entity.Schedule;
import com.entity.Team;

@Local
public interface ScheduleDAOLocal {

	
	public ScheduleResponse findScheduleById(Long id);
	
	public List<ScheduleResponse> findScheduleByDate(Date date);
	
	public List<ScheduleResponse> findScheduleByTime(Date time);
	
	public List<ScheduleResponse> findScheduleByDateAndTime(Date date, Date time);
	
	public List<ScheduleResponse> findScheduleByHomeTeam(Team homeTeam);
	
	public List<ScheduleResponse> findScheduleByAwayTeam(Team awayTeam);
	
	public List<ScheduleResponse> findScheduleByMatchUp(Team teamOne, Team teamTwo);
}
