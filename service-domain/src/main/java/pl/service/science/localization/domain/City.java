package pl.service.science.localization.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.service.science.translation.domain.Translation;

/**
 * The City mapping  on a database for table name: "city"
 * @author kolardia
 *
 */
@Entity
@Table(name = "city")
public class City {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name: "city_id"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "city_id")
	Long id;

	/**
	 * The mapping on a database is one-to-one; column name: "city_translation_id"
	 */
	@OneToOne
	@JoinColumn(name = "city_translation_id")
	public Translation city;

	/**
	 * The mapping on a database is one-to-many
	 */
	@OneToMany(mappedBy = "city")
	public List<Location> cities;

	public City() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getCity() {
		return city;
	}

	public void setCity(Translation city) {
		this.city = city;
	}

}