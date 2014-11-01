package samples;

import java.util.Scanner;

public class ConnectFourGame {

	private ConnectFourBoard board;
	private Player current;
	private GameState gameState;

	public enum GameState
	{
		Active, Win, Tie;
	}
	
	public enum Player
	{
		Red,Black
	}
	
	public class ConnectFourBoard
	{
		private Player[][] board;
		
		public ConnectFourBoard(int columns, int rows)
		{
			board = new Player[columns][rows];
		}
		
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < this.board.length; i++)
			{
				for(int j = 0; j < this.board[i].length; j++)
				{
					String value = "";
					
					if (this.board[i][j] != null)
					{
						value = this.board[i][j].toString();
					}
					sb.append(String.format("%1$-" + 10 + "s", value) + "|");
				}
				
				sb.append("\n\r");
			}
			
			return sb.toString();
		}

		public Boolean move(Player current, int column) throws Exception {
			if(column < 0 || column > this.board.length)
			{
				throw new Exception("Invalid column");
			}else if(this.board[0][column] != null)
			{
				throw new Exception("Column is full");
			}

			for(int i = this.board.length - 1; i>= 0; i--)
			{
				if(this.board[i][column] == null)
				{
					this.board[i][column] = current;
					return this.gameOver(current, i, column);
				}
			}
			
			return false;
		}
		
		public Boolean isBoardFull()
		{
			Boolean isFull = this.board[0][0] != null;
			for(int i = 1; i < this.board[0].length; i++)
			{
				isFull = isFull && (this.board[0][i] != null);
			}
			
			return isFull;
		}
		
		public Boolean gameOver(Player player, int x, int y)
		{
			return this.checkHorizontal(player, x,y) || this.checkVertical(player, x, y) || this.checkDiagonal(player, x, y);
		}
		
		private Boolean checkHorizontal(Player player, int x, int y)
		{
			for(int i = 0; i < this.board.length; i++)
			{
				int consecutive = 0;
				for(int j = 0; j < this.board[i].length; j++)
				{
					if(this.board[i][j] == player)
					{
						if (++consecutive == 4)
						{
							return true;
						}
					}
					else
					{
						consecutive = 0;
					}
				}
			}
			
			return false;
		}
		
		private Boolean checkVertical(Player player, int x, int y)
		{
			for(int i = 0; i < this.board[0].length; i++)
			{
				int consecutive = 0;
				for(int j = 0; j < this.board.length; j++)
				{
					if(this.board[j][i] == player)
					{
						if(++consecutive == 4)
						{
							return true;
						}
					}
					else
					{
						consecutive = 0;
					}
				}
			}
			
			return false;
		}
		
		private Boolean checkDiagonal(Player player, int x, int y)
		{
			for(int column = 0; column < this.board[0].length; column++)
			{
				int consecutive = 0;
				for(int i = column, j = 0; i < this.board[0].length && j < this.board.length; i++, j++)
				{
					System.out.print(i +  "," + j + " ");
					
					if(this.board[j][i] == player)
					{
						if(++consecutive == 4)
						{
							return true;
						}
					}else
					{
						consecutive = 0;
					}
				}
				
				System.out.println();
			}
			
			System.out.println();
			
			for(int column = 0; column < this.board[0].length; column++)
			{
				int consecutive = 0;
				for(int i = column, j = this.board.length - 1; i < this.board[0].length && j >= 0; i++, j--)
				{
					System.out.print(i +  "," + j + " ");
					
					if(this.board[j][i] == player)
					{
						if(++consecutive == 4)
						{
							return true;
						}
					}else
					{
						consecutive = 0;
					}
				}
				
				System.out.println();
			}
			
			return false;
		}
	}
	
	public ConnectFourGame()
	{
		this.board = new ConnectFourBoard(7, 6); 
		this.current = Player.Red;
		this.gameState = GameState.Active;
	}
	
	public void move(int column) throws Exception
	{	
		if(!this.board.move(this.current, column))
		{
			if (this.board.isBoardFull())
			{
				this.gameState = GameState.Tie;
			}
			if (this.current == Player.Red){
				this.current = Player.Black;
			}else
			{
				this.current = Player.Red;
			}
		}
		else
		{
			this.gameState = GameState.Win;
		}
	}
	
	public String toString()
	{
		return this.board.toString();
	}
	
	public GameState GameState()
	{
		return this.gameState;
	}
	
	public Player Current(){
		return this.current;
	}
	
	public static void main(String[] args) {
		System.out.println("Staring a new game! \n");
		ConnectFourGame game = new ConnectFourGame();
		Scanner sc = new Scanner(System.in);
		while(game.gameState == GameState.Active)
		{
			System.out.println(game);
			System.out.println("Your turn "  + game.Current() + " select the column to drop the piece [0-6]");
			while(true){
				while (!sc.hasNextInt()) sc.next();
			    int column = sc.nextInt();
			    try {
					game.move(column);
					break;
				} catch (Exception e) {				
					System.err.println(e.getMessage());
				}
			}
		}
		
		if (game.gameState == GameState.Win)
		{
			System.out.println("Game over, the winner is: " + game.Current());
		}else if (game.gameState == GameState.Tie)
		{
			System.out.println("Game over, it's a Tie!");
		}
		
		System.out.println(game);
		
		sc.close();
	}

}
