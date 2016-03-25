package Ynzc.YnzcAms.Util;

import net.sf.json.JSONArray;

public class FieldsAndQueryToCondition {

	public String FieldsAndQueryToCondition(String fields, String query) {
		if (query == "") {
			return "";
		} else {
			JSONArray jsonfields = JSONArray.fromObject(fields);
			Object f[] = jsonfields.toArray();
			String condition = "";
			for (int i = 0; i < f.length; i++) {
					condition = condition + f[i].toString() + " like '%" + query + "%' or ";
			}
			condition = condition.substring(0, condition.lastIndexOf("or"));
			return condition;
		}
	}

}
