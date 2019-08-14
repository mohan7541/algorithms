package com.amazon;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 * @author Mohanraja
 * 
 * You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. 
There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
Assume the map area is a two dimensional grid, represented by a matrix of characters.
You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
The treasure island is marked as ‘X’ in a block of the matrix. ‘X’ will not be at the top-left corner.
Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
Output the minimum number of steps to get to the treasure.


e.g.
Input
[
[‘O’, ‘O’, ‘O’, ‘O’],
[‘D’, ‘O’, ‘D’, ‘O’],
[‘O’, ‘O’, ‘O’, ‘O’],
[‘X’, ‘D’, ‘D’, ‘O’],
]

Output from aonecode.com
Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps. 
 *
 *Approach: 1) First we will find the destination co-ordinates(X)(i,j positions in 2-D array) by looping all
 *			2) Then we will loop from 0-1 position(Horizontally)
 *			3) If we found destination(X) then we will break form loop and return Point.
 *				Else If we found obstacle(D) then we will move to next row(i++)
 *				Else If destination column position(Y) is less than current column position(j) then we decrement current column position(J--)
 *				Else we will increment current column poistion(J++)
 *				In each step of this ELSE-IF, we will note the point details to display the points which we travelled
 *				
 */
public class TreasureIsland {
	
	public static void main(String[] args) {
		//char[][] grid = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
			//	{ 'X', 'D', 'D', 'O' } };
		char[][] grid = {{'O', 'O', 'O', 'O'},
		                 {'D', 'O', 'D', 'O'},
		                 {'O', 'O', 'O', 'O'},
		                 {'X', 'D', 'D', 'O'}};


		System.out.println(minSteps(grid));
	}

	private static int minSteps(char[][] grid) {
		Point destination = checkPath(grid);
		Queue<Point> points = new ArrayDeque<>();
		points.add(new Point(0,1));
		int i = 0, j = 1;
		boolean isFound = false;
		System.out.println("Values [i][j] 0,0 : " + grid[0][0]);
		while(!isFound) {
			System.out.println("Values [i][j] " + i + "," + j + " : " + grid[i][j]);
			
			if(grid[i][j] == 'X') {
				isFound = true;
			} else if(grid[i + 1][j] != 'D') {
				i++;
				points.add(new Point(i, j));
			} else if (destination.y <= j && grid[i][j - 1] != 'D') {
				j--;
				points.add(new Point(i, j));
			} else {
				j++;
				points.add(new Point(i, j));
			}
		}
		return points.size();
	}
	
	private static Point checkPath(char[][] grid) {
		Point destination = null;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length; j++) {
				if(grid[i][j] == 'X') {
					destination = new Point(i, j);
					break;
				}
			}
			if(destination != null) {
				break;
			}
		}
		return destination;
	}
}
class Point {
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y; 
	}
}