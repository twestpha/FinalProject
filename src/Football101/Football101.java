package Football101;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Football101 extends JFrame {
	
	private Field field;
	private Play currentPlay;
	
	private ArrayList<Player> offensivePlayers;
	private ArrayList<Player> defensivePlayers;
	
	private static final int PLAYERS_PER_TEAM = 11;
	
	public Football101() {
		// TODO Auto-generated constructor stub
		offensivePlayers = new ArrayList<Player>();
		defensivePlayers = new ArrayList<Player>();
		
	}

	public void clear(){

	}
	
	public void executePlay(Play target){
		
	}
	
	public void loadPlay(String filename){
	}

	public ArrayList<Player> getOffensivePlayers() {
		return offensivePlayers;
	}

	public ArrayList<Player> getDefensivePlayers() {
		return defensivePlayers;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
