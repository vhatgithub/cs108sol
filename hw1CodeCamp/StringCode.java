import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int maxRun = 0, count = 1;
		char prevChar, currentChar;
		
		for(int i = 1; i < str.length(); i++) {
			prevChar = str.charAt(i - 1);
			currentChar = str.charAt(i);
			
			if(currentChar == prevChar) {
				count++;
			} else {
				count = 1;
			}
			
			if(maxRun < count) {
				maxRun = count;
			}
		}
		
		return maxRun;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String resultString = "";
		char currentChar = '\0', nextChar = '\0';
		
		for(int i = 0; i < str.length() - 1; i++) {
			currentChar = str.charAt(i);
			nextChar = str.charAt(i + 1);
			
			if(isNumber(currentChar)) {
				for(int j = 0; j < currentChar - 48; j++) {
					resultString += nextChar;
				}
			} else {
				resultString += currentChar;
			}
			
			if(i == str.length() - 2 && !isNumber(nextChar)) {
				resultString += nextChar;
			}
		}
		
		return resultString;
	}
	
	private static boolean isNumber(char ch) {
		return ch >= '0' && ch <= '9';
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		Set<String> setA = new HashSet<String>();
		Set<String> setB = new HashSet<String>();
		int strLen = a.length() > b.length() ? a.length() - len : b.length() - len;
		
		for(int i = 0; i <= strLen; i++) {
			if(i <= a.length() - len) {
				setA.add(a.substring(i, i + len));
			}
			if(i <= b.length() - len) {
				setB.add(b.substring(i, i + len));
			}
		}
		
		for(String subStr : setA) {
			if(setB.contains(subStr)) {
				return true;
			}
		}
		
		return false;
	}
}
