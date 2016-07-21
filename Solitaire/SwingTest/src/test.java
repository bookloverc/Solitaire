import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class test {
	public static void main(String []args) {
		JFrame solitaireTest = new JFrame("Solitaire by Connor - Made with Eclipse");
		JLabel title = new JLabel("6 of diamonds");
		title.setPreferredSize(new Dimension(400, 50));
		JButton button = new JButton("hi i do nothing");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(solitaireTest, "jk i do something");
			}
		});
		JPasswordField password = new JPasswordField(10);
		password.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(solitaireTest, "LOLOLOLOL u dont know the password");
			}
		});
		solitaireTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		solitaireTest.getContentPane().add(title, BorderLayout.NORTH);
		solitaireTest.getContentPane().add(button, BorderLayout.CENTER);
		solitaireTest.getContentPane().add(password, BorderLayout.SOUTH);
		solitaireTest.pack();
		solitaireTest.setVisible(true);
	}
}
