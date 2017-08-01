package cn.bdqn.util;

public class StringUtil {

	public static boolean isEmpty(String str){
        if(str==null||"".equals(str.trim())){
            return true;
        }else{
            return false;
        }
    }
	
	 public static boolean isNotEmpty(String str){
	        if((str!=null)&&!"".equals(str.trim())){
	            return true;
	        }else{
	            return false;
	        }
	    }
	 public static String formatLike(String str){
	        if(isNotEmpty(str)){
	            return "%"+str+"%";
	        }else{
	            return null;
	        }
	    }

public static boolean existStrArr(String str,String []strArr){
	for(int i=0;i<strArr.length;i++){
		if(strArr[i].equals(str)){
			return true;
		}
	}
	return false;
}
}