package Football101;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;


public class Menu extends JPanel {

	private String selection;
	private String filePath;
	private Map<String,String> fileData;
	
	public Menu(HashMap<String, String> fileData){
		this.fileData = new HashMap<String, String>(fileData);
	}

	public Menu(Map<String,String> fileData){
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
	
	public String getFilePath(){
		return filePath;
	}

	public void setSelection(String selection) {
		// For testing, later will be for
		// comboboxes to use
		this.selection = selection;
		this.filePath = fileData.get(selection);
	}



}
