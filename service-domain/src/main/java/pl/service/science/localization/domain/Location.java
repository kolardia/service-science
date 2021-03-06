package pl.service.science.localization.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.authorization.domain.User;
import pl.service.science.publication.domain.Publication;
import pl.service.science.section.domain.Section;

/**
 * The Location class mapping  on a database for table name: "location"
 * @author kolardia
 *
 */
@Entity
@Table(name = "location")
public class Location {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "location_id" 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id")
	public Long id;

	/**
	 * The mapping on a database for column name: "address"
	 */
	@Column(name = "address")
	public String postalAddress;
	
	/**
	 * Geographic latitude of location; the mapping on a database for column name: "location_longitude"
	 */
	@Column(name="location_longitude")
	public String longitude;
	
	/**
	 * Geographic latitude of location; the mapping on a database for column name: "location_latitude"
	 */
	@Column(name="location_latitude ")
	public String latitude;

	/**
	 * The mapping on a database is one-to-one; column name: "city_id"
	 */
	@ManyToOne
	@JoinColumn(name = "city_id")
	public City city;

	/**
	 * The mapping on a database is many-to-one; column name: "region_id"
	 */
	@ManyToOne
	@JoinColumn(name = "region_id")
	public Region regon;

	/**
	 * The mapping on a database is one-to-one"
	 */
	@OneToOne(mappedBy = "location")
	public Section sectionLocation;
	
	@OneToMany(mappedBy = "eventLocation")
	List <Publication> eventsLocation;

	/**
	 * The mapping on a database is one-to-one"
	 */
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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Section getSectionLocation() {
		return sectionLocation;
	}

	public void setSectionLocation(Section sectionLocation) {
		this.sectionLocation = sectionLocation;
	}

	public List<Publication> getEventsLocation() {
		return eventsLocation;
	}

	public void setEventsLocation(List<Publication> eventsLocation) {
		this.eventsLocation = eventsLocation;
	}

	public User getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(User userLocation) {
		this.userLocation = userLocation;
	}
	
}
