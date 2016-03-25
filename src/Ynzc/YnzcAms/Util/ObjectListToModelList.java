package Ynzc.YnzcAms.Util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ObjectListToModelList<T> {
	private final Class<T> clazz;

	public ObjectListToModelList(Class<T> clazz) {
		this.clazz = clazz;
	}

	public List getPropertyName(Object obj) {
		List list = new ArrayList();
		Field[] fs = obj.getClass().getDeclaredFields();
		for (Field f : fs) {
			list.add(f.getName());
		}
		return list;
	}

	public List<T> getModelList(List<Map> res) throws SecurityException,
			NoSuchFieldException, InstantiationException,
			IllegalAccessException {
		List<T> list = new ArrayList();
		for (Map m : res) {
			T tempClass = (T) clazz.newInstance();
			List propertyName = this.getPropertyName(tempClass);
			for (int i = 0; i < propertyName.size(); i++) {
				Field f = tempClass.getClass().getDeclaredField(
						propertyName.get(i).toString());
				f.setAccessible(true);
				try {
					if (f.getType().getName().equals("java.util.Date")) {
						SimpleDateFormat formatter = new SimpleDateFormat(
								"yyyy-MM-dd");
						Date d = formatter.parse(m.get(
								propertyName.get(i).toString().trim())
								.toString());
						f.set(tempClass, d);
					} else if (f.getType().getName().equals("java.lang.Integer") && m.get(propertyName.get(i).toString().trim())==null) {
						f.set(tempClass, 0);
					} else if (f.getType().getName().equals("java.lang.String") && m.get(propertyName.get(i).toString().trim())==null) {						
						f.set(tempClass, "");
					} else {
						f.set(tempClass,
								m.get(propertyName.get(i).toString().trim()));
					}
				} catch (Exception e) {
					System.out.println("The Value is:"+m.get(propertyName.get(i).toString().trim()));
					System.out.println(propertyName.get(i).toString().trim()+"["+f.getType().getName()+"]"
							+ "=>setValue() error!");
					if(m.get(propertyName.get(i).toString().trim()) == null){
						f.set(tempClass,null);
					}else{
						f.set(tempClass,m.get(propertyName.get(i).toString().trim()).toString());
					}
				}
			}
			list.add((T) tempClass);
		}
		return list;
	}
}