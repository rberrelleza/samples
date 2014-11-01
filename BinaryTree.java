package samples;

import java.util.Random;

public class BinaryTree<T extends Comparable<T>> {

	public Node<T> root;
	
	@SuppressWarnings("hiding")
	class Node<T> {
		
		public Node(T value){
			this.value = value;
		}
		public Node<T> left;
		public Node<T> right;
		public T value;
	}
	
	public void add(T value) throws Exception{
		if (value == null){
			throw new Exception("Bad value!");
		}
		
		if (root == null){
			this.root = new Node<T>(value);
		}else{
			Node<T> newNode= new Node<T>(value);
			this.add(root, newNode);
		}
	}
	
	private void add(Node<T> root, Node<T> newNode)
	{
		if (newNode.value.compareTo(root.value) < 0){
			if (root.left == null){
				root.left = newNode;
			}
			else
			{
				this.add(root.left, newNode);
			}
		}else{
			if (root.right == null){
				root.right = newNode;
			}
			else{
				this.add(root.right, newNode);
			}
		}
		
	}
	
	public void inOrder()
	{
		this.inOrder(this.root);
	}
	
	private void inOrder(Node<T> root){
		if (root != null){
			System.out.println(root.value);
			inOrder(root.left);
			inOrder(root.right);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 100; i++){
			tree.add(rand.nextInt(1000));
		}

		tree.inOrder();
	}

}
