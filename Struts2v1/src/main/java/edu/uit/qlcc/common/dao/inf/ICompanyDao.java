package edu.uit.qlcc.common.dao.inf;

import java.sql.SQLException;

public interface ICompanyDao {
	public String getCompanyNameByCompanyCode(String comCode) throws SQLException;
}
