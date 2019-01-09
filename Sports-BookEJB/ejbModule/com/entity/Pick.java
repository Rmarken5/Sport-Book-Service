package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PICK")
@NamedQueries({
	@NamedQuery(name = "Pick.findByGameDate", query = "SELECT p FROM Pick p WHERE p.gameDate = :gameDate ORDER BY p.gameTime ASC"),
	@NamedQuery(name = "Pick.findByGameTime", query = "SELECT p FROM Pick p WHERE p.gameTime = :gameTime ORDER BY p.gameDate ASC"),
	@NamedQuery(name = "Pick.findByHomeTeam", query = "SELECT p FROM Pick p WHERE p.homeTeam.id = :homeTeamId"),
	@NamedQuery(name = "Pick.findByAwayTeam", query = "SELECT p FROM Pick p WHERE p.awayTeam.id = :awayTeamId"),
	@NamedQuery(name = "Pick.findByFavoriteTeam", query = "SELECT p FROM Pick p WHERE p.favoriteTeam.id = :favoriteTeamId" ),
	@NamedQuery(name = "Pick.findPickByGame", query = "SELECT p FROM Pick p WHERE "
			+ "p.gameDate = :gameDate "
			+ "AND p.homeTeam.id = :homeTeamId "
			+ "AND p.awayTeam.id = :awayTeamId" )
	
})
public class Pick {

	@Id
	@Column(name = "PICK_ID")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "GAME_DATE")
	private Date gameDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "GAME_TIME")
	private Date gameTime;
	
	@ManyToOne
	@JoinColumn(name = "HOME_TEAM_ID")
	private Team homeTeam;
	
	@ManyToOne
	@JoinColumn(name = "AWAY_TEAM_ID")
	private Team awayTeam;
	
	@Column(name = "SPREAD")
	private float spread;
	
	@ManyToOne
	@JoinColumn(name = "FAVORITE_TEAM_ID")
	private Team favoriteTeam;
	
	@Column(name = "PICKED_CORRECTLY")
	private Boolean pickedCorrectly;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((awayTeam == null) ? 0 : awayTeam.hashCode());
		result = prime * result + ((favoriteTeam == null) ? 0 : favoriteTeam.hashCode());
		result = prime * result + ((gameDate == null) ? 0 : gameDate.hashCode());
		result = prime * result + ((gameTime == null) ? 0 : gameTime.hashCode());
		result = prime * result + ((homeTeam == null) ? 0 : homeTeam.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pickedCorrectly == null) ? 0 : pickedCorrectly.hashCode());
		result = prime * result + Float.floatToIntBits(spread);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pick other = (Pick) obj;
		if (awayTeam == null) {
			if (other.awayTeam != null)
				return false;
		} else if (!awayTeam.equals(other.awayTeam))
			return false;
		if (favoriteTeam == null) {
			if (other.favoriteTeam != null)
				return false;
		} else if (!favoriteTeam.equals(other.favoriteTeam))
			return false;
		if (gameDate == null) {
			if (other.gameDate != null)
				return false;
		} else if (!gameDate.equals(other.gameDate))
			return false;
		if (gameTime == null) {
			if (other.gameTime != null)
				return false;
		} else if (!gameTime.equals(other.gameTime))
			return false;
		if (homeTeam == null) {
			if (other.homeTeam != null)
				return false;
		} else if (!homeTeam.equals(other.homeTeam))
			return false;
		if (id != other.id)
			return false;
		if (pickedCorrectly == null) {
			if (other.pickedCorrectly != null)
				return false;
		} else if (!pickedCorrectly.equals(other.pickedCorrectly))
			return false;
		if (Float.floatToIntBits(spread) != Float.floatToIntBits(other.spread))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public Date getGameTime() {
		return gameTime;
	}

	public void setGameTime(Date gameTime) {
		this.gameTime = gameTime;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public float getSpread() {
		return spread;
	}

	public void setSpread(float spread) {
		this.spread = spread;
	}

	public Team getFavoriteTeam() {
		return favoriteTeam;
	}

	public void setFavoriteTeam(Team favoriteTeam) {
		this.favoriteTeam = favoriteTeam;
	}

	public Boolean getPickedCorrectly() {
		return pickedCorrectly;
	}

	public void setPickedCorrectly(Boolean pickedCorrectly) {
		this.pickedCorrectly = pickedCorrectly;
	}
	
	
	
	
}
