package com.example.Snake;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.ArrayList;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakePanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       ArrayList<Color> color = new ArrayList<Color>();
       color.add(Color.RED);
       color.add(Color.magenta);
       color.add(Color.black);
       color.add(Color.orange);
       color.add(Color.PINK);
       color.add(Color.yellow);
       color.add(Color.GREEN);
       color.add(Color.BLUE);
       color.add(Color.white);
       if(Board.prettyColors == true){
           g.setColor(color.get((int)(Math.random() * color.size())));
        }
       else{
           g.setColor(Color.white);
        }
       g.fillRect(0, 0, 720, 660);
       g.setColor(Color.black);
       for(int s=0; s<Board.snake.body.size(); s++){
           if(Board.prettyColors == true){
              g.setColor(color.get((int)(Math.random() * color.size())));
           }
           g.fillOval(Board.snake.body.get(s).x * 12, Board.snake.body.get(s).y * 12, 12, 12);
        }
       g.setColor(Color.RED);
       g.fillRect(Board.food.x * 12, Board.food.y * 12, 12, 12);
       g.setColor(Color.black);
       String score = "Score: " + Board.score;
       g.drawString(score, (int) (360 - score.length()), 10);
       if(Board.gameOver == true){
           String lose = "Game Over";
           String cont = "Press the spacebar to play again";
           g.drawString(lose,360-lose.length(),305);
           g.drawString(cont,360-cont.length()-40,355);
       }
       if(Board.pause == true){
           String pause = "Paused";
           g.drawString(pause,360-pause.length(), 330);
        }
    }
}
