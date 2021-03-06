/**
 * 
 */
package com.book.service;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.book.dao.TeamDAO;
import com.book.dao.TeamDAOImpl;
import com.book.response.TeamResponse;

/**
 * @author pegasus
 *
 */
@RequestScoped
@Path("/hello")
@Produces({ "application/json", "text/plain"})
@Consumes({ "application/xml", "application/json" })
public class Hello {

	@GET
	@Path("/helloworld")
	@Produces({"application/json"})
	public TeamResponse sayHello() {
		TeamResponse team = new TeamResponse();
		team.setId(1l);
		team.setSpreadName("Hello");
		
		TeamDAO dao = new TeamDAOImpl();
		
		dao.getTeamById(1l);
		
		return team;
	}
	
	
}
