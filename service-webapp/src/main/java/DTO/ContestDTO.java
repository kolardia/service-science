package DTO;

import org.hibernate.validator.constraints.NotEmpty;

public class ContestDTO {


	public String contents;

	
	public String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
