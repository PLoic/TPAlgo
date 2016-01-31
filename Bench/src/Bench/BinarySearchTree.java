package Bench;

public class BinarySearchTree {

	private Node root;

	private class Node {

		private String val;
		private Node left, right;

		public Node(String val) {
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

		public String getVal() {
			return val;
		}
	}

	public BinarySearchTree(String val) {
		this.root = new Node(val);
	}

	public Node search(Node node, String val) {
		if (node == null) {
			return node;
		}

		if (node.getVal().compareTo(val) < 0) {
			return search(node.getLeft(), val);
		} else if (node.getVal().compareTo(val) > 0) {
			return search(node.getRight(), val);
		}
		return node;
	}

	public Node getRoot() {
		return root;
	}

	public void delete(String val) {
		root = delete(null, root, val);
	}

	public Node delete(Node prec, Node node, String val) {
		if (node == null) {
			return null;
		}
		if (node.getVal().compareTo(val) < 0) {
			delete(node, node.getLeft(), val);
		} else if (node.getVal().compareTo(val) > 0) {
			delete(node, node.getRight(), val);
		} else {
			if (node.getLeft() == null && node.getRight() == null) {
				if (prec != null) {
					if (prec.getLeft() == node) {
						prec.setLeft(null);
					} else {
						prec.setRight(null);
					}
				} else {
					node = null;
				}
			} else if (node.getRight() == null) {
				Node tmp = node;
				node = getMax(tmp.getLeft());
				node.setLeft(deleteMax(tmp.getLeft()));
				if (prec != null) {
					if (prec.getLeft() == tmp) {
						prec.setLeft(node);
					} else {
						prec.setRight(node);
					}
				}
			} else {
				Node tmp = node;
				node = getMin(tmp.getRight());
				node.setRight(deleteMin(tmp.getRight()));
				node.setLeft(tmp.getLeft());
				if (prec != null) {
					if (prec.getLeft() == tmp) {
						prec.setLeft(node);
					} else {
						prec.setRight(node);
					}
				}
			}
		}
		return node;
	}

	private Node deleteMax(Node node) {
		if (node.getRight() == null)
			return node.getLeft();
		node.setRight(deleteMax(node.getRight()));
		return node;
	}

	private Node deleteMin(Node node) {
		if (node.getLeft() == null) {
			return node.getRight();
		}
		node.setLeft(deleteMin(node.getLeft()));
		return node;
	}

	private Node getMin(Node node) {
		if (node.getLeft() == null)
			return node;
		return getMin(node.getLeft());
	}

	private Node getMax(Node node) {
		if (node.getRight() == null) {
			return node;
		}
		return getMax(node.getRight());
	}

	public void insert(Node prec, Node node, String val) {
		if (node == null) {
			node = new Node(val);
			if (prec.getVal().compareTo(val) < 0) {
				prec.setLeft(node);
			} else {
				prec.setRight(node);
			}
		} else {
			if (node.getVal().compareTo(val) < 0) {
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

	/*public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree(5);

		bst.insert(null, bst.getRoot(), 3);
		bst.insert(null, bst.getRoot(), 2);
		bst.insert(null, bst.getRoot(), 12);
		bst.insert(null, bst.getRoot(), 7);
		bst.insert(null, bst.getRoot(), 9);
		bst.insert(null, bst.getRoot(), 11);
		bst.insert(null, bst.getRoot(), 14);
		bst.insert(null, bst.getRoot(), 6);

		// bst.print(bst.getRoot());

		// System.out.println(bst.search(bst.getRoot(), 14));
		// System.out.println(bst.search(bst.getRoot(), 9));

		bst.delete(5);
		bst.print(bst.getRoot());

	}*/

}
