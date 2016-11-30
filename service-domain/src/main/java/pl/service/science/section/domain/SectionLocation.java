package pl.service.science.section.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pl.service.science.localization.domain.City;

@Entity
@Table(name = "section_location")
public class SectionLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "section_location_id")
	public Long id;

	@OneToOne(mappedBy = "location")
	@JoinColumn(name="section_id")
	public Section location;

	@ManyToOne
	@JoinColumn(name = "section_city_id")
	public City sectonLocation;

	@Column(name = "section_adress")
	public String sectionAdress;

	@Column(name = "section_map")
	public String sectionmap;

}
