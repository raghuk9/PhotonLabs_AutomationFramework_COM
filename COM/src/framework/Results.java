package framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.jopendocument.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import framework.util.CSVWriter;
import framework.util.ResultVO;

public class Results {
	private static final String STATUS_PASS = "Pass";
	private static final String STATUS_FAIL = "Fail";
	private static int successCount = 0;
	private static int failureCount = 0;

	@SuppressWarnings({ "unused" })
	public static void results(String testCaseNumber, String testCaseDescription, String status, String viewPort,
			String application, String startTm, String endTm, WebDriver driver) throws IOException, ParseException {
		SimpleDateFormat ddd = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date dt = new Date();
		Timestamp ts = new Timestamp(dt.getTime());
		String totalDifference = " ";
		String screenpath = null;
		FileWriter screenfw = null;
		File file = null;
		BufferedWriter screenbw = null;
		if (!(startTm == null)) {
			java.util.Date startTime = (java.util.Date) ddd.parse(startTm);
			if (!(endTm == null)) {
				java.util.Date endTime = (java.util.Date) ddd.parse(endTm);
				Long timeDiff = endTime.getTime() - startTime.getTime();
				Long hours = timeDiff / (60 * 60 * 1000);
				Long minutes = timeDiff / (60 * 1000);
				Long seconds = timeDiff / (1000);
				Long milliSeconds = seconds * 1000;
				totalDifference = DurationFormatUtils.formatDuration(milliSeconds, "HH:mm:ss");
			}
		}
		String osname = System.getProperty("os.name").toLowerCase();
		String output = null;
		String newPath = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		File ff = new File("DriverSheet.ods");
		String path = ff.getAbsolutePath();
		if (osname.contains("win")) {
			newPath = path.substring(0, path.lastIndexOf("\\")).concat("\\");
		} else {
			newPath = path.substring(0, path.lastIndexOf("/")).concat("/");
		}
		String files = newPath.concat(viewPort).concat(application).concat(".html");
		String align = "center";
		String color = "lightgreen";
		String headercolor = "grey";
		File f = new File(files);
		System.out.println("In Results page file name to work on = " + f.getName());
		fw = new FileWriter(f, true);
		bw = new BufferedWriter(fw);
		bw.write("<table border=1 style=width:1000px>");
		bw.write("<tr>");
		ResultVO resultVO = new ResultVO();
		CSVWriter csvWriter = new CSVWriter();
		if (STATUS_PASS.equals(status)) {
			resultVO.setSuccessCount(++successCount);
			resultVO.setFailureCount(failureCount);
			csvWriter.writeToCSVFile(new StringBuilder(viewPort).append(application).append(".csv").toString(),
					resultVO);
			bw.write("<td style=width:100px >" + testCaseNumber + "</td>");
			bw.write("<td style=width:800px>" + testCaseDescription + "</td>");
			bw.write("<td style=width:100px BGCOLOR=" + color + ">" + "PASS" + "</td>");
			bw.write("<td style=width:100px BGCOLOR=" + color + ">" + totalDifference + "</td>");
			bw.write("<td style=width:100px BGCOLOR=" + color + ">" + ts + "</td>");
		}
		if (STATUS_FAIL.equals(status)) {
			System.out.println("coming to fail section");
			resultVO.setFailureCount(++failureCount);
			resultVO.setSuccessCount(successCount);
			csvWriter.writeToCSVFile(new StringBuilder(viewPort).append(application).append(".csv").toString(),
					resultVO);
			String fail = "FAIL";
			if (!"APPIUM".equalsIgnoreCase(viewPort)) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File screens = new File("screenshots");
				String screenshotFileName = testCaseDescription.replace(" ", "_");
				FileUtils.copyFile(scrFile, new File(screens + "/" + screenshotFileName + ".jpg"));
				File fileScreenshot = new File(screens + "/" + screenshotFileName + ".jpg");
				screenpath = fileScreenshot.getAbsolutePath();
				String ScreenFiles = screens + "/" + screenshotFileName + ".html";
				file = new File(ScreenFiles);
				screenfw = new FileWriter(file);
				screenbw = new BufferedWriter(screenfw);
				screenbw.write("<html><head><title>Screenshots html</title></head><body>");
				screenbw.write("<img src='" + screenpath + "'>");
				screenbw.close();
			}
			bw.write("<td style=width:100px >" + testCaseNumber + "</td>");
			bw.write("<td style=width:800px>" + testCaseDescription + "</td>");
			if (!"APPIUM".equalsIgnoreCase(viewPort)) {
				bw.write("<td style=width:100px BGCOLOR=#FF0000" + "</td>");
				bw.write("<a href='" + file.getAbsolutePath() + "'>" + fail + "</a>");
			} else {
				bw.write("<td style=width:100px BGCOLOR=#FF0000 >" + "FAIL" + "</td>");
			}
			bw.write("<td style=width:100px BGCOLOR=" + color + ">" + totalDifference + "</td>");
			bw.write("<td style=width:100px BGCOLOR=" + color + ">" + ts + "</td>");
		}
		bw.write("</tr>");
		bw.write("</table>");
		bw.close();
	}

}
