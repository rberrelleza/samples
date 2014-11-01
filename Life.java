package samples;

import java.io.IOException;
import java.util.Random;

public class Life {

	public int[][] board;
	public int alive;
	public Life(int n, double avg)
	{
		this.board = new int[n][n];
		this.alive = 0;
		Random rand = new Random();
		for(int i = 0; i < this.board.length; i++)
			for(int j = 0; j < this.board[i].length; j++)
			{
				if(rand.nextDouble() > avg)
				{
					this.board[i][j] = 1;
					this.alive++;
				}
			}
	}
	
	public void generation()
	{
		int[][] oldGeneration = new int[this.board.length][this.board[0].length];
		for(int i = 0; i < this.board.length; i++)
		{
			for(int j = 0; j < this.board[i].length; j++)
			{
				oldGeneration[i][j] = this.board[i][j];
			}
		}
		
		for(int i = 0; i < this.board.length; i++)
		{
			for(int j = 0; j < this.board[i].length; j++)
			{
				int neighbors = this.count_neighbors(i,  j, oldGeneration);
				if(neighbors <=1 || neighbors > 3)
				{
					this.board[i][j] = 0;
					this.alive--;
				} 
				else if(neighbors == 3)
				{
					this.board[i][j]++;
					this.alive++;
				}
			}
		}
	}
	
	public int count_neighbors(int x, int y, int[][] board)
	{		
		int neighbors = 0;
		int left = Math.max(0, x - 1);
		int right = Math.min(x + 1, board.length -1);
		int top =  Math.max(0, y - 1);
		int bottom = Math.min(y + 1, board[0].length - 1);
				
		for(int i = left; i <= right; i++)
		{
			for(int j = top; j <= bottom; j++)
			{
				if(i != x || j != y){
					if(board[i][j] > 0)
					{
						neighbors++;
					}
				}
			}
		}
		
		return neighbors;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.board.length; i++){
			for(int j = 0; j < this.board[i].length; j++)
			{
				if(this.board[i][j] > 0)
				{
					sb.append(String.format("  %s  ", this.board[i][j]));
				}else
				{
					sb.append("  *  ");
				}
			}
			sb.append("\n\r");
		}
		
		return sb.toString();
				
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Life life = new Life(6, 0.5);
		System.out.println("Initial!");
		System.out.println(life);	
		
		int i = 0;
		while(true){
			System.out.println(String.format("Generation %s", ++i));
			life.generation();
			System.out.println(life);
			if(life.alive == 0)
			{
				System.out.println("They are all dead Jim!");
				break;
			}
			int input = System.in.read();
			if ((char)input == 'q')
			{
				break;
			}
		}
	}
}
