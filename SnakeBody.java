package com.example.Snake;
import java.util.*;
import java.awt.*;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeBody
{
    public ArrayList<Point> body;
    public int bodylength;
    public SnakeBody(){
         body = new ArrayList<Point>();
         bodylength = 5;
    }
    
    public boolean isTail(int x, int y){
        for(int s=0; s<body.size(); s++){
            if(body.get(s).equals(new Point(x,y))){
                return true;
            }
        }
        return false;
    }
    
    public void addLength(){
        bodylength++;
    }
    
    public void add(Point x){
        body.add(x);
    }
}
