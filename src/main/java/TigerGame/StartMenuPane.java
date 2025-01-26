package TigerGame;
import acm.graphics.*;


public class StartMenuPane extends GraphicsPane {

    private MainApplication program;
	private AudioPlayer audio = AudioPlayer.getInstance();
	public static final String MUSIC_FOLDER = "sounds";
    GImage background = new GImage("images/start_menu.png");
    GImage manualPage = new GImage("images/player_manual.png");
    //having trouble with new button and want to make sure at least the image is existing
    System.out.println("Highscore table image loaded: " + highscorePage.getWidth() + "x" + highscorePage.getHeight());
    //(2025)
    GImage highscoreTable = new GImage ("images/high_score_table.png");
    // Button 1: Single-player
    public GRect but1 = new GRect(172,63,255,54);
    // Button 2: Multi-player
    public GRect but2 = new GRect(172,136,255,54);
    // Button 3: Player manual
    public GRect but3 = new GRect(172,209,255,54);
    //Button 4: High-Score Table (2025)
    public GRect but4 = new GRect(172,281,255,54);

    public StartMenuPane(MainApplication app) {
        super();
        program = app;
        but1.setLineWidth(0);
        but2.setLineWidth(0);
        but3.setLineWidth(0);
        //(2025)
        but4.setLineWidth(0);
        
    }

    public void clickedAt(GObject objIn) {
        if (objIn == but1) {
        	// Stop audio when playing single mode
        	audio.stopSound(MUSIC_FOLDER, "MMenu.mp3");
            program.switchToSinglePlayer();
        } 
        else if(objIn == but3) {
            program.switchToManual();
            
        } 
        else if (objIn == but2) {
        	// Stop audio when playing in multi-player mode
    		audio.pauseSound(MUSIC_FOLDER, "MMenu.mp3");
        	program.switchToMultiPlayer();
        }
      //(2025)
        else if(objIn == but4){
        	//debugging text to make sure that the new 4th button works (2025)
       	 	System.out.println("Highscore button clicked!");
        	program.switchHighscorePane();
        }
    }

    @Override
    public void showContents() {
        program.add(background);
        program.add(but1);
        program.add(but2);
        program.add(but3);
      //debug 
        System.out.println("but4 added to the canvas");
        but4.setFilled(true);
        but4.setFillColor(java.awt.Color.RED);
        //(2025)
        program.add(but4);
    }

    @Override
    public void hideContents() {
        program.remove(background);
        program.remove(but1);
        program.remove(but2);
        program.remove(but3);
        //(2025)
        program.remove(but4);
    }

}