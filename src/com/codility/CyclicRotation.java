package com.codility;

public class CyclicRotation {

	public static void main(String[] args) {
		int data[] = {3, 8,9,7,6};
		int totalEle = data.length;
		int k = 3;
		int newArr[] = new int[totalEle];
		for(int i=0;i<totalEle;i++) {
			int newPosition = (i+k) % totalEle;
			newArr[newPosition] = data[i];
		}
		for(int each : newArr) {
			System.out.print(each + " ");
		}
	}

}
