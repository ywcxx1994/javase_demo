package com.yw.structure.bst;

/**
 * 二分搜索树 bary serch tree
 *
 * @author 18765
 */
public class BST<E extends Comparable<E>> {
    class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

    }

    private Node root;//根节点

    private int size;

    public int getSize() {
        return size;
    }

    public Boolean isEmpty() {
        return this.size == 0;
    }

    //添加元素，从根节点开始遍历,递归遍历.
    private Node add(Node node, E e) {
        /*第一版本的写法,返回值为null**/
//		//根节点就是该元素，则不添加
//		if(e.equals(node.e)) 
//			return;
//		//当前添加的元素比当前节点的元素小,左子节点为null
//		else if(e.compareTo(node.e)<0 && node.left == null) {
//			node.left = new Node(e);
//			size++;
//		}
//		else if(e.compareTo(node.e) > 0 && node.right == null) {
//			node.right = new Node(e);
//			size++;
//		}
//		//递归遍历
//		if(e.compareTo(node.e)<0) {
//			this.add(node.left, e);
//		}else {
//			this.add(node.right, e);
//		}
        /*优化版本**/
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = this.add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = this.add(node.right, e);
        }
        return node;

    }

    public void add(E e) {
//		if(this.root == null) {
//			root = new Node(e);
//			size++;
//		}else {
//			this.add(root, e);
//		}
        this.root = this.add(root, e);

    }

    public boolean constains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return constains(node.left, e);
        } else {
            return constains(node.right, e);
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(10);
        bst.add(13);
        bst.add(15);
    }
}
