package Football101;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Menu extends JPanel {

	private String selection;
	private String filePath;
	private Football101 f;
	private Map<String,String> fileData;

	public Menu(Map<String,String> fileData, Football101 f){
		this.fileData = fileData;
		this.f = f;

		// Combo box stuff
		String fpath;
		DisabledItemsComboBox box = new DisabledItemsComboBox();
		for(String play: fileData.keySet() ){
			fpath = fileData.get(play);
			box.addItem(play, (fpath.equals("BREAKER")));
		}
		box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox jbx = (JComboBox)e.getSource();
				setSelection((String)jbx.getSelectedItem());
				Play play = new Play(getFilePath(),getF());
				try {
					play.readPlayFromFile();
				} catch (BadConfigException e1) {
					e1.printStackTrace();
				}
				getF().getField().setCurPlay(play);
				getF().getField().repaint();
			}
		});
		add(box);

		// Execute button stuff
		JButton button = new JButton("Execute Play");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				class TimerListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						Timer t = (Timer)e.getSource();
						getF().getField().getCurPlay().execute();
						if(getF().getField().getCurPlay().isEverybodyDone()){ // boolean, if everybody is done with their play = TRUE
							t.stop();
						}
					}
				}
				
				Timer t = new Timer(100, new TimerListener());

				t.start();

				 
				


			}
		});
		add(button);

	}

	// Getters 
	public int getNumElements(){
		return fileData.size();
	}

	public Football101 getF(){
		return f;
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
