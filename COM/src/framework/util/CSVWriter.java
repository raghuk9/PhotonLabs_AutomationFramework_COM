package framework.util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

	private static final String COMMMA_SEPARATOR = ",";
	private static final String LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "Pass,Fail";

	public void writeToCSVFile(String fileName, ResultVO resultVO) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName, false);
			fileWriter.append(FILE_HEADER);
			fileWriter.append(LINE_SEPARATOR);
			fileWriter.append(String.valueOf(resultVO.getSuccessCount()));
			fileWriter.append(COMMMA_SEPARATOR);
			fileWriter.append(String.valueOf(resultVO.getFailureCount()));
			fileWriter.append(LINE_SEPARATOR);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured at writing to csv file: " + e.getMessage());
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.flush();
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
