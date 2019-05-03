package by.http.web.entity;

public class User {

	private long id;
	private String right;
	
	public User() {
		super();
	}
	
	public User(String right) {
		super();
		this.right = right;
	}
	
	public User(long id, String right) {
		super();
		this.id = id;
		this.right = right;
	}

	public long getId() {
		return id;
	}
	
	public String getRight() {
		return right;
	}
	
	public void setRight(String role) {
		this.right = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", right=" + right + "]";
	}
}
