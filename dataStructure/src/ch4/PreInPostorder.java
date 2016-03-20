package ch4;
public class PreInPostorder {

	/**
	 * 建立一棵二叉树，并输出前序、中序、后序遍历结果。
	 *                 a
	 *                / \
	 *               b   c
	 *              / \   \
	 *             d   e   f
	 */
	public static void main(String[] args) {
		BinaryNode d=new BinaryNode('d', null, null);
		BinaryNode e=new BinaryNode('e', null, null);
		BinaryNode f=new BinaryNode('f', null, null);
		BinaryNode b=new BinaryNode('b', d, e);
		BinaryNode c=new BinaryNode('c', null, f);
		BinaryNode a=new BinaryNode('a', b, c);
		BinaryTree tr=new BinaryTree(a);
		tr.preOrder(tr.root);
		System.out.println();
		tr.inOrder(tr.root);
		System.out.println();
		tr.postOrder(tr.root);
		System.out.println();
	}

}


// 二叉树
class BinaryTree {
	BinaryNode root;

	public BinaryTree(){}
	
	public BinaryTree(BinaryNode n){
		root=n;
	}
	
	public boolean isEmpty() {
		return ((root == null) ? false : true);
	}

	 public void makeTree(Object e, BinaryTree left, BinaryTree right) {
	 root = new BinaryNode(e, left.root, right.root);
	 }
	
//前序遍历
	public void preOrder(BinaryNode root) {
		if (root != null) {
			visit(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
//中序遍历
	 void inOrder(BinaryNode root){
		 if (root != null) {
				inOrder(root.left);
				visit(root);
				inOrder(root.right);
			}
	 }
//后序遍历	 
	 void postOrder (BinaryNode root){
		 if (root != null) {
				postOrder(root.left);
				postOrder(root.right);
				visit(root);
			}
	 }
//访问
	void visit(BinaryNode node) {
		System.out.print(node.element);
	}

}


// 二叉树节点
class BinaryNode {
	Object element;
	BinaryNode left; // left subtree
	BinaryNode right; // right subtree

	BinaryNode() {
	}

	BinaryNode(Object e) {
		element = e;
	}

	BinaryNode(Object e, BinaryNode l, BinaryNode r) {
		element = e;
		left = l;
		right = r;
	}

}