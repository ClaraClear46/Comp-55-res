package TigerGame;

import acm.graphics.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighscoreTable extends GraphicsPane {

    private MainApplication program;
    private AudioPlayer audio = AudioPlayer.getInstance();
    
    
    private List<Integer> highScores;
    private List<GLabel> scoreLabels;
    
    public static final String MUSIC_FOLDER = "sounds";
    GImage highscorePage = new GImage("images/high_score_table.png");
    public GRect backButton = new GRect(25, 22, 86, 34);
    public HighscoreTable(MainApplication app) {
        super();
        program = app;
        backButton.setLineWidth(0);
        audio.playSound(MUSIC_FOLDER, "MMenu.mp3");
        
        highScores= new ArrayList<>();
        scoreLabels = new ArrayList<>();
    }
    public void clickedAt(GObject objIn) {
        if (objIn == backButton) {
//            System.out.println("Back button clicked"); // Debugging click
            program.switchToMainMenu();
        }
    }
    public void saveScore(Player player) {
        // Get the player's score
        int currentScore = player.playerScore;

        // Add the score to the list and sort it in descending order
        highScores.add(currentScore);
        Collections.sort(highScores, Collections.reverseOrder());

        // Trim to keep only the top 5 scores
        if (highScores.size() > 5) {
            highScores = highScores.subList(0, 5);
        }
    }
    
    private void displayHighScores() {
        // Clear any existing score labels
        for (GLabel label : scoreLabels) {
            program.remove(label);
        }
        scoreLabels.clear();

        // Add labels for each high score
        for (int i = 0; i < highScores.size(); i++) {
            GLabel scoreLabel = new GLabel((i + 1) + ". " + highScores.get(i));
            scoreLabel.setFont("Serif-bold-26");
            scoreLabel.setColor(java.awt.Color.LIGHT_GRAY);
            scoreLabel.setLocation(100, 150 + i * 50); 
            program.add(scoreLabel);
            scoreLabels.add(scoreLabel);
        }
    }
    
    @Override
    public void showContents() {
        program.add(highscorePage);

        // Ensure button is visible
//        backButton.setFilled(true); 
//        backButton.setFillColor(java.awt.Color.LIGHT_GRAY);  // Set color
        program.add(backButton);  // Add button to the screen
//
//        System.out.println("HighscoreTable shown"); // Debugging contents
        
        displayHighScores();
    }

    @Override
    public void hideContents() {
        program.remove(highscorePage);
        program.remove(backButton);
        //System.out.println("HighscoreTable hidden"); // Debugging hide
        for (GLabel label : scoreLabels) {
        	program.remove(label);
        }
    }
}
