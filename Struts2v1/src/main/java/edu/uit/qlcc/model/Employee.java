package edu.uit.qlcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee extends Base implements java.io.Serializable{
	@Id
	@Column(name = "emp_code")
	private String empCode;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "com_code")
	private String comCode;
	@Column(name = "emp_address")
	private String address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "emp_password")
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
