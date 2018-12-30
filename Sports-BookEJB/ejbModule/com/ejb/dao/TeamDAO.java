package com.ejb.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.book.exception.custom.ParameterNotFoundException;
import com.book.response.TeamResponse;
import com.ejb.persistence.PersistenceService;
import com.ejb.queries.Queries;
import com.ejb.queries.TeamQueries;
import com.entity.Team;
import com.entity.Team.SORT_ORDER;

/**
 * Session Bean implementation class TeamDAO
 */
@Stateless(mappedName = "TeamDAO")
@LocalBean
public class TeamDAO implements TeamDAOLocal {

	private static final Logger log = Logger.getLogger(TeamDAO.class);

	@EJB(name = "PersistenceUnit")
	private PersistenceService persistenceService;

	/**
	 * Default constructor.
	 */
	public TeamDAO() {

	}

	@Override
	public TeamResponse findTeamById(long id) {
		Team team = null;

		team = persistenceService.find(Team.class, id);

		return buildTeamResponse(team);
	}

	@Override
	public TeamResponse findTeamByScheduleName(Team team) {
		StringBuilder queryString = null;
		Map<String, Object> parameters = null;

		if (team == null || StringUtils.isBlank(team.getScheduleName())) {
			log.error("findTeamBySchedulName: team or scheduleName is null");
			throw new ParameterNotFoundException(
					"findTeamBySchedulName: team or scheduleName is null");
		}

		queryString = new StringBuilder();
		parameters = new HashMap<String, Object>();

		queryString.append(TeamQueries.FIND_TEAM);
		queryString.append(Queries.WHERE);
		queryString.append(TeamQueries.SCHEDULE_NAME);
		queryString.append(Queries.EQUALS);
		queryString.append(TeamQueries.SCHEDULE_NAME_PARAM);

		parameters.put(TeamQueries.SCHEDULE_NAME_PARAM.substring(1).trim(),
				team.getScheduleName());

		Team result = persistenceService
				.findSingleByCustomQuery(queryString.toString(), parameters);

		return buildTeamResponse(result);
	}

	@Override
	public TeamResponse findTeamBySpreadName(Team team) {
		StringBuilder queryString = null;
		Map<String, Object> parameters = null;

		if (team == null || StringUtils.isBlank(team.getSpreadName())) {
			log.error("findTeamBySpreadName: team or spreadName is null");
			throw new ParameterNotFoundException(
					"findTeamBySpreadName: team or spreadName is null");
		}

		queryString = new StringBuilder();
		parameters = new HashMap<String, Object>();

		queryString.append(TeamQueries.FIND_TEAM);
		queryString.append(Queries.WHERE);
		queryString.append(TeamQueries.SPREAD_NAME);
		queryString.append(Queries.EQUALS);
		queryString.append(TeamQueries.SPREAD_NAME_PARAM);

		parameters.put(TeamQueries.SPREAD_NAME_PARAM.substring(1).trim(),
				team.getSpreadName());

		Team result = persistenceService
				.findSingleByCustomQuery(queryString.toString(), parameters);

		return buildTeamResponse(result);
	}

	@Override
	public Set<TeamResponse> findTeamsByOrderedBy(SORT_ORDER SORT_VALUE) {
		Set<TeamResponse> returnSet = new LinkedHashSet<TeamResponse>();
		StringBuilder queryString = new StringBuilder();

		queryString.append(TeamQueries.FIND_TEAM);
		queryString.append(Queries.ORDER_BY);
		queryString.append(findSortValue(SORT_VALUE));

		returnSet.addAll(buildTeamResponse(persistenceService.findByCustomQuery(
				queryString.toString(), new HashMap<String, Object>())));

		return returnSet;

	}

	private TeamResponse buildTeamResponse(Team team) {

		return new TeamResponse.TeamResponseBuilder().setTeam(team).build();

	}

	private Collection<TeamResponse> buildTeamResponse(
			Collection<Team> teamCollection) {
		ArrayList<TeamResponse> responses = new ArrayList<TeamResponse>();
		for (Team team : teamCollection) {
			responses.add(new TeamResponse.TeamResponseBuilder().setTeam(team)
					.build());
		}

		return responses;

	}

	private String findSortValue(SORT_ORDER SORT_VALUE) {

		switch (SORT_VALUE) {
		case SCHEDULE_NAME:
			return TeamQueries.SCHEDULE_NAME;
		case SPREAD_NAME:
			return TeamQueries.SPREAD_NAME;
		case WINS:
			return TeamQueries.WINS;
		case ATS_LOSSES:
			return TeamQueries.ATS_LOSSES;
		case ATS_WINS:
			return TeamQueries.ATS_WINS;
		case LOSSES:
			return TeamQueries.LOSSES;
		default:
			throw new ParameterNotFoundException("sort value not found.");

		}

	}

}
