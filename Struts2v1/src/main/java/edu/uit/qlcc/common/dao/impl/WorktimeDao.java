package edu.uit.qlcc.common.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import com.mysql.jdbc.PreparedStatement;

import edu.uit.qlcc.common.dao.inf.IWorktimeDao;
import edu.uit.qlcc.model.Global;
import edu.uit.qlcc.model.Worktime;

public class WorktimeDao implements IWorktimeDao{
	public Worktime getWorktimeByDate(String empcode, String yyyyMMdd) throws SQLException, ParseException {
		Worktime worktime = new Worktime();
		String call = "SELECT * FROM worktime WHERE emp_code = ? and cal_ymd = ?";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		PreparedStatement cstmt = (PreparedStatement) dbConnection.prepareStatement(call);
		try {
			cstmt.setString(1, empcode);
			cstmt.setString(2, yyyyMMdd);
			ResultSet rs = cstmt.executeQuery();
			if (rs.next()) {
				worktime = convertToWorktime1(rs);
			}
		} catch (SQLException e) {
		} finally {
//			if (caStatement != null) {
//				caStatement.close();
//				caStatement = null;
//			}
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		}
		return worktime;
	}

	public boolean insertWorktime(Worktime worktime) throws SQLException {
		String call = "INSERT INTO `qlcc`.`worktime` (`emp_code`, `cal_ymd`, `wrk_class`, `start_class`, `end_class`, `start_time`, `end_time`, `note`, `create_code`, `create_date`, `flag_delete`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		PreparedStatement cstmt = (PreparedStatement) dbConnection.prepareStatement(call);
		try {
			cstmt.setString(1, worktime.getEmpCode());
			cstmt.setString(2, worktime.getCalYmd());
			cstmt.setString(3, worktime.getWrkClass());
			cstmt.setString(4, worktime.getStartClass());
			cstmt.setString(5, worktime.getEndClass());
			cstmt.setString(6, worktime.getStartTime());
			cstmt.setString(7, worktime.getEndTime());
			cstmt.setString(8, worktime.getNote());
			cstmt.setString(9, worktime.getEmpCode());
			cstmt.setString(10, getCurrentDate());
			cstmt.setString(11, "0");
			int rs = cstmt.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
		} finally {
			if (cstmt != null) {
				cstmt.close();
				cstmt = null;
			}
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		}
		return false;
	}

	public boolean updateWorktime(Worktime worktime) throws SQLException {
		String call = "UPDATE `qlcc`.`worktime` SET  `wrk_class`=?, `start_class`=?, `end_class`=?, `start_time`=?, `end_time`=?, `note`=? , `update_code`=?, `update_date`=? WHERE `emp_code`= ? and `cal_ymd` = ? and `flag_delete`=?" ;
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		CallableStatement cstmt = dbConnection.prepareCall(call);
		try {
			cstmt.setString(1, worktime.getWrkClass());
			cstmt.setString(2, worktime.getStartClass());
			cstmt.setString(3, worktime.getEndClass());
			cstmt.setString(4, worktime.getStartTime());
			cstmt.setString(5, worktime.getEndTime());
			cstmt.setString(6, worktime.getNote());
			cstmt.setString(7, worktime.getEmpCode());
			cstmt.setString(8, getCurrentDate());
			cstmt.setString(9, worktime.getEmpCode());
			cstmt.setString(10, worktime.getCalYmd());
			cstmt.setString(11, "0");
			int rs = cstmt.executeUpdate();
			if (rs >= 0) {
				return true;
			}
		} catch (SQLException e) {
		} finally {
			if (cstmt != null) {
				cstmt.close();
				cstmt = null;
			}
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		}
		return false;
	}

//	public boolean deleteWorktime(String comcode, String yyyyMMdd) throws SQLException {
//		String call = "{cal deleteWorktime(?,?)}";
//		Connection dbConnection = null;
//		CallableStatement cstmt = null;
//		try {
//			dbConnection = ConnectDatabase.getInstance().getConnection();
//			cstmt = dbConnection.prepareCall(call);
//			cstmt.setString(1, comcode);
//			cstmt.setString(2, yyyyMMdd);
//			int rs = cstmt.executeUpdate();
//			if (rs >= 0) {
//				return true;
//			}
//		} catch (SQLException e) {
//			System.out.println(e);
//		} finally {
//			// Closing the CallableStatement object
//			if (cstmt != null) {
//				cstmt.close();
//				cstmt = null;
//			}
//			// Closing the Connection object
//			if (dbConnection != null) {
//				dbConnection.close();
//				dbConnection = null;
//			}
//		}
//		return false;
//	}
	
