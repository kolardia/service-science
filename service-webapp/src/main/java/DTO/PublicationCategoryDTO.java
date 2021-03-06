package DTO;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class PublicationCategoryDTO {

	@NotEmpty
	private Long id;

	@NotEmpty
	@Size(min = 3)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
