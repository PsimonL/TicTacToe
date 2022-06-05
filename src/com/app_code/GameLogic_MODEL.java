package com.app_code;

import javax.swing.*;
import java.util.HashMap;
import java.awt.Color;
public class GameLogic_MODEL extends Board_VIEW{
    public void Victorious(HashMap<Integer, JButton> buttons_ids, char result){
        System.out.println(result);
        if(if_winner(buttons_ids)){
            if(result == 'X'){
                result = 'O';
                System.out.println("KONIEC GRY - WYGRYWA O");
            } else {
                result = 'X';
                System.out.println("KONIEC GRY  - WYGRYWA X");
            }
            JOptionPane pane = new JOptionPane();
//            if(result  == 'X') {
//                result = 'O';
//            }else {
//                result = 'X';
//            }
            String message = "Wygrał gracz " + result + ". Rematch?";
            int messageAfterGame = JOptionPane.showConfirmDialog(pane, message,"Koniec gry.", JOptionPane.YES_NO_OPTION);
            if(messageAfterGame == JOptionPane.YES_OPTION){
                resetButtoins(buttons_ids, result);
            }else{
                System.exit(0);
            }
        }else if(if_draw(buttons_ids)){
            System.out.println("remis");
            JOptionPane pane = new JOptionPane();
            int messageAfterGame = JOptionPane.showConfirmDialog(pane, "Draw. Play again?","Koniec gry.", JOptionPane.YES_NO_OPTION);
            if(messageAfterGame == JOptionPane.YES_OPTION){
                resetButtoins(buttons_ids, result);
            }else{
                System.exit(0);
            }
        }
    }
    private void resetButtoins(HashMap<Integer, JButton> buttons_ids, char result){
        result = 'X';
        for(int i = 0; i < 9; i++){
            buttons_ids.get(i).setText("-");
            buttons_ids.get(i).setBackground(Color.white);
        }
    }
    public boolean if_winner(HashMap<Integer, JButton> buttons_ids) {
        boolean temp = true;
        if(check_rows(buttons_ids) || check_columns(buttons_ids) || check_diagonals(buttons_ids)) {
            return temp;
        } else {
            temp = false;
            return temp;
        }
    }
    public boolean if_draw(HashMap<Integer, JButton> buttons_ids) {
        boolean full = true;
        for(int i = 0 ; i<9;i++) {
            if(buttons_ids.get(i).getText().charAt(0) == '-') {
                full = false;
            }
        }
        return full;
    }
    public boolean check_rows(HashMap<Integer, JButton> buttons_ids) {
        for(int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 3; j++) {
                if (buttons_ids.get(i).getText().equals(buttons_ids.get(i + 1).getText()) && buttons_ids.get(i).getText().equals(buttons_ids.get(i + 2).getText())
                        && buttons_ids.get(i).getText().charAt(0) != '-') {
                    System.out.println("koniec gry -> check_rows working");
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check_columns(HashMap<Integer, JButton> buttons_ids) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(buttons_ids.get(i).getText().equals(buttons_ids.get(i + 3).getText()) && buttons_ids.get(i).getText().equals(buttons_ids.get(i + 6).getText())
                        && buttons_ids.get(i).getText().charAt(0) != '-'){
                    System.out.println("koniec gry -> check_columns working");
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check_diagonals(HashMap<Integer, JButton> buttons_ids) {
        if(buttons_ids.get(0).getText().equals(buttons_ids.get(4).getText()) && buttons_ids.get(0).getText().equals(buttons_ids.get(8).getText())
                && buttons_ids.get(0).getText().charAt(0) !='-') {
            System.out.println("koniec gry -> check_diagonals working");
            return true;
        } else if(buttons_ids.get(2).getText().equals(buttons_ids.get(4).getText()) && buttons_ids.get(2).getText().equals(buttons_ids.get(6).getText())
                && buttons_ids.get(2).getText().charAt(0) !='-') {
            System.out.println("koniec gry check_diagonals working");
            return true;
        } else {
            return false;
     }
    }
}
