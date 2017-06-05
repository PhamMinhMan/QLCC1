package edu.uit.qlcc.model;

public class Worktime extends Base{
	private String dateOfmonth;
	private String day;
	private String empCode;
	private String calYmd;
	private String wrkClass;
	private String startClass;
	private String endClass;
	private String startTime;
	private String endTime;
	private String note;

	public Worktime() {
		super();
		dateOfmonth = "";
		day = "";
		empCode = "";
		calYmd = "";
		wrkClass = "";
		startClass = "";
		endClass = "";
		startTime = "";
		endTime = "";
		note = "";
	}

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

	public String getWrkClass() {
		return wrkClass;
	}

	public void setWrkClass(String wrkClass) {
		this.wrkClass = wrkClass;
	}

	public String getStartClass() {
		return startClass;
	}

	public void setStartClass(String startClass) {
		this.startClass = startClass;
	}

	public String getEndClass() {
		return endClass;
	}

	public void setEndClass(String endClass) {
		this.endClass = endClass;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDateOfmonth() {
		return dateOfmonth;
	}

	public void setDateOfmonth(String dateOfmonth) {
		this.dateOfmonth = dateOfmonth;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
}
