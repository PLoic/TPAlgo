package Bench;

public class AVLTree {

	private Node root;

	private class Node {
		private String val;
		private Node left, right;
		private int height;

		public Node(String val) {
			this.val = val;
			this.height = 0;
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

		public int getHeight() {
			return height;
		}

		public void setHeight(int newHeight) {
			height = newHeight;
		}
	}

	private int calculHeight(Node node) {
		if (node == null) {
			return -1;
		}
		return node.getHeight();
	}

	public void insert(String val) {
		root = insert(root, val);
	}

	private Node insert(Node node, String val) {
		if (node == null) {
			node = new Node(val);
		} else if (node.getVal().compareTo(val) >= 0) {
			node.setLeft(insert(node.getLeft(), val));
			if (calculHeight(node.getLeft()) - calculHeight(node.getRight()) == 2) {
				if (node.getLeft().getVal().compareTo(val) > 0) {
					node = rotateLeftChild(node);
				} else {
					node = doubleRotateLeftChild(node);
				}
			}
		} else {
			node.setRight(insert(node.getRight(), val));
			if (calculHeight(node.getRight()) - calculHeight(node.getLeft()) == 2) {
				if (node.getRight().getVal().compareTo(val) < 0) {
					node = rotateRightChild(node);
				} else {
					node = doubleRotateRightChild(node);
				}
			}
		}
		node.setHeight(max(calculHeight(node.getLeft()),
				calculHeight(node.getRight())) + 1);
		return node;
	}

	private int max(int calculWeight, int calculWeight2) {
		return (calculWeight > calculWeight2) ? calculWeight : calculWeight2;
	}

	private Node rotateRightChild(Node node) {
		if (node.getRight() != null) {
			Node pivot = node.getRight();
			node.setRight(pivot.getLeft());
			pivot.setLeft(node);

			node.setHeight(max(calculHeight(node.getLeft()),
					calculHeight(node.getRight())) + 1);
			pivot.setHeight(max(node.getHeight(),
					calculHeight(pivot.getRight())) + 1);
			return pivot;
		}
		return node;
	}

	private Node rotateLeftChild(Node node) {
		if (node.getLeft() != null) {
			Node pivot = node.getLeft();
			node.setLeft(pivot.getRight());
			pivot.setRight(node);

			node.setHeight(max(calculHeight(node.getLeft()),
					calculHeight(node.getRight())) + 1);
			pivot.setHeight(max(calculHeight(pivot.getLeft()), node.getHeight()) + 1);

			return pivot;
		}
		return node;
	}

	private Node doubleRotateRightChild(Node node) {
		if (node.getRight() != null) {
			node.setRight(rotateLeftChild(node.getRight()));
		}
		return rotateRightChild(node);
	}

	private Node doubleRotateLeftChild(Node node) {
		if (node.getLeft() != null) {
			node.setLeft(rotateRightChild(node.getLeft()));
		}
		return rotateLeftChild(node);
	}

	public void delete(String val) {
		root = delete(null, root, val);
	}

	private Node delete(Node prec, Node node, String val) {
		if (node != null) {
			if (node.getVal().compareTo(val) > 0) {

				node.setLeft(delete(node, node.getLeft(), val));

				if (calculHeight(node.getRight())
						- calculHeight(node.getLeft()) >= 2) {

					int rightRightHeight = calculHeight(node.getRight()
							.getRight());
					int leftLeftHeight = calculHeight(node.getLeft().getLeft());

					if (rightRightHeight >= leftLeftHeight) {
						node = rotateLeftChild(node);
					} else {
						node = doubleRotateRightChild(node);
					}
				}

			} else if (node.getVal().compareTo(val) < 0) {

				node.setRight(delete(node, node.getRight(), val));

				if (calculHeight(node.getLeft())
						- calculHeight(node.getRight()) >= 2) {

					int rightHeight = calculHeight(node.getLeft().getRight());
					int leftHeight = calculHeight(node.getLeft().getLeft());

					if (leftHeight >= rightHeight) {
						node = rotateRightChild(node);
					} else {
						node = doubleRotateLeftChild(node);
					}
				}
			} else {
				if (node.getLeft() == null && node.getRight() == null) {
					if (prec != null) {
						if (prec.getLeft() == node) {
							prec.setLeft(null);
						} else {
							prec.setRight(null);
						}
					}
					node = null;
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
			if (node != null) {
				node.setHeight(max(calculHeight(node.getLeft()),
						calculHeight(node.getRight()) + 1));
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

	public Node search(Node node, String val) {
		if (node == null) {
			return node;
		}

		if (node.getVal().compareTo(val) > 0) {
			return search(node.getLeft(), val);
		} else if (node.getVal().compareTo(val) < 0) {
			return search(node.getRight(), val);
		}
		return node;
	}

	public void print(Node node) {
		if (node != null) {
			System.out.println(node + " pointeur : " + node.getVal()
					+ " ---- hauteur : " + node.getHeight());
			print(node.getLeft());
			print(node.getRight());
		}
	}

	public Node getRoot() {
		return root;
	}

	public AVLTree() {
		root = null;
	}

	/*public static void main(String[] args) {
		AVLTree avl = new AVLTree();

		// avl.insert(12);
		avl.insert("aaaa");
		avl.insert("acda");
		avl.insert("abcd");
		avl.insert("adcb");

		avl.insert("bbbb");
		avl.insert("cccc");
		// avl.insert(11);
		avl.insert("dddd");

		// System.out.println(avl.search(avl.getRoot(), 14));
		// System.out.println(avl.search(avl.getRoot(), 9));
		// avl.delete(5);
		// avl.delete(14);
		//
		System.out.println(avl.getRoot());
		avl.print(avl.getRoot());
	}*/

}
