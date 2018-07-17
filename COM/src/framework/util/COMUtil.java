package framework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryIteratorException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class COMUtil {

	/*
	 * Methods for getting file with extension based on latest time stamp
	 * 
	 */
	public static String getLatestFile(String path, String extension) throws FileNotFoundException {

		File directory = new File(path);
		File latestFile = null;
		if (directory == null || !directory.exists() || !directory.isDirectory()) {
			System.out.println("Incorrect Directory");
			throw new DirectoryIteratorException(null);
		}

		FileFilter fileFilter = new WildcardFileFilter("*." + extension);
		File[] files = directory.listFiles(fileFilter);
		if (files.length > 0) {
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			latestFile = files[0];
		} else {
			throw new FileNotFoundException("File is missing");
		}
		return latestFile.getName();
	}

	/*
	 * Methods for getting *.apk file based on latest time stamp
	 * 
	 */

	public static String getLatestAPKFile() throws FileNotFoundException {

		System.out.println("Apk Filename in Test: " + getLatestFile("ApkFile", "apk"));
		return System.getProperty("user.dir") + File.separator + "ApkFile" + File.separator
				+ getLatestFile("ApkFile", "apk");
	}

	public static String getAdbDeviceID() throws IOException, InterruptedException {
		String line = null;
		String cmd = "adb devices";
		try {

			Process process = Runtime.getRuntime().exec(cmd);
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			Pattern pattern = Pattern.compile("^([a-zA-Z0-9\\-]+)(\\s+)(device)");
			Matcher matcher = null;
			while ((line = in.readLine()) != null) {
				if (line.matches(pattern.pattern())) {
					matcher = pattern.matcher(line);
					if (matcher.find())
						// System.out.println("Device ID: "+matcher.group(1));
						return matcher.group(1);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "No Device Connected";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
