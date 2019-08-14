package com.ms;

public class MirrorTree {

	private TreeNode root;

	public static void main(String[] args) {
		MirrorTree mt = new MirrorTree();
		mt.createSampleTree();
		mt.inOrder();
		mt.convertToMirror();
		
		mt.inOrder();
	}

	private void convertToMirror() {
		if(root != null) {
			convertToMirror(root.getLeft());
			convertToMirror(root.getRight());
			
			//Interchage left and right subtree root nodes
			TreeNode t = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(t);
		}
		
	}

	private void convertToMirror(TreeNode left) {
		
	}

	private void inOrder() {
		inOrder(root);
		System.out.println();
	}

	/**
	 * 
	 * 						1
	 * 					2			3
	 * 				4			5
	 * 
	 * 
	 */
	public void createSampleTree() {
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), null));
	}
	
	public void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.getLeft());
			System.out.println(root.getData() + " ");
			inOrder(root.getRight());
		}
	}

}

class TreeNode {

	private int data;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}

	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

}
