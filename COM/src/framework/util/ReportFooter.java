package framework.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportFooter {

	public void prepare(String viewPort, String application) throws IOException {
		String osname = System.getProperty("os.name").toLowerCase();
		FileWriter fw = null;
		String newPath = null;
		BufferedWriter bw = null;
		File ff = new File("DriverSheet.ods");
		String path = ff.getAbsolutePath().trim();
		System.out.println("Path in Report_header = " + path);
		if (osname.contains("win")) {
			newPath = path.substring(0, path.lastIndexOf("\\")).concat("\\");
		} else {
			newPath = path.substring(0, path.lastIndexOf("/")).concat("/");
		}
		final String files = newPath.concat(viewPort).concat(application).concat(".html");
		fw = new FileWriter(files, true);
		bw = new BufferedWriter(fw);
		String csvFileName = new StringBuilder(newPath).append(viewPort).append(application).append(".csv").toString();
		ResultVO resultVO = buildResultVO(csvFileName);
		String pixel = "1000px";
		bw.write("<TABLE Border=1 style=width:" + pixel
				+ "><tr  BGCOLOR=#C0C0C0><td style=width:250px align=left>Success Count:" + resultVO.getSuccessCount()
				+ "</td><td style=width:250px align=left>Failure Count:" + resultVO.getFailureCount()
				+ "</td><td style=width:250px align=left>Success Percentage:" + resultVO.getSuccessPercentage() + "%"
				+ "</td><td style=width:250px align=left>Failure Percentage:" + resultVO.getFailurePercentage() + "%"
				+ "</td></tr>");
		bw.write("</TABLE></body></html>");
		bw.close();
	}

	private ResultVO buildResultVO(String fileName) {
		ResultVO resultVO = new ResultVO();
		CSVReader csvReader = new CSVReader();
		resultVO = csvReader.readFromCSVFile(fileName);
		return resultVO;
	}
}
