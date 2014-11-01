package samples;

import java.util.HashMap;

public class Fibonnacci {

	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public int recursion(int n)
	{
		if (n == 1 || n == 2)
		{
			return 1;
		}else{
			return this.recursion(n -1) + this.recursion(n - 2);
		}
	}
	
	public int recursion_lookup(int n)
	{
		if (n == 1 || n == 2)
		{
			return 1;
		}else{
			if(!this.map.containsKey(n)){
				int fibb =  this.recursion(n -1) + this.recursion(n - 2);
				this.map.put(n, fibb);
			}
			
			return this.map.get(n);
		}
	}
	
	
	public int loop(int n)
	{
		if (n == 1 || n == 2)
		{
			return 1;
		}else{
			int fibo1 = 1, fibo2 = 1, total = 1;
			for(int i = 3; i <= n; i++)
			{
				total = fibo1 + fibo2;
				fibo1 = fibo2;
				fibo2 = total;	
			}
			
			return total;
		}
		
	}
	public static void main(String[] args) throws Exception {
		int n = 30;
		Fibonnacci f = new Fibonnacci();
		System.out.println("Recursion");
		long startTime = System.nanoTime();
		for(int i = 1; i < n; i++)
		{
			System.out.print(f.recursion(i) + " ");	
		}
		
		long duration = (System.nanoTime() - startTime);
		System.out.println("Took " + duration/1000);
		
		System.out.println("Loop");
		startTime = System.nanoTime();
		for(int i = 1; i < n; i++)
		{
			System.out.print(f.loop(i) + " ");	
		}
		
		duration = (System.nanoTime() - startTime);
		System.out.println("Took " + duration/1000);
		
		System.out.println("Recursion with lookup");
		startTime = System.nanoTime();
		for(int i = 1; i < n; i++)
		{
			System.out.print(f.recursion_lookup(i) + " ");	
		}
		
		duration = (System.nanoTime() - startTime);
		System.out.println("Took " + duration/1000);
	}

}
