package DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

public class ProfileDTO {
	
	public Long id;

	@NotEmpty
	@Size(min=2, max=30)
	public String name;
	
	public String surname;
	
	@NotEmpty
	@Email
	public String email;
	
	@Pattern(regexp="^(\\+?([0]{2})?\\ ?([0-9]{2})?)\\ ?([0-9]{3}\\-?\\:?){3}+")
	public String phone;
	
	public String address;
	
	public String city;
	
	public String province;
	
	public String country;
	
	public String account;
	
	public String title;
	
	public String img;
	
	public String quickIntroduction;
	
	public String description;
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuickIntroduction() {
		return quickIntroduction;
	}

	public void setQuickIntroduction(String quickIntroduction) {
		this.quickIntroduction = quickIntroduction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ProfileDTO [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone="
				+ phone + ", address=" + address + ", city=" + city + ", province=" + province + ", country=" + country
				+ ", account=" + account + ", title=" + title + ", img=" + img + ", quickIntroduction="
				+ quickIntroduction + ", description=" + description + "]";
	}
	
}
