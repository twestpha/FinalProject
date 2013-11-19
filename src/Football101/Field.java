package Football101;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Field extends JPanel {
	private Menu menu;
	   
	public Field() {
		// TODO Auto-generated constructor stub
	}
	
    public void loadMenu(String Filename){
        menu = new Menu();
    }

    public Menu getMenu() {
        return menu;
    }
	public void paintComponent(Graphics g){
		
	}

}
