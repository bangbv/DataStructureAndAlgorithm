package datastructure.avl_tree;

public class AVLTree {

	AVLNode insert(AVLNode root, int avl) {
		if(root == null) {
			return new AVLNode(avl);
		}else {
			AVLNode cur;
			if(avl <= root.avl) {
				 cur = insert(root.left,avl);
				 root.left = cur;
			}else {
				 cur = insert(root.right,avl);
				 root.right =cur;
			}
			return root;
		}
	}

	private AVLNode rotateLeft(AVLNode x, AVLNode z) {
//        AVLNode k1 = k2.left;
//        k2.left = k1.right;
//        k1.right = k2;
//        
//		t23 = left_child(z);
//		righ_child(x) = t23;
//		if(t23 != null) {
//			parent(t23) = x;
//		}
//		left_child(z) = x;
//		parent(x) = z;
//		if()
		return z;
	}

	private AVLNode rotateRight(AVLNode k) {
		return null;
	}

	private AVLNode rotateRightLeft(AVLNode k) {
		return null;
	}

	private AVLNode rotateLeftRight(AVLNode k) {
		return null;
	}
	
	public int balanceFactory(AVLNode root) {
		// BalanceFactor(N) := Height(RightSubtree(N)) – Height(LeftSubtree(N))
		int ht = 0;
		return ht;
	}
}
