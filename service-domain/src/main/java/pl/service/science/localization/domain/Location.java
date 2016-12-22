package pl.service.science.localization.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.section.domain.Section;
import pl.service.science.user.domain.User;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id")
	public Long id;

	@Column(name = "adress")
	public String postalAddress;

	@ManyToOne
	@JoinColumn(name = "city_id")
	public City city;

	@ManyToOne
	@JoinColumn(name = "region_id")
	public Region regon;

	@OneToOne(mappedBy = "location")
	public Section sectionLocation;

	@OneToOne(mappedBy = "addressOfResidence")
	public User userLocation;

	/*
	 * @Column(name = "section_map") public [type] coordinatesOnMap;
	 *******************************/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public Region getRegon() {
		return regon;
	}

	public void setRegon(Region regon) {
		this.regon = regon;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
