package pl.service.science.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pl.service.science.localization.domain.City;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_id")
	public Long id;

	@Column(name = "user_emaail")
	public String email;

	@Column(name = "user_name")
	public String name;

	@Column(name = "user_password")
	public String password;

	@OneToOne
	@JoinColumn(name = "user_aadress_city")
	public City userAdressCity;

	@Column(name = "user_enabled")
	public Boolean enabled;

}
