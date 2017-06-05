package edu.uit.qlcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WorktimeId implements Serializable {
	@Column(name = "emp_code")
	private String empCode;
	@Column(name = "cal_ymd")
	private String calYmd;

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getCalYmd() {
		return calYmd;
	}

	public void setCalYmd(String calYmd) {
		this.calYmd = calYmd;
	}

}
