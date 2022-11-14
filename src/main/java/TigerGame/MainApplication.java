package TigerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;

import acm.graphics.*;	

public class MainApplication extends GraphicsApplication implements ActionListener
{
	//TODO is obstacle should be controller from here ? RH
	
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 436;
	public static final int GRAVITY_TIMER_MS = 200;
	
	private startMenuPane mainMenu;
	private PlayerManualPane manualMenu;
	private SinglePlayerModePane singleMenu;
	
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		//this.requestFocus();
	}
	
	public void run() {		//run is called when green button
		mainMenu = new startMenuPane(this);		//main menu initialized / start menu pane.java reference functions below
		manualMenu = new PlayerManualPane(this);	//loads player manual pane
		setupInteractions();		//allows for clicking
		switchToMainMenu();
	}
	
	public void switchToMainMenu() {
		switchToScreen(mainMenu);
	}

	public void switchToManual() {
		switchToScreen(manualMenu);
	}
	
	public void switchToSinglePlayer() {
		singleMenu = new SinglePlayerModePane(this);
		switchToScreen(singleMenu);
	}
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject button = getElementAt(e.getX(), e.getY());
		if (curScreen == mainMenu) { 
			mainMenu.clickedAt(button);
		} else if (curScreen == manualMenu) {
			manualMenu.clickedAt(button);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38) {
			singleMenu.LevelOne.player.jump();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 38) {
		}
	}
	
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
	
}