package mypackage.context;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AppContext implements Serializable {
	
	private static final long serialVersionUID = 8646328574953543140L;
	private static Map<ContextValues, Object> ctx;
	
	private AppContext() {
	}

	public static void addInContext(ContextValues key, Object value) {
		if (ctx == null)
			ctx = new HashMap<>();
		
		ctx.put(key, value);
	}
	
	public static Object getFromContext(ContextValues key) {
		if (ctx == null)
			ctx = new HashMap<>();
		
		Object o = ctx.get(key);
		return o;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Object> T getFromContext(ContextValues key, Class<T> clazz) {
		return (T) getFromContext(key);
	}
	
	
}
