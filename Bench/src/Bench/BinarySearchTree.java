package Bench;

public class BinarySearchTree {

	private Node root;

	private class Node {

		private int val;
		private Node left, right;

		public Node(int val) {
			this.val = val;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getVal() {
			return val;
		}
	}

	public BinarySearchTree(int val) {
		this.root = new Node(val);
	}

	public Node search(Node node, int val) {
		if (node == null) {
			return node;
		}

		if (node.getVal() > val) {
			return search(node.getLeft(), val);
		} else if (node.getVal() < val) {
			return search(node.getRight(), val);
		}
		return node;
	}
	
	public Node getRoot() {
		return root;
	}

	public Node delete(Node prec, Node node, int val) {
		if (node == null) {
			return null;
		}
		if (node.getVal() > val) {
			delete(node, node.getLeft(), val);
		} else if (node.getVal() < val) {
			delete(node, node.getRight(), val);
		}
		balance(prec, node);
		return node;
	}
	
	public void balance(Node prec, Node node) {
		if (prec.getLeft() == node) {
			prec.setLeft(getMin(node));
		} else {
			prec.setRight(getMin(node));
		}
	}
	
	private Node getMin(Node node) {
		Node tmp = null;
		for(tmp = node.getLeft(); tmp.getRight() != null; tmp = tmp.getRight());
		return tmp;
	}
	
	public void insert(Node prec, Node node, int val) {
		if (node == null) {
			node = new Node(val);
			if (prec.getVal() >= val) {
				prec.setLeft(node);
			} else {
				prec.setRight(node);
			}
		} else {
			if (node.getVal() >= val) {
				insert(node, node.getLeft(), val);
			} else {
				insert(node, node.getRight(), val);
			}
		}
	}

	
	public void print(Node node) {
		if (node != null) {
			System.out.println(node + " pointeur : " + node.getVal());
			print(node.getLeft());
			print(node.getRight());
		}
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree(5);
		
		bst.insert(null, bst.getRoot(), 3);
		bst.insert(null, bst.getRoot(), 2);
		bst.insert(null, bst.getRoot(), 12);
		bst.insert(null, bst.getRoot(), 4);
		bst.insert(null, bst.getRoot(), 7);
		bst.insert(null, bst.getRoot(), 9);
		bst.insert(null, bst.getRoot(), 11);
		bst.insert(null, bst.getRoot(), 14);
		bst.insert(null, bst.getRoot(), 6);
		
		bst.print(bst.getRoot());
		
		System.out.println(bst.search(bst.getRoot(), 14));
		System.out.println(bst.search(bst.getRoot(), 9));
		
		bst.delete(null, bst.getRoot(), 14);
		bst.print(bst.getRoot());
				
	}
	
}
