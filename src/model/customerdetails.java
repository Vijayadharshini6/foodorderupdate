package model;

public class customerdetails {
	private String name;
	private String mobileNumber;
	private String address;
	private menumodel orderrecipe;
	public customerdetails(String name, String mobileNumber, String address,menumodel orderrecipe) {
		//super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.orderrecipe=orderrecipe;
	}
	public menumodel getOrderrecipe() {
		return orderrecipe;
	}
	public void setOrderrecipe(menumodel orderrecipe) {
		this.orderrecipe = orderrecipe;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
}
