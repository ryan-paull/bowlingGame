package org.example;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {


    @Test
    void parseFramesThreeStrikeTenthFrame(){
        List<Frame> frames = Parser.parseFrames("X,X,X");
        assertEquals(3,frames.size());
        frames.forEach(frame -> assertTrue(frame.isStrike()));
    }

    @Test
    void parseFramesSpareTest(){
        List<Frame> frames = Parser.parseFrames("4,/:3,/");
        assertEquals(2,frames.size());
        frames.forEach(frame -> assertTrue(frame.isSpare()));
    }

    @Test
    void parseFramesMixedResults(){
        List<Frame> frames = Parser.parseFrames("3,5:-,/:X");
        assertEquals(3,frames.size());
        assertEquals(3,frames.get(0).getBowls().get(0));
        assertEquals(5,frames.get(0).getBowls().get(1));
        assertTrue(frames.get(1).isSpare());
        assertFalse(frames.get(1).isStrike());
        assertNull(frames.get(2).getBowls());
        assertTrue(frames.get(2).isStrike());
        assertFalse(frames.get(2).isSpare());
    }

    @Test
    void parseFramesThreeStrikes(){
        List<Frame> frames = Parser.parseFrames("X,X,X");
        assertEquals(3,frames.size());
    }

    @Test
    void parseFramesTwoStrikesRegular(){
        List<Frame> frames = Parser.parseFrames("X,X,2");
        assertEquals(3,frames.size());
    }

    @Test
    void parseFramesTwoStrikesMiss(){
        List<Frame> frames = Parser.parseFrames("X,X,-");
        assertEquals(3,frames.size());
    }

    @Test
    void parseFramesOneStrikeTwoRegular(){
        List<Frame> frames = Parser.parseFrames("X,2,2");
        assertEquals(2,frames.size());
    }

    @Test
    void parseFramesOneStrikeSpare(){
        List<Frame> frames = Parser.parseFrames("X,2,/");
        assertEquals(2,frames.size());
        assertTrue(frames.get(1).isSpare());
    }

    @Test
    void parseFramesTwoSparesOneRegular(){
        List<Frame> frames = Parser.parseFrames("1,2,/");
        assertEquals(2,frames.size());
        assertTrue(frames.get(1).isSpare());
    }

    @Test
    void parseFramesOneSpareOneMiss(){
        List<Frame> frames = Parser.parseFrames("1,/,-");
        assertEquals(2,frames.size());
        assertTrue(frames.get(0).isSpare());
    }

    @Test
    void parseFramesOneSpareOneStrike(){
        List<Frame> frames = Parser.parseFrames("1,/,X");
        assertEquals(2,frames.size());
        assertTrue(frames.get(0).isSpare());
    }
}
