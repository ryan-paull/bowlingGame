package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private List<Frame> frames;

    private int score = 0;

    public Game(List<Frame> frame) {
        this.frames = frame;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public int getScore() {
        return score;
    }

//    public getFrameScores (prevframes, totalframes, ne)
    public void calculateScore(){
        //for loop to iterate over frames
        for(int i = 0; i<frames.size(); i++){
            List<Frame> nextFrames = new ArrayList<>();
            int amountLeft = frames.size()-i-1;
            if(i>=9){
                if(frames.size()==10)
                    this.score += Frame.getLastFrameScoreRegular(frames.get(i));
                else if(frames.size()>=11)
                    this.score += Frame.getLastFrameSpareOrStrike(frames.get(i));
            }
            else{
                if(amountLeft>2){
                    nextFrames = frames.subList(i+1, i + 3);
                }
                else{
                    nextFrames = frames.subList(i+1, frames.size());
                }
                this.score += Frame.getFrameScore(frames.get(i),nextFrames);
            }
        }
        //on each frame run the getscore function
        //add frame score to score
        //
    }





}
