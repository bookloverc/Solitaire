import java.io.File;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.accessibility.Accessible;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main extends JComponent implements Accessible {
	
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		//GUI gui = new GUI();
		//gui.runMainFrame();
		Interface mainToInterface = new Interface();
		mainToInterface.beginInput();
		
	}

}
