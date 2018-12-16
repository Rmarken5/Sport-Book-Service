package com.book.response;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.book.response.TeamResponse.TeamResponseBuilder;
import com.entity.Schedule;
import com.entity.Team;

@XmlRootElement
public class ScheduleResponse implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -2717449977011679949L;

	public ScheduleResponse() {

	}

	private Long scheduleId;

	private Date gameDate;

	private Date gameTime;

	private TeamResponse homeTeam;

	private TeamResponse awayTeam;

	private TeamResponse winningTeam;

	private TeamResponse losingTeam;

	private Integer homeTeamScore;
	
	private Integer awayTeamScore;
	
	
	
	@XmlAttribute
	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	@XmlElement
	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	@XmlElement
	public Date getGameTime() {
		return gameTime;
	}

	public void setGameTime(Date gameTime) {
		this.gameTime = gameTime;
	}

	@XmlElement
	public TeamResponse getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(TeamResponse homeTeam) {
		this.homeTeam = homeTeam;
	}

	@XmlElement
	public TeamResponse getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(TeamResponse awayTeam) {
		this.awayTeam = awayTeam;
	}

	@XmlElement
	public TeamResponse getWinningTeam() {
		return winningTeam;
	}

	public void setWinningTeam(TeamResponse winningTeam) {
		this.winningTeam = winningTeam;
	}

	@XmlElement
	public TeamResponse getLosingTeam() {
		return losingTeam;
	}

	public void setLosingTeam(TeamResponse losingTeam) {
		this.losingTeam = losingTeam;
	}
	@XmlElement
	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}

	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	@XmlElement
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
		ScheduleResponse other = (ScheduleResponse) obj;
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
				+ ", losingTeam=" + losingTeam + "]";
	}

	public static class ScheduleResponseBuilder {

		private Long scheduleId;

		private Date gameDate;

		private Date gameTime;

		private TeamResponse homeTeam;

		private TeamResponse awayTeam;

		private TeamResponse winningTeam;

		private TeamResponse losingTeam;
		
		private Integer homeTeamScore;
		
		private Integer awayTeamScore;

		
		public ScheduleResponseBuilder(Long scheduleId, Date gameDate, Date gameTime, TeamResponse homeTeam,
				TeamResponse awayTeam, TeamResponse winningTeam, TeamResponse losingTeam,
				Integer homeTeamScore, Integer awayTeamScore) {
			super();
			this.scheduleId = scheduleId;
			this.gameDate = gameDate;
			this.gameTime = gameTime;
			this.homeTeam = homeTeam;
			this.awayTeam = awayTeam;
			this.winningTeam = winningTeam;
			this.losingTeam = losingTeam;
			this.homeTeamScore = homeTeamScore;
			this.awayTeamScore = awayTeamScore;
			
		}
		public ScheduleResponseBuilder() {

		}

		public ScheduleResponseBuilder setScheduleId(Long scheduleId) {
			this.scheduleId = scheduleId;
			return this;
		}
		
		public ScheduleResponseBuilder setGameDate(Date gameDate) {
			this.gameDate = gameDate;
			return this;
		}
		
		public ScheduleResponseBuilder setGameTime(Date gameTime) {
			this.gameTime = gameTime;
			return this;
		}
		
		public ScheduleResponseBuilder setHomeTeam(TeamResponse homeTeam) {
			this.homeTeam = homeTeam;
			return this;
		}
		
		public ScheduleResponseBuilder setAwayTeam(TeamResponse awayTeam) {
			this.awayTeam = awayTeam;
			return this;
		}
		public ScheduleResponseBuilder setHomeTeam(Team homeTeam) {
			this.homeTeam = new TeamResponse.TeamResponseBuilder().setTeam(homeTeam).build();
			return this;
		}
		
		public ScheduleResponseBuilder setAwayTeam(Team awayTeam) {
			this.awayTeam = new TeamResponse.TeamResponseBuilder().setTeam(awayTeam).build();
			return this;
		}
		
		public ScheduleResponseBuilder setWinningTeam(TeamResponse winningTeam) {
			this.winningTeam = winningTeam;
			return this;
		}
		
		public ScheduleResponseBuilder setLosingTeam(TeamResponse losingTeam) {
			this.losingTeam = losingTeam;
			return this;
		}
		public ScheduleResponseBuilder setWinningTeam(Team winningTeam) {
			this.winningTeam = new TeamResponse.TeamResponseBuilder().setTeam(winningTeam).build();
			return this;
		}
		
		public ScheduleResponseBuilder setLosingTeam(Team losingTeam) {
			this.losingTeam = new TeamResponse.TeamResponseBuilder().setTeam(losingTeam).build();
			return this;
		}

		public ScheduleResponseBuilder setHomeTeamScore(Integer homeTeamScore) {
			this.homeTeamScore = homeTeamScore;
			return this;
		}
		
		public ScheduleResponseBuilder setAwayTeamScore(Integer awayTeamScore) {
			this.awayTeamScore = awayTeamScore;
			return this;
		}
		
		public ScheduleResponse buildFromSchedule(Schedule schedule) {
			
			setScheduleId(schedule.getScheduleId());
			setAwayTeam(schedule.getAwayTeam());
			setHomeTeam(schedule.getHomeTeam());
			setGameTime(schedule.getGameTime());
			setGameDate(schedule.getGameDate());
			setWinningTeam(schedule.getWinningTeam());
			setLosingTeam(schedule.getLossingTeam());
			setHomeTeamScore(schedule.getHomeTeamScore());
			setAwayTeamScore(schedule.getAwayTeamScore());
			
			return build();
		}
		
		public ScheduleResponse build() {
			ScheduleResponse scheduleResponse = new ScheduleResponse();
			scheduleResponse.scheduleId = this.scheduleId;
			scheduleResponse.homeTeam = this.homeTeam;
			scheduleResponse.awayTeam = this.awayTeam;
			scheduleResponse.gameDate = this.gameDate;
			scheduleResponse.gameTime = this.gameTime;
			scheduleResponse.winningTeam = this.winningTeam;
			scheduleResponse.losingTeam = this.losingTeam;
			scheduleResponse.homeTeamScore = this.homeTeamScore;
			scheduleResponse.awayTeamScore = this.awayTeamScore;
			return scheduleResponse;
		}
	}

}
