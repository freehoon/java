package com.freehoon.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


public class UploadFile {
	private static final Logger logger = LoggerFactory.getLogger(UploadFile.class);

	/*
	 * 파일을 저장하고 저장된 경로(문자열)을 반환한다.
	 */
	public static Map<String, Object> uploadFile(MultipartFile file, HttpServletRequest request) throws Exception{
		Map<String, Object> result = new HashMap<>();
		
		try {
			//파일명
			String originalFileName = file.getOriginalFilename();
			//파일 데이터 크기
			byte[] fileData = file.getBytes();
			
			//파일명 중복 처리 방지
			String uuidFileName = getUuidFileName(originalFileName);
			
			//파일 업로드 경로 설정(파일의 형식에 따라 기본 경로를 지정한다.)
			String rootPath = getRootPath(originalFileName, request);
			String datePath = getDatePath(rootPath);
			
			//파일을 서버에 저장
			File target = new File(rootPath + File.separator + datePath, uuidFileName);
			FileCopyUtils.copy(fileData, target);
			
			result.put("savedPath", rootPath + File.separator + datePath);
			result.put("status", "OK");
		} catch (Exception e) {
			e.getStackTrace();
			result.put("status",  "False");
		}
		
		
		return result;
	}
	
	public static String getUuidFileName(String originalFileName) {
		return UUID.randomUUID().toString() + "_" + originalFileName;
	}
	
	public static String getRootPath(String fileName, HttpServletRequest request) throws IOException {
		String rootPath = "/resources/upload";
		
		//파일 타입 확인
		Path path = new File(fileName).toPath();
		String mimeType = Files.probeContentType(path);
		//MediaType mediaType = MediaUtils.getMediaType(fileName);
		
		//if (mediaType != null)
		if(mimeType.equals("image/png"))
			return request.getSession().getServletContext().getRealPath(rootPath + "/images");
		
		return request.getSession().getServletContext().getRealPath(rootPath + "files");
	}
	
	public static String getDatePath(String path) {
		Calendar calendar = Calendar.getInstance();
		String yearPath = File.separator + calendar.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.DAY_OF_MONTH));
		//날짜 폴더 생성
		makeDateDir(path, yearPath, monthPath, datePath);
		
		return datePath;
	}
	
	public static void makeDateDir(String path, String yearPath, String monthPath, String datePath) {
		File file = new File(path + yearPath + monthPath + datePath);
		if(!file.exists())
			file.mkdirs();
		
		/*
		 인자를 배열 형식으로 받을 수 있다.
		 public void makeDateDir(String uploadPath, String... paths){
		 	//년도, 날짜, 날, 년도+월+일 로 된 디렉토리 구조를 만든다면 아래 로직을 쓰면 된다.
		 	for(String path : paths) {
		 		File dirPath = new File(uploadPath + path);
		 		if (!dirPath.exists())
		 			dirPath.mkdir();
		 	}
		 }
		 */
	}
}
