package edu.uit.qlcc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Global {
	public static final Map<String, String> WORKING_CLASS;
	static {
		WORKING_CLASS = new HashMap<String, String>();
		WORKING_CLASS.put("01", "Làm việc bình thường");
		WORKING_CLASS.put("02", "Nghỉ làm");
		WORKING_CLASS.put("03", "Ngày nghỉ(Nghỉ lễ)");

	}
	public static final Map<String, String> START_CLASS;
	static {
		START_CLASS = new HashMap<String, String>();
		START_CLASS.put("00", "Chưa thiết lập");
		START_CLASS.put("01", "Bình thường");
		START_CLASS.put("02", "Đi trể");
		START_CLASS.put("03", "Nghỉ buổi sáng");
	}
	public static final Map<String, String> END_CLASS;
	static {
		END_CLASS = new HashMap<String, String>();
		END_CLASS.put("00", "Chưa thiết lập");
		END_CLASS.put("01", "Bình thường");
		END_CLASS.put("02", "Về sớm");
		END_CLASS.put("03", "Nghỉ buổi chiều");
	}

	public static final ArrayList<String> HOUR;
	static {
		HOUR = new ArrayList<String>();
		HOUR.add("");
		for (int i = 0; i < 24; i++) {
			if (i < 10) {
				HOUR.add("0" + String.valueOf(i));
			}else{
				HOUR.add(String.valueOf(i));
			}
		}
	}
	
	public static final ArrayList<String> MINUTE;
	static {
		MINUTE = new ArrayList<String>();
		MINUTE.add("");
		for (int i = 0; i < 60; i++) {
			if (i < 10) {
				MINUTE.add("0" + String.valueOf(i));
			}else{
				MINUTE.add(String.valueOf(i));
			}
		}
	}
}
