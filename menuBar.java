package com.example.Snake;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class menuBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menuBar extends JMenuBar
{
    JMenu file;
    JMenuItem exit;
    JMenu cheats;
    JMenuItem prettyColors;
    JMenuItem grow;
    JMenu difficulty;
    JMenuItem easy;
    JMenuItem medium;
    JMenuItem hard;
    menuBar(){
        file = new JMenu("File");
        this.add(file);
        exit = new JMenuItem("Exit");
        file.add(exit);
        
        cheats = new JMenu("Cheats");
        this.add(cheats);
        prettyColors = new JMenuItem("Pretty Colors");
        cheats.add(prettyColors);
        grow = new JMenuItem("Grow Forever");
        cheats.add(grow);
        
        difficulty = new JMenu("Difficulty");
        this.add(difficulty);
        easy = new JMenuItem("Easy");
        medium = new JMenuItem("Medium");
        hard = new JMenuItem("Hard");
        difficulty.add(easy);
        difficulty.add(medium);
        difficulty.add(hard);
        
        
        event1 leave = new event1();
        exit.addActionListener(leave);
        
        event2 color = new event2();
        prettyColors.addActionListener(color);
        
        event3 big = new event3();
        grow.addActionListener(big);
        
        event4 level1 = new event4();
        easy.addActionListener(level1);
        
        event5 level2 = new event5();
        medium.addActionListener(level2);
        
        event6 level3 = new event6();
        hard.addActionListener(level3);
    }
    
    public class event1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    public class event2 implements ActionListener{
       public void actionPerformed(ActionEvent e){
            Board.prettyColors = !Board.prettyColors;
            Board.pause = false;
        } 
    }
    
    public class event3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Board.snake.bodylength = 1000;
            Board.score = 1000;
            Board.pause = false;
        } 
    }
    
    public class event4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Board.speed = 5;
            Board.pause = false;
        }
    }
    
    public class event5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Board.speed = 3;
            Board.pause= false;
        }
    }
    
    public class event6 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Board.speed = 1;
            Board.pause = false;
        }
    }
}
