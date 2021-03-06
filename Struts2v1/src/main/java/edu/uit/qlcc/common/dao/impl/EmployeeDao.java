package edu.uit.qlcc.common.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.hibernate.Transaction;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;

import edu.uit.qlcc.common.dao.inf.IEmployeeDao;
import edu.uit.qlcc.model.Company;
import edu.uit.qlcc.model.Employee;
import edu.uit.qlcc.model.HibernateUtil;

public class EmployeeDao implements IEmployeeDao {
	// public boolean loginEmployee(String empcode, String password) throws
	// SQLException {
	// String call = "{cal loginEmployee(?,?)}";
	// Connection dbConnection = ConnectDatabase.getInstance().getConnection();
	// CallableStatement cstmt = (CallableStatement)
	// dbConnection.prepareCall(call);
	// Boolean result = false;
	// try {
	// cstmt.setString(1, empcode);
	// cstmt.setString(2, password);
	// ResultSet rs = cstmt.executeQuery();
	// if (rs.next()) {
	// result = true;
	// }
	// } catch (SQLException e) {
	// } finally {
	// // Closing the CallableStatement object
	// if (cstmt != null) {
	// cstmt.close();
	// cstmt = null;
	// }
	// // Closing the Connection object
	// if (dbConnection != null) {
	// dbConnection.close();
	// dbConnection = null;
	// }
	// }
	// return result;
	// }

	@SuppressWarnings("unchecked")
	public boolean loginEmployee(String empcode, String password) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProcedureCall procedureCall = session.createStoredProcedureCall("loginEmployee");
		procedureCall.registerParameter("empcode", String.class, ParameterMode.IN);
		procedureCall.registerParameter("pass", String.class, ParameterMode.IN);
		
		procedureCall.getParameterRegistration("empcode").bindValue(empcode);
		procedureCall.getParameterRegistration("pass").bindValue(password);                
		ProcedureOutputs procedureOutputs = procedureCall.getOutputs();
		ResultSetOutput resultSetOutput = (ResultSetOutput) procedureOutputs.getCurrent();
		List<?> results = resultSetOutput.getResultList();
		
		if (results.size() > 0)
			return true;
		return false;
	}

	// public Employee getEmployeeByEmpcode(String empcode) throws SQLException,
	// SecurityException, IllegalStateException, RollbackException,
	// HeuristicMixedException, HeuristicRollbackException, SystemException {
	// Employee employee = new Employee();
	// String sql = "select * from employee where emp_code =? and flag_delete
	// ='0'";
	// Connection dbConnection =
	// ConnectDatabase.getInstance().getConnection();
	// PreparedStatement cstmt = (PreparedStatement)
	// dbConnection.prepareStatement(sql);
	// try {
	// cstmt.setString(1, empcode);
	// ResultSet rs = cstmt.executeQuery();
	// if (rs.next()) {
	// employee = convertToEmployee(rs);
	// }
	// } catch (SQLException e) {
	// } finally {
	// if (cstmt != null) {
	// cstmt.close();
	// cstmt = null;
	// }
	// if (dbConnection != null) {
	// dbConnection.close();
	// dbConnection = null;
	// }
	// }
	// return employee;
	//
	// }

	public Employee getEmployeeByEmpcode(String empcode) throws SQLException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, empcode);
		transaction.commit();
		return employee;

	}

	// private Employee convertToEmployee(ResultSet rSet) throws SQLException {
	// Employee employee = new Employee();
	// employee.setEmpCode(rSet.getString("emp_code"));
	// employee.setEmpName(rSet.getString("emp_name"));
	// employee.setComCode(rSet.getString("com_code"));
	// employee.setFlagDelete(rSet.getString("flag_delete"));
	// return employee;
	// }

}
