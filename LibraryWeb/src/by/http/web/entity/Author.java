package by.http.web.entity;

public class Author {

	private int id;
	private String name;
	
	public Author () {
		super();
	}
	
	public Author (String name) {
		super();
		this.name = name;
	}
	
	public Author (int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}
}
