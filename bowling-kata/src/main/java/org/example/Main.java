package org.example;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Print "Welcome to the Bowling Game"
        System.out.println("Welcome to the Bowling Game!");
        //Ask user to enter the 10 rounds in 1 string
        //Give user instructions on how to enter scores
        System.out.println("Instructions: ");
        System.out.println("Use \":\" to separate each round");
        System.out.println("Use \",\" to separate each throw within the round");
        System.out.println("Use \"X\" to indicate a strike");
        System.out.println("Use \"/\" to indicate a spare");
        System.out.println("Use \"-\" to indicate a miss");
        System.out.println("Use 1-9 to indicate all other scores");
        System.out.println("Enter the game like this: X:4,3:X:-,/:9,-:2,7:X:X:6,/:4,3");

        //Read the scores and add to respective Frames
        System.out.print("Enter your simulated game: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println("This is your game: " + input);

        //creating frames
        List<Frame> frames = Parser.parseFrames(input);

        //calculate the game score
        Game game = new Game(frames);
        game.calculateScore();

        //return the game score to user
        System.out.println("\nScore: " + game.getScore());
        if(game.getScore()==300)
            System.out.println("WOW Perfect Score!!!");
        if(game.getScore()==0)
            System.out.println("Better luck next time :(");
        System.out.println("Thanks for playing!");
    }
}