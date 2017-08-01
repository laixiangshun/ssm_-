package cn.bdqn.util;

import java.util.List;
import java.util.UUID;

public class StringUtils {
	
	public static boolean  isNotNull(String text){
		return text != null && !"".equals(text);
	}
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static boolean isNotNull(String[] array){
		return array != null && array.length > 0;
	}
	public static boolean isNotNull(List<?> list){
		return list != null && list.size() > 0;
	}
}
