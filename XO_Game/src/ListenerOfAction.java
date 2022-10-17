import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ListenerOfAction implements ActionListener {

	
	public void actionPerformed(ActionEvent arg0) {
		
		JButton button = (JButton)arg0.getSource();
		
		button.setText("Again New Game?");

	}

}
