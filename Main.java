import java.util.Scanner;
import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		int[] gameBoard = new int[9];
		Scanner scanner = new Scanner(System.in);
		int choice;
		int playWith;
		
		do
		{
			System.out.println("1. Computer\n2. Two Players");
			System.out.println("Choose who you want to play with: ");
			playWith = scanner.nextInt();
		} while (playWith < 1 || playWith > 2);
		
		Random random = new Random();
		boolean playerOneTurn = random.nextBoolean();
		
		while(!Game.isOver(gameBoard) && playWith == 1)
		{
			Game.printBoard(gameBoard);
			if (playerOneTurn)
			{	
				do
				{
				System.out.println("Player 1, enter your choice: ");
				choice = scanner.nextInt();
				} while (choice < 1 || choice > 9);
				
				choice--;
				
				if (gameBoard[choice] == 1 || gameBoard[choice] == 2)
				{
					System.out.println("Square already marked.");
					continue;
				}
				
				gameBoard[choice] = 1;
				playerOneTurn = false;	
			}
			else if (!playerOneTurn)
			{
				do
				{
				choice = random.nextInt() % 10;
				} while (choice < 1 || choice > 9);
				
				choice--;
				
				if (gameBoard[choice] == 1 || gameBoard[choice] == 2)
				{
					continue;
				}
				
				gameBoard[choice] = 2;
				playerOneTurn = true;	
			}
		}
		
		while (!Game.isOver(gameBoard) && playWith == 2)
		{
			Game.printBoard(gameBoard);
			
			if (playerOneTurn)
			{	
				do
				{
				System.out.println("Player 1, enter your choice: ");
				choice = scanner.nextInt();
				} while (choice < 1 || choice > 9);
				
				choice--;
				
				if (gameBoard[choice] == 1 || gameBoard[choice] == 2)
				{
					System.out.println("Square already marked.");
					continue;
				}
				
				gameBoard[choice] = 1;
				playerOneTurn = false;	
			}
			else if (!playerOneTurn)
			{
				do
				{
				System.out.println("Player 2, enter your choice: ");
				choice = scanner.nextInt();
				} while (choice < 1 || choice > 9);
				
				choice--;
				
				if (gameBoard[choice] == 1 || gameBoard[choice] == 2)
				{
					System.out.println("Square already marked.");
					continue;
				}
				
				gameBoard[choice] = 2;
				playerOneTurn = true;
			}
		}
		scanner.close();
	}
}
