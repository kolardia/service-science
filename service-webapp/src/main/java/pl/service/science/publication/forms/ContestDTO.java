package pl.service.science.publication.forms;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ContestDTO {
	
	
	//private int id;
	
	@NotEmpty
    @Size(min=3)
    private String contents;
	@NotEmpty
    private String title;
	
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
