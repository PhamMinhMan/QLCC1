package edu.uit.qlcc.common.dao.inf;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import edu.uit.qlcc.model.Worktime;

public interface IWorktimeDao {
	public Worktime getWorktimeByDate(String empcode, String yyyyMMdd) throws SQLException, ParseException;
	public boolean insertWorktime(Worktime worktime) throws SQLException;
	public boolean updateWorktime(Worktime worktime) throws SQLException;
	public boolean deleteWorktime(String comcode, String yyyyMMdd) throws SQLException;
	public ArrayList<Worktime> getWorktimeByMonth(String empcode, String yyyyMM) throws SQLException, ParseException;
	public Boolean checkDateAndEmp(String empcode, String yyyyMMdd) throws SQLException;
}
