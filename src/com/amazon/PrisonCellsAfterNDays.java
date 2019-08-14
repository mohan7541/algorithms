package com.amazon;

public class PrisonCellsAfterNDays {

	public static void main(String[] args) {
		int[] cells = {0,1,0,1,1,0,0,1}; 
		int n = 7;
		PrisonCellsAfterNDays p = new PrisonCellsAfterNDays();
		p.prisonAfterNDays(cells, n);
		
	}
	public int[] prisonAfterNDays(int[] cells, int n) {
		int size  =cells.length;
		int[] temp = new int[size];
		for(int i=0;i<size;i++) {
			temp[i] = cells[i];
		}
		
		while(n-- > 0) {
			// Finding next values for corner cells 
			temp[0] = 0 ^ cells[1];
			temp[size - 1] = 0 ^ cells[size - 1];
			
			for(int i=1;i<=size -2;i++) {
				temp[i] = cells[i - 1] ^ cells[i + 1];
			}
			for(int i=0;i<size;i++) {
				cells[i] = temp[i];
			}
		}
		return cells;
	}

}
