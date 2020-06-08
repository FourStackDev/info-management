package org.fourstack.infomanagement.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

import org.springframework.util.ResourceUtils;

public class CommonUtils {
	
	public static long getRandomLong() {
		return new Random().nextLong();
	}
	
	public static String getFileContent(String filenameWithPath) {
		String content = "";
		try {
			File file = ResourceUtils.getFile("classpath:"+filenameWithPath);
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
