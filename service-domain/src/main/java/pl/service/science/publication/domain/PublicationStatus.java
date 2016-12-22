package pl.service.science.publication.domain;

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
@Table(name = "publication_status")
public class PublicationStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publication_status_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "status_translation_id")
	public Translation statusName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Translation getStatusName() {
		return statusName;
	}

	public void setStatusName(Translation statusName) {
		this.statusName = statusName;
	}

}