	public boolean deleteWorktime(String comcode, String yyyyMMdd) throws SQLException {
		String call = "UPDATE worktime SET flag_delete= '1'  WHERE emp_code=? and cal_ymd=?;";
		Connection dbConnection = null;
		PreparedStatement cstmt = null;
		try {
			dbConnection = ConnectDatabase.getInstance().getConnection();
			cstmt = (PreparedStatement) dbConnection.prepareStatement(call);
			cstmt.setString(1, comcode);
			cstmt.setString(2, yyyyMMdd);
			int rs = cstmt.executeUpdate();
			if (rs >= 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (cstmt != null) {
				cstmt.close();
				cstmt = null;
			}
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		}
		return false;
	}

	public ArrayList<Worktime> getWorktimeByMonth(String empcode, String yyyyMM) throws SQLException, ParseException {
		ArrayList<Worktime> worktimes = null;
		String call = "{call getWorktimeByMonth(?,?)}";
		Connection dbConnection = null;
		CallableStatement caStatement = null;
		try {
			dbConnection = ConnectDatabase.getInstance().getConnection();
			caStatement = dbConnection.prepareCall(call);
			caStatement.setString(1, empcode);
			caStatement.setString(2, yyyyMM);
			ResultSet resultSet = caStatement.executeQuery();
			worktimes = new ArrayList<Worktime>();
			while (resultSet.next()) {
				Worktime wt = convertToWorktime(resultSet);
				worktimes.add(wt);
			}
		} catch (SQLException e) {
		} finally {
			if (caStatement != null) {
				caStatement.close();
				caStatement = null;
			}
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		}
		return worktimes;
	}

	private Worktime convertToWorktime(ResultSet rSet) throws SQLException, ParseException {
		Worktime worktime = new Worktime();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date cal_ymd_date = dateFormat.parse(rSet.getString("cal_ymd"));
		cal.setTime(cal_ymd_date);
		int dayOfmonth = cal.get(Calendar.DAY_OF_MONTH);
		String dayOfmonthString = String.valueOf(dayOfmonth);
		worktime.setDateOfmonth(dayOfmonthString);
		dateFormat = new SimpleDateFormat("EEEE");
		String day = dateFormat.format(cal_ymd_date);
		worktime.setDateOfmonth(dayOfmonthString);
		worktime.setDay(day);
		worktime.setEmpCode(rSet.getString("emp_code"));
		worktime.setCalYmd(rSet.getString("cal_ymd"));
		worktime.setWrkClass(Global.WORKING_CLASS.get(rSet.getString("wrk_class")));
		worktime.setEndClass(Global.END_CLASS.get(rSet.getString("end_class")));
		String endtime = rSet.getString("end_time");
		if (endtime.length() == 4) {
			StringBuilder str = new StringBuilder(endtime);
			worktime.setEndTime(str.insert(2, ":").toString());
		}
		worktime.setStartClass(Global.START_CLASS.get(rSet.getString("start_class")));
		String starttime = rSet.getString("start_time");
		if (starttime.length() == 4) {
			StringBuilder str = new StringBuilder(starttime);
			worktime.setStartTime(str.insert(2, ":").toString());
		}
		worktime.setNote(rSet.getString("note"));
		return worktime;
	}
	
	private Worktime convertToWorktime1(ResultSet rSet) throws SQLException, ParseException {
		Worktime worktime = new Worktime();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date cal_ymd_date = dateFormat.parse(rSet.getString("cal_ymd"));
		cal.setTime(cal_ymd_date);
		int dayOfmonth = cal.get(Calendar.DAY_OF_MONTH);
		String dayOfmonthString = String.valueOf(dayOfmonth);
		worktime.setDateOfmonth(dayOfmonthString);
		dateFormat = new SimpleDateFormat("EEEE");
		String day = dateFormat.format(cal_ymd_date);
		worktime.setDateOfmonth(dayOfmonthString);
		worktime.setDay(day);
		worktime.setEmpCode(rSet.getString("emp_code"));
		worktime.setCalYmd(rSet.getString("cal_ymd"));
		worktime.setWrkClass(rSet.getString("wrk_class"));
		worktime.setEndClass(rSet.getString("end_class"));
		String endtime = rSet.getString("end_time");
		if (endtime.length() == 4) {
			worktime.setEndTime(endtime);
		}
		worktime.setStartClass(rSet.getString("start_class"));
		String starttime = rSet.getString("start_time");
		if (starttime.length() == 4) {
			worktime.setStartTime(starttime);
		}
		worktime.setNote(rSet.getString("note"));
		return worktime;
	}

	private String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	public Boolean checkDateAndEmp(String empcode, String yyyyMMdd) throws SQLException {
		//Worktime worktime = new Worktime();
		String call = "SELECT * FROM worktime WHERE emp_code = ? and cal_ymd = ?";
		Connection dbConnection = ConnectDatabase.getInstance().getConnection();
		PreparedStatement cstmt = (PreparedStatement) dbConnection.prepareStatement(call);
		try {
			cstmt.setString(1, empcode);
			cstmt.setString(2, yyyyMMdd);
			ResultSet resultSet = cstmt.executeQuery();
			if (resultSet.next()){
				return true;		
			}
			return false;
			
						
		} catch (SQLException e) {
		} finally {
			// Closing the CallableStatement object
			if (cstmt != null) {
				cstmt.close();
				cstmt = null;
			}
			// Closing the Connection object
			if (dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		}
		return false;
	}
}
