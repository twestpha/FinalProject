package Football101;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;


public class Menu extends JPanel {
	
	private String selection;
	Map<String, String> content;
	
	public Menu(){
		
	}
	
	public Menu(Map<String, String> menuContent){
		content = menuContent;
	}
	
	public int getNumElements(){
        return content.size();
    }
	
	public void executeSelectedPlay(){
		
	}

	public String getSelection() {
		return "";
	}

	public void setSelection(String selection) {
		// For testing, later will be for
		// comboboxes to use
		//this.selection = selection;
		selection = null;
	}
	
	
	
}
