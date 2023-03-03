package pojo.request.createbooking;

import java.util.Date;

public class ReporterDetails {
	
    public String request_id;
    public int user_id;
    public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public String getReporter_fullname() {
		return reporter_fullname;
	}
	public void setReporter_fullname(String reporter_fullname) {
		this.reporter_fullname = reporter_fullname;
	}
	public int getReporter_age() {
		return reporter_age;
	}
	public void setReporter_age(int reporter_age) {
		this.reporter_age = reporter_age;
	}
	public String getReporter_gender() {
		return reporter_gender;
	}
	public void setReporter_gender(String reporter_gender) {
		this.reporter_gender = reporter_gender;
	}
	public String getReporter_relation() {
		return reporter_relation;
	}
	public void setReporter_relation(String reporter_relation) {
		this.reporter_relation = reporter_relation;
	}
	public String getParenting_type() {
		return parenting_type;
	}
	public void setParenting_type(String parenting_type) {
		this.parenting_type = parenting_type;
	}
	public String getContact_address_type() {
		return contact_address_type;
	}
	public void setContact_address_type(String contact_address_type) {
		this.contact_address_type = contact_address_type;
	}
	public String getContact_address_line_1() {
		return contact_address_line_1;
	}
	public void setContact_address_line_1(String contact_address_line_1) {
		this.contact_address_line_1 = contact_address_line_1;
	}
	public String getContact_address_line_2() {
		return contact_address_line_2;
	}
	public void setContact_address_line_2(String contact_address_line_2) {
		this.contact_address_line_2 = contact_address_line_2;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPrimary_country_code() {
		return primary_country_code;
	}
	public void setPrimary_country_code(String primary_country_code) {
		this.primary_country_code = primary_country_code;
	}
	public String getPrimary_contact_number() {
		return primary_contact_number;
	}
	public void setPrimary_contact_number(String primary_contact_number) {
		this.primary_contact_number = primary_contact_number;
	}
	public String getSecondary_country_code() {
		return secondary_country_code;
	}
	public void setSecondary_country_code(String secondary_country_code) {
		this.secondary_country_code = secondary_country_code;
	}
	public String getSecondary_contact_number() {
		return secondary_contact_number;
	}
	public void setSecondary_contact_number(String secondary_contact_number) {
		this.secondary_contact_number = secondary_contact_number;
	}
	public String getCommunication_language() {
		return communication_language;
	}
	public void setCommunication_language(String communication_language) {
		this.communication_language = communication_language;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((communication_language == null) ? 0 : communication_language.hashCode());
		result = prime * result + ((contact_address_line_1 == null) ? 0 : contact_address_line_1.hashCode());
		result = prime * result + ((contact_address_line_2 == null) ? 0 : contact_address_line_2.hashCode());
		result = prime * result + ((contact_address_type == null) ? 0 : contact_address_type.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((parenting_type == null) ? 0 : parenting_type.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((primary_contact_number == null) ? 0 : primary_contact_number.hashCode());
		result = prime * result + ((primary_country_code == null) ? 0 : primary_country_code.hashCode());
		result = prime * result + ((report_date == null) ? 0 : report_date.hashCode());
		result = prime * result + reporter_age;
		result = prime * result + ((reporter_fullname == null) ? 0 : reporter_fullname.hashCode());
		result = prime * result + ((reporter_gender == null) ? 0 : reporter_gender.hashCode());
		result = prime * result + ((reporter_relation == null) ? 0 : reporter_relation.hashCode());
		result = prime * result + ((request_id == null) ? 0 : request_id.hashCode());
		result = prime * result + ((secondary_contact_number == null) ? 0 : secondary_contact_number.hashCode());
		result = prime * result + ((secondary_country_code == null) ? 0 : secondary_country_code.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + user_id;
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
		ReporterDetails other = (ReporterDetails) obj;
		if (communication_language == null) {
			if (other.communication_language != null)
				return false;
		} else if (!communication_language.equals(other.communication_language))
			return false;
		if (contact_address_line_1 == null) {
			if (other.contact_address_line_1 != null)
				return false;
		} else if (!contact_address_line_1.equals(other.contact_address_line_1))
			return false;
		if (contact_address_line_2 == null) {
			if (other.contact_address_line_2 != null)
				return false;
		} else if (!contact_address_line_2.equals(other.contact_address_line_2))
			return false;
		if (contact_address_type == null) {
			if (other.contact_address_type != null)
				return false;
		} else if (!contact_address_type.equals(other.contact_address_type))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (parenting_type == null) {
			if (other.parenting_type != null)
				return false;
		} else if (!parenting_type.equals(other.parenting_type))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (primary_contact_number == null) {
			if (other.primary_contact_number != null)
				return false;
		} else if (!primary_contact_number.equals(other.primary_contact_number))
			return false;
		if (primary_country_code == null) {
			if (other.primary_country_code != null)
				return false;
		} else if (!primary_country_code.equals(other.primary_country_code))
			return false;
		if (report_date == null) {
			if (other.report_date != null)
				return false;
		} else if (!report_date.equals(other.report_date))
			return false;
		if (reporter_age != other.reporter_age)
			return false;
		if (reporter_fullname == null) {
			if (other.reporter_fullname != null)
				return false;
		} else if (!reporter_fullname.equals(other.reporter_fullname))
			return false;
		if (reporter_gender == null) {
			if (other.reporter_gender != null)
				return false;
		} else if (!reporter_gender.equals(other.reporter_gender))
			return false;
		if (reporter_relation == null) {
			if (other.reporter_relation != null)
				return false;
		} else if (!reporter_relation.equals(other.reporter_relation))
			return false;
		if (request_id == null) {
			if (other.request_id != null)
				return false;
		} else if (!request_id.equals(other.request_id))
			return false;
		if (secondary_contact_number == null) {
			if (other.secondary_contact_number != null)
				return false;
		} else if (!secondary_contact_number.equals(other.secondary_contact_number))
			return false;
		if (secondary_country_code == null) {
			if (other.secondary_country_code != null)
				return false;
		} else if (!secondary_country_code.equals(other.secondary_country_code))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String report_date;
    public String reporter_fullname;
    public int reporter_age;
    public String reporter_gender;
    public String reporter_relation;
    public String parenting_type;
    public String contact_address_type;
    public String contact_address_line_1;
    public String contact_address_line_2;
    public String pincode;
    public String country;
    public String primary_country_code;
    public String primary_contact_number;
    public String secondary_country_code;
    public String secondary_contact_number;
    public String communication_language;
    public String status;

}
