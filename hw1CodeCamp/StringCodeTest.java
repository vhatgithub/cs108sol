// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

import junit.framework.TestCase;

public class StringCodeTest extends TestCase {
	//
	// blowup
	//
	public void testBlowup1() {
		// basic cases
		assertEquals("attttxzzz", StringCode.blowup("a3tx2z"));
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	
	public void testBlowup2() {
		// things with digits
		
//		two consecutive digit
		assertEquals("2xxx", StringCode.blowup("12x"));
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	
	//
	// maxRun
	//
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}
	
	public void testRun4() {
		// tests with special chars
		assertEquals(2, StringCode.maxRun("--&&!@#123"));
		assertEquals(2, StringCode.maxRun("**"));
		assertEquals(2, StringCode.maxRun("  "));
	}

	// Need test cases for stringIntersect
	
	public void testStringIntersect1() {
//		Basic cases
		assertEquals(true, StringCode.stringIntersect("abbcc", "bbcca", 2));
		assertEquals(true, StringCode.stringIntersect("abccc", "bbcca", 2));
		assertEquals(false, StringCode.stringIntersect("abccc", "bbcda", 3));
	}
	
	public void testStringIntersect2() {
//		Number cases
		assertEquals(true, StringCode.stringIntersect("11223", "22331", 2));
		assertEquals(false, StringCode.stringIntersect("1123ab", "221cd", 2));
		assertEquals(true, StringCode.stringIntersect("ab11123", "22111cd", 3));
		assertEquals(false, StringCode.stringIntersect("ab11123", "221111cd", 4));
		assertEquals(false, StringCode.stringIntersect("", "", 1));
	}
	
	public void testStringIntersect3() {
//		Special Char cases
		assertEquals(true, StringCode.stringIntersect("--++!!", "==++@@", 2));
		assertEquals(false, StringCode.stringIntersect("--++!!", "==++@@@", 3));
	}
	
}
