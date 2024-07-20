package com.edu.Menu.model;

public class MenuItem {
	
	private String value;
	private String onclick;
	

	

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public MenuItem(String value, String onclick) {
		super();
		this.value = value;
		this.onclick = onclick;
	}



	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	@Override
	public String toString() {
		return "MenuItem [value=" + value + ", onclick=" + onclick + "]";
	}
	
	

}
