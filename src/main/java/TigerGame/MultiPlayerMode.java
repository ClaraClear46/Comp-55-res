package TigerGame;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import acm.graphics.GRect;
import acm.graphics.GImage;
import acm.graphics.GObject;
//
//	DO NOT PUSH SETTINGS, ONLY ADDED/MODIFIED
//

import acm.graphics.GObject;




public class MultiPlayerMode extends GraphicsPane {
	//TODO showContents(), hideContents()
	
	private MainApplication program;
	
	public Level LevelTwo;


	ArrayList<String> Player = new ArrayList<String>();

	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;


	public MultiPlayerMode(MainApplication app) {
		super();
		program = app;
		LevelTwo = new Level(program);
	}
	
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}
}
