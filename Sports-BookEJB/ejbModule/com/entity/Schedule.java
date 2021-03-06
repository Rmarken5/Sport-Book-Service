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


@Entity(name="Schedule")
@Table(name="SCHEDULE")
@NamedQueries(value = {
		@NamedQuery(name = "Schedule.findScheduleById",
				query = "SELECT s FROM Schedule s WHERE s.scheduleId = :id"),
		@NamedQuery(name = "Schedule.findScheduleByGameDate",
		query = "SELECT s FROM Schedule s WHERE s.gameDate = :gameDate"),
		@NamedQuery(name = "Schedule.findScheduleByGameTime",
		query = "SELECT s FROM Schedule s WHERE s.gameTime = :gameTime"),
		@NamedQuery(name = "Schedule.findScheduleByDateAndTime",
		query = "SELECT s FROM Schedule s WHERE s.gameDate = :gameDate "
				+ "AND s.gameTime = :gameTime"),
		@NamedQuery(name = "Schedule.findScheduleByHomeTeam",
		query = "SELECT s FROM Schedule s WHERE s.homeTeam.id = :homeTeamId"),
		@NamedQuery(name = "Schedule.findScheduleByAwayTeam",
		query = "SELECT s FROM Schedule s WHERE s.awayTeam.id = :awayTeamId"),
		@NamedQuery(name = "Schedule.findScheduleByMatchup",
		query = "SELECT s FROM Schedule s WHERE (s.homeTeam.id = :teamOneId"
				+ " AND s.awayTeam.id = :teamTwoId)"
				+ " OR ( s.homeTeam.id = :teamTwoId"  
				+ " AND s.awayTeam.id = :teamOneId)")
})
public class Schedule implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8610990845442701585L;

	@Id
	@Column(name = "SCHEDULE_ID")
	private Long scheduleId;

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

	@ManyToOne
	@JoinColumn(name = "WINNING_TEAM_ID")
	private Team winningTeam;

	@ManyToOne
	@JoinColumn(name = "LOSING_TEAM_ID")
	private Team lossingTeam;
	
	@Column(name = "HOME_TEAM_SCORE" )
	private Integer homeTeamScore;
	
	@Column(name = "AWAY_TEAM_SCORE")
	private Integer awayTeamScore;

	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
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

	public Team getWinningTeam() {
		return winningTeam;
	}

	public void setWinningTeam(Team winningTeam) {
		this.winningTeam = winningTeam;
	}

	public Team getLossingTeam() {
		return lossingTeam;
	}

	public void setLossingTeam(Team lossingTeam) {
		this.lossingTeam = lossingTeam;
	}

	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}

	public void setAwayTeamScore(Integer awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((awayTeam == null) ? 0 : awayTeam.hashCode());
		result = prime * result + ((gameDate == null) ? 0 : gameDate.hashCode());
		result = prime * result + ((gameTime == null) ? 0 : gameTime.hashCode());
		result = prime * result + ((homeTeam == null) ? 0 : homeTeam.hashCode());
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
		Schedule other = (Schedule) obj;
		if (awayTeam == null) {
			if (other.awayTeam != null)
				return false;
		} else if (!awayTeam.equals(other.awayTeam))
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
		return true;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", gameDate=" + gameDate + ", gameTime=" + gameTime
				+ ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", winningTeam=" + winningTeam
				+ ", lossingTeam=" + lossingTeam + "]";
	}

}
