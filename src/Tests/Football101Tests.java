package Tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Football101.BadConfigException;
import Football101.Field;
import Football101.Football101;
import Football101.Menu;
import Football101.Path;
import Football101.Play;
import Football101.Player;

public class Football101Tests {
	private Player p1;
	private Football101 football101;
	private Menu m;

	@Before
	public void setUp() throws Exception {
		football101 = new Football101();
		p1 = new Player(0,0,'O', new ArrayList<Point>(), football101);
	}

	@Test
	public void testMove() {
		// Marcus
		// NULL because football101.getField is null because the member variable football101 is uninitialized
		p1.moveTo(50, 25);
		Assert.assertEquals(50, p1.getX());
		Assert.assertEquals(25, p1.getY());

		p1.moveTo(100, 50);
		Assert.assertEquals(100, p1.getX());
		Assert.assertEquals(50, p1.getY());
	}

	@Test
	public void testMoveAlongLine(){
		// Marcus
		// Create an array of points which will be used to
		// draw a line, which will be followed by the player.
		ArrayList<Point> lines = new ArrayList<Point>();
		lines.add(new Point(0,0));
		lines.add(new Point(25,25));
		lines.add(new Point(15,15));

		// Make sure that the player follows the line, ends up
		// at the end of it.
		p1.setPath(lines);
		p1.moveAlongLine();
		Assert.assertEquals(15, p1.getX());
		Assert.assertEquals(15, p1.getY());

		// Add more points to the line. Make sure player still
		// follows it and ends up at the end.
		lines.add(new Point(30, 35));
		lines.add(new Point( 40, 30));
		
		p1.setPath(lines);
		p1.moveAlongLine();
		Assert.assertEquals(40, p1.getX());
		Assert.assertEquals(30, p1.getY());
	}

	@Test
	public void testLoadMenu() throws BadConfigException, FileNotFoundException {
		// Tests the loading of the menu file
		football101.loadMenu("Menu.conf");
		assertEquals(football101.getMenu().getNumElements(),3);
		//Later add contains tests
	}

	@Test (expected = FileNotFoundException.class)
	public void testNoLoadMenu() throws BadConfigException, FileNotFoundException {
		// Tests the loading of the menu file
		// Brendan's Test
		football101.loadMenu("NoMenuFile");
	}

	@Test (expected = BadConfigException.class)
	public void testLoadBadMenu() throws BadConfigException, FileNotFoundException {
		// Tests the loading of the menu file
		// Brendan's Test
		football101.loadMenu("badMenuFile");
	}

	@Test
	public void loadOffensiveTeam(){
		// Tests the creation/loading of the offensive "team" (collection) of players.
		// Chris
		ArrayList<Player> offense = football101.getOffensivePlayers();

		Assert.assertEquals(offense.size(), 11);

		boolean isCorrectChar = true;
		for (Player player : offense) {
			isCorrectChar &= (player.getSymbol() == 'O');
		}

		assertTrue(isCorrectChar);
	}

	@Test
	public void loadDefensiveTeam(){
		// Tests the creation/loading of the defensive "team" (collection) of players.
		// Chris
		ArrayList<Player> defense = football101.getDefensivePlayers();

		Assert.assertEquals(defense.size(), 11);

		boolean isCorrectChar = true;
		for (Player player : defense) {
			isCorrectChar &= (player.getSymbol() == 'X');
		}

		assertTrue(isCorrectChar);

	}

	@Test
	public void testDropDownSelection(){
		// Tests which Item has been selected for the dropdown menus.
		// First, set up the selection
		try {
			football101.loadMenu("Menu.conf");
		} catch (FileNotFoundException | BadConfigException e) {
			e.printStackTrace();
		}
		
		football101.getMenu().setSelection("Blue 42");
		// Then, simulate the enter command
		football101.getMenu().executeSelectedPlay();
		// Finally, verify the selection persists
		Assert.assertEquals(football101.getMenu().getFilePath(),"/src/blue42.play");
		Assert.assertEquals(football101.getMenu().getSelection(),"Blue 42");
	}
}
