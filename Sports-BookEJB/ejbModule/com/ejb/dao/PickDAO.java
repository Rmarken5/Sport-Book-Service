package com.ejb.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.book.exception.custom.ParameterNotFoundException;
import com.book.response.PickResponse;
import com.ejb.persistence.PersistenceService;
import com.entity.Pick;

@LocalBean
@Stateless(mappedName = "pickDAO")
public class PickDAO implements PickDAOLocal {

	@EJB(name = "PersistenceService")
	private PersistenceService persistenceService;

	Logger log = Logger.getLogger(PickDAO.class);

	@Override
	public PickResponse findPickById(long id) {

		Pick pick = persistenceService.find(Pick.class, id);

		return buildPickResponseFromPick(pick);
	}

	@Override
	public List<PickResponse> findPickByGameDate(Pick pick) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<Pick> pickList = new ArrayList<Pick>();

		if (pick == null || pick.getGameDate() == null) {
			log.error("Pick or gameDate is null...");
			throw new ParameterNotFoundException("Pick or gameDate is null...");
		}
		parameters.put("gameDate", pick.getGameDate());

		pickList.addAll(persistenceService.findByQuery("Pick.findByGameDate", parameters));

		return buildResponseList(pickList);
	}

	@Override
	public List<PickResponse> findPickByGameTime(Pick gameTime) {
		List<Pick> picks = new ArrayList<Pick>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (gameTime == null || gameTime.getGameTime() == null) {
			log.error("Pick or gametime is null...");
			throw new ParameterNotFoundException("Pick or gametime is null...");
		}

		parameters.put("gameTime", gameTime.getGameTime());

		picks.addAll(persistenceService.findByQuery("Pick.findByGameTime", parameters));

		return buildResponseList(picks);

	}
	
	@Override
	public List<PickResponse> findPickByAwayTeam(Pick awayTeam) {
		List<Pick> pickList = new ArrayList<Pick>();
		Map<String,Object> parameters = new HashMap<String, Object>();
		
		if(awayTeam == null || awayTeam.getAwayTeam() == null
				|| awayTeam.getAwayTeam().getId() == null) {
			log.error("awayTeam null...");
			throw new ParameterNotFoundException("getAwayTeam is null...");
			
		}
		parameters.put("awayTeamId", awayTeam.getAwayTeam().getId());
		
		pickList.addAll(persistenceService.findByQuery("Pick.findByAwayTeam", parameters));
		
		return buildResponseList(pickList);
	}
	
	@Override
	public List<PickResponse> findPickByHomeTeam(Pick homeTeam) {
		List<Pick> pickList = new ArrayList<Pick>();
		Map<String,Object> parameters = new HashMap<String, Object>();
		
		if(homeTeam == null || homeTeam.getHomeTeam() == null
				|| homeTeam.getHomeTeam().getId() == null) {
			log.error("homeTeam null...");
			throw new ParameterNotFoundException("getAwayTeam is null...");
		}
		
		parameters.put("homeTeamId", homeTeam.getHomeTeam().getId());
		
		pickList.addAll(persistenceService.findByQuery("Pick.findByHomeTeam", parameters));
		
		return buildResponseList(pickList);
		
	}
	
	@Override
	public List<PickResponse> findPickByFavoriteTeam(Pick favoriteTeam) {
		List<Pick> pickList = new ArrayList<Pick>();
		Map<String,Object> parameters = new HashMap<String, Object>();
		
		if(favoriteTeam == null || favoriteTeam.getFavoriteTeam() == null
				|| favoriteTeam.getFavoriteTeam().getId() == null) {
			log.error("homeTeam null...");
			throw new ParameterNotFoundException("getFavoriteTeam is null...");
		}
		
		parameters.put("favoriteTeamId", favoriteTeam.getFavoriteTeam().getId());
		
		pickList.addAll(persistenceService.findByQuery("Pick.findByFavoriteTeam", parameters));
		
		return buildResponseList(pickList);
	}

	@Override
	public PickResponse findPickByGame(Pick params) {
		
		Map<String,Object> parameters = new HashMap<String, Object>();
		
		if(params == null 
				|| params.getHomeTeam() == null
				|| params.getHomeTeam().getId() == null
				|| params.getAwayTeam() == null
				|| params.getAwayTeam().getId() == null
				|| params.getGameDate() == null) {
			log.error("homeTeam or awayTeam or gameDate is null...");
			throw new ParameterNotFoundException("homeTeam or awayTeam or gameDate is null...");
		}
		
		parameters.put("homeTeamId", params.getHomeTeam().getId());
		parameters.put("awayTeamId", params.getAwayTeam().getId());
		parameters.put("gameDate", params.getGameDate());
		
		Pick pick = persistenceService.findSingleByQuery("Pick.findPickByGame", parameters);
		
		return buildPickResponseFromPick(pick);
	}
	
	private PickResponse buildPickResponseFromPick(Pick pick) {

		return new PickResponse.PickResponseBuilder(pick).build();

	}

	private List<PickResponse> buildResponseList(Collection<Pick> pickList) {
		List<PickResponse> responseCollection = new ArrayList<PickResponse>();
		if (pickList != null) {
			for (Pick pick : pickList) {
				responseCollection.add(buildPickResponseFromPick(pick));
			}
		}

		return responseCollection;

	}

}
