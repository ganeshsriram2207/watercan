package com.revature.wp.model;

public class UserDetail {

	private static String name;
	private static String password;
	private long mobilenumber;
	private String Emailid;
	private int availablecans;
	private int orderedcans;
	private int availablecansafterordered;

	public int getAvailablecansafterordered() {
		return availablecansafterordered;
	}

	public void setAvailablecansafterordered(int availablecansafterordered) {
		this.availablecansafterordered = availablecansafterordered;
	}

	public int getOrderedcans() {
		return orderedcans;
	}

	public void setOrderedcans(int orderedcans) {
		this.orderedcans = orderedcans;
	}

	public int getAvailablecans() {
		return availablecans;
	}

	public void setAvailablecans(int availablecans) {
		this.availablecans = availablecans;
	}

	public static String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmail_id(String emailid) {
		Emailid = emailid;
	}

}
