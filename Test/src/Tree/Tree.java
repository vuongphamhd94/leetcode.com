package Tree;

import java.util.ArrayList;

public class Tree {
	private TreeNode root;
	private int count;

	// them node
	public void insert(int date) {
		if (this.root == null)
			this.root = new TreeNode(date);
		else
			root.insert(date);
	}

	// tim kiem
	public TreeNode search(int data) {
		TreeNode temp = this.root;
		while (temp != null) {
			if (temp.getData() == data)
				break;

			if (temp.getData() > data)
				temp = temp.getLeftChild();
			else
				temp = temp.getRightChild();
		}
		return temp;
	}

	/*
	 * Xoa phan tu
	 */

	public void delete(int data) {
		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;

		if (current == null)
			return;

		while (current != null && current.getData() != data) {
			parent = current;

			if (current.getData() > data) {
				current = current.getLeftChild();
				isLeftChild = true;
			} else {
				current = current.getRightChild();
				isLeftChild = false;
			}
		}
		// truong hop node can xoa khong tonn tai
		if (current == null)
			return;

		// truong hop node can xoa la la

		if (current.getLeftChild() == null && current.getRightChild() == null) {
			if (current == root)
				root = null;
			else {
				if (isLeftChild)
					parent.setLeftChild(null);
				else
					parent.setRightChild(null);
			}
		} else {
			// node xoa co 1 node con ben trai
			if (current.getLeftChild() == null) {
				if (current == root)
					root = current.getRightChild();
				else {
					if (isLeftChild)
						parent.setLeftChild(current.getRightChild());
					else
						parent.setRightChild(current.getRightChild());
				}
			} else
			// node xoa co mot node con ben phai
			if (current.getRightChild() == null) {
				if (current == root)
					root = current.getLeftChild();
				else {
					if (isLeftChild)
						parent.setLeftChild(current.getLeftChild());
					else
						parent.setRightChild(current.getLeftChild());
				}
			} else {
				// node xoa co hai node con => tim node the mang(gia tri nho nhat ben phai hoac
				// lonn nhat benn trai)
				TreeNode changerP = current.getRightChild();
				TreeNode changer = current.getRightChild();
				while (changer.getLeftChild() != null) {
					changerP = changer;
					changer = changer.getLeftChild();
				}

				if (current == root) {
					changer.setLeftChild(root.getLeftChild());
					if (changerP == changer) {
						root = changer;
					} else {
						changerP.setLeftChild(changer.getRightChild());
						changer.setRightChild(current.getRightChild());
						root = changer;
					}
				} else {
					changer.setLeftChild(current.getLeftChild());

					if (changer != changerP) {
						changerP.setLeftChild(changer.getRightChild());
						changer.setRightChild(current.getRightChild());
					}

					if (isLeftChild)
						parent.setLeftChild(changer);
					else
						parent.setRightChild(changer);
				}
			}
		}
	}
	// duyet cay

	public ArrayList<Integer> preOrder() {
		TreeNode current = root;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		PreOrder(arr, current);
		return arr;

	}

	private void PreOrder(ArrayList<Integer> arr, TreeNode node) {
		if (node == null)
			return;

		arr.add(node.getData());
		PreOrder(arr, node.getLeftChild());
		PreOrder(arr, node.getRightChild());
	}

	public ArrayList<Integer> inOrder() {
		TreeNode current = root;
		ArrayList<Integer> arr = new ArrayList<Integer>();

		InOrder(arr, current);
		return arr;
	}

	private void InOrder(ArrayList<Integer> a, TreeNode node) {
		if (node == null)
			return;

		if (node.getLeftChild() != null)
			InOrder(a, node.getLeftChild());

		a.add(node.getData());

		if (node.getRightChild() != null)
			InOrder(a, node.getRightChild());

	}

	public ArrayList<Integer> postOrder() {
		TreeNode current = root;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		PostOrger(arr, current);
		return arr;
	}

	private void PostOrger(ArrayList<Integer> arr, TreeNode node) {
		if (node == null)
			return;

		if (node.getLeftChild() != null)
			PostOrger(arr, node.getLeftChild());

		if (node.getRightChild() != null)
			PostOrger(arr, node.getRightChild());

		arr.add(node.getData());
	}

	// dem nut la
	public int nutLa() {
		this.count = 0;
		TreeNode current = this.root;
		NutLa(current);
		return this.count;
	}

	private void NutLa(TreeNode node) {
		if (node.getLeftChild() == null && node.getRightChild() == null)
			this.count++;

		if (node.getLeftChild() != null)
			NutLa(node.getLeftChild());

		if (node.getRightChild() != null)
			NutLa(node.getRightChild());
	}

	public TreeNode getRoot() {
		return root;
	}
	/*
	 * xoay ben trai
	 */

	public void avlL(TreeNode temp) {
		TreeNode l = temp.getLeftChild();
		temp.setLeftChild(l.getRightChild());
		l.setRightChild(temp);
		if (temp == this.root)
			this.root = l;
	}

	/*
	 * xoay ben phai
	 */

	public void avlR(TreeNode temp) {

		TreeNode r = temp.getRightChild();
		temp.setRightChild(r.getLeftChild());
		r.setLeftChild(temp);
		if (temp == root) {
			root = r;
		}
	}
	
	public TreeNode seachParent(TreeNode node) {
		TreeNode current = root;
		TreeNode parent = root;
		if(current == root)
			return root;
		
		while(current == node) {
			parent = current;
			
			if(current.getData() > node.getData())
				current = current.getLeftChild();
			else
				current = current.getRightChild();
		}
		
		return parent;
		
	}
}
