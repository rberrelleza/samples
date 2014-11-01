package samples;

public class Queens {

	private int[] queens;
	
	public Queens(int totalQueens)
	{
		this.queens = new int[totalQueens];
		for(int i = 0; i < this.queens.length; i++)
		{
			this.queens[i] = -1;
		}
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder(); 
				
		for(int i = 0; i < queens.length; i++)
		{
			for(int j = 0; j < queens.length; j++)
			{
				if(this.queens[i] == j)
				{
					sb.append("Q  ");
				}
				else
				{
					sb.append("*  ");
				}
			}
			
			sb.append("\n\r");
		}
		
		return sb.toString();
	}
	
	public Boolean isSafe(int column, int row)
	{
		for(int i = 0; i <= column; i++ )
		{
			if(this.queens[i] == row)
			{
				return false;
			}
			
			if(Math.abs(i - column) == Math.abs(this.queens[i] - row))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void placeQueen(int column)
	{
		if(column == this.queens.length)
		{
			System.out.println("Solved! ");
			System.out.println(this.toString());
			System.out.println();
		}
		else
		{
			for(int i = 0; i < this.queens.length; i++)
			{
				if(this.isSafe(column, i))
				{
					System.out.println(String.format("%s,%s is safe", column, i));
					this.queens[column] = i;
					placeQueen(column + 1);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Queens q = new Queens(8);
		q.placeQueen(0);
	}
}
