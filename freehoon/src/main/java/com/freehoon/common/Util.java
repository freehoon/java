package com.freehoon.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Util {

	/*
	 * 날짜 문자열 생성
	 * 
	 */
	public static String getToday(String format) {
		if( format == null || format.equals(""))
			format = "yyyy-MM-dd";
		
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.KOREA);
		return sdf.format(new Date());
	}
	
	/*
	 * 퍼미션 설정
	 * 
	 */
	public static void setPermission(File file, String permission) {
		file.setReadable(false, false);
		file.setWritable(false, false);
		file.setExecutable(false, false);
		
		if ( permission.equals("777") ) {
			file.setReadable(true, false);
			file.setWritable(true, false);
			file.setExecutable(true, false);
		} else if ( permission.equals("766") ) {
			file.setReadable(true, false);
			file.setWritable(true, false);
			file.setExecutable(true, true);
		} else if ( permission.equals("755") ) {
			file.setReadable(true, false);
			file.setWritable(true, true);
			file.setExecutable(true, false);
		}
	}
	
	/*
	 * 퍼미션 설정
	 * 
	 */
	public static void setPermission(String targetPath, String permission) throws Exception{
		File targetFile = new File(targetPath);
		
		targetFile.setReadable(false, false);
		targetFile.setWritable(false, false);
		targetFile.setExecutable(false, false);
			
		String cmd = "chmod " + permission + " -R " + targetPath;
		Runtime rt = Runtime.getRuntime();
		Process prc = rt.exec(cmd);
		prc.waitFor();
	}
	
	/*
	 * 공백 또는 null 체크
	 */
	public static boolean isEmpty(Object obj) {
		if(obj == null) return true;
		if ((obj instanceof String) && (((String)obj).trim().length() == 0)) { return true; }
	    if (obj instanceof Map) { return ((Map<?, ?>) obj).isEmpty(); }
	    if (obj instanceof Map) { return ((Map<?, ?>)obj).isEmpty(); } 
	    if (obj instanceof List) { return ((List<?>)obj).isEmpty(); }
	    if (obj instanceof Object[]) { return (((Object[])obj).length == 0); }

		return false;
	}

	
	
}
