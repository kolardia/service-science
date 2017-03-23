package pl.service.science.authorization.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Role mapping  on a database for table name: "user_role"
 * @author kolardia
 *
 */
@Entity
@Table(name = "user_role")
public class Role {

	/**
	 * The mapping on a database is a generating automatic for primary key; column name:  "user_role_id"
	 */
	@Id
	@Column(name = "user_role_id")
	public Long id;

	/**
	 * The mapping on a database for column name: "user_rola"
	 */
	@Column(name = "user_rola")
	public String rola;

	/**
	 * The mapping on a database is one-to-one; column name: "user_id"
	 */
	@OneToOne
	@JoinColumn(name = "user_id")
	public User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRola() {
		return rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}