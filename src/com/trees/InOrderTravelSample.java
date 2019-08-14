package com.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * In order traversal of Binary Tree will be like LEFT Child-> ROOT -> RIGHT Child  
 * @author Mohan Raja Reddy
 *
 */
public class InOrderTravelSample {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(7);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(8);
		
		InOrderTravelSample inorder = new InOrderTravelSample();
	}
	
	public void iterativeMethod(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode p = root;
		while(p != null) {
			stack.push(p.left);
			p = p.left;
		}
		
		while(!stack.isEmpty()) {
			TreeNode t = stack.pop();
			result.add(t.value);
			
			t = t.right;
			while(t != null) {
				stack.push(t);
				t = t.left;
			}
		}
	}
	
	public void recursiveMethod(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root != null) {
			traverse(root, result);
		}
		
		
	} 
	public void traverse(TreeNode t, List<Integer> result) {
		if(t.left != null) {
			traverse(t.left, result);
		}
		result.add(t.value);
		if(t.right != null) {
			traverse(t.right, result);
		}
		
	}
}
