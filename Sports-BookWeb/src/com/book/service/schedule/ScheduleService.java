package com.book.service.schedule;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.book.response.ScheduleResponse;
import com.book.response.ScheduleResponseList;
import com.ejb.dao.ScheduleDAOLocal;

@RequestScoped
@Path("/schedule")
@Produces({ "application/json", "text/plain" })
@Consumes({ "application/xml", "application/json", "text/plain" })
public class ScheduleService {

	@EJB(name = "ScheduleDAO")
	private ScheduleDAOLocal scheduleDAO;

	@Path("/find")
	@GET
	@Produces({ "application/json" })
	public Response findScheduleById(@QueryParam("id") Long id) {
		ScheduleResponse scheduleResponse = null;
		try {
			scheduleResponse = scheduleDAO.findScheduleById(id);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					e.getMessage()).build();
		}
		return Response.ok(scheduleResponse).build();

	}

	@Path("/bydate")
	@GET
	@Produces({ "application/json" })
	public Response findScheduleByDate(@QueryParam("date") String date) {
		List<ScheduleResponse> resultList = null;
		ScheduleResponseList responseList = null;
		final Date dateObject;
		try {
			dateObject = parseToDateObj(date);
			resultList = scheduleDAO.findScheduleByDate(dateObject);
			responseList = new ScheduleResponseList();
			responseList.setList(resultList);
		} catch (ParseException e) {
			return Response.status(Response.Status.BAD_REQUEST.getStatusCode(),
					"Date not able to format").build();
		} catch (Exception e) {
			return Response.status(
					Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					e.getMessage()).build();
		}
		return Response.ok(responseList).build();
	}
/*	@Path("/bytime")
	@GET
	@Produces({ "application/json" })
	public List<ScheduleResponse> findScheduleByTime(Date time) {

	}
*/
	/*
	 * public List<ScheduleResponse> findScheduleByDateAndTime(Date date, Date
	 * time);
	 * 
	 * public List<ScheduleResponse> findScheduleByHomeTeam(Team homeTeam);
	 * 
	 * public List<ScheduleResponse> findScheduleByAwayTeam(Team awayTeam);
	 * 
	 * public List<ScheduleResponse> findScheduleByMatchUp(Team teamOne, Team
	 * teamTwo);
	 */

	private Date parseToDateObj(String date) throws ParseException {
		final String format = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(format);
		final Date dateObject;

		dateObject = df.parse(date);

		return dateObject;
	}
}
