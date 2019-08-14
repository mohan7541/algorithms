package com.amazon;

import java.util.Arrays;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String data = "abcabcbb";
		int length = lengthOfLongestSubstring(data);
		System.out.println(length);
	}
	
	 public static int lengthOfLongestSubstring(String s) {
	        int len = s.length();
	        if(len == 0) {
	            return 0;
	        }
	        int max = 0;
	        int[] pos = new int[256];
	        Arrays.fill(pos, -1);
	        for(int start = 0, end = 0; end < len; end++) {
	        	
	            char cur = s.charAt(end);
	            if(pos[cur] >= start) {
	                start = pos[cur] + 1;
	            }
	            pos[cur] = end;
	            max = Math.max(max, end - start + 1);
	            System.out.println("start::"+start+"::end::"+end+":;curr::"+cur+"::pos[cur]"+pos[cur]);
	        }
	        return max;
	    }

}
