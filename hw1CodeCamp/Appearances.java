import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		Map<T, Integer> mapA = new HashMap<T, Integer>();
		Map<T, Integer> mapB = new HashMap<T, Integer>();
		int count = 0;
		
		for(T key : a) {
			mapA.put(key, mapA.get(key) == null ? 0 : mapA.get(key) + 1);
		}
		
		for(T key : b) {
			mapB.put(key, mapB.get(key) == null ? 0 : mapB.get(key) + 1);
		}
		
		for(T key : mapA.keySet()) {
			if(mapA.get(key) == mapB.get(key)) {
				count++;
			}
		}
		
		
		return count;
	}
	
}
