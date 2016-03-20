package ch4;
public class PreInPostorder {

	/**
	 * ����һ�ö������������ǰ�����򡢺�����������
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


// ������
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
	
//ǰ�����
	public void preOrder(BinaryNode root) {
		if (root != null) {
			visit(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
//�������
	 void inOrder(BinaryNode root){
		 if (root != null) {
				inOrder(root.left);
				visit(root);
				inOrder(root.right);
			}
	 }
//�������	 
	 void postOrder (BinaryNode root){
		 if (root != null) {
				postOrder(root.left);
				postOrder(root.right);
				visit(root);
			}
	 }
//����
	void visit(BinaryNode node) {
		System.out.print(node.element);
	}

}


// �������ڵ�
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