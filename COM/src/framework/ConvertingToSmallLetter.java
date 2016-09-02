package framework;

public class ConvertingToSmallLetter {
	public static String convertingToSmallLetter(String action) {
		Character firstLetter = action.charAt(0);
		char[] chararray = action.toCharArray();
		chararray[0] = Character.toLowerCase(firstLetter);
		action = new String(chararray);
		return action;
	}
}
