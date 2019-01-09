package com.book.service.pick;

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

import com.book.response.PickResponse;
import com.book.response.PickResponseList;
import com.book.util.DateTimeUtil;
import com.ejb.dao.PickDAOLocal;
import com.entity.Pick;
import com.entity.Team;

@RequestScoped
@Path("/pick")
@Produces({ "application/json", "text/plain" })
@Consumes({ "application/xml", "application/json", "text/plain" })
public class PickService {

	private static final Logger logger = Logger.getLogger(PickService.class);

	@EJB(mappedName = "pickDAO")
	private PickDAOLocal pickDAO;

	@Path("/findById")
	@GET
	@Produces({ "application/json" })
	public Response findById(@QueryParam("id") String id) {
		PickResponse pickResponse = null;

		try {

			if (StringUtils.isBlank(id)) {
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), "id is null or blank").build();
			}

			if (!StringUtils.isNumeric(id)) {
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), "id is not numeric").build();
			}

			pickResponse = pickDAO.findPickById((Long.parseLong(id)));

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
		}

		return Response.ok(pickResponse).build();

	}

	@GET
	@Path("/findByGameDate")
	@Produces({ "application/json" })
	public Response findByGameDate(@QueryParam("gameDate") String gameDate) {
		PickResponseList pickResponseList = new PickResponseList();
		Pick parameters = new Pick();
		try {

			if (StringUtils.isBlank(gameDate)) {
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), "gameDate is null or blank")
						.build();
			}
			parameters.setGameDate(DateTimeUtil.parseToDateObject(gameDate));
			pickResponseList.setPickResponseList(pickDAO.findPickByGameDate(parameters));

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
		}

		return Response.ok(pickResponseList).build();

	}

	@GET
	@Path("/findByGameTime")
	@Produces({ "application/json" })
	public Response findByGameTime(@QueryParam("gameTime") String gameTime) {
		PickResponseList pickResponseList = new PickResponseList();
		Pick parameters = new Pick();
		try {

			if (StringUtils.isBlank(gameTime)) {
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), "gameDate is null or blank")
						.build();
			}
			parameters.setGameTime(DateTimeUtil.parseTimeToDateObject(gameTime));
			pickResponseList.setPickResponseList(pickDAO.findPickByGameTime(parameters));

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
		}

		return Response.ok(pickResponseList).build();

	}

	@GET
	@Path("/findByHomeTeam")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findByHomeTeam(@QueryParam("homeTeamId") String homeTeamId) {
		PickResponseList pickResponses = new PickResponseList();
		Pick parameters = new Pick();
		Team team = new Team();
		try {

			if (StringUtils.isBlank(homeTeamId) || !StringUtils.isNumeric(homeTeamId)) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), "homeTeamId is null, blank, or NAN")
						.build();
			}
			team.setId(Long.parseLong(homeTeamId));
			parameters.setHomeTeam(team);
			pickResponses.setPickResponseList(pickDAO.findPickByHomeTeam(parameters));

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
		}
		return Response.ok(pickResponses).build();
	}

	@GET
	@Path("/findByAwayTeam")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findByAwayTeam(@QueryParam("awayTeamId") String awayTeamId) {
		PickResponseList pickResponses = new PickResponseList();
		Pick parameters = new Pick();
		Team team = new Team();
		try {

			if (StringUtils.isBlank(awayTeamId) || !StringUtils.isNumeric(awayTeamId)) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), "awayTeamId is null, blank, or NAN")
						.build();
			}
			team.setId(Long.parseLong(awayTeamId));
			parameters.setAwayTeam(team);
			pickResponses.setPickResponseList(pickDAO.findPickByAwayTeam(parameters));

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
		}
		return Response.ok(pickResponses).build();
	}

	@GET
	@Path("/findByFavoriteTeam")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findByFavoriteTeam(@QueryParam("favoriteTeamId") String favoriteTeamId) {
		PickResponseList pickResponses = new PickResponseList();
		Pick parameters = new Pick();
		Team team = new Team();
		try {

			if (StringUtils.isBlank(favoriteTeamId) || !StringUtils.isNumeric(favoriteTeamId)) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), "awayTeamId is null, blank, or NAN")
						.build();
			}
			team.setId(Long.parseLong(favoriteTeamId));
			parameters.setFavoriteTeam(team);
			pickResponses.setPickResponseList(pickDAO.findPickByFavoriteTeam(parameters));

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
		}
		return Response.ok(pickResponses).build();
	}

	@GET
	@Path("/findByGame")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findByGame(@QueryParam("awayTeamId") String awayTeamId, @QueryParam("homeTeamId") String homeTeamId,
			@QueryParam("gameDate") String gameDate) {
		PickResponse pickResponses = new PickResponse();
		Pick parameters = new Pick();
		Team homeTeam = new Team();
		Team awayTeam = new Team();
		try {

			if (StringUtils.isBlank(awayTeamId) || !StringUtils.isNumeric(awayTeamId) || StringUtils.isBlank(awayTeamId)
					|| !StringUtils.isNumeric(awayTeamId) || StringUtils.isBlank(gameDate)) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), "awayTeamId, homeTeam, or gameDate is null, blank, or NAN")
						.build();
			}
			homeTeam.setId(Long.parseLong(homeTeamId));
			awayTeam.setId(Long.parseLong(awayTeamId));
			
			parameters.setGameDate(DateTimeUtil.parseToDateObject(gameDate));
			parameters.setHomeTeam(homeTeam);
			parameters.setAwayTeam(awayTeam);
			
			pickResponses = pickDAO.findPickByGame(parameters);

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
		}
		return Response.ok(pickResponses).build();
	}

}
