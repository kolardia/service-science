package pl.service.science.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorization")
public class Authorization {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorization_id")
	public Long id;

}
