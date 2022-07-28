package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<Frame> parseFrames(String game) {
        List<Frame> frames = new ArrayList<>();
        String[] frameStrings = game.split(":", 10);
        for (String frameString : frameStrings) {
            List<String> bowls = Arrays.asList(frameString.split(","));
            int countOfBowls = bowls.size();
            if (countOfBowls == 3) {
                Frame temp = new Frame();
                if (bowls.get(1).equals("/")) {
                    temp.setSpare(true);
                    if (bowls.get(0).equals("-"))
                        temp.addBowl(0);
                    else
                        temp.addBowl(Integer.parseInt(bowls.get(0)));
                    frames.add(temp);
                    if (bowls.get(2).equals("X"))
                        frames.add(new Frame(true, false));
                    else {
                        Frame temp2 = new Frame();
                        if (bowls.get(2).equals("-"))
                            temp2.addBowl(0);
                        else
                            temp2.addBowl(Integer.parseInt(bowls.get(2)));
                        frames.add(temp2);
                    }
                }
                else {
                    frames.add(new Frame(true, false));
                    if (bowls.get(1).equals("X")) {
                        frames.add(new Frame(true, false));
                        if(bowls.get(2).equals("X"))
                            frames.add(new Frame(true, false));
                        else {
                            if (bowls.get(2).equals("-"))
                                temp.addBowl(0);
                            else
                                temp.addBowl(Integer.parseInt(bowls.get(2)));
                            frames.add(temp);
                        }
                    }else {
                        if (bowls.get(1).equals("-"))
                            temp.addBowl(0);
                        else
                            temp.addBowl(Integer.parseInt(bowls.get(1)));
                        if(bowls.get(2).equals("/"))
                            temp.setSpare(true);
                        else {
                            if (bowls.get(2).equals("-"))
                                temp.addBowl(0);
                            else
                                temp.addBowl(Integer.parseInt(bowls.get(2)));
                        }
                        frames.add(temp);
                    }
                }
            } else {
                if (bowls.contains("X")) {
                    frames.add(new Frame(true, false));
                } else if (bowls.contains("/")) {
                    Frame temp = new Frame();
                    if (bowls.get(0).equals("-"))
                        temp.addBowl(0);
                    else
                        temp.addBowl(Integer.parseInt(bowls.get(0)));
                    temp.setSpare(true);
                    frames.add(temp);
                } else {
                    Frame temp = new Frame();
                    for (String bowl : bowls) {
                        if (bowl.equals("-"))
                            temp.addBowl(0);
                        else
                            temp.addBowl(Integer.parseInt(bowl));
                    }
                    frames.add(temp);
                }
            }
        }
        return frames;
    }
}
