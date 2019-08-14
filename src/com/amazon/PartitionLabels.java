package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		PartitionLabels partition = new PartitionLabels();
		String s = "ababcbacadefegdehijhklij";
		List<Integer> result = partition.partitionLabels(s);
		System.out.println(result.toString());

	}

	public List<Integer> partitionLabels(String S) {
		 int[] map = new int[26];
		 System.out.println("before::map::"+Arrays.toString(map));
	     List<Integer> res = new ArrayList<>();
	     for(char c:S.toCharArray()) {
	    	 map[c-'a']++;
	     }
	     System.out.println("After::map::"+Arrays.toString(map));
	     int cur = 0, len = 0;
	     int[] curSet = new int[26];
	     for(char c:S.toCharArray()) {
	    	 if(curSet[c-'a'] == 0) {
	    		 cur += map[c-'a'];
	    		 curSet[c-'a']++;
	    		 System.out.println(c+"::"+cur+":::curSet::"+Arrays.toString(curSet));
	    	 }
	    	 System.out.println("currr::"+cur);
	    	 cur--;
	    	 len++;
	    	 if(cur == 0) {
	    		 res.add(len);
	    		 len = 0;
	    	 }
	     }
	     return res;
	}

}
