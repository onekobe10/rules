package com.gankki.demo.ma.annotation.example2;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
public class SimpleContainer2 {

	private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

	private static <T> T createInstance(Class<T> cls) throws Exception {
		T obj = cls.newInstance();
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(SimpleInject.class)) {
				if (!f.isAccessible()) {
					f.setAccessible(true);
				}
				Class<?> fieldCls = f.getType();
				f.set(obj, getInstance(fieldCls));
			}
		}
		return obj;
	}

	/**
	 * 首先检查类型是否是单例，如果不是，就直接调用createInstance创建对象。
	 * 否则，检查缓存，如果有，直接返回，没有的话，调用createInstance创建对象，并放入缓存中。
	 * @param cls
	 * @param <T>
	 * @return
	 */
	public static <T> T getInstance(Class<T> cls) {
		try {
			boolean singleton = cls.isAnnotationPresent(SimpleSingleton.class);
			if (!singleton) {
				return createInstance(cls);
			}
			Object obj = instances.get(cls);
			if (obj != null) {
				return (T) obj;
			}
			synchronized (cls) {
				obj = instances.get(cls);
				if (obj == null) {
					obj = createInstance(cls);
					instances.put(cls, obj);
				}
			}
			return (T) obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
