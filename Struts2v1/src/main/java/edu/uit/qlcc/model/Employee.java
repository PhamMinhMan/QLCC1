package edu.uit.qlcc.model;

public class Employee extends Base implements java.io.Serializable{
	private String empCode;
	private String empName;
	private String comCode;
	private String address;
	private String phone;
	private String empPassword;
	
	
	public Employee() {
		super();
		empCode = "";
		empName = "";
		comCode = "";
		address = "";
		phone = "";
		empPassword = "";
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String password) {
		this.empPassword = password;
	}
	
}
