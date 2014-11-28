/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessprogram;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Evan
 */
public class Clock {
    
    private int s = 0; //this is used to keep track of how many seconds
                        //have passed. Counts down to 0, then resets.
    private int second = 1000;
    private int min = 60 * second;
    private int time = 0;
    private int p1; //the player number i.e. 1 or 2
    
    private ImageIcon digit0 = new ImageIcon("digit_0.jpg");
    private ImageIcon digit1 = new ImageIcon("digit_1.jpg");
    private ImageIcon digit2 = new ImageIcon("digit_2.jpg");
    private ImageIcon digit3 = new ImageIcon("digit_3.jpg");
    private ImageIcon digit4 = new ImageIcon("digit_4.jpg");
    private ImageIcon digit5 = new ImageIcon("digit_5.jpg");
    private ImageIcon digit6 = new ImageIcon("digit_6.jpg");
    private ImageIcon digit7 = new ImageIcon("digit_7.jpg");
    private ImageIcon digit8 = new ImageIcon("digit_8.jpg");
    private ImageIcon digit9 = new ImageIcon("digit_9.jpg");
    private ImageIcon colon = new ImageIcon ("digit_colon.jpg");
    
    ActionListener tick = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            time-=second; //timer ticks every second
            
            checkSeconds();
            
            if (p1 == 1){
                displayTime(ChessProgram.p1TimePanel);
            }
            else{
                displayTime(ChessProgram.p2TimePanel);
            }
        }
    };
    private Timer timer = new Timer (second, tick);
    
    //constructor
    public Clock(int minutes, int player){
        time = minutes * min; //converts to milliseconds
        p1 = player;
        //displays the unchanged time before the game starts
        if(p1==1){
            displayTime(ChessProgram.p1TimePanel);
        }
        else{
            displayTime(ChessProgram.p2TimePanel);
        }
    }
    //starts the timer
    public void startClock(){
        timer.start();
    }
    //stops the timer
    public void stopClock(){
        timer.stop();
    }
    
    public void displayTime(JPanel p){
        
        Graphics g;
        if(p1==1){
            g = ChessProgram.p1TimePanel.getGraphics();
        }
        else{
            g = ChessProgram.p2TimePanel.getGraphics();
        }
        g.setColor(Color.white); //resets the panel to a blank white screen
        g.fillRect(0,0,500,100); //so the numbers can go on fresh
        
        int minutes = time / min;
        int m1 = minutes / 10; //used for the 10's digit of minutes remaining
        int m2 = minutes % 10; //used for the 1's digit of minutes remaining
        int hours = minutes / 60;
        int h1 = hours / 10; //used for the 10's digit of hours remaining
        int h2 = hours % 10; //used for the 1's digit of hours remaining
        int s1 = s / 10; //used for the 10's digit of seconds remaining
        int s2 = s % 10; //used for the 1's digit of seconds remaining
        
        switch (h1){ //paints the 10's digit of the hours remaining
            case 0:
                digit0.paintIcon(p, g, 0, 0);
                break;
            default:
                digit0.paintIcon(p, g, 0, 0);
        }
        
        switch (h2){ //paints the 1's digit of the hours remaining
            case 0:
                digit0.paintIcon(p, g, 75, 0);
                break;
            case 1:
                digit1.paintIcon(p, g, 75, 0);
                break;
            case 2:
                digit2.paintIcon(p, g, 75, 0);
                break;
            case 3:
                digit3.paintIcon(p, g, 75, 0);
                break;
            case 4:
                digit4.paintIcon(p, g, 75, 0);
                break;
            case 5:
                digit5.paintIcon(p, g, 75, 0);
                break;
            case 6:
                digit6.paintIcon(p, g, 75, 0);
                break;
            case 7:
                digit7.paintIcon(p, g, 75, 0);
                break;
            case 8:
                digit8.paintIcon(p, g, 75, 0);
                break;
            case 9:
                digit9.paintIcon(p, g, 75, 0);
                break;
        }
        
        colon.paintIcon(p, g, 150, 0);
        
        switch (m1){ //paint the 10's digit of the minutes remaining
            case 0:
                digit0.paintIcon(p, g, 175, 0);
                break;
            case 1:
                digit1.paintIcon(p, g, 175, 0);
                break;
            case 2:
                digit2.paintIcon(p, g, 175, 0);
                break;
            case 3:
                digit3.paintIcon(p, g, 175, 0);
                break;
            case 4:
                digit4.paintIcon(p, g, 175, 0);
                break;
            case 5:
                digit5.paintIcon(p, g, 175, 0);
                break;
            case 6:
                digit6.paintIcon(p, g, 175, 0);
                break;
            default:
                digit0.paintIcon(p, g, 175, 0);
                break;
        }
        
        switch (m2){ //paints the 1's digit of the minutes remaining
            case 0:
                digit0.paintIcon(p, g, 250, 0);
                break;
            case 1:
                digit1.paintIcon(p, g, 250, 0);
                break;
            case 2:
                digit2.paintIcon(p, g, 250, 0);
                break;
            case 3:
                digit3.paintIcon(p, g, 250, 0);
                break;
            case 4:
                digit4.paintIcon(p, g, 250, 0);
                break;
            case 5:
                digit5.paintIcon(p, g, 250, 0);
                break;
            case 6:
                digit6.paintIcon(p, g, 250, 0);
                break;
            case 7:
                digit7.paintIcon(p, g, 250, 0);
                break;
            case 8:
                digit8.paintIcon(p, g, 250, 0);
                break;
            case 9:
                digit9.paintIcon(p, g, 250, 0);
                break;
            default:
                digit0.paintIcon(p, g, 250, 0);
                break;
        }
        colon.paintIcon(p, g, 325, 0);
        switch (s1){ //paints the 10's digit of the seconds remaining
            case 0:
                digit0.paintIcon(p, g, 350, 0);
                break;
            case 1:
                digit1.paintIcon(p, g, 350, 0);
                break;
            case 2:
                digit2.paintIcon(p, g, 350, 0);
                break;
            case 3:
                digit3.paintIcon(p, g, 350, 0);
                break;
            case 4:
                digit4.paintIcon(p, g, 350, 0);
                break;
            case 5:
                digit5.paintIcon(p, g, 350, 0);
                break;
            case 6:
                digit6.paintIcon(p, g, 350, 0);
                break;
            default:
                digit0.paintIcon(p, g, 350, 0);
                break;
        }
        
        switch (s2){ //paints the 1's digit of the seconds remaining
            case 0:
                digit0.paintIcon(p, g, 425, 0);
                break;
            case 1:
                digit1.paintIcon(p, g, 425, 0);
                break;
            case 2:
                digit2.paintIcon(p, g, 425, 0);
                break;
            case 3:
                digit3.paintIcon(p, g, 425, 0);
                break;
            case 4:
                digit4.paintIcon(p, g, 425, 0);
                break;
            case 5:
                digit5.paintIcon(p, g, 425, 0);
                break;
            case 6:
                digit6.paintIcon(p, g, 425, 0);
                break;
            case 7:
                digit7.paintIcon(p, g, 425, 0);
                break;
            case 8:
                digit8.paintIcon(p, g, 425, 0);
                break;
            case 9:
                digit9.paintIcon(p, g, 425, 0);
                break;
        }
    }
    //The following checks to see if the seconds are at zero; if they
    //are, it resets them to 60. If they are not, it reduces the seconds
    //by one.
    public void checkSeconds(){
        if(s == 0){
            s = 59;
        } else { s--; }
    }
}