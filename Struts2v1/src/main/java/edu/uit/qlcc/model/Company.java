package edu.uit.qlcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company extends Base implements java.io.Serializable {
	@Id
	@Column(name = "com_code")
	private String comCode;
	@Column(name = "com_name")
	private String comName;

	public Company() {
		super();
		comCode = "";
		comName = "";
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
}
