package edu.hitsz.swing;

import edu.hitsz.Thread.MusicThread;
import edu.hitsz.application.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu {
    private JPanel MainPanel;
    private JButton easyButton;
    private JButton normalButton;
    private JButton difficultButton;
    private JComboBox<String> MusiccomboBox;

    private static int difficulty;
    //0:easy 1:normal 2:difficult

    public static void setDifficulty(int difficulty) {
        StartMenu.difficulty = difficulty;
    }

    public static int getDifficulty(){
        return StartMenu.difficulty;
    }

    public StartMenu() {
        MusiccomboBox.addItem("开");
        MusiccomboBox.addItem("关");


        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game=new EasyGame();
                Main.cardPanel.add(game);
                Main.cardLayout.last(Main.cardPanel);
                StartMenu.setDifficulty(0);
                game.action();
            }
        });
        normalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game=new NormalGame();
                Main.cardPanel.add(game);
                Main.cardLayout.last(Main.cardPanel);
                StartMenu.setDifficulty(1);
                game.action();

            }
        });
        difficultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game=new DifficultGame();
                Main.cardPanel.add(game);
                Main.cardLayout.last(Main.cardPanel);
                StartMenu.setDifficulty(2);
                game.action();
            }
        });

        MusiccomboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) MusiccomboBox.getSelectedItem();
                if (selectedValue.equals("开")){
                    MusicThread.ifOpen=true;
                }
                else MusicThread.ifOpen=false;
            }
        });
    }
    public JPanel getMainPanel() {
        return MainPanel;
    }



}
