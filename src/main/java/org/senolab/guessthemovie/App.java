package org.senolab.guessthemovie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Game guessTheMovie;
    public static void main(String[] args) {
        //Introductory message and user instructions
        System.out.println("Welcome to Guess The Movie game!");
        System.out.println("The rules are simple, the computer randomly picks a movie title, and shows you how many letters it's made up of. " +
                "Your goal is to try to figure out the movie by guessing one letter at a time.");
        System.out.println("If a letter is indeed in the title the computer will reveal its correct position in the word, if not, you lose a point. " +
                "If you lose 10 points, game over!");
        System.out.println("Let's get started!!! Enjoy!\n\n");
        System.out.println("================================================================================================\n");
        //Read list of movies from File and store it array
        File file = new File("C:\\project\\udacity\\resources\\movies.txt");
        ArrayList<String> listOfMovies = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                listOfMovies.add(scanner.nextLine());
            }
            //Setup Game class instance and scanner for user input
            guessTheMovie = new Game(listOfMovies);
            Scanner userInput = new Scanner(System.in);
            while(!guessTheMovie.hasPlayerWin() && guessTheMovie.getNumberOfWrongGuess() < 10) {
                gameStatus();
                String userGuess = userInput.nextLine();
                guessTheMovie.guess(userGuess.charAt(0));
            }
            if(guessTheMovie.hasPlayerWin()) {
                System.out.println("You win!");
                System.out.println("You have guessed '"+guessTheMovie.getMovieNameDisplay()+"' correctly.");
            } else {
                System.out.println("You lose!");
                System.out.println("You lose all your 10 points after making 10 incorrect guesses!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file you specified doesn't exist!");
            e.printStackTrace();
        }
    }

    /**
     * gameStatus
     * Method to print current state of the game after each user guess
     */
    private static void gameStatus() {
        System.out.println("You are guessing: "+guessTheMovie.getMovieNameDisplay());
        System.out.println("You have guessed ("+guessTheMovie.getNumberOfWrongGuess()+") wrong letter.");
        System.out.println("Guess a letter: ");

    }

}
