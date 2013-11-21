package Football101;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Field extends JPanel {
	private Menu menu;
	   
	public Field() {
		// TODO Auto-generated constructor stub
	}

	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(new Color(57, 128, 71));
		
		// Dynamic Scaling
		g.fillRect(0,0,getSize().width,getSize().height);
	}

}
