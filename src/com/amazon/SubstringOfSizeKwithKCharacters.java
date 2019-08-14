package com.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Mohanraja
 *
 *
 *Michelle has created a word game for her students. The word game begins with Michelle writing a string and a number, K, on the board. The students have to ﬁnd the substrings of size K with K distinct characters.

	Write an algorithm to help the students ﬁnd the correct answer. If the given string does not have K distinct characters then output an empty list.
	
	Input
	The input to the function/method consists of two arguments -
	str, representing the string written by the teacher;
	k, an integer, written by the teacher on the board.
	
	Output
	Return distinct substrings of input string of size K with K distinct characters.
	
	Constraints
	0 ≤ k ≤ 26
	
	Note
	The input string consists of only lowercase letters of the English alphabet. Substrings are not necessarily distinct.
	
	Example 1:
	
	Input: str = "awaglknagawunagwkwagl", k = 4
	Output: [wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag]
	Explanation: 
	Substrings in order are: wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag, wagl 
	"wagl" is repeated twice, but is included in the output once.
 *
 *
 *Solu - 2:- https://leetcode.com/playground/R2gSRbR4
 */
public class SubstringOfSizeKwithKCharacters {

	public static void main(String[] args) {
		String str = "awaglknagawunagwkwagl";
		int k = 4;
		List<String> result = distinctStrings(str,4);
		System.out.println(result);
		System.out.println(0x7f);
	}

	private static List<String> distinctStrings(String str, int k) {
		Set<Character> window = new HashSet<>();
		Set<String> result = new HashSet<>();
		for(int start = 0, end = 0; end < str.length(); end++) {
			for(; window.contains(str.charAt(end)); start++) {
				window.remove(str.charAt(start));
			}
			window.add(str.charAt(end));
			if(window.size() == k) {
				result.add(str.substring(start, end+1));
				window.remove(str.charAt(start++));
			}
		}
		return new ArrayList<String>(result);
	}

}
