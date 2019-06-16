package com.gankki.demo.ma.annotation.example;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
public class SimpleFormatter {

	private static Object formatDate(Field f, Object value) {
		Format format = f.getAnnotation(Format.class);
		if (format != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format.pattern());
			sdf.setTimeZone(TimeZone.getTimeZone(format.timezone()));
			return sdf.format(value);
		}
		return value;
	}

	public static String format(Object obj) {
		try {
			Class<?> cls = obj.getClass();
			StringBuilder sb = new StringBuilder();
			for (Field f : cls.getDeclaredFields()) {
				if (!f.isAccessible()) {
					f.setAccessible(true);
				}
				Label label = f.getAnnotation(Label.class);
				String name = label != null ? label.value() : f.getName();
				Object value = f.get(obj);
				if (value != null && f.getType() == Date.class) {
					value = formatDate(f, value);
				}
				sb.append(name + "：" + value + "\n");
			}
			return sb.toString();
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Student zhangsan = new Student("张三", sdf.parse("1990-12-12"), 80.9d);

		System.out.println(SimpleFormatter.format(zhangsan));
	}

}
