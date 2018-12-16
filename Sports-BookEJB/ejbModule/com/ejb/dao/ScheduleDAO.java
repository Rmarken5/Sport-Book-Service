package com.ejb.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.book.exception.custom.ParameterNotFoundException;
import com.book.response.ScheduleResponse;
import com.ejb.persistence.PersistenceService;
import com.entity.Schedule;
import com.entity.Team;

/**
 * Session Bean implementation class ScheduleDAO
 */
@Stateless(mappedName = "ScheduleDAO")
@LocalBean
public class ScheduleDAO implements ScheduleDAOLocal {

	@EJB(name = "PersistenceUnit")
	private PersistenceService persistenceService;

	private static final Logger log = Logger.getLogger(ScheduleDAO.class);

	/**
	 * Default constructor.
	 */
	public ScheduleDAO() {

	}

	@Override
	public ScheduleResponse findScheduleById(Long id) {
		Schedule schedule = null;
		try {
			if (id == null) {
				log.error("ID cannot be null");
				throw new RuntimeException("ID cannot be null");
			}
			schedule = persistenceService.find(Schedule.class, id);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		log.debug(schedule.toString());

		return new ScheduleResponse.ScheduleResponseBuilder()
				.buildFromSchedule(schedule);

	}

	@Override
	public List<ScheduleResponse> findScheduleByDate(Date date) {

		List<ScheduleResponse> scheduleResponseList = new ArrayList<ScheduleResponse>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (date == null) {
			log.error("findScheduleByDate: date argument is null.");
			throw new ParameterNotFoundException(
					"findScheduleByDate: date argument is null.");
		}
		parameters.put("gameDate", date);

		addAllEntitiesToCollection(scheduleResponseList, persistenceService
				.findByQuery("Schedule.findScheduleByGameDate", parameters));

		return scheduleResponseList;
	}

	@Override
	public List<ScheduleResponse> findScheduleByTime(Date time) {
		List<ScheduleResponse> scheduleResponseList = new ArrayList<ScheduleResponse>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (time == null) {
			throw new ParameterNotFoundException(
					"findScheduleByTime: time cannot be null");
		}
		parameters.put("gameTime", time);

		addAllEntitiesToCollection(scheduleResponseList,
				persistenceService.findByQuery(
						"Schedule.findSchedule.findScheduleByGameTime",
						parameters));
		return scheduleResponseList;
	}

	@Override
	public List<ScheduleResponse> findScheduleByDateAndTime(Date date,
			Date time) {
		List<ScheduleResponse> scheduleResponseList = new ArrayList<ScheduleResponse>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (date == null) {
			throw new ParameterNotFoundException(
					"findScheduleByDateAndTime: date cannot be null");
		}
		if (time == null) {
			throw new ParameterNotFoundException(
					"findScheduleByDateAndTime: time cannot be null");
		}
		parameters.put("gameTime", time);
		parameters.put("gameDate", date);

		addAllEntitiesToCollection(scheduleResponseList, persistenceService
				.findByQuery("Schedule.findScheduleByGameTime", parameters));
		return scheduleResponseList;
	}

	@Override
	public List<ScheduleResponse> findScheduleByHomeTeam(Team homeTeam) {

		List<ScheduleResponse> scheduleResponseList = new ArrayList<ScheduleResponse>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (homeTeam == null) {
			log.error("findScheduleByHomeTeam: homeTeam cannot be null.");
			throw new ParameterNotFoundException(
					"findScheduleByHomeTeam: homeTeam cannot be null.");
		}
		parameters.put("homeTeam", homeTeam);

		addAllEntitiesToCollection(scheduleResponseList, persistenceService
				.findByQuery("Schedule.findScheduleByHomeTeam", parameters));

		return scheduleResponseList;
	}

	@Override
	public List<ScheduleResponse> findScheduleByAwayTeam(Team awayTeam) {
		List<ScheduleResponse> scheduleResponseList = new ArrayList<ScheduleResponse>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (awayTeam == null) {
			log.error("findScheduleByAwayTeam: awayTeam cannot be null.");
			throw new ParameterNotFoundException(
					"findScheduleByAwayTeam: awayTeam cannot be null.");
		}
		parameters.put("awayTeam", awayTeam);

		addAllEntitiesToCollection(scheduleResponseList, persistenceService
				.findByQuery("Schedule.findScheduleByAwayTeam", parameters));

		return scheduleResponseList;
	}

	@Override
	public List<ScheduleResponse> findScheduleByMatchUp(Team teamOne,
			Team teamTwo) {
		List<ScheduleResponse> scheduleResponseList = new ArrayList<ScheduleResponse>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (teamOne == null) {
			log.error("findScheduleByMatchUp: teamOne cannot be null.");
			throw new ParameterNotFoundException(
					"findScheduleByMatchUp: teamOne cannot be null.");
		}
		if (teamTwo == null) {
			log.error("findScheduleByMatchUp: teamTwo cannot be null.");
			throw new ParameterNotFoundException(
					"findScheduleByMatchUp: teamTwo cannot be null.");
		}

		parameters.put("teamOne", teamOne);
		parameters.put("teamTwo", teamTwo);

		addAllEntitiesToCollection(scheduleResponseList, persistenceService
				.findByQuery("Schedule.findScheduleByMatchup", parameters));

		return scheduleResponseList;
	}

	public void addAllEntitiesToCollection(List<ScheduleResponse> collection,
			List<Schedule> entities) {

		if (collection == null) {
			log.error(
					"addAllEntitiesToCollection: collection in arguments is null");
			throw new NullPointerException(
					"addAllEntitiesToCollection: collection in arguments is null");
		}

		if (entities == null) {
			log.error(
					"addAllEntitiesToCollection: entities in arguments is null");
			throw new NullPointerException(
					"addAllEntitiesToCollection: entities in arguments is null");
		}

		for (Schedule schedule : entities) {
			collection.add(new ScheduleResponse.ScheduleResponseBuilder()
					.buildFromSchedule(schedule));
		}
	}

}
