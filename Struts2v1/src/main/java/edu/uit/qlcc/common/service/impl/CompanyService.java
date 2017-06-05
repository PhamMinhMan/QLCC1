package edu.uit.qlcc.common.service.impl;

import java.sql.SQLException;

import edu.uit.qlcc.common.dao.impl.CompanyDao;
import edu.uit.qlcc.common.service.inf.ICompanyService;

public class CompanyService implements ICompanyService {
	CompanyDao companyDao;

	// DI via Spring
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public String getCompanyNameByCompanyCode(String comCode) throws SQLException {
		companyDao = new CompanyDao();
		return companyDao.getCompanyNameByCompanyCode(comCode);
	}

}
