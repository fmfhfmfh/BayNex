package kr.co.codemaker.common.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* MkDir.java
*
* @author 최민준
* @version 1.0
* @since 2020. 12. 21.
*
* 수정자 수정내용
* ------ ------------------------
* 최민준 파일생성시 디렉토리에 해당하는 폴더가 없을때 자동으로 생성해주는 클래스
*
 */
public class MkDir {
	private static final Logger logger = LoggerFactory.getLogger(MkDir.class);
	
	//선생님 폴더 없을때 생성
	public void mkdirTeacher() {
		File folder = Paths.get("C:","file","teacher","profile").toFile(); 
		
		//해당 디렉토리가 없을때 디렉토리 생성
		if (!folder.exists()) {
			folder.mkdirs();
			logger.debug("폴더생성 완료");
		}else {
			logger.debug("이미 폴더 존재함");
		}
	}
	
}
