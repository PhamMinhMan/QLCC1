package edu.uit.qlcc.common.service.inf;

import java.sql.SQLException;

public interface ICompanyService {
	public String getCompanyNameByCompanyCode(String comCode) throws SQLException;
}
