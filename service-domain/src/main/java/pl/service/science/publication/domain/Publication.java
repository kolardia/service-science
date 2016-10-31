package pl.service.science.publication.domain;

public class Publication {
	
	public int id;
	public String title;
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
