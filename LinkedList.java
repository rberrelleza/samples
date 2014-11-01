package samples;

import java.util.Random;
import java.util.Stack;

import samples.BinaryTree.Node;

public class LinkedList<T extends Comparable> {
	public Node<T> root;
	
	class Node<T> {
		
		public Node(T value){
			this.value = value;
		}
		
		public Node<T> next;
		public T value;
	}
	
	public void add(T value){
		Node<T> newNode = new Node<T>(value);
		if (this.root == null){
			this.root = newNode;
		}else
		{
			Node<T> temp = this.root;
			while(temp.next != null){
				temp = temp.next;
			}
			
			temp.next = newNode;
		}
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		Node<T> temp = this.root;
		while(temp != null){
			str.append(temp.value + ", ");
			temp = temp.next;
		}

		
		return str.toString();
	}
	
	public String backwards()
	{
		StringBuilder str = new StringBuilder();
		Stack<T> stack = new Stack<T>();
		Node<T> temp = this.root;
		while(temp != null)
		{
			stack.push(temp.value);
			temp = temp.next;
		}
		
		while(!stack.isEmpty()){
			str.append(stack.pop() + " ");
		}
		
		return str.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> test = new LinkedList<Integer>();
		Random rand = new Random();
		String numbers = "";
		for(int i = 0; i < 5; i++)
		{
			int number = rand.nextInt(100);
			numbers = numbers + " " + number;
			test.add(number);
		}
		
		System.out.println(numbers);
		System.out.println(test);
		System.out.println(test.backwards());
	}

}
