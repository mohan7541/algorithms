package com.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author Mohanraja
 * 
 * Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
Euclidean distance is applied to find the distance between you and a post office.
Assume your location is [m, n] and the location of a post office is [p, q], the Euclidean distance between the office and you is
SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
K is a positive integer much smaller than the given number of post offices.

e.g.
Input
you: [0, 0]
post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
k = 3

Output
[[-1, 2], [0, 3], [4, 3]] 
 *
 *
 *Approach:- MAX Heap
 *we can use MAX_HEAP for distance and keep <= K items in the heap at any given point.
if size becomes more than K we remove the item from the HEAP.
In the end we gonna have K points which are closest to 0,0
This would be N*log(K)
 */
public class NearestPostOffices {

	public static void main(String[] args) {
		int[][] points = {{-16, 5}, {-1, 2}, {4, 3}, {10, -2}, {0, 3}, {-5, -9}};
		int[][] result = kClosest(points, 3);
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] kClosest(int[][] points, int K) {
		int n = points.length;
		int[] dists = new int[n];
		for(int i=0;i<n;i++) {
			dists[i] = dist(points[i]);
			System.out.println(i+" distance is :"+dists[i]);
		}
		System.out.println("****All distances::"+Arrays.toString(dists));
		Arrays.sort(dists);
		System.out.println("****All distances sorted::"+Arrays.toString(dists));
		int distK = dists[K-1];
		System.out.println("distK::::"+distK);
		int[][] ans = new int[K][2];
		int t = 0;
		 for (int i = 0; i < n; ++i)
	            if (dist(points[i]) <= distK)
	                ans[t++] = points[i];
	        return ans;
	}

	private static int dist(int[] point) {
		System.out.println("("+point[0] +"*"+ point[0]+")+(" +"*"+ point[1] +"*"+ point[1]+")");
		return point[0] * point[0] + point[1] * point[1];
	}
}

class Solution {
    class PointDistance{
        int x,y,distance;
        PointDistance(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    class sortByDistanceDec implements Comparator<PointDistance>{
        public int compare(PointDistance a, PointDistance b){
            return b.distance - a.distance;
        }
    }
    
    int calDistance(int[] point){
        return point[0]*point[0] + point[1]*point[1] ; 
    }
    
    public int[][] kClosest(int[][] points, int K) {
        if(points == null) return new int[0][];
        
        PriorityQueue<PointDistance> queue = new PriorityQueue<PointDistance>(new sortByDistanceDec());
        for(int i=0;i<points.length;i++){
            queue.add(new PointDistance(points[i][0],points[i][1],calDistance(points[i])));
            if(queue.size()>K)
                queue.poll();
        }
        int [][] ans = new int[K][2];
        int i=0;
        while(!queue.isEmpty()){
            PointDistance p = queue.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }
        return ans;
    }
}

/**
 * 3MS solution
 * @author I343648
 *
 */
class Solution2 {
    public int[][] kClosest(int[][] points, int K) {
        quickSelect(points, 0, points.length-1, K-1);
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private void quickSelect(int[][] points, int left, int right, int K) {
        int i=left, j=right;
        int pivot = distance(points[right][0], points[right][1]);
        while (i <= j) {
            while (i<=j && distance(points[i][0], points[i][1])<pivot) {
                i++;
            }
            while (i<=j && distance(points[j][0], points[j][1])>pivot) {
                j--;
            }
            
            if (i<=j) {
                int tmp0 = points[i][0];
                int tmp1 = points[i][1];
                points[i][0] = points[j][0];
                points[i][1] = points[j][1];
                points[j][0] = tmp0;
                points[j][1] = tmp1;
                i++;
                j--;
            }
        }
        
        if (K <=j) {
            quickSelect(points, left, j, K);
        } else if (K >= i) {
            quickSelect(points, i, right, K);
        }
    }
    
    
    public int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        
        for (int i=0; i<points.length; i++) {
            queue.add(new Point(points[i][0], points[i][1]));
            if (queue.size() > K) {
                queue.poll();
            }
        }
        
        int[][] array = new int[K][0];
        int i = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            array[i++] = new int[]{p.x, p.y};
        }
        
        return array;
        
    }
    
    private int distance(int x, int y) {
        return x*x+y*y;
    }
    
    class Point implements Comparable<Point>{
        int x;
        int y;
        Point(){};
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        int distance() {
            return x*x + y*y;
        }
        
        @Override
        public int compareTo(Point p) {
            return p.distance() - this.distance();
        }
    }
}

/**
 * 4 MS solution
 * @author I343648
 * https://leetcode.com/submissions/detail/251321890/
 *
 */
class Solution4MS {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int helper(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            while (l < r && compare(points[r], pivot) >= 0) {
                r--;
            }
            points[l] = points[r];
            while (l < r && compare(points[l], pivot) <= 0) {
                l++;
            }
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }
    
    private int compare(int[] p1, int[] p2) {
        return p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1];
    }
}