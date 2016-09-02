package framework.util;

import org.jopendocument.dom.spreadsheet.Sheet;

public class SmartUtil {

	public static int calculateUsedRowCount(Sheet functionalitysheet) {
		String usedRangeInnerSheet;
		int innerRowCount =-1;
		usedRangeInnerSheet = functionalitysheet.getUsedRange().toString();
		System.out.println("usedRangeInnerSheet = " + usedRangeInnerSheet);
		String[] splitted = usedRangeInnerSheet.split(":");
		innerRowCount = Integer.parseInt(splitted[splitted.length - 1].replaceAll("[^0-9]", ""));
		System.out.println("innerRowCount = " + innerRowCount);
		return innerRowCount;
	}
}
