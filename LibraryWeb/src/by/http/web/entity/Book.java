package by.http.web.entity;

public class Book {
	
	private int id;
	private String title;
	
	public Book() {
		super();
	}
	
	public Book(String title) {
		super();
		this.title = title;
	}
	
	public Book(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}
}
