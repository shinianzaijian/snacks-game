package com.edu.bdu.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.edu.bdu.controller.Controller;
import com.edu.bdu.entities.Food;
import com.edu.bdu.entities.Ground;
import com.edu.bdu.entities.Snake;
import com.edu.bdu.util.Global;
import com.edu.bdu.view.GamePanel;

public class Game {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Snake snake = new Snake();
        Food food = new Food();
        Ground ground = new Ground();
        GamePanel gamePanel = new GamePanel();

        Controller controller = new Controller(snake, food, ground, gamePanel);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel.setSize(Global.WIDTH * Global.CELL_SIZE,
                Global.HEIGHT * Global.CELL_SIZE);
        ;

        frame.setSize(Global.WIDTH * Global.CELL_SIZE,
                Global.HEIGHT * Global.CELL_SIZE);

        frame.add(gamePanel, BorderLayout.CENTER);

        gamePanel.addKeyListener(controller);
        snake.addSankeListener(controller);

        frame.setVisible(true);

        controller.newGame();


    }

}
