package pojo.request.createbooking;

public class ChildDetails {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birth_signs == null) ? 0 : birth_signs.hashCode());
		result = prime * result + ((clothing == null) ? 0 : clothing.hashCode());
		result = prime * result + ((complexion == null) ? 0 : complexion.hashCode());
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((image_file_key == null) ? 0 : image_file_key.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((other_details == null) ? 0 : other_details.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		ChildDetails other = (ChildDetails) obj;
		if (age != other.age)
			return false;
		if (birth_signs == null) {
			if (other.birth_signs != null)
				return false;
		} else if (!birth_signs.equals(other.birth_signs))
			return false;
		if (clothing == null) {
			if (other.clothing != null)
				return false;
		} else if (!clothing.equals(other.clothing))
			return false;
		if (complexion == null) {
			if (other.complexion != null)
				return false;
		} else if (!complexion.equals(other.complexion))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (image_file_key == null) {
			if (other.image_file_key != null)
				return false;
		} else if (!image_file_key.equals(other.image_file_key))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (other_details == null) {
			if (other.other_details != null)
				return false;
		} else if (!other_details.equals(other.other_details))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	public String fullname;
    public int age;
    public String gender;
    public String height;
    public String weight;
    public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getComplexion() {
		return complexion;
	}
	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}
	public String getClothing() {
		return clothing;
	}
	public void setClothing(String clothing) {
		this.clothing = clothing;
	}
	public String getBirth_signs() {
		return birth_signs;
	}
	public void setBirth_signs(String birth_signs) {
		this.birth_signs = birth_signs;
	}
	public String getOther_details() {
		return other_details;
	}
	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}
	public Object getImage_file_key() {
		return image_file_key;
	}
	public void setImage_file_key(Object image_file_key) {
		this.image_file_key = image_file_key;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String complexion;
    public String clothing;
    public String birth_signs;
    public String other_details;
    public Object image_file_key;
    public String nickname;

}
