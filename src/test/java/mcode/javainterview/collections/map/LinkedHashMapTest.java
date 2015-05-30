package mcode.javainterview.collections.map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class LinkedHashMapTest {

	/**
	 * LinkedHashMap stores entries in the order that was inserted.
	 * HashMap does not guarantee entries are stored in the order that was inserted.
	 */
	@Test
	public void HashMapVsLinkedHashMapTest() {
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		insertConsecutiveIntegers(hashMap, 1000);
		
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		insertConsecutiveIntegers(linkedHashMap, 1000);
		
		// TreeMap maintains natural order of insertion.
		
		assertFalse(mapEntriesAreInOrder(hashMap));
		assertTrue(mapEntriesAreInOrder(linkedHashMap));
	}
	
	/**
	 * Adds a list of consecutive Integers into map in order.
	 * @param map map to add Integer entries to.
	 * @param count number of integers to add.
	 */
	private static void insertConsecutiveIntegers(Map<String, Integer> map, int count) {
		for(int i = 0; i < count; i++) {
			map.put("" + i, i);
		}
	}
	
	/**
	 * Checks that all Integer values are in order in the map.
	 * @param map
	 * @return true if all Integer values in the map are in order.
	 */
	private static boolean mapEntriesAreInOrder(Map<String, Integer> map) {
		Integer val = null;
		for(Entry<String, Integer> entry : map.entrySet()) {
			if(val != null) {
				if(val.intValue() + 1 != entry.getValue().intValue())
					return false;
			}
			val = entry.getValue();
		}
		return true;
	}

}
