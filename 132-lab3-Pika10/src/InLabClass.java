import java.util.Arrays;
import java.util.Random;

public class InLabClass {
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
	
	
	
	public static void inLabProblem(String[] args)
	{
		
		int fullTours=0;
		for (int j=0;j<Integer.parseInt(args[2]);j++)
		{
			int [][] access =
				{{2, 3, 4, 4, 4, 4, 3, 2},
				{3, 4, 6, 6, 6, 6, 4, 3},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{3, 4, 6, 6, 6, 6, 4, 3},
				{2, 3, 4, 4, 4, 4, 3, 2}};
		boolean thereIsMove=false;
		int myMin=9;
		int minMove=0;
		
		generatingBoard(8);
		do {
		for (int i=0;i<8;i++)
		{
		if (currentRow+vertical[i]<8 && currentRow+vertical[i]>=0 && currentCol+horizontal[i]<8&&currentCol+horizontal[i]>=0)
		{
			if (board[currentRow+vertical[i]][currentCol+horizontal[i]]==0)
			{
				
				if (myMin > access[currentRow+vertical[i]][currentCol+horizontal[i]])
				{
				myMin=access[currentRow+vertical[i]][currentCol+horizontal[i]];
				minMove=i;
				thereIsMove=true;
				}
				
			}
		}
		
		}
		if (thereIsMove ==true)
		{
			for (int i=0;i<8;i++)
			{
				if (currentRow+vertical[i]<8 && currentRow+vertical[i]>=0 && currentCol+horizontal[i]<8&&currentCol+horizontal[i]>=0)
				{
					if (board[currentRow+vertical[i]][currentCol+horizontal[i]]==0)
					{
						access[currentRow+vertical[i]][currentCol+horizontal[i]]-=1;
					}
				}
			}
			currentRow += vertical[minMove];
			currentCol += horizontal[minMove];
			counter+=1;
			board[currentRow][currentCol]=counter;
			
			myMin=9;
			minMove=0;
			if (counter==64)
			{
				fullTours+=1;
			}
		}
		else
		{
			gameEnds=true;
			
		}
		thereIsMove=false;
	}
		while(gameEnds==false);
		thereIsMove=false;
		myMin=9;
		minMove=0;
		System.out.printf("Trial no %d%n",j);
		PrintEnd();
		}
		System.out.printf("There are %d full tours in %s trials%n",fullTours,args[2]);
		}
	
	
	
}

