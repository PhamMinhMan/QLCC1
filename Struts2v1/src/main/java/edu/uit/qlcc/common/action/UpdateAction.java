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


public class UpdateAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String starttime_hh;
	private String starttime_mm;
	private String endtime_hh;
	private String endtime_mm;
	private String starttime_hh_default = "";   
	private String starttime_mm_default = "";
	private String endtime_hh_default = "";
	private String endtime_mm_default = "";
	private String workingClassDefault = LAM_VIEC_BINH_THUONG;
	private String startClassDefault = CHUA_THIET_LAP;
	private String endClassDefault = CHUA_THIET_LAP;
	private String noteDefault = "";
	ArrayList<Worktime> worktimes = new ArrayList<Worktime>();
	Worktime worktime = new Worktime();
	private Map<String, Object> session;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	public void validate() {
		if (session == null || session.get(SESSION_EMPLOYEE_CODE) == null || session.get(SESSION_DATE) == null) {
			return;
		}
		starttime_hh_default = getStarttime_hh();
		starttime_mm_default = getStarttime_mm();
		endtime_hh_default = getEndtime_hh();
		endtime_mm_default = getEndtime_mm();
		workingClassDefault = worktime.getWrkClass();
		startClassDefault = worktime.getStartClass();
		endClassDefault = worktime.getEndClass();
		noteDefault = worktime.getNote();
		String starttime = getStarttime_hh() + getStarttime_mm();
		String endtime = getEndtime_hh() + getEndtime_mm();
		if (starttime.trim().length() != 0 && starttime.trim().length() != 4) {
			addFieldError("starttime_hh", "Start Time không hợp lệ");
		}

		if (endtime.trim().length() != 0 && endtime.trim().length() != 4) {
			addFieldError("endtime_hh", "End Time không hợp lệ");
		}

		if (starttime.trim().length() == 4 && endtime.trim().length() == 4) {
			int start = Integer.parseInt(starttime);
			int end = Integer.parseInt(endtime);
			if (start >= end) {
				addFieldError("starttime_hh", "Start Time phải nhỏ hơn End Time");
				addFieldError("endtime_hh", "EndTime phải lớn hơn Start Time");
			}
		}

		if (worktime.getWrkClass().equals(LAM_VIEC_BINH_THUONG)) {
			if (worktime.getStartClass().equals(NGHI_BUOI_SANG)) {
				addFieldError("worktime.startClass", "Làm việc bình thường thì không được nghỉ");
			} else if (!worktime.getStartClass().equals(CHUA_THIET_LAP)) {
				if (starttime.trim().length() == 0) {
					addFieldError("starttime_hh", "Chưa thiết lập Start Time");
				}
			}else{
				addFieldError("worktime.startClass", "Start Class phải được thiết lập");
			}
			if (worktime.getEndClass().equals(NGHI_BUOI_CHIEU)) {
				addFieldError("worktime.endClass", "Làm việc bình thường thì không được nghỉ");
			} else if (!worktime.getEndClass().equals(CHUA_THIET_LAP)) {
				if (endtime.trim().length() == 0) {
					addFieldError("endtime_hh", "Chưa thiết lập End Time");
				}
			}else{
				addFieldError("worktime.endClass", "End Class phải được thiết lập");
			}
		}
	}
	
	public String doUpdate() throws Exception {
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date date = (Date) session.get(SESSION_DATE);
		if (session == null || empCode == null || date == null) {
			return SESSION;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		dateFormat = new SimpleDateFormat("yyyyMMdd");
		String sdate = dateFormat.format(calendar.getTime());
		worktime.setCalYmd(sdate);
		worktime.setEmpCode(empCode);
		String starttime = getStarttime_hh() + getStarttime_mm();
		starttime = starttime != null ? starttime : "";
		worktime.setStartTime(starttime);
		String endtime = getEndtime_hh() + getEndtime_mm();
		endtime = endtime != null ? endtime : "";
		worktime.setEndTime(endtime);
		WorktimeDao worktimeDao = new WorktimeDao();
		boolean result = worktimeDao.updateWorktime(worktime);
		if (result)
			return SUCCESS;
		return ERROR;
	}
	
	public String doBack() {
		if (session == null || session.get(SESSION_EMPLOYEE_CODE) == null || session.get(SESSION_DATE) == null) {
			return SESSION;
		}
		return SUCCESS;
	}
	
	public ArrayList<Worktime> getWorktimes() throws SQLException, ParseException{
		String empCode = (String) session.get(SESSION_EMPLOYEE_CODE);
		Date date = (Date) session.get(SESSION_DATE);
		dateFormat = new SimpleDateFormat("yyyyMM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String yyyyMM = dateFormat.format(calendar.getTime());
		SearchLogic searchLogic = new SearchLogic();
		worktimes = searchLogic.getWorktimeAllDateByMonth(empCode, yyyyMM);
		return worktimes;
	}
	public void setSession(Map<String, Object> arg0) {
		session = arg0;

	}
	
	public Map<String, String> getWorkingClassList() {
		return Global.WORKING_CLASS;
	}
	public ArrayList<String> getHourList() {
		return Global.HOUR;
	}

	public ArrayList<String> getMinuteList() {
		return Global.MINUTE;
	}
	public Map<String, String> getStartClassList() {
		return Global.START_CLASS;
	}
		public Map<String, String> getEndClassList() {
			return Global.END_CLASS;
		}
		public Worktime getWorktime() {
			return worktime;
		}

		public void setWorktime(Worktime worktime) {
			this.worktime = worktime;
		}

		public String getStarttime_hh() {
			return starttime_hh;
		}

		public void setStarttime_hh(String starttime_hh) {
			this.starttime_hh = starttime_hh;
		}

		public String getStarttime_mm() {
			return starttime_mm;
		}

		public void setStarttime_mm(String starttime_mm) {
			this.starttime_mm = starttime_mm;
		}

		public String getEndtime_hh() {
			return endtime_hh;
		}

		public void setEndtime_hh(String endtime_hh) {
			this.endtime_hh = endtime_hh;
		}

		public String getEndtime_mm() {
			return endtime_mm;
		}

		public void setEndtime_mm(String endtime_mm) {
			this.endtime_mm = endtime_mm;
		}

		public String getSdate() {
			Date registerDate = (Date) session.get(SESSION_DATE);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(registerDate);
			dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String sdate = dateFormat.format(calendar.getTime());
			return sdate;
		}

		public String getStarttime_hh_default() {
			return starttime_hh_default;
		}

		public void setStarttime_hh_default(String starttime_hh_default) {
			this.starttime_hh_default = starttime_hh_default;
		}

		public String getStarttime_mm_default() {
			return starttime_mm_default;
		}

		public void setStarttime_mm_default(String starttime_mm_default) {
			this.starttime_mm_default = starttime_mm_default;
		}

		public String getEndtime_hh_default() {
			return endtime_hh_default;
		}

		public void setEndtime_hh_default(String endtime_hh_default) {
			this.endtime_hh_default = endtime_hh_default;
		}

		public String getEndtime_mm_default() {
			return endtime_mm_default;
		}

		public void setEndtime_mm_default(String endtime_mm_default) {
			this.endtime_mm_default = endtime_mm_default;
		}

		public String getWorkingClassDefault() {
			return workingClassDefault;
		}

		public void setWorkingClassDefault(String workingClassDefault) {
			this.workingClassDefault = workingClassDefault;
		}

		public String getStartClassDefault() {
			return startClassDefault;
		}

		public void setStartClassDefault(String startClassDefault) {
			this.startClassDefault = startClassDefault;
		}

		public String getEndClassDefault() {
			return endClassDefault;
		}

		public void setEndClassDefault(String endClassDefault) {
			this.endClassDefault = endClassDefault;
		}

		public String getNoteDefault() {
			return noteDefault;
		}

		public void setNoteDefault(String noteDefault) {
			this.noteDefault = noteDefault;
		}
		
		// truyen date qua search.jsp
		public Date getDate() {
			Date date = (Date) session.get(SESSION_DATE);
			return date;
		}
}