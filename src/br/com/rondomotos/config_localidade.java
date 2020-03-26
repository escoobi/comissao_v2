package br.com.rondomotos;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Locale;

public class config_localidade {
	public static void configLocalidade() {
		
		Field charset;
		Locale.setDefault(new Locale("pt", "BR"));

		System.setProperty("file.encoding", "UTF-8");
		try {
			charset = Charset.class.getDeclaredField("defaultCharset");
			charset.setAccessible(true);
			charset.set(null, null);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
