package edu.uit.qlcc.common.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.omg.CORBA.portable.ValueBase;

import edu.uit.qlcc.common.dao.impl.WorktimeDao;
import edu.uit.qlcc.model.Worktime;

public class SearchLogic {
	public ArrayList<Worktime> getWorktimeAllDateByMonth(String empcode, String yyyyMM)
			throws SQLException, ParseException {
		ArrayList<Worktime> allworktimes = new ArrayList<Worktime>();
		WorktimeDao worktimeDao = new WorktimeDao();
		// danh sach worktime theo thang lay tu database
		ArrayList<Worktime> worktimes = new ArrayList<Worktime>();
		worktimes = worktimeDao.getWorktimeByMonth(empcode, yyyyMM);
		System.out.println(worktimes.size());
		// can danh sach worktime tat ca cac ngay trong thang, database khong co
		// thi hien thi rong
		int maxday;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		Date day = dateFormat.parse(yyyyMM);
		cal.setTime(day);
		maxday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= maxday; i++) {
			boolean check = true;
			for (Worktime w : worktimes) {
				int temp = Integer.parseInt(w.getCalYmd().substring(6));
				if (temp == i) {
					check = false;
					allworktimes.add(w);
					break;
				}
			}
			if (check) {
				Worktime work = new Worktime();
				work.setDateOfmonth(String.valueOf(i));
				String day_temp = yyyyMM;
				if (i < 10) {
					day_temp += "0" + String.valueOf(i);
				} else {
					day_temp += String.valueOf(i);
				}
				dateFormat = new SimpleDateFormat("yyyyMMdd");
				Date date_temp = dateFormat.parse(day_temp);
				dateFormat = new SimpleDateFormat("EEEE");
				String dayofweek = dateFormat.format(date_temp);
				work.setDay(dayofweek);
				allworktimes.add(work);
			}
		}
		return allworktimes;
	}

	public SearchLogic() {
		super();
		// TODO Auto-generated constructor stub
	}
}
