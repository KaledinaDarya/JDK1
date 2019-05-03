package by.http.xml.parser.sax.entity;

public class Family {

	private String adress;
	private BaseEntity mother;
	private BaseEntity father;
	private BaseEntity child;
	
	public Family() {
		super();
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public BaseEntity getMother() {
		return mother;
	}

	public void setMother(BaseEntity mother) {
		this.mother = mother;
	}

	public BaseEntity getFather() {
		return father;
	}

	public void setFather(BaseEntity father) {
		this.father = father;
	}

	public BaseEntity getChild() {
		return child;
	}

	public void setChild(BaseEntity child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "Family: [\r Adress = " + adress + ", \r mother = " + mother + ", \r father = " + father + ", \r child = " + child + "\r]";
	}
}
