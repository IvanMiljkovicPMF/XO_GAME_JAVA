


public class XO 
{
	
	
	private int[][] fields = new int[3][3];
	
	private int OnTheMove = 1;
	
	private int NumberOfPlayedMoves = 0;
	
	
	
	public XO()
	{
		newGame();
	}
	
	
	public void newGame()
	{
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields.length; j++) {
				fields[i][j] = 0;
			}
		}
		
		OnTheMove = 1;
		NumberOfPlayedMoves = 0;
	}
	
	
	public boolean playMove(int i, int j)
	{
		boolean movePlayed = false;
		
		if(fields[i][j] == 0)
		{
			fields[i][j] = OnTheMove;
			OnTheMove *= -1;
			NumberOfPlayedMoves++;
			movePlayed = true;
			
		}
		
		return movePlayed;
	}
	
	
	public String getMarkOfField(int i, int j)
	{
		if(fields[i][j] == 1)
			return " X ";
		else if(fields[i][j] == -1)
			return " O ";
		else
			return " - ";
	}
	
	public String whoIsOnTheMove()
	{
		if(OnTheMove == 1)
			return " X ";
		else 
			return " O ";
	}
	
	public GameStatus getGameStatus()
	{
		int sumRow;
		int sumColumns;
		int sumMainDiagonal = 0;
		int sumCounterDiagonal = 0;
		
		for (int i = 0; i < fields.length; i++) {
			
			sumRow = 0;
			sumColumns = 0;
			
			for (int j = 0; j < fields.length; j++) {
				sumRow += fields[i][j];
				sumColumns += fields[j][i]; 
				
			}
			
			if(sumRow == 3 || sumColumns == 3)
				return GameStatus.WINNER_X;
			
			if(sumRow == -3 || sumColumns == -3)
				return GameStatus.WINNER_O;
			
			sumMainDiagonal += fields[i][i];
			sumCounterDiagonal += fields[2-i][i];
		}
		
		if(sumMainDiagonal == 3 || sumCounterDiagonal == 3)
			return GameStatus.WINNER_X;
		
		if(sumMainDiagonal == -3 || sumCounterDiagonal == -3)
			return GameStatus.WINNER_O;
		
		if(NumberOfPlayedMoves == 9)
			return GameStatus.TIE;
		else
			return GameStatus.GAME_IS_LIVE;
		
	}
}
