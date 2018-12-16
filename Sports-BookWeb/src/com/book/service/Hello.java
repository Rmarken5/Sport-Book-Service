/**
 * 
 */
package com.book.service;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.book.response.ScheduleResponse;
import com.book.response.TeamResponse;
import com.ejb.dao.ScheduleDAO;
import com.ejb.dao.TeamDAO;
import com.ejb.test.TestBeanLocal;
import com.entity.Schedule;
import com.entity.Team;

/**
 * @author pegasus
 *
 */
@RequestScoped
@Path("/hello")
@Produces({ "application/json", "text/plain"})
@Consumes({ "application/xml", "application/json" })
public class Hello {

	@EJB(beanName = "TeamDAO")
	private TeamDAO teamDAO;
	
	@EJB(beanName = "ScheduleDAO")
	private ScheduleDAO scheduleDAO;
	
	@GET
	@Path("/helloworld")
	@Produces({"application/json"})
	public TeamResponse sayHello() {
		Team team = teamDAO.findTeamById(5L);
		
		TeamResponse tr = new TeamResponse();
		tr.setId(team.getId());
		tr.setScheduleName(team.getScheduleName());
		
		
		return tr;
	}
	
	@GET
	@Path("/schedule")
	@Produces({"application/json"})
	public ScheduleResponse getSchedule() {
		ScheduleResponse sr  = scheduleDAO.findScheduleById(187l);
		
		return sr;
	}
}