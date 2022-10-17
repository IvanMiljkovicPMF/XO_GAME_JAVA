import java.util.Scanner;

public class TestConsole {

	public static void main(String[] args) {
		
		XO xo = new XO();
		printGameStatus(xo);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			
			boolean potezJeOdigran = xo.playMove(i, j);
			if(potezJeOdigran)
			{
				printGameStatus(xo);
				
				
				GameStatus si = xo.getGameStatus();
				
				if(si != GameStatus.GAME_IS_LIVE)
				{
					System.out.println();
					System.out.println(si);
					break;
				}
			}
		}
		
		
		

	}

	private static void printGameStatus(XO xo) {
		System.out.println();
		System.out.println("On the move " + xo.whoIsOnTheMove());
		
		for (int i = 0; i < 3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
				System.out.print(xo.getMarkOfField(i, j));
			}
		}
		
	}

}
