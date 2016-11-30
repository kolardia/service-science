package pl.service.science.section.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "section_center")
public class SectionCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "center_id")
	public Long id;

	@ManyToOne
	@JoinColumn(name = "section_center_id")
	public Section sectionCenter;

	@ManyToOne
	@JoinColumn(name = "section_order_id")
	public Section subsection;

}
