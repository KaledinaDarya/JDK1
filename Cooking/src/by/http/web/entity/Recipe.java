package by.http.web.entity;

public class Recipe {

	private long id;
	private String title;
	private String description;
	private long complexity;
	private long time;
	private String imageName;
	private boolean flagVisible;
	
	public Recipe() {
		super();
	}
	
	public Recipe(String title, String description, long recipe_complexity, long recipe_time, String imageName,
			boolean flagVisible) {
		super();
		this.title = title;
		this.description = description;
		this.complexity = recipe_complexity;
		this.time = recipe_time;
		this.imageName = imageName;
		this.flagVisible = flagVisible;
	}
	
	public Recipe(int id, String title, String description, int complexity, int time, String imageName,
			boolean flagVisible) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.complexity = complexity;
		this.time = time;
		this.imageName = imageName;
		this.flagVisible = flagVisible;
	}
	
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	public long getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public boolean isFlagVisible() {
		return flagVisible;
	}

	public void setFlagVisible(boolean flagVisible) {
		this.flagVisible = flagVisible;
	}

	@Override
	public String toString() {
		String descriptionText = description == null ? " " : " : " + description;
		return id + " " + title + descriptionText + ". Complexity: " + complexity
				+ ". Time preparing: " + time + " mun. Link to image = images/" + imageName + ".jpg\n";
	}
}
