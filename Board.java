package com.example.Snake;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 */
public class Board implements KeyListener, ActionListener
{
    public static SnakeBody snake;
    public static Board board;
    public JFrame jframe;
    public static Point head;
    public static final int up = 1, down = 2, left = 3, right = 4;
    public static Point food;
    public static boolean gameOver;
    public int direction;
    public static int score;
    public int time;
    public static int speed = 3;
    public Timer timer = new Timer(20, this);
    public static final int XLength = 60, YLength = 55;
    public SnakePanel panel;
    public menuBar menu;
    public static boolean pause;
    public static boolean prettyColors;
    public Board(){
        jframe = new JFrame("Snake");
        menu = new menuBar();
        jframe.addKeyListener(this);
        jframe.setJMenuBar(menu);
        jframe.add(panel = new SnakePanel());
        jframe.setSize(732, 716);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start();
    }
    
    public void start(){
        snake = new SnakeBody();
        food = new Point ((int)(Math.random()*XLength), (int)(Math.random()*YLength));
        gameOver = false;
        direction = down;
        score = 0;
        head = new Point(10,10);
        timer.start();
        pause = false;
        prettyColors = false;
    }
    
    public void move(){
        if(time % speed ==0){
            if(head!=null && !pause){
                snake.add(new Point(head.x, head.y));
                if(snake.body.size() > snake.bodylength){
                    snake.body.remove(0);
                }
                if(direction == left){
                    if(head.x-1>=0 && !(snake.isTail(head.x-1, head.y))){
                        head = new Point(head.x-1, head.y);
                    }
                    else{
                        gameOver = true;
                    }
                }
                if(direction == right){
                    if(head.x+1<XLength && !(snake.isTail(head.x+1, head.y))){
                        head = new Point(head.x+1, head.y);
                    }
                    else{
                        gameOver = true;
                    }
                }
                if(direction == up){
                    if(head.y-1>=0 && !(snake.isTail(head.x, head.y-1))){
                        head = new Point(head.x, head.y-1);
                    }
                    else{
                        gameOver = true;
                    }
                }
                if(direction == down){
                    if(head.y+1<YLength && !(snake.isTail(head.x, head.y+1))){
                        head = new Point(head.x, head.y+1);
                    }
                    else{
                        gameOver = true;
                    }
                }
                    if(head.equals(food)){
                        score++;
                        snake.addLength();
                        food = new Point ((int)(Math.random()*XLength), (int)(Math.random()*YLength));
                }
            }
        }
        time++;
    }
    
    public static void main(String args[]){
        board = new Board();
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        panel.repaint();
        if(!gameOver) {
            move();
        }
    }
    
     @Override
    public void keyPressed(KeyEvent e){
        int arrow = e.getKeyCode();
        if(arrow == KeyEvent.VK_LEFT && direction!=right){
            direction = left;
        }
        if(arrow == KeyEvent.VK_RIGHT && direction!=left){
            direction = right;
        }
        if(arrow == KeyEvent.VK_UP && direction!=down){
            direction = up;
        }
        if(arrow == KeyEvent.VK_DOWN && direction!=up){
            direction = down;
        }
        if(arrow == KeyEvent.VK_SPACE && gameOver){
                start();
            }
        if(arrow == KeyEvent.VK_P){
            pause = !pause;
        }
    }
     @Override
    public void keyReleased(KeyEvent e){
    
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
}
