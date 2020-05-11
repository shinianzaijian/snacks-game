package com.edu.bdu.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.edu.bdu.controller.SnakeListener;
import com.edu.bdu.util.Global;

public class Snake {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private int direction;

    private Set<SnakeListener> listeners = new HashSet<SnakeListener>();

    private LinkedList<Point> body = new LinkedList<Point>();

    public Snake() {
        init();
    }

    public void init() {
        //��x,y��GamePanel�����ĵ�
        int x = Global.HEIGHT / 2;
        int y = Global.WIDTH / 2;

        for (int i = 0; i < 3; i++) {
            body.addLast(new Point(x--, y));
        }
        direction = RIGHT;

    }

    //�ƶ�(��һ��)
    public void move() {
        System.out.println("snake move");
        //1.ȥβ
        body.removeLast();

        int x = body.getFirst().x;
        int y = body.getFirst().y;
        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
        //2.��ͷ

        Point newHead = new Point(x, y);//�ؼ����µ�ͷ������
        body.addFirst(newHead);
    }

    //�ı䷽��
    public void changeDirection() {
        System.out.println("snake changeDirection");
    }

    //��ʳ��(����䳤)
    public void eatFood() {
        System.out.println("snake eatFood");
    }

    //���Ƿ�Ե����Լ�������
    public boolean isEatBody() {
        System.out.println("snake isEatBody?");
        return false;
    }

    //��ʾ
    public void drawMe(Graphics g) {
        System.out.println("snake drawMe");

        g.setColor(Color.BLUE);

        for (Point p : body) {
            //���ߵ�����
            g.fill3DRect(p.x * Global.CELL_SIZE, p.y * Global.CELL_SIZE,
                    Global.CELL_SIZE, Global.CELL_SIZE, true);
        }
    }

    //������ͣ���߶���ʹ���߳���ʵ�֣�����һ��ר�ŵ��ڲ���
    private class SnakeDriver implements Runnable {

        @Override
        public void run() {
            while (true) {
                move();
                for (SnakeListener l : listeners) {
                    l.snakeMoved(Snake.this);
                }
                //����һ��ʱ��
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }

    }

    public void start() {
        new Thread(new SnakeDriver()).start();//��ָ���߳�����
    }

    public void addSankeListener(SnakeListener l) {
        if (l != null) {
            //�������ӵ�ʲô�ط���
            this.listeners.add(l);
        }
    }


}
