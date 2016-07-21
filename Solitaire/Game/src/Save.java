import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Save {
	public File saveFileName;
	public static JFileChooser saveFile = new JFileChooser();
	public File openNewFile() {
		
		FileNameExtensionFilter solitsav = new FileNameExtensionFilter(
				"Connor's Solitaire Save File", "solitsave");
		saveFile.setFileFilter(solitsav);
		saveFile.setCurrentDirectory(new File("."));
		saveFile.setDialogTitle("Choose save file:");
		saveFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnValue = saveFile.showOpenDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			saveFileName = saveFile.getSelectedFile();
			return saveFileName;
		}
		else {
			return null;
		}
	}
}
