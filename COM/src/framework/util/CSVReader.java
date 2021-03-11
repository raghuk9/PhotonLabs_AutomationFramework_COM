package framework.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;

public class CSVReader {
	private static final String COMMA_SEPARATOR = ",";

	public ResultVO breadFromCSVFile(String fileName) {
		ResultVO resultVO = new ResultVO();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			System.out.println("firstline from csv = " + bufferedReader.readLine());
			String line = "";
			if ((line = bufferedReader.readLine()) != null) {
				System.out.println("Entering to read secondline");
				String[] tokens = line.split(COMMA_SEPARATOR);
				int successCount = Integer.parseInt(tokens[0]);
				int failureCount = Integer.parseInt(tokens[1]);
				resultVO.setSuccessCount(successCount);
				resultVO.setFailureCount(failureCount);
				DecimalFormat decimalFormat = new DecimalFormat("#.##");
				resultVO.setSuccessPercentage(Double
						.valueOf(decimalFormat.format(successCount / (double) (successCount + failureCount) * 100)));
				resultVO.setFailurePercentage(Double
						.valueOf(decimalFormat.format(failureCount / (double) (successCount + failureCount) * 100)));
			}
		} catch (Exception e) {
			System.out.println("Exception occured at CSVReader: " + e.getMessage());
			e.printStackTrace();
		}
		return resultVO;
	}

}
