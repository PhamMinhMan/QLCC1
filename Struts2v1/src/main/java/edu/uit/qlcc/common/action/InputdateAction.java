package edu.uit.qlcc.common.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import edu.uit.qlcc.common.dao.impl.WorktimeDao;
import edu.uit.qlcc.model.Global;
import edu.uit.qlcc.model.Worktime;

public class InputdateAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 1L;
	private Date date;
	private Map<String, Object> session;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	ArrayList<Worktime> worktimes;

	public String doRegister() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		if (session == null || empCode == null) {
			return SESSION;
		}
		Date regDate = getDate();
		Date curDate = new Date();
		if (regDate.compareTo(curDate) > 0){
			addActionError("Ngày đăng kí không được sau ngày hiện tại");
			return INPUT;
		}
		WorktimeDao worktimeDao = new WorktimeDao();
		dateFormat = new SimpleDateFormat("yyyyMMdd");
		String yyyyMMdd = dateFormat.format(regDate);
		if (worktimeDao.checkDateAndEmp(empCode, yyyyMMdd)) {
			addActionError("Ngày này đã được đăng kí");
			return INPUT;
		}
		dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date registerDate = getDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(registerDate);
		session.put(SESSION_DATE, getDate());
		return SUCCESS;
	}

	public String doSearch() throws SQLException, ParseException {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		if (session == null || empCode == null) {
			return SESSION;
		}
		session.put(SESSION_DATE, getDate());
	    Date regDate = getDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		regDate = dateFormat.parse(dateFormat.format(regDate));
		Date curDate = new Date();
		curDate = dateFormat.parse(dateFormat.format(curDate));
		if (curDate.compareTo(regDate) < 0) {
			addActionError("Tháng tìm kiếm không được sau tháng hiện tại");
			return INPUT;
		}
		dateFormat = new SimpleDateFormat("yyyyMM");
		String searchDate = dateFormat.format(getDate());
		SearchLogic searchLogic = new SearchLogic();
		// lay worktime tat ca cac ngay trong thang
		worktimes = searchLogic.getWorktimeAllDateByMonth(empCode, searchDate);
		return SUCCESS;
	}

	public String doBack() {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		if (session == null || empCode == null) {
			return SESSION;
		}
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// truyen workingClassList qua jsp file
	public Map<String, String> getWorkingClassList() {
		return Global.WORKING_CLASS;
	}

	// truyen startClassList qua jsp file
	public Map<String, String> getStartClassList() {
		return Global.START_CLASS;
	}

	// truyen endClassList qua jsp file
	public Map<String, String> getEndClassList() {
		return Global.END_CLASS;
	}

	// truyen hourList qua jsp file
	public ArrayList<String> getHourList() {
		return Global.HOUR;
	}

	// truyen minuteList qua jsp file
	public ArrayList<String> getMinuteList() {
		return Global.MINUTE;
	}

	public ArrayList<Worktime> getWorktimes() {
		return worktimes;
	}

	public void setWorktimes(ArrayList<Worktime> worktimes) {
		this.worktimes = worktimes;
	}

}
