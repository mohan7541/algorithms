package com.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public static void main(String[] args) {
		String text = "a, a, a, a, b,b,b,c, c";
				
		String[] banned = {"a"};
		long start = System.currentTimeMillis();
		String result = mostCommonWordOptimized(text, banned);
		long end = System.currentTimeMillis();
		System.out.println("Execution speed "+ (end - start)+" ms\n");
		System.out.println(result);
	}

	private static String mostCommonWord(String text, String[] banned) {
		long start = System.currentTimeMillis();
		if(text == null || text.length() == 0) {
			return text;
		}
		Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> count = new HashMap<>();
		String[] words = text.replaceAll("[!?',;.]", " ").trim().toLowerCase().split("\\s+");
		//System.out.println("lower case::"+text.replaceAll("[!?',;.]", "").toLowerCase());
		//System.out.println("Before for runtime");
		long end = System.currentTimeMillis();
		//System.out.println("Execution speed "+ (end - start)+" ms\n");
		//start = System.currentTimeMillis();
		for(String word : words) {
			if(!bannedSet.contains(word)) {
				
				count.put(word, count.getOrDefault(word, 0)+1);
			}
		}
		
		//System.out.println("all::"+count.toString());
		
		/*
		 * Optional<Entry<String, Integer>> result = count.entrySet().stream()
		 * .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst();
		 * end = System.currentTimeMillis(); System.out.println("2.Execution speed "+
		 * (end - start)+" ms\n"); System.out.println("key::"+result.get().getKey());
		 * System.out.println("value::"+result.get().getValue()); return
		 * result.get().getKey();
		 */
		String rst = "";
		int countMax = 0;
		for (Map.Entry<String, Integer> entry : count.entrySet()) {
			if (entry.getValue() > countMax) {
				rst = entry.getKey();
				countMax = entry.getValue();
			}
		}
		//end = System.currentTimeMillis(); 
		//System.out.println("2.Execution speed "+(end - start)+" ms\n");
		return rst;
	}
	
	public static String mostCommonWordOptimized(String paragraph, String[] banned) {
        paragraph += ".";

		Set<String> banset = new HashSet();
		for (String word : banned)
			banset.add(word.toLowerCase());
		Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }
	public static void printRunTime() {
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();
		System.out.println("Execution speed "+ (end - start)+" ms\n");
	}
}
