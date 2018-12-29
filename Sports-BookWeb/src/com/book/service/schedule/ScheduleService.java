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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.book.response.ScheduleResponse;
import com.book.response.ScheduleResponseList;
import com.ejb.dao.ScheduleDAOLocal;
import com.entity.Team;

@RequestScoped
@Path("/schedule")
@Produces({ "application/json", "text/plain" })
@Consumes({ "application/xml", "application/json", "text/plain" })
public class ScheduleService {

	private static final Logger logger = Logger
			.getLogger(ScheduleService.class);

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

	@Path("/bytime")
	@GET
	@Produces({ "application/json" })
	public Response findScheduleByTime(@QueryParam("time") String time) {

		List<ScheduleResponse> resultList = null;
		ScheduleResponseList responseList = null;
		final Date dateObject;
		try {
			dateObject = parseTimeToDateObject(time);
			resultList = scheduleDAO.findScheduleByTime(dateObject);
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

	@GET
	@Path("/bydatetime")
	@Produces("application/json")
	public Response findScheduleByDateAndTime(@QueryParam("date") String date,
			@QueryParam("time") String time) {

		List<ScheduleResponse> resultList = null;
		ScheduleResponseList responseList = null;
		final Date dateObject;
		final Date timeObject;
		try {
			dateObject = parseToDateObj(date);
			timeObject = parseTimeToDateObject(time);
			resultList = scheduleDAO.findScheduleByDateAndTime(dateObject,
					timeObject);
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

	@GET
	@Path("/byhometeam")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findScheduleByHomeTeam(
			@QueryParam("id") String homeTeamId) {

		List<ScheduleResponse> resultList = null;
		ScheduleResponseList responseList = null;

		try {

			if (StringUtils.isBlank(homeTeamId)) {
				logger.error("home id is null or blank.");
				return Response
						.status(Response.Status.BAD_REQUEST.getStatusCode(),
								"home id is null or blank.")
						.build();
			}
			if (!StringUtils.isNumeric(homeTeamId)) {
				logger.error("home id is not a number.");
				return Response
						.status(Response.Status.BAD_REQUEST.getStatusCode(),
								"home id is not a number.")
						.build();
			}
			Team homeTeam = new Team();
			homeTeam.setId(Long.valueOf(homeTeamId));
			resultList = scheduleDAO.findScheduleByHomeTeam(homeTeam);
			responseList = new ScheduleResponseList();
			responseList.setList(resultList);
		} catch (Exception e) {
			return Response.status(
					Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					e.getMessage()).build();
		}
		return Response.ok(responseList).build();
	}

	@GET
	@Path("/byawayteam")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findScheduleByAwayTeam(
			@QueryParam("id") String awayTeamId) {

		List<ScheduleResponse> resultList = null;
		ScheduleResponseList responseList = null;

		try {

			if (StringUtils.isBlank(awayTeamId)) {
				logger.error("home id is null or blank.");
				return Response
						.status(Response.Status.BAD_REQUEST.getStatusCode(),
								"away id is null or blank.")
						.build();
			}
			if (!StringUtils.isNumeric(awayTeamId)) {
				logger.error("home id is not a number.");
				return Response
						.status(Response.Status.BAD_REQUEST.getStatusCode(),
								"away id is not a number.")
						.build();
			}
			Team awayTeam = new Team();
			awayTeam.setId(Long.valueOf(awayTeamId));
			resultList = scheduleDAO.findScheduleByAwayTeam(awayTeam);
			responseList = new ScheduleResponseList();
			responseList.setList(resultList);
		} catch (Exception e) {
			return Response.status(
					Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					e.getMessage()).build();
		}
		return Response.ok(responseList).build();
	}

	/*
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

	private Date parseTimeToDateObject(String time) throws ParseException {
		final String format = "HH:mm:ss";
		DateFormat df = new SimpleDateFormat(format);
		final Date dateObject = df.parse(time);

		return dateObject;
	}

}
