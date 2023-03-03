package pojo.request.createbooking;

public class AddReportRequestPojo {
	
	public ReporterDetails reporter_details;
    public ChildDetails child_details;
    public ReporterDetails getReporter_details() {
		return reporter_details;
	}
	public void setReporter_details(ReporterDetails reporter_details) {
		this.reporter_details = reporter_details;
	}
	public ChildDetails getChild_details() {
		return child_details;
	}
	public void setChild_details(ChildDetails child_details) {
		this.child_details = child_details;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((child_details == null) ? 0 : child_details.hashCode());
		result = prime * result + ((incident_details == null) ? 0 : incident_details.hashCode());
		result = prime * result + ((reporter_details == null) ? 0 : reporter_details.hashCode());
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
		AddReportRequestPojo other = (AddReportRequestPojo) obj;
		if (child_details == null) {
			if (other.child_details != null)
				return false;
		} else if (!child_details.equals(other.child_details))
			return false;
		if (incident_details == null) {
			if (other.incident_details != null)
				return false;
		} else if (!incident_details.equals(other.incident_details))
			return false;
		if (reporter_details == null) {
			if (other.reporter_details != null)
				return false;
		} else if (!reporter_details.equals(other.reporter_details))
			return false;
		return true;
	}
	public IncidentDetails getIncident_details() {
		return incident_details;
	}
	public void setIncident_details(IncidentDetails incident_details) {
		this.incident_details = incident_details;
	}
	public IncidentDetails incident_details;

}
