package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Frame {

    private List<Integer> bowls;
    private boolean isStrike;
    private boolean isSpare;
    public void setSpare(boolean spare) {
        isSpare = spare;
    }
    public Frame() {
        this.bowls = new ArrayList<>();
    }
    public Frame(Integer firstBowl) {
        this.bowls = Arrays.asList(firstBowl);
    }

    public Frame(Integer firstBowl, Integer secondBowl) {
        this.bowls = Arrays.asList(firstBowl, secondBowl);
    }
    public Frame(Integer firstBowl,boolean isSpare) {
        this.bowls = Arrays.asList(firstBowl);
        setSpare(true);
    }

    public Frame(boolean isStrike, boolean isSpare) {
        this.isStrike = isStrike;
        this.isSpare = isSpare;
    }

    public static Integer getLastFrameSpareOrStrike(Frame currentFrame) {
        if (currentFrame.isSpare() || currentFrame.isStrike()){
            return 10;
        }
        else{
            if(currentFrame.getBowls().size() == 2)
                return currentFrame.getBowls().get(0) + currentFrame.getBowls().get(1);
            else
                return currentFrame.getBowls().get(0);
        }
    }

    public static Integer getLastFrameScoreRegular(Frame currentFrame) {
        return currentFrame.getBowls().get(0) + currentFrame.getBowls().get(1);
    }

    public static Integer getFrameScore(Frame currentFrame, List<Frame> nextFrames) {
        Integer frameScore = 0;
        if (currentFrame.isStrike()) {
            frameScore += 10 + getBowls(nextFrames, 0, 2);
        } else if (currentFrame.isSpare()) {
            frameScore += 10 + getBowls(nextFrames, 0, 1);
        } else
            frameScore += currentFrame.getBowls().stream().mapToInt(Integer::intValue).sum();
        return frameScore;
    }

    private static int getBowls(List<Frame> frames, int index, int count) {
        if (count == 0 || index == frames.size())
            return 0;
        if (frames.get(index).isStrike() || frames.get(index).isSpare()){
            if(frames.get(index).isStrike())
                count -= 1;
            else if(frames.get(index).isSpare() && count == 1)
                return frames.get(index).getBowls().get(0);
            else
                count -= 2;
            index += 1;
            return 10 + getBowls(frames, index, count);
        }
        else {
            if (count == 1)
                return frames.get(index).getBowls().get(0);
            else
                return frames.get(index).getBowls().stream().mapToInt(Integer::intValue).sum();
        }
    }


    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public List<Integer> getBowls() {
        return bowls;
    }

    public void addBowl(Integer i) {
        this.bowls.add(i);
    }
}

