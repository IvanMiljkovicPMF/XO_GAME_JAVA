import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class XoGUI extends JFrame
{
	JLabel WhoIsOnTheMoveLabel = new JLabel("Who is on the move: ");
	JButton buttons[][] = new JButton[3][3];
	
	XO xo = new XO();
	
	public XoGUI()
	{
		setBounds(500, 50, 500, 500);
		setTitle("XO GAME");
		
		xo.newGame();
		
		
		getContentPane().setLayout(new BorderLayout());
		
		
		JPanel north = new JPanel(new FlowLayout());
		north.add(WhoIsOnTheMoveLabel);
		getContentPane().add(north, BorderLayout.NORTH);

		
		JPanel center = new JPanel(new GridLayout(3,3));
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				JButton button = new Buttons(i, j);
				
				
				
				button.addActionListener(listenerButtonXO);
				
				button.setPreferredSize(new Dimension(150,150));
				
				buttons[i][j] = button;
				center.add(button); 
				
			}
		}
		
		refreshGUI();
		
		getContentPane().add(center, BorderLayout.CENTER);
		
		
		JButton NewGameButton = new JButton("New Game");
		
		NewGameButton.addActionListener(new ListenerOfAction());
		
		NewGameButton.addActionListener(listenerNewGame);
		
		JPanel jug = new JPanel(new FlowLayout());
		jug.add(NewGameButton);
		getContentPane().add(jug, BorderLayout.SOUTH);
		 
		pack();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void refreshGUI()
	{
		WhoIsOnTheMoveLabel.setText("On the move: " + xo.whoIsOnTheMove());
		
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j].setText(xo.getMarkOfField(i, j));
			}
		}
	}
	
	private ActionListener listenerNewGame = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			xo.newGame();
			refreshGUI();
			
			for (int j2 = 0; j2 < buttons.length; j2++) {
				for (int j3 = 0; j3 < buttons.length; j3++) {
					buttons[j2][j3].setEnabled(true);
				}
			}
			
		}
	};
	
	private ActionListener listenerButtonXO = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Buttons button = (Buttons)e.getSource();
			
			boolean playedMove = xo.playMove(button.getI(), button.getJ());
			
			if(playedMove)
			{
				refreshGUI();
				
				GameStatus si = xo.getGameStatus();
				if(si != GameStatus.GAME_IS_LIVE)
				{
					switch (si) {
					case WINNER_O:
						WhoIsOnTheMoveLabel.setText("Winner O");
						break;

					case WINNER_X:
						WhoIsOnTheMoveLabel.setText("Winner X");
						break;
					case TIE:
						WhoIsOnTheMoveLabel.setText("TIe");
						break;
					}
					
					for (int j2 = 0; j2 < buttons.length; j2++) {
						for (int j3 = 0; j3 < buttons.length; j3++) {
							buttons[j2][j3].setEnabled(false);
						}
					}
					
				}
				
				
				
			}
			
			
		}
	};
	
	
}
