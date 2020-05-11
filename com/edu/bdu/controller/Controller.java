package com.edu.bdu.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.edu.bdu.entities.Food;
import com.edu.bdu.entities.Ground;
import com.edu.bdu.entities.Snake;
import com.edu.bdu.view.GamePanel;

/*
 * ����
 * �¼�������������
 */
public class Controller extends KeyAdapter implements SnakeListener {

    private Snake snake;
    private Food food;
    private Ground ground;
    private GamePanel gamePanel;

    public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
        super();
        this.snake = snake;
        this.food = food;
        this.ground = ground;
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //�ж��û������Ǹ���
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                snake.changeDirection();
                break;
            case KeyEvent.VK_DOWN:
                snake.changeDirection();
                break;
            case KeyEvent.VK_LEFT:
                snake.changeDirection();
                break;
            case KeyEvent.VK_RIGHT:
                snake.changeDirection();
                break;
        }

    } //KeyAdapter������

    @Override
    public void snakeMoved(Snake snake) {
        gamePanel.display(snake, food, ground);
    }

    //����
    /*
     * 1.�¼�Դ���¼������ĵط� ������Ķ���  2.�¼�������Ҫ���������� ���ӿڣ�
     * 3.ʱ�䴦��������Է��������������Ĵ����� ���Խӿڵ�ʵ�֣�4.�¼����������ǰ��¼�Դ���¼��������� ��ע�������
     */

    public void newGame() {
        snake.start();
    }


}
