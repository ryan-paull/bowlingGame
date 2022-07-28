package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

    @Test
    void getFrameScore (){
        Frame nextFrame = new Frame();
        nextFrame.addBowl(1);
        nextFrame.addBowl(2);
        List<Frame> nextFrames = Arrays.asList(nextFrame);
        Frame currFrame = new Frame(true,false);

        Integer score = Frame.getFrameScore(currFrame,nextFrames);
        assertEquals(13,score);



    }

    @Test
    void getFrameScoreWithThreeStrikes (){
        List<Frame> nextFrames = Arrays.asList(new Frame(true,false),new Frame(true,false));
        Frame currFrame = new Frame(true,false);
        Integer score = Frame.getFrameScore(currFrame,nextFrames);
        assertEquals(30,score);
    }
    @Test
    void getFrameScoreWithStrikeSpareRegular (){
        List<Frame> nextFrames = Arrays.asList(new Frame(false,true), new Frame(1,2));
        Frame currFrame = new Frame(true,false);
        Integer score = Frame.getFrameScore(currFrame,nextFrames);
        assertEquals(20,score);
    }

    @Test
    void getFrameScoreNextBlank (){
        List<Frame> nextFrames = new ArrayList<>();
        Frame currFrame = new Frame(true,false);
        Integer score = Frame.getFrameScore(currFrame,nextFrames);
        assertEquals(10,score);
    }

    @Test
    void getFrameScoreStrikeStrike (){
        List<Frame> nextFrames = Arrays.asList(new Frame(true,false));
        Frame currFrame = new Frame(true,false);
        Integer score = Frame.getFrameScore(currFrame,nextFrames);
        assertEquals(20,score);
    }

    @Test
    void getFrameScoreStrikeStrikeSpare (){
        Frame spareFrame = new Frame ();
        spareFrame.setSpare(true);
        spareFrame.addBowl(5);
        List<Frame> nextFrames = Arrays.asList(new Frame(true,false),spareFrame);
        Frame currFrame = new Frame(true,false);
        Integer score = Frame.getFrameScore(currFrame,nextFrames);
        assertEquals(25,score);
    }


}