package com.book.service.team;

import java.util.LinkedList;
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

import org.apache.commons.lang3.StringUtils;

import com.book.exception.custom.ParameterNotFoundException;
import com.book.response.TeamResponse;
import com.book.response.TeamResponseList;
import com.ejb.dao.TeamDAO;
import com.ejb.queries.TeamQueries;
import com.entity.Team;
import com.entity.Team.SORT_ORDER;

@RequestScoped
@Path("/team")
@Produces({ "application/json", "text/plain" })
@Consumes({ "application/xml", "application/json", "text/plain" })
public class TeamService {

	@EJB(mappedName = "TeamDAO")
	private TeamDAO teamDAO;

	@GET
	@Path("byId")
	@Produces({ "application/json" })
	public Response getTeamById(@QueryParam("id") String id) {
		TeamResponse team = null;
		try {

			if (StringUtils.isBlank(id)) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
								"id is null or blank")
						.build();
			}

			if (!StringUtils.isNumeric(id)) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
								"id is not numeric")
						.build();
			}

			team = teamDAO.findTeamById(Long.parseLong(id));

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					e.getMessage()).build();
		}

		return Response.ok(team).build();

	}

	@GET
	@Path("byScheduleName")
	@Produces({ "application/json" })
	public Response getTeamByScheduleName(
			@QueryParam("scheduleName") String scheduelName) {
		TeamResponse team = null;
		Team param = null;
		try {

			if (StringUtils.isBlank(scheduelName)) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
								"id is null or blank")
						.build();
			}
			param = new Team();
			param.setScheduleName(scheduelName);

			team = teamDAO.findTeamByScheduleName(param);

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					e.getMessage()).build();
		}

		return Response.ok(team).build();
	}

	@GET
	@Path("bySpreadName")
	@Produces({ "application/json" })
	public Response getTeamBySpreadName(
			@QueryParam("spreadName") String spreadName) {
		TeamResponse team = null;
		Team param = null;
		try {

			if (StringUtils.isBlank(spreadName)) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
								"spreadName is null or blank")
						.build();
			}
			param = new Team();
			param.setSpreadName(spreadName);

			team = teamDAO.findTeamBySpreadName(param);

		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					e.getMessage()).build();
		}

		return Response.ok(team).build();
	}
	
	@GET
	@Path("sorted")
	@Produces({ "application/json" })
	public Response getTeamsByColumn(
			@QueryParam("attribute") String attributeName) {
		List<TeamResponse> teamResponse = new LinkedList<TeamResponse>();
		TeamResponseList teamResponseList = new TeamResponseList();
		try {

			if (StringUtils.isBlank(attributeName)) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
								"spreadName is null or blank")
						.build();
			}
			teamResponse.addAll(teamDAO.findTeamsByOrderedBy(findSortValue(attributeName)));
			teamResponseList.setResponseList(teamResponse);
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					e.getMessage()).build();
		}

		return Response.ok(teamResponseList).build();
	}
	

	private SORT_ORDER  findSortValue(String param) {
		param = param.toUpperCase();
		switch (param){
		case "SPREAD_NAME":
			return SORT_ORDER.SPREAD_NAME;
		case "SCHEDULE_NAME":
			return SORT_ORDER.SCHEDULE_NAME;
		case "WINS":
			return SORT_ORDER.WINS;
		case "ATS_LOSSES":
			return SORT_ORDER.ATS_LOSSES;
		case "ATS_WINS":
			return SORT_ORDER.ATS_WINS;
		case "LOSSES":
			return SORT_ORDER.LOSSES;
		default:
			throw new ParameterNotFoundException("sort value not found.");

		}
	}

}
