package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void calculateScoreTwoStrikes (){
        List<Frame> gameFrames = Arrays.asList(new Frame(true,false),new Frame(true,false));
        Game game = new Game(gameFrames);
        assertEquals(0,game.getScore());
        game.calculateScore();
        assertEquals(30,game.getScore());
    }

    @Test
    void calculateScoreFourStrikes (){
        List<Frame> gameFrames = Arrays.asList(new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false));
        Game game = new Game(gameFrames);
        assertEquals(0,game.getScore());
        game.calculateScore();
        assertEquals(90,game.getScore());
    }@Test
    void calculateScoreAllStrikes (){
        List<Frame> gameFrames = Arrays.asList(new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(true,false));
        Game game = new Game(gameFrames);
        assertEquals(0,game.getScore());
        game.calculateScore();
        assertEquals(300,game.getScore());
    }

    @Test
    void calculateScoreLastSpareRegular (){
        List<Frame> gameFrames = Arrays.asList(new Frame(true,false),
                new Frame(4,3),
                new Frame(true,false),
                new Frame(0,true),
                new Frame(9,0),
                new Frame(2,7),
                new Frame(true,false),
                new Frame(true,false),
                new Frame(6,true),
                new Frame(4,3));
        Game game = new Game(gameFrames);
        assertEquals(0,game.getScore());
        game.calculateScore();
        assertEquals(148,game.getScore());
    }

}