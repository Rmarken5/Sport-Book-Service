package com.book.response;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.entity.Pick;
import com.entity.Team;

@XmlRootElement
public class PickResponse {

	private long id;

	private Date gameDate;

	private Date gameTime;

	private TeamResponse awayTeam;

	private TeamResponse homeTeam;

	private double spread;

	private TeamResponse favorite;

	private Boolean pickedCorrectly;

	public PickResponse() {

	}

	public PickResponse(long id, Date gameDate, Date gameTime, TeamResponse awayTeam, TeamResponse homeTeam,
			double spread, TeamResponse favorite, Boolean pickedCorrectly) {
		super();
		this.id = id;
		this.gameDate = gameDate;
		this.gameTime = gameTime;
		this.awayTeam = awayTeam;
		this.homeTeam = homeTeam;
		this.spread = spread;
		this.favorite = favorite;
		this.pickedCorrectly = pickedCorrectly;
	}

	@XmlAttribute
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public TeamResponse getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(TeamResponse awayTeam) {
		this.awayTeam = awayTeam;
	}

	@XmlElement
	public TeamResponse getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(TeamResponse homeTeam) {
		this.homeTeam = homeTeam;
	}

	@XmlElement
	public double getSpread() {
		return spread;
	}

	public void setSpread(double spread) {
		this.spread = spread;
	}

	@XmlElement
	public TeamResponse getFavorite() {
		return favorite;
	}

	public void setFavorite(TeamResponse favorite) {
		this.favorite = favorite;
	}

	@XmlElement
	public Boolean getPickedCorrectly() {
		return pickedCorrectly;
	}

	public void setPickedCorrectly(Boolean pickedCorrectly) {
		this.pickedCorrectly = pickedCorrectly;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((awayTeam == null) ? 0 : awayTeam.hashCode());
		result = prime * result + ((favorite == null) ? 0 : favorite.hashCode());
		result = prime * result + ((gameDate == null) ? 0 : gameDate.hashCode());
		result = prime * result + ((gameTime == null) ? 0 : gameTime.hashCode());
		result = prime * result + ((homeTeam == null) ? 0 : homeTeam.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pickedCorrectly == null) ? 0 : pickedCorrectly.hashCode());
		long temp;
		temp = Double.doubleToLongBits(spread);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PickResponse other = (PickResponse) obj;
		if (awayTeam == null) {
			if (other.awayTeam != null)
				return false;
		} else if (!awayTeam.equals(other.awayTeam))
			return false;
		if (favorite == null) {
			if (other.favorite != null)
				return false;
		} else if (!favorite.equals(other.favorite))
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
		if (Double.doubleToLongBits(spread) != Double.doubleToLongBits(other.spread))
			return false;
		return true;
	}

	public static class PickResponseBuilder {

		private static Logger log = Logger.getLogger(PickResponseBuilder.class);
		
		private long id;

		private Date gameDate;

		private Date gameTime;

		private TeamResponse awayTeam;

		private TeamResponse homeTeam;

		private float spread;

		private TeamResponse favorite;

		private Boolean pickedCorrectly;
		
		public PickResponseBuilder(Pick pick) {
			if (pick != null) {
				setId(pick.getId());
				setGameDate(pick.getGameDate());
				setGameTime(pick.getGameTime());
				setAwayTeam(pick.getAwayTeam());
				setHomeTeam(pick.getHomeTeam());
				setFavorite(pick.getFavoriteTeam());
				setSpread(pick.getSpread());
				setPickedCorrectly(pick.getPickedCorrectly());
			} else {
				log.info("Pick object is null for builder...");
			}

		}
		
		public PickResponseBuilder() {
			
		}

		public PickResponseBuilder setId(long id) {
			this.id = id;
			return this;
		}

		public PickResponseBuilder setGameDate(Date gameDate) {
			this.gameDate = gameDate;
			return this;
		}

		public PickResponseBuilder setGameTime(Date gameTime) {
			this.gameTime = gameTime;
			return this;
		}

		public PickResponseBuilder setAwayTeam(TeamResponse awayTeam) {
			this.awayTeam = awayTeam;
			return this;
		}

		public PickResponseBuilder setHomeTeam(TeamResponse homeTeam) {
			this.homeTeam = homeTeam;
			return this;
		}

		public PickResponseBuilder setAwayTeam(Team awayTeam) {
			this.awayTeam = new TeamResponse.TeamResponseBuilder().setTeam(awayTeam).build();
			return this;
		}

		public PickResponseBuilder setHomeTeam(Team homeTeam) {
			this.homeTeam = new TeamResponse.TeamResponseBuilder().setTeam(homeTeam).build();
			return this;
		}

		public PickResponseBuilder setSpread(float spread) {
			this.spread = spread;
			return this;
		}

		public PickResponseBuilder setFavorite(TeamResponse favorite) {
			this.favorite = favorite;
			return this;
		}
		
		public PickResponseBuilder setFavorite(Team favorite) {
			this.favorite = new TeamResponse.TeamResponseBuilder().setTeam(favorite).build();
			return this;
		}

		public PickResponseBuilder setPickedCorrectly(Boolean pickedCorrectly) {
			this.pickedCorrectly = pickedCorrectly;
			return this;
		}

		public PickResponse build() {

			return new PickResponse(this.id, this.gameDate, this.gameTime, this.awayTeam, this.homeTeam, this.spread,
					this.favorite, this.pickedCorrectly);

		}

	}

}
