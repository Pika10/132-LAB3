import java.util.Arrays;
import java.util.Random;
public class KnightsTour {
	static Random rand=new Random();
	static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[][] board;
	static int boardLength;
	static boolean gameEnds=false;
	static int currentRow=0;
	static int currentCol=0;
	static int counter=0;
	static int moveNumber=0;
	static boolean reachedOnce=false;
	public static void main(String[] args)
	{
		
		
	}
	
	
	public static void makingMove()
	{
		
		if (currentRow+vertical[moveNumber]<boardLength && currentRow+vertical[moveNumber]>=0 && currentCol+horizontal[moveNumber]<boardLength&&currentCol+horizontal[moveNumber]>=0)
		{
			if (board[currentRow+vertical[moveNumber]][currentCol+horizontal[moveNumber]]==0)
			{
				currentRow += vertical[moveNumber];
				currentCol += horizontal[moveNumber];
				counter+=1;
				board[currentRow][currentCol]=counter;
				moveNumber=rand.nextInt(8);
				reachedOnce=false;
			}
			else
			{
				moveNumber+=1;
				if (moveNumber>=8)
				{
					if (reachedOnce==true)
					{
						
						
						gameEnds=true;
					}
					else
					{
						reachedOnce=true;
						moveNumber=0;
						makingMove();
					}
					
				}
				else
				{
					makingMove();
				}
				
			}
		}
		else
		{
			moveNumber+=1;
			if (moveNumber>=8)
			{
				if (reachedOnce==true)
				{
					
					
					gameEnds=true;
				}
				else
				{
					reachedOnce=true;
					moveNumber=0;
					makingMove();
				}
				
			}
			else
			{
				makingMove();
			}
		}
		
		
		
	}
	
	public static void generatingBoard(int n)
	{
		board=new int[n][n];
		for (int[] i : board)
		{
			Arrays.fill(i, 0);
		}
		boardLength=board[0].length;
		currentRow= rand.nextInt(n);
		currentCol=rand.nextInt(n);
		counter=0;
		counter+=1;
		reachedOnce=false;
		gameEnds=false;
		board[currentRow][currentCol]=counter;
		moveNumber=rand.nextInt(8);
		
		
	}
	public static void PrintEnd()
	{
		
		System.out.printf("The tour ended with %d moves.%n",counter);
		if (boardLength*boardLength==counter)
		{
			System.out.print("This was a full tour.\n");
		}
		else
		{
			System.out.print("This was not a full tour.\n");
		}
		System.out.print("     ");
		for (int i=0;i<board.length;i++)
		{
			System.out.print(i);
			System.out.print("   ");
		}
		System.out.print("\n");
		System.out.print("\n");
		int myCounter=0;
		for (int[] i : board)
		{
			System.out.print(" ");
			System.out.print(myCounter);
			System.out.print("  ");
			myCounter+=1;
			for (int a :i)
			{
				if (a <10)
				{
					System.out.print(" ");
				}
				System.out.print(a);
				System.out.print("  ");
			}
			System.out.print("\n");
		}
	}
	public static void singleTour(String[] args)
	{
		rand.setSeed(-1);
		int myN=Integer.parseInt(args[0]);
		generatingBoard(myN);
		do 
		{
			makingMove();
		}
		while (gameEnds==false);
		PrintEnd();
	}
	public static void thousandTours(String[] args)
	{
		rand.setSeed(Integer.parseInt(args[1]));
		int myN=Integer.parseInt(args[0]);
		int[] tours = new int[myN*myN];
		Arrays.fill(tours, 0);
		System.out.print("#tours   tour length\n");
		System.out.print("\n");
		for (int i=0;i<1000;i++)
		{
			generatingBoard(myN);
			do 
			{
				makingMove();
			}
			while (gameEnds==false);
			tours[counter-1]+=1;
		}
		for (int i=1;i<(myN*myN)+1;i++)
		{
			System.out.printf("%-10d%d %n",tours[i-1],i);
		}
		
	}
	public static void fullTour(String[] args)
	{
		rand.setSeed(Integer.parseInt(args[1]));
		int myN=Integer.parseInt(args[0]);
		int myTours=0;
		int[] tours = new int[myN*myN];
		Arrays.fill(tours, 0);
		System.out.print("#tours   tour length\n");
		System.out.print("\n");
		do 
		{
			myTours+=1;
			generatingBoard(myN);
			do 
			{
				makingMove();
			}
			while (gameEnds==false);
			tours[counter-1]+=1;
		}
		while (counter!=myN*myN);
		for (int i=1;i<((myN*myN)+1);i++)
		{
			System.out.printf("%-10d%d %n",tours[i-1],i);
		}
		System.out.print("\n");
		System.out.printf("It took %d tries to get a full tour\n",myTours);
	}
	
	
	
	
}
