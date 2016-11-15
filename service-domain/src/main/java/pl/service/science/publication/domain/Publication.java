package pl.service.science.publication.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Publication {
	
	@Id
	public int id;
	 
	@Column//(name="publication_title", nullable=false)
	public String title;
	
	@Column//(name="publication_contents")
	public String contents;
	
	public Publication(int id, String title, String contents) {
		this.setId(id);
		this.setTitle(title);
		this.setContents(contents);
	}
	public Publication() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
