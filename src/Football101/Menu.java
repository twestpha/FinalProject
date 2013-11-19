package Football101;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;


public class Menu extends JPanel {
	
	private String selection;
	private Map<String,String> fileData;
	
	public Menu( HashMap<String,String> fileData){
		this.fileData = fileData;
	}
	
	public int getNumElements(){
        return fileData.size();
    }
	
	public void executeSelectedPlay(){
		// Iunno yet
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		// For testing, later will be for
		// comboboxes to use
		this.selection = selection;
	}
	
	
	
}
