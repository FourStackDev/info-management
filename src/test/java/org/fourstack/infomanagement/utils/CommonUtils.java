package org.fourstack.infomanagement.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

public class CommonUtils {
	private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	/**
	 * Generates a random Long value.
	 * 
	 * @return Generated Long value
	 */
	public static long getRandomLong() {
		return new Random().nextLong();
	}

	/**
	 * Reads and Returns the Content of Specified file.
	 * 
	 * @param filenameWithPath File Path
	 * @return String content of the File
	 */
	public static String getFileContent(String filenameWithPath) {
		String content = "";
		try {
			File file = ResourceUtils.getFile("classpath:" + filenameWithPath);
			content = new String(Files.readAllBytes(file.toPath()));

		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException: Specified File Not found - " + filenameWithPath, e);
		} catch (IOException e) {
			logger.error("IOException: IOException occurred while processing the file - " + filenameWithPath, e);
		}
		return content;
	}

	/**
	 * Reads the content of the specified file under resource folder. Method
	 * requires the ClassLoader instance of class from where it is being called.
	 * 
	 * @param filenameWithPath file path
	 * @param loader           ClassLoader instance
	 * @return String content of the file
	 */
	public static String getFileContentUsingResource(String filenameWithPath, ClassLoader loader) {
		String content = "";
		try {
			URL resource = loader.getResource(filenameWithPath);
			if (resource == null)
				throw new IllegalArgumentException("Specified File Not found !!");

			File file = new File(resource.getFile());
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			logger.error("IOException: IOException occurred while processing the file - " + filenameWithPath, e);
		}
		return content;
	}

	/**
	 * Reads the content of the specified file under resource folder using
	 * ResourceStream. Method requires the ClassLoader instance of class from where
	 * it is being called
	 * 
	 * @param filenameWithPath file path
	 * @param loader           ClassLoader Object
	 * @return String content of File
	 */
	public static String getFileContentUsingResourceStream(String filenameWithPath, ClassLoader loader) {
		StringBuffer content = new StringBuffer();

		try (InputStream inputStream = loader.getResourceAsStream(filenameWithPath);
				InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader);) {
			
			/* content = IOUtils.toString(inputStream, StandardCharsets.UTF_8); */
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}

		} catch (IOException e) {
			logger.error("IOException: IOException occurred while processing the file - " + filenameWithPath, e);
		}
		return content.toString();
	}
}
