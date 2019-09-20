package org.senolab.guessthemovie;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Game {
    private ArrayList<String> movies;
    private String movieName;
    private StringBuilder movieNameDisplay;
    private int numberOfWrongGuess = 0;
    private boolean playerWin = false;


    /**
     * Game constructor
     * Setup all variables and randomly pick one movie name for player to guess
     * @param movieList list of movies that the player will guess
     */
    public Game(ArrayList<String> movieList) throws FileNotFoundException {
        this.movies = movieList;
        int rand = (int) (Math.random()*movieList.size());
        movieName = movieList.get(rand);
        movieNameDisplay = new StringBuilder(movieName.length());
        for(int i=0; i < movieName.length(); i++) {
            if(movieName.charAt(i) == ' ') {
                movieNameDisplay.append(" ");
            } else {
                movieNameDisplay.append("_");
            }
        }
    }
    /**
     * guess method
     * Method that take the letter which the player guess and update the state of th game after the guess
     * @param c the letter which player guess
     */
    public void guess(char c) {
        boolean isGuessCorrect = false;
        for (int i = 0; i < movieName.length(); i++){
            if (Character.toLowerCase(c) == Character.toLowerCase(movieName.charAt(i))) {
                isGuessCorrect = true;
                movieNameDisplay.setCharAt(i, movieName.charAt(i));
            }
        }
        if(movieName.equalsIgnoreCase(movieNameDisplay.toString()))
            playerWin = true;
        if(!isGuessCorrect)
            numberOfWrongGuess++;
    }


    /**
     * getNumberOfWrongGuess
     * Method that return # of wrong guess the user made
     * @return int # of wrong guess the user made
     */
    public int getNumberOfWrongGuess() {
        return numberOfWrongGuess;
    }

    /**
     * hasPlayerWin
     * Method that return whether the player has win (means guess all the letters of the movie name)
     * @return boolean whether the player has won (true = win, false = not win yet)
     */
    public boolean hasPlayerWin() {
        return playerWin;
    }

    /**
     * getMovieNameDisplay
     * Method that return the current state of the movie name string (letter that yet to be guess will be displayed "-")
     * @return String string representation of the current state of the movie name
     */
    public String getMovieNameDisplay() {
        return movieNameDisplay.toString();
    }



}
