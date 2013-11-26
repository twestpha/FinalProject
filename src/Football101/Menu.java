package Football101;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JPanel;


public class Menu extends JPanel {

	private String selection;
	private String filePath;
	private Map<String,String> fileData;

	public Menu(Map<String,String> fileData){
		this.fileData = fileData;
		JComboBox playList = new JComboBox();
		for(String play: fileData.keySet() ){
			//playList.
		}
	}
	
	public void executeSelectedPlay(){
		// TODO: implement executeSelectedPlay()
	}

	// Getters 
	public int getNumElements(){
		return fileData.size();
	}

	public String getSelection(){
		return selection;
	}
	
	public String getFilePath(){
		return filePath;
	}
	
	// Setters
	public void setSelection(String selection) {
		this.selection = selection;
		this.filePath = fileData.get(selection);
	}

}
