package TigerGame;

import acm.graphics.GImage;

public class Player {
	private double moveSpeed;
	private double posX;
	private double posY;
	private double tigerWidth;
	private double tigerHeight;
	private double playerScore;
	GImage tigerRunImage;
	GImage tigerJumpImage;
	GImage tigerLandImage;
	
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	
}
