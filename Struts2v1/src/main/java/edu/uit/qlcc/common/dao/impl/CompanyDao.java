package edu.uit.qlcc.common.dao.impl;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import edu.uit.qlcc.common.dao.inf.ICompanyDao;
import edu.uit.qlcc.common.util.HibernateUtil;
import edu.uit.qlcc.model.Company;

public class CompanyDao extends HibernateDaoSupport implements ICompanyDao {
	SessionFactory sessionFactory;

//	public String getCompanyNameByCompanyCode(String comCode) throws SQLException {
//		String sql = "select com_name from company where com_code =?";
//		Connection dbConnection= null;
//		dbConnection = ConnectDatabase.getInstance().getConnection();
//		PreparedStatement cstmt = (PreparedStatement) dbConnection.prepareStatement(sql);
//		String comName = "";
//		try {
//			cstmt.setString(1, comCode);
//			ResultSet rs = cstmt.executeQuery();
//			if (rs.next()) {
//				comName = rs.getString("com_name");
//			}
//		} catch (SQLException e) {
//		} finally {
//			if (cstmt != null) {
//				cstmt.close();
//				cstmt = null;
//			}
//			if (dbConnection != null) {
//				dbConnection.close();
//				dbConnection = null;
//			}
//		}
//		return comName;
//	}

	
	public String getCompanyNameByCompanyCode(String comCode) throws SQLException {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Company company = (Company) session.get(Company.class, comCode);
		transaction.commit();
		return company.getComName();
	}
}
