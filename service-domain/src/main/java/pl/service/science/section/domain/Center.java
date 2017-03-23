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

@Entity
@Table(name = "section_center")
public class Center {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "center_id")
	public Long id;

	@OneToOne
	@JoinColumn(name = "section_center_id")
	public Section sectionCenter;
	

	@ManyToOne
	@JoinColumn(name = "section_order_id")
	public Section subsection;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Section getSectionCenter() {
		return sectionCenter;
	}


	public void setSectionCenter(Section sectionCenter) {
		this.sectionCenter = sectionCenter;
	}


	public Section getSubsection() {
		return subsection;
	}


	public void setSubsection(Section subsection) {
		this.subsection = subsection;
	}
}
