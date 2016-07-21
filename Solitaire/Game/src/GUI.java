import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	public JFrame mainFrame;
	public Interface GUIInterface;
	public void runMainFrame() {
		mainFrame = new JFrame("Solitaire - Made by Connor and Fox (aka Larry)");
		mainFrame.setSize(1920, 1080);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel window = new JPanel();
		placeComponents(window);
		mainFrame.add(window);
		mainFrame.setVisible(true);
	}
	public void placeComponents(JPanel panel) {
		GUIInterface = new Interface();
		panel.setLayout(null);
		JButton newGame = new JButton("New Game");
		newGame.setBounds(20, 20, 200, 50);
		newGame.addActionListener(this);
		panel.add(newGame);
		
		JButton loadGame = new JButton(new AbstractAction ("Continue Game") {
			public void actionPerformed (ActionEvent e) {
				try {
					GUIInterface.readIn();
				}
				catch(FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		loadGame.setBounds(20, 80, 200, 50);
		panel.add(loadGame);
	}
	public void actionPerformed(ActionEvent e) {
		try {
			GUIInterface.newGame();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
