package com.book.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TeamResponse {

	private long id;

	private String spreadName;

	private String scheduleName;

	private long wins;

	private long losses;

	private long againstTheSpreadWins;

	private long againstTheSpreadLosses;

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
	public long getId() {
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
	public long getWins() {
		return wins;
	}

	public void setWins(long wins) {
		this.wins = wins;
	}
	@XmlElement
	public long getLosses() {
		return losses;
	}

	public void setLosses(long losses) {
		this.losses = losses;
	}
	@XmlElement
	public long getAgainstTheSpreadWins() {
		return againstTheSpreadWins;
	}

	public void setAgainstTheSpreadWins(long againstTheSpreadWins) {
		this.againstTheSpreadWins = againstTheSpreadWins;
	}
	@XmlElement
	public long getAgainstTheSpreadLosses() {
		return againstTheSpreadLosses;
	}

	public void setAgainstTheSpreadLosses(long againstTheSpreadLosses) {
		this.againstTheSpreadLosses = againstTheSpreadLosses;
	}

}
