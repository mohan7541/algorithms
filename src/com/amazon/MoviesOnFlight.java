package com.amazon;

import java.util.Arrays;

/**
 * 
 * @author Mohanraja
 * 
 * 
 * You are on a flight and wanna watch two movies during this flight. 
You are given int[] movie_duration which includes all the movie durations. 
You are also given the duration of the flight which is d in minutes. 
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min). 
Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

e.g. 
Input
movie_duration: [90, 85, 75, 60, 120, 150, 125]
d: 250

Output 
[90, 125]
90min + 125min = 215 is the maximum number within 220 (250min - 30min)
 *
 */
public class MoviesOnFlight {

	public static void main(String[] args) {
		int d = 250;
		int[] nums = new int[] {90, 85, 75, 60, 120, 150, 125};
		int[] result = findBetterChoice(nums, d);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findBetterChoice(int[] nums, int d) {
		int[] result = new int[2];
		int start = 0, end = nums.length - 1;
		Arrays.sort(nums);
		int dur = 0;
		while(start < end) {
			dur = nums[start] + nums[end]; 
			if( dur <= d-30) {
				result[0] = nums[start];
				result[1] = nums[end];
				start ++;
			} else if(dur > d-30){
				end--;
			}
		}
		
		return result;
	}

}
