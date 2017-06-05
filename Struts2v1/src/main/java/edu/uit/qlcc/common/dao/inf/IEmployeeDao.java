package edu.uit.qlcc.common.dao.inf;

import java.sql.SQLException;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import edu.uit.qlcc.model.Employee;

public interface IEmployeeDao {
	public boolean loginEmployee(String empcode, String password) throws SQLException;
	public Employee getEmployeeByEmpcode(String empcode) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
}
