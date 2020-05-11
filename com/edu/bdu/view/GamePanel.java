package com.edu.bdu.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.edu.bdu.entities.Food;
import com.edu.bdu.entities.Ground;
import com.edu.bdu.entities.Snake;
import com.edu.bdu.util.Global;

public class GamePanel extends JPanel {
    private Snake snake;
    private Food food;
    private Ground ground;


    public void display(Snake snake, Food food, Ground ground) {
        System.out.println("GamePanel display");
        this.snake = snake;
        this.food = food;
        this.ground = ground;
        this.repaint();//������������paintComponent(Graphics g)
    }

    @Override
    protected void paintComponent(Graphics g) {
        //������ʾ
        //����֮ǰ��ͼ��
        g.setColor(new Color(0xcfcfcf));
        g.fillRect(0, 0, Global.WIDTH * Global.CELL_SIZE,
                Global.HEIGHT * Global.CELL_SIZE);

        this.snake.drawMe(g);
        this.food.drawMe();
        this.ground.drawMe();
    }


}
