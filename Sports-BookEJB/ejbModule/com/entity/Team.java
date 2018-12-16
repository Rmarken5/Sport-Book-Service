package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team {

	public Team() {

		
	}
	
	@Id
	@Column(name = "TEAM_ID")
	private Long id;
	
	@Column(name = "SPREAD_NAME")
	private String spreadName;

	@Column(name = "SCHEDULE_NAME")
	private String scheduleName;
	
	@Column(name = "WINS")
	private Long wins;
	
	@Column(name = "LOSSES")
	private Long losses;
	
	@Column(name = "ATS_WINS")
	private Long againstTheSpreadWins;
	
	@Column(name = "ATS_LOSSES")
	private Long againstTheSpreadLosses;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getSpreadName() {
		return this.spreadName;
	}



	public void setSpreadName(String spreadName) {
		this.spreadName = spreadName;
	}



	public String getScheduleName() {
		return scheduleName;
	}



	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}



	public Long getWins() {
		return wins;
	}



	public void setWins(Long wins) {
		this.wins = wins;
	}



	public Long getLosses() {
		return losses;
	}



	public void setLosses(Long losses) {
		this.losses = losses;
	}



	public Long getAgainstTheSpreadWins() {
		return againstTheSpreadWins;
	}



	public void setAgainstTheSpreadWins(Long againstTheSpreadWins) {
		this.againstTheSpreadWins = againstTheSpreadWins;
	}



	public Long getAgainstTheSpreadLosses() {
		return againstTheSpreadLosses;
	}



	public void setAgainstTheSpreadLosses(Long againstTheSpreadLosses) {
		this.againstTheSpreadLosses = againstTheSpreadLosses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scheduleName == null) ? 0 : scheduleName.hashCode());
		result = prime * result + ((spreadName == null) ? 0 : spreadName.hashCode());
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
		Team other = (Team) obj;
		if (scheduleName == null) {
			if (other.scheduleName != null)
				return false;
		} else if (!scheduleName.equals(other.scheduleName))
			return false;
		if (spreadName == null) {
			if (other.spreadName != null)
				return false;
		} else if (!spreadName.equals(other.spreadName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", spreadName=" + spreadName + ", scheduleName=" + scheduleName + ", wins=" + wins
				+ ", losses=" + losses + ", againstTheSpreadWins=" + againstTheSpreadWins + ", againstTheSpreadLosses="
				+ againstTheSpreadLosses + "]";
	}

}
