package com.book.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.entity.Team;

@XmlRootElement
public class TeamResponse {

	private Long id;

	private String spreadName;

	private String scheduleName;

	private Long wins;

	private Long losses;

	private Long againstTheSpreadWins;

	private Long againstTheSpreadLosses;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (againstTheSpreadLosses ^ (againstTheSpreadLosses >>> 32));
		result = prime * result + (int) (againstTheSpreadWins ^ (againstTheSpreadWins >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (losses ^ (losses >>> 32));
		result = prime * result + ((scheduleName == null) ? 0 : scheduleName.hashCode());
		result = prime * result + ((spreadName == null) ? 0 : spreadName.hashCode());
		result = prime * result + (int) (wins ^ (wins >>> 32));
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
		TeamResponse other = (TeamResponse) obj;
		if (againstTheSpreadLosses != other.againstTheSpreadLosses)
			return false;
		if (againstTheSpreadWins != other.againstTheSpreadWins)
			return false;
		if (id != other.id)
			return false;
		if (losses != other.losses)
			return false;
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
		if (wins != other.wins)
			return false;
		return true;
	}

	
	@XmlAttribute
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@XmlElement
	public String getSpreadName() {
		return spreadName;
	}

	public void setSpreadName(String spreadName) {
		this.spreadName = spreadName;
	}
	@XmlElement
	public String getScheduleName() {
		return scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	@XmlElement
	public Long getWins() {
		return wins;
	}

	public void setWins(long wins) {
		this.wins = wins;
	}
	@XmlElement
	public Long getLosses() {
		return losses;
	}

	public void setLosses(long losses) {
		this.losses = losses;
	}
	@XmlElement
	public Long getAgainstTheSpreadWins() {
		return againstTheSpreadWins;
	}

	public void setAgainstTheSpreadWins(long againstTheSpreadWins) {
		this.againstTheSpreadWins = againstTheSpreadWins;
	}
	@XmlElement
	public Long getAgainstTheSpreadLosses() {
		return againstTheSpreadLosses;
	}

	public void setAgainstTheSpreadLosses(long againstTheSpreadLosses) {
		this.againstTheSpreadLosses = againstTheSpreadLosses;
	}
	
	public static class TeamResponseBuilder{
		
		private Long id;

		private String spreadName;

		private String scheduleName;

		private Long wins;

		private Long losses;

		private Long againstTheSpreadWins;

		private Long againstTheSpreadLosses;

		public TeamResponseBuilder(long id, String spreadName, String scheduleName, long wins, long losses,
				long againstTheSpreadWins, long againstTheSpreadLosses) {
			super();
			this.id = id;
			this.spreadName = spreadName;
			this.scheduleName = scheduleName;
			this.wins = wins;
			this.losses = losses;
			this.againstTheSpreadWins = againstTheSpreadWins;
			this.againstTheSpreadLosses = againstTheSpreadLosses;
		}
		
		public TeamResponseBuilder() {
		}

		public TeamResponseBuilder setTeam(Team team) {
			this.id = team.getId();
			this.spreadName = team.getSpreadName();
			this.scheduleName = team.getScheduleName();
			this.wins = team.getWins();
			this.losses = team.getLosses();
			this.againstTheSpreadWins = team.getAgainstTheSpreadWins();
			this.againstTheSpreadLosses = team.getAgainstTheSpreadLosses();
			return this;
		}
		
		public TeamResponseBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		public TeamResponseBuilder setSpreadName(String spreadName) {
			this.spreadName = spreadName;
			return this;
		}
		public TeamResponseBuilder setScheduleName(String scheduleName) {
			this.scheduleName = scheduleName;
			return this;
		}
		public TeamResponseBuilder setWins(Long wins) {
			this.wins = wins;
			return this;
		}
		public TeamResponseBuilder setLosses(Long losses) {
			this.losses = losses;
			return this;
		}
		public TeamResponseBuilder setAgainstTheSpreadWins(Long againstTheSpreadWins) {
			this.againstTheSpreadWins = againstTheSpreadWins;
			return this;
		}
		public TeamResponseBuilder setAgainstTheSpreadLosses(Long againstTheSpreadLosses) {
			this.againstTheSpreadLosses = againstTheSpreadLosses;
			return this;
		}
		
		public TeamResponse build() {
			TeamResponse teamResponse = new TeamResponse();
			teamResponse.id = this.id;
			teamResponse.scheduleName = this.scheduleName;
			teamResponse.spreadName = this.spreadName;
			teamResponse.wins = this.wins;
			teamResponse.losses = this.losses;
			teamResponse.againstTheSpreadWins = this.againstTheSpreadWins;
			teamResponse.againstTheSpreadLosses = this.againstTheSpreadLosses;
			return teamResponse;
		}
		
	}

}
