package TigerGame;
import acm.graphics.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Level implements ActionListener {
	// Obstacles are created here when NewObstacleTimer raises up
	// The question is if we the Level should control the movement (like with jumping and gravity)
	// or can the movement of obstacle be performed in itself
	// array of obstacles ? move them all ?
	// TODO add general speed value which controls: gravity, jump power, obstacle move speed
	
	
	private MainApplication program;
	public Player player;
	private Timer NewObstacleTimer;
	private MapElement bush1;
	private MapElement bush2;
	private ArrayList<MapElement> clouds;
	
	GImage backgroundImg = new GImage("sounds/blank_background.png");
	
	public Level(MainApplication app) {
		
		program = app;
		program.add(backgroundImg);
		
		// Add clouds
		clouds = new ArrayList<MapElement>();
		for(int i = 1; i <= 3; i++) {
			clouds.add(new MapElement(program, MapElementType.CLOUD, i * 200));
		}
		
		// Add bushes
		bush1 = new MapElement(program, MapElementType.BUSH, 0);
		bush2 = new MapElement(program, MapElementType.BUSH, 370);
		
		// Add player
		player = new Player(program);
		NewObstacleTimer = new Timer(5000, this);
		NewObstacleTimer.start();
		
		
	}
	

	public void actionPerformed(ActionEvent e) {
		Obstacle obstacle = new Obstacle(program);
		if(player.isCollided(obstacle)) {
			NewObstacleTimer.stop();
			
			System.out.println("Player has collided");
		}
	}
	
	public void jump(GObject playerIn) {
		player.jump();
	}
	
	public void gravity(GObject playerIn) {
		player.land();
	}
	
}