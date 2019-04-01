package com.training.bean;

public class RealEstateBean {
	private String nametextbox;
	private String slugtextbox;
	private String parentfeaturelistbox;
	private String descriptiontextbox;
	//private String website;
	//private String password;
	//private String role;

	public RealEstateBean() {
	}

	public RealEstateBean(String nametextbox, String slugtextbox, String parentfeaturelistbox, String descriptiontextbox ) {
		super();
		this.nametextbox = nametextbox;
		this.slugtextbox = slugtextbox;
		this.parentfeaturelistbox = parentfeaturelistbox;
		this.descriptiontextbox = descriptiontextbox;
		//this.website = website;
		//this.password = password;
		//this.role = role;
	}

	public String getNameTextBox() {
		return nametextbox;
	}

	public void setNameTextBox(String nametextbox) {
		this.nametextbox = nametextbox;
	}

	public String getSlugTextBox() {
		return slugtextbox;
	}

	public void setSlugTextBox(String slugtextbox) {
		this.slugtextbox = slugtextbox;
	}

	public String getParentFeatureListBox() {
		return parentfeaturelistbox;
	}

	public void setParentFeatureListbox(String parentfeaturelistbox) {
		this.parentfeaturelistbox = parentfeaturelistbox;
	}

	public String getDescriptionTextBox() {
		return descriptiontextbox;
	}

	public void setdDscriptionTextBox(String descriptiontextbox) {
		this.descriptiontextbox = descriptiontextbox;
	}

	/*public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}*/

	@Override
	public String toString() {
		return "LoginBean [NameTextBox=" + nametextbox + ",SlugTextBox=" + slugtextbox + ",ParentFeatureListBox=" + parentfeaturelistbox + "DescriptionTextBox="
				+ descriptiontextbox + "]";
	}

}