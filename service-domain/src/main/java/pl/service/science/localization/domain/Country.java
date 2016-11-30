package pl.service.science.localization.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pl.service.science.translation.domain.Translation;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "coutry_transation_id")
	public Translation country;

	// Country which is divided into regions
	@OneToOne(mappedBy = "country")
	public Region region;

	public Long getId() {
		return id;
	}

	public Translation getCountry() {
		return country;
	}

	public void setCountry(Translation country) {
		this.country = country;
	}

	public void setId(Long id) {
		this.id = id;
	}
}