package TigerGame;

import acm.graphics.*;

public class HighscoreTable extends GraphicsPane {

    private MainApplication program;
    private AudioPlayer audio = AudioPlayer.getInstance();
    public static final String MUSIC_FOLDER = "sounds";
    GImage highscorePage = new GImage("images/high_score_table.png");
    public GRect backButton = new GRect(25, 22, 86, 34);

    public HighscoreTable(MainApplication app) {
        super();
        program = app;
        backButton.setLineWidth(0);
        audio.playSound(MUSIC_FOLDER, "MMenu.mp3");
    }

    public void clickedAt(GObject objIn) {
        if (objIn == backButton) {
            System.out.println("Back button clicked"); // Debugging click
            program.switchToMainMenu();
        }
    }

    @Override
    public void showContents() {
        program.add(highscorePage);

        // Ensure button is visible
        backButton.setFilled(true); 
        backButton.setFillColor(java.awt.Color.LIGHT_GRAY);  // Set color
        program.add(backButton);  // Add button to the screen

        System.out.println("HighscoreTable shown"); // Debugging contents
    }

    @Override
    public void hideContents() {
        program.remove(highscorePage);
        program.remove(backButton);
        System.out.println("HighscoreTable hidden"); // Debugging hide
    }
}
