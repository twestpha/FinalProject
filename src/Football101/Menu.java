package Football101;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class Menu extends JPanel {

	private String selection;
	private String filePath;
	private Map<String,String> fileData;

	public Menu(Map<String,String> fileData){
		this.fileData = fileData;
		String fpath;
		DisabledItemsComboBox box = new DisabledItemsComboBox();
		for(String play: fileData.keySet() ){
			fpath = fileData.get(play);
			box.addItem(play, (fpath.equals("BREAKER")));
		}
		add(box);
		
		
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
