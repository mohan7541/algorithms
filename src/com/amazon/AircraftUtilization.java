package com.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AircraftUtilization {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] forwardRouteLists = {{1, 2000}, {2, 4000}, {3, 6000}};
		 int[][] returnRouteLists = {{1, 2000}};
		 int maxTravelDist = 7000;
		 List<List<Integer>> res = aircraftUtilization(maxTravelDist,forwardRouteLists,returnRouteLists);
		 int[][] forwardRouteLists1 = {{1, 3000}, {2, 5000}, {3, 7000},{4,10000}};
		 int[][] returnRouteLists1 = {{1, 2000},{2,3000},{3,4000},{4,5000}};
		 int maxTravelDist1 = 10000;
		 List<List<Integer>> res1 = aircraftUtilization(maxTravelDist1,forwardRouteLists1,returnRouteLists1);
	}
 
	public static List<List<Integer>> aircraftUtilization(int maxTravelDist,int[][] forwardRoutes, int[][] returnRoutes){
		
		List<Node> forwardRouteList = new ArrayList<Node>() ;
		for(int[] f: forwardRoutes){
			forwardRouteList.add(new Node(f[0],f[1]));
		}
		List<Node> returnRouteList = new ArrayList<Node>() ;
		for(int[] r: returnRoutes){
			returnRouteList.add(new Node(r[0],r[1]));
		}
		
		//sort forwardlist
		Collections.sort(forwardRouteList,new Comparator<Node>(){
 
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.y,o2.y);
			}			
		});
		
		//sort returnlist
		Collections.sort(returnRouteList,new Comparator<Node>(){
 
			@Override
			public int compare(Node o1, Node o2) {
				
				return Integer.compare(o1.y,o2.y);
			}			
		});
		
		//	
		int max = 0;
		List<List<Integer>> result = null;
		for(int i=0;i<forwardRouteList.size();i++ ){
			 Node f = forwardRouteList.get(i);
			for(int j=0;j<returnRouteList.size();j++ ){
				 Node r = returnRouteList.get(j);
					int tmp = f.y+r.y;
				if(tmp<=maxTravelDist&& tmp>max ){			
					max = tmp;
					result =  new LinkedList<List<Integer>>();	 
					List<Integer> list = new ArrayList<Integer>();
					list.add(f.x);
					list.add(r.x);
					result.add(list);
				}else if(tmp<=maxTravelDist&& tmp ==max ){
					List<Integer> list = new ArrayList<Integer>();
					list.add(f.x);
					list.add(r.x);
					result.add(list);
				}
			}
			
		}
		
		return result;		
	}
	
}
class Node {
    public int x;
    public int y;
 
    Node(int x, int y) {
        this.x = x;
        this.y = y; 
    }
}
