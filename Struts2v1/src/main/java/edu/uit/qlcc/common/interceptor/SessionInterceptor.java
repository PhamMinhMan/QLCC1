package edu.uit.qlcc.common.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import edu.uit.qlcc.common.action.BaseAction;

public class SessionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		String empcode = (String) session.get(BaseAction.SESSION_EMPLOYEE_CODE);
		if (empcode == null)
			return "session";
		return invocation.invoke();
	}

//	@Override
//	public String intercept(ActionInvocation invocation) throws Exception {
//		Map<String, Object> session = invocation.getInvocationContext().getSession();
//		String empcode = (String) session.get(BaseAction.SESSION_EMPLOYEE_CODE);
//		if (empcode == null)
//			return "session";
//		return invocation.invoke();
//	}
}
