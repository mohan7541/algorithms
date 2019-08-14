package com.amazon;

/**
 * 
 * @author Mohanraja
 * https://www.hashnopolis.com/post/2019/03/subtree-with-maximum-average/
 * Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
Example Given a binary tree:

       2 ​ 
     /   \ 
  -2       14 
  / \      / \ 
-1  1     5  -1
 *
 *return the node 14.
 */
public class MaxAverageNode {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);  
	    root.left = new TreeNode(-2);  
	    root.right = new TreeNode(14);  
	    root.left.left = new TreeNode(-1);  
	    root.left.right = new TreeNode(1);  
	    root.right.left = new TreeNode(5);  
	    root.right.right = new TreeNode(-1);  
	    
	    MaxAverageNode maxAvgNode = new MaxAverageNode();
	    TreeNode subTree = maxAvgNode.findSubTree(root);
	    System.out.println("Value::"+subTree.value);
	    
	}

	public class ResultType {
		TreeNode node;
		public int sum, size;
		double maxAve;
		
		public ResultType(int sum, int size, double maxAve, TreeNode node) {
			this.node = node;
			this.sum = sum;
			this.size = size;
			this.maxAve = maxAve;
		}
	}

	
	
	public TreeNode findSubTree(TreeNode root) {
		if(root == null)
			return null;
		ResultType ans = helper(root);
		System.out.println("max avg::"+ans.maxAve);
		return ans.node;
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
            return new ResultType(0, 0, Integer.MIN_VALUE, null);
        }
		
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		int sum = root.value + left.sum + right.sum;
		int numNodes = left.size + right.size + 1;
		double ave = (double) sum / numNodes;
		TreeNode node = null;
		
		if(ave > left.maxAve && ave > right.maxAve) {
			node = root;
		} else if (left.maxAve > ave && left.maxAve > right.maxAve ) {
			ave = left.maxAve;
			node = left.node;
		} else {
			ave = right.maxAve;
			node = right.node;
		}
		return new ResultType(sum, numNodes, ave, node);
	}
}
class TreeNode {
	public int value;
	public TreeNode left, right;

	public TreeNode(int value) {
		this.value = value;
		this.left = this.right = null;
	}
}