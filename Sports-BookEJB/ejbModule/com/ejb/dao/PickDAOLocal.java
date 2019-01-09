package com.ejb.dao;

import java.util.List;

import javax.ejb.Local;

import com.book.response.PickResponse;
import com.entity.Pick;

@Local
public interface PickDAOLocal {

	public PickResponse findPickById(long id);
	
	public List<PickResponse> findPickByGameDate(Pick gameDate);
	
	public List<PickResponse> findPickByGameTime(Pick gameTime);
	
	public List<PickResponse> findPickByHomeTeam(Pick homeTeam);
	
	public List<PickResponse> findPickByAwayTeam(Pick awayTeam);
	
	public List<PickResponse> findPickByFavoriteTeam(Pick favoriteTeam);
	
	public PickResponse findPickByGame(Pick params);
	
}
 