package com.app_code;

import javax.swing.*;
import java.awt.*;

public class FrameStuff_CONTROLL extends JFrame{
    JFrame frame = new JFrame("Gra w kolko i krzyzyk");
    JPanel txt_panel = new JPanel();
    JLabel txt = new JLabel();
    Board_VIEW board = new Board_VIEW();
    final int width = 800;
    final int height = 800;

    FrameStuff_CONTROLL() {
        frame.setSize(width, height);
        frame.add(txt_panel, BorderLayout.NORTH);
        setTxt();
        txt_panel.setLayout(new BorderLayout());
        txt_panel.add(txt);
        frame.add(board.initializeButtons());
        frame.setVisible(true);
    }
    final Color bg = Color.WHITE;
    public void setTxt(){
        txt.setBackground(bg);
        txt.setOpaque(true);
        txt.setForeground(Color.BLACK);
        txt.setText("Kolko i Krzyzyk");
        txt.setFont(new Font("Calibri", Font.ITALIC, 40));
        txt.setHorizontalAlignment(JLabel.CENTER);
    }
}


