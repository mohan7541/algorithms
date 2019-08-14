package com.codility;

/**
 * Complexity:
	expected worst-case time complexity is O(1);
	expected worst-case space complexity is O(1).
 * @author I343648
 *
 */
public class FrogJump {

	public static void main(String[] args) {
		
		int initPosition = 10;
		int maxPosition = 85;
		int fixedDistance = 30;
		
		long difference = maxPosition - initPosition;
		long coverage = 0;
		
		if(difference % fixedDistance != 0) {
			coverage = 1;
		}
		
		long hop = (difference / fixedDistance) + coverage;
		
		System.out.println("hop::"+hop);

	}

}
