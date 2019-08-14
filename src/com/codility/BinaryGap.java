package com.codility;

public class BinaryGap {

	public static void main(String[] args) {
		int n = 1043;
		BinaryGap bg = new BinaryGap();
		int result = bg.solution(n);
		System.out.println(result);
	}

	private int solution(int n) {
	
		int maxGap = 0, currGap = 0;
		boolean counting = false;
		
		while(n != 0) {
			
			if(!counting) {
				if ( (n & 1) == 1)
					counting = true;
			} else {
				if( (n & 1) == 1) {
					maxGap = Math.max(maxGap, currGap);
					System.out.println("maxGap::"+maxGap);
					currGap = 0;
				} else {
					currGap++;
				}
			}
			n = n >> 1;
			System.out.println("After shift n value: "+n);
		}
		return maxGap;
	}

}
