package pojo.request.createbooking;

import java.util.Date;

public class IncidentDetails {
	
	 	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allow_connect_police_NGO ? 1231 : 1237);
		result = prime * result + (community_terms ? 1231 : 1237);
		result = prime * result + ((incident_brief == null) ? 0 : incident_brief.hashCode());
		result = prime * result + ((incident_date == null) ? 0 : incident_date.hashCode());
		result = prime * result + ((landmark_signs == null) ? 0 : landmark_signs.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((nearby_NGO == null) ? 0 : nearby_NGO.hashCode());
		result = prime * result + ((nearby_police_station == null) ? 0 : nearby_police_station.hashCode());
		result = prime * result + (self_verification ? 1231 : 1237);
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
		IncidentDetails other = (IncidentDetails) obj;
		if (allow_connect_police_NGO != other.allow_connect_police_NGO)
			return false;
		if (community_terms != other.community_terms)
			return false;
		if (incident_brief == null) {
			if (other.incident_brief != null)
				return false;
		} else if (!incident_brief.equals(other.incident_brief))
			return false;
		if (incident_date == null) {
			if (other.incident_date != null)
				return false;
		} else if (!incident_date.equals(other.incident_date))
			return false;
		if (landmark_signs == null) {
			if (other.landmark_signs != null)
				return false;
		} else if (!landmark_signs.equals(other.landmark_signs))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (nearby_NGO == null) {
			if (other.nearby_NGO != null)
				return false;
		} else if (!nearby_NGO.equals(other.nearby_NGO))
			return false;
		if (nearby_police_station == null) {
			if (other.nearby_police_station != null)
				return false;
		} else if (!nearby_police_station.equals(other.nearby_police_station))
			return false;
		if (self_verification != other.self_verification)
			return false;
		return true;
	}
		public String incident_date;
	    public String incident_brief;
	    public String location;
	    public String getIncident_date() {
			return incident_date;
		}
		public void setIncident_date(String incident_date) {
			this.incident_date = incident_date;
		}
		public String getIncident_brief() {
			return incident_brief;
		}
		public void setIncident_brief(String incident_brief) {
			this.incident_brief = incident_brief;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getLandmark_signs() {
			return landmark_signs;
		}
		public void setLandmark_signs(String landmark_signs) {
			this.landmark_signs = landmark_signs;
		}
		public String getNearby_police_station() {
			return nearby_police_station;
		}
		public void setNearby_police_station(String nearby_police_station) {
			this.nearby_police_station = nearby_police_station;
		}
		public String getNearby_NGO() {
			return nearby_NGO;
		}
		public void setNearby_NGO(String nearby_NGO) {
			this.nearby_NGO = nearby_NGO;
		}
		public boolean isAllow_connect_police_NGO() {
			return allow_connect_police_NGO;
		}
		public void setAllow_connect_police_NGO(boolean allow_connect_police_NGO) {
			this.allow_connect_police_NGO = allow_connect_police_NGO;
		}
		public boolean isSelf_verification() {
			return self_verification;
		}
		public void setSelf_verification(boolean self_verification) {
			this.self_verification = self_verification;
		}
		public boolean isCommunity_terms() {
			return community_terms;
		}
		public void setCommunity_terms(boolean community_terms) {
			this.community_terms = community_terms;
		}
		public String landmark_signs;
	    public String nearby_police_station;
	    public String nearby_NGO;
	    public boolean allow_connect_police_NGO;
	    public boolean self_verification;
	    public boolean community_terms;

}
