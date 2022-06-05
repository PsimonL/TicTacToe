package com.app_code;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


class FrameStuff_CONTROLL_Test {
    @Test
    void check_width(){
        FrameStuff_CONTROLL width_obj = new FrameStuff_CONTROLL();
        int value_w = width_obj.width;
        assertEquals(800, value_w);
    }
    @Test
    void check_height(){
        FrameStuff_CONTROLL height_obj = new FrameStuff_CONTROLL();
        int value_h = height_obj.height;
        assertEquals(800, value_h);
    }
    @Test
    void check_color(){
        FrameStuff_CONTROLL color_obj = new FrameStuff_CONTROLL();
        Color col = color_obj.bg;
        assertEquals(Color.WHITE, col);
    }
}