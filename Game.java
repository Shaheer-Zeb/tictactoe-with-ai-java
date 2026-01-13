public class Game
{
	static boolean isOver(int[] gameArray)
	{
		if (p1Wins(gameArray))
		{
			return true;
		}
		if (p2Wins(gameArray))
		{
			return true;
		}
		if (isDraw(gameArray))
		{
			return true;
		}
		return false;
	}

	static boolean p1Wins(int[] gameArray)
	{
		if ((gameArray[0] == 1 && gameArray[1] == 1 && gameArray[2] == 1) || 
		(gameArray[3] == 1 && gameArray[4] == 1 && gameArray[5] == 1) || 
		(gameArray[6] == 1 && gameArray[7] == 1 && gameArray[8] == 1) ||
		(gameArray[0] == 1 && gameArray[3] == 1 && gameArray[6] == 1) ||
		(gameArray[1] == 1 && gameArray[4] == 1 && gameArray[7] == 1) ||
		(gameArray[2] == 1 && gameArray[5] == 1 && gameArray[8] == 1) || 
		(gameArray[0] == 1 && gameArray[4] == 1 && gameArray[8] == 1) ||
		(gameArray[2] == 1 && gameArray[4] == 1 && gameArray[6] == 1))
		{
			printBoard(gameArray);
			System.out.println("Player 1 won.");
			return true;
		}
		return false;
	}
	
	static boolean p2Wins(int[] gameArray)
	{
		if ((gameArray[0] == 2 && gameArray[1] == 2 && gameArray[2] == 2) || 
		(gameArray[3] == 2 && gameArray[4] == 2 && gameArray[5] == 2) || 
		(gameArray[6] == 2 && gameArray[7] == 2 && gameArray[8] == 2) ||
		(gameArray[0] == 2 && gameArray[3] == 2 && gameArray[6] == 2) ||
		(gameArray[1] == 2 && gameArray[4] == 2 && gameArray[7] == 2) ||
		(gameArray[2] == 2 && gameArray[5] == 2 && gameArray[8] == 2) || 
		(gameArray[0] == 2 && gameArray[4] == 2 && gameArray[8] == 2) ||
		(gameArray[2] == 2 && gameArray[4] == 2 && gameArray[6] == 2))
		{
			printBoard(gameArray);
			System.out.println("Player 2 won.");
			return true;
		}
		return false;
	}
	
	static boolean isDraw(int[] gameArray)
	{
		int boxesFilled = 0;
		
		for (int i = 0; i < gameArray.length; i++)
		{
			if (gameArray[i] == 1 || gameArray[i] == 2)
			{
				boxesFilled++;
			}
		}
		
		if (boxesFilled == 9 && (!p1Wins(gameArray) || !p2Wins(gameArray)))
		{
			printBoard(gameArray);
			System.out.println("It's a draw.");
			return true;
		}
		
		return false;
		
	}
	
	static void printBoard(int[] gameBoard)
	{
		for (int i = 0; i < gameBoard.length; i++)
			{
				if (i == 0 || i == 3 || i == 6)
				{
					System.out.print("-------------\n");
				}
				if (i == 0 || i == 3 || i == 6)
				{
					System.out.print("| ");			
				}
				if (gameBoard[i] == 1)
				{
					System.out.print("X " + "| ");
				}
				else if (gameBoard[i] == 2)
				{
					System.out.print("O " + "| ");
				}
				else
				{
					System.out.print(i + 1 + " | ");
				}
				if (i == 2 || i == 5 || i == 8)
				{
					System.out.print("\n");
				}
				if (i == 8)
				{
					System.out.print("-------------\n");
				}
			}
	}
	
}
