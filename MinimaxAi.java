public class MinimaxAi
{
	static int evaluation(int[] gameArray)
	{
		if (Game.p1Wins(gameArray))
		{
			return -10;
		}
		else if (Game.p2Wins(gameArray))
		{
			return 10;
		}
		return 0;
	}
	
	static int minimax(int[] gameArray, boolean isTurnOfComputer)
	{
		int score = evaluation(gameArray);
		
		if (score == 10 || score == -10)
		{
			return score;
		}
		if (Game.isDraw(gameArray))
		{
			return 0;
		}
		
		if (isTurnOfComputer)
		{
			int bestCase = -1000;
			for (int i = 0; i < gameArray.length; i++)
			{
				if (gameArray[i] == 0)
				{
					gameArray[i] = 2;
					bestCase = Math.max(bestCase, minimax(gameArray, !isTurnOfComputer));
					gameArray[i] = 0;
				}
			}
			return bestCase;
		}
		if (!isTurnOfComputer)
		{
			int bestCase = 1000;
			for (int i = 0; i < gameArray.length; i++)
			{
				if (gameArray[i] == 0)
				{
					gameArray[i] = 1;
					bestCase = Math.min(bestCase, minimax(gameArray, !isTurnOfComputer));
					gameArray[i] = 0;
				}
			}
			return bestCase;
		}
		return 0;
	}
	
	static int bestMove(int[] gameArray)
	{
		int bestValue = -1000;
		int bestMoveBox = -1;
		
		for (int index = 0; index < gameArray.length; index++)
		{
			if (gameArray[index] == 0)
			{
				gameArray[index] = 2;
				
				int moveValue = minimax(gameArray, false);
				gameArray[index] = 0;
				
				if (moveValue > bestValue)
				{
					bestValue = moveValue;
					bestMoveBox = index;
				}
			}
		}
		return bestMoveBox;
	}
}
