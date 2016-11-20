package pl.service.science.publication.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Publication {
	
	@Id
	public Long id;
	@Column
	public String title;
	@Column
	public String contents;
	
	@OneToOne
	public PublicationCategory category;
	
	/*@OneToMany(mappedBy="department")
	private Set<Employee> employees;*/

	/*@OneToMany(mappedBy="id")
    public List<PublicationCategory> categoryId;*/
	
	public Publication(Long id, String title, String contents) {
		this.setId(id);
		this.setTitle(title);
		this.setContents(contents);
	}
	
	public Publication() {
		
	}

	public PublicationCategory getCategory() {
		return category;
	}

	public void setCategory(PublicationCategory category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	@Override
	public String toString() {
		return "Publication [id=" + id + ", title=" + title + ", contents=" + contents + ", category=" + category + "]";
	}
	
	
}