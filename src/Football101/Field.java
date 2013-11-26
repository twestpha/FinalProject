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
		final int SPACING = 32;
		super.paintComponents(g);
		g.setColor(new Color(57, 128, 71));
		g.fillRect(0,0,getSize().width,getSize().height);
		g.setColor(Color.WHITE);
		g.fillRect((getSize().width/2)-3,30,6,getSize().height - 60);
		g.fillRect((getSize().width/4)-3,30,6,getSize().height - 60);
		g.fillRect((getSize().width/2)+(getSize().width/4)-3,30,6,getSize().height - 60);
		// TEST GRID.
		for(int i = 0; i < getSize().width/SPACING+1; ++i){
			g.drawLine(SPACING*i, 0, SPACING*i, getSize().height);
		}
		for(int j = 0; j < getSize().height/SPACING+1; ++j){
			g.drawLine(0,SPACING*j,getSize().width,SPACING*j);
		}
		
		
	}

}
