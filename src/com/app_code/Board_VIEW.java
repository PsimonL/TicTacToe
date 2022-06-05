package com.app_code;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Board_VIEW extends JPanel{
    JButton[] buttons;
    JPanel buttons_panel;
    char result;
    HashMap<Integer, JButton> buttons_ids;
    GameLogic_MODEL model_object;

    public JPanel initializeButtons(){
        buttons = new JButton[9];
        buttons_panel = new JPanel();
        result = 'X';
        buttons_ids = new HashMap<Integer, JButton>();
        model_object = new GameLogic_MODEL();

        buttons_panel.setLayout(new GridLayout(3,3));
        for(int j = 0; j <= 8; j++) {
            buttons[j] = new JButton();
            //buttons[j].setText("-");
            buttons_ids.put(j, buttons[j]);
            buttons_ids.get(j).setText("-");
        }
        for(int i = 0; i <= 8; i++) {
            buttons_ids.get(i).setBackground(Color.GRAY);
            buttons_panel.add(buttons_ids.get(i));
            buttons_ids.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JButton buttonClicked = (JButton) event.getSource();
                    buttonClicked.setText(String.valueOf(Character.valueOf(result)));
                    if(result == 'X') {
                        result = 'O';
                        buttonClicked.setBackground(new Color(102, 255, 255));
                    }else if (result == 'O'){
                        result ='X';
                        buttonClicked.setBackground(new Color(255, 255, 102));
                    }
                    model_object.Victorious(buttons_ids, result);
                }
            }
            );
        }
        return buttons_panel;
    }
}
