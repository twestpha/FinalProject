package Football101;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

public class Football101 extends JFrame {

	private Field field;
	private Play currentPlay;
	private Menu menu;

	private ArrayList<Player> offensivePlayers;
	private ArrayList<Player> defensivePlayers;
	
	private Map<String, String> menuContent = new LinkedHashMap<String, String>();

	private static final int PLAYERS_PER_TEAM = 11;

	public Football101() {

		offensivePlayers = new ArrayList<Player>();
		defensivePlayers = new ArrayList<Player>();
		
		// Jframe/Gui stuff
		field = new Field();
		add(field, BorderLayout.CENTER);
		try {
			loadMenu("Menu.conf");
		} catch (FileNotFoundException | BadConfigException e) {
			e.printStackTrace();
		}
		add(menu, BorderLayout.NORTH);
		setSize(1024,768);
		setResizable(false);
		setVisible(true);
		setTitle("Football 101");
	}

	public void loadPlay(String filename){
		currentPlay = new Play(filename, this);
	}

	public ArrayList<Player> getOffensivePlayers() {
		return offensivePlayers;
	}

	public ArrayList<Player> getDefensivePlayers() {
		return defensivePlayers;
	}

	public static void main(String[] args) {
		Football101 f = new Football101();
		
		Play play = new Play("zeroplay.play", f);
		try {
			play.readPlayFromFile();
		} catch (BadConfigException e) {
			e.printStackTrace();
		}
	}

	public Field getField(){
		return field;
	}
	
    public void loadMenu(String filename) throws BadConfigException, FileNotFoundException{
        try {
			FileReader reader = new FileReader(filename);
			Scanner in = new Scanner(reader);
			while(in.hasNext()){
				String[] content = in.nextLine().split(",");
				if (content.length != 2){
					throw new BadConfigException("Bad legend Config");
				}
				System.out.println(content[0]);
				menuContent.put(content[0], content[1]);
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("The Menu.conf could not be found");
		}
        menu = new Menu(menuContent, this);
    }

	public Menu getMenu() {
		return menu;
	}

	public Map<String, String> getMap(){
		return menuContent;
	}


}
