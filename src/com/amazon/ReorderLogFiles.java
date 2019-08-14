package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Mohanraja
 * 
 * You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

Note:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
 *
 */
public class ReorderLogFiles {

	public static void main(String[] args) {
		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		ReorderLogFiles order = new ReorderLogFiles();
		String[] result = order.reorderLogFiles(logs);
		System.out.println(Arrays.toString(result));
	}

	public String[] reorderLogFiles(String[] logs) {
		List<String> letter_logs = new ArrayList<>();
		List<String> digit_logs = new ArrayList<>();
		for (String log : logs) {
			int idx = log.indexOf(' ') + 1;
			if (Character.isDigit(log.charAt(idx)))
				digit_logs.add(log);
			else
				letter_logs.add(log);
		}
		// sort letter_logs
		letter_logs.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int i1 = s1.indexOf(' ') + 1;
				int i2 = s2.indexOf(' ') + 1;
				System.out.println(s1.substring(i1)+":::::::"+s2.substring( i2));
				int res = s1.substring(i1).compareTo(s2.substring(i2));
				if (res != 0) {
					return res;
				}
				
				return s1.substring(0, i1).compareTo(s2.substring(0, i2));
			}

		});
		// merge and return
		letter_logs.addAll(digit_logs);
		return letter_logs.toArray(new String[letter_logs.size()]);
	}

}
