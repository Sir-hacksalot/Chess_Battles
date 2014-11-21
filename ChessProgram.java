/*
 * Author: Evan Moore, Scott Curtis
 * Date: Oct 4 2014
 * Purpose: Plays the game of chess
 */
package chessprogram;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessProgram extends JFrame implements ActionListener{

    private int second = 1000;
    private int minute = 60 * second;
    private int p1Time = 0;
    private int p2Time = 0;
    ActionListener tick = new ActionListener(){
        public void actionPerformed (ActionEvent e){
            Object source = e.getSource();
            timeHandler(source);
        }
    };
    private Timer timer1 = new Timer (second, tick);
    private Timer timer2 = new Timer (second, tick);
    
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
    
    
    private JPanel boardPanel;
    private JPanel p1TimePanel, p2TimePanel;
    private JTextField winner;
    private JTextField playerTurn;
    private JLabel title;
    private JButton button;

    
    public static void main(String[] args) {
        ChessProgram frame = new ChessProgram();
        frame.setSize(1500,1500);
        frame.setVisible(true);
        frame.createGUI();
        
    }
    
    public void createGUI(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        p1TimePanel = new JPanel();
        p1TimePanel.setPreferredSize(new Dimension(425, 100));
        p1TimePanel.setBackground(Color.white);
        window.add(p1TimePanel);
        
        p2TimePanel = new JPanel();
        p2TimePanel.setPreferredSize(new Dimension(425, 100));
        p2TimePanel.setBackground(Color.white);
        window.add(p2TimePanel);
        
        button = new JButton("Press me");
        button.addActionListener(this);
        window.add(button);
    }   

    
    public void actionPerformed (ActionEvent evt){
        Object source = evt.getSource();
        if (source == button){
            startClock();
        }
    }

    public void startClock(){
        
        String str = JOptionPane.showInputDialog(null, "Enter time limit "
                + "per player (in min): ");
        p1Time = minute * Integer.parseInt(str);
        p2Time = minute * Integer.parseInt(str);
        
        timer1.start();
    }
    
    public void timeHandler(Object source){
        
        Graphics p1 = p1TimePanel.getGraphics();
        Graphics p2 = p2TimePanel.getGraphics();
        if(source==timer1){
            p1Time-=second;
            writeTime(p1, p1Time);
        }
        else{
            p2Time-=second;
            writeTime(p2, p2Time);
        }
    }
    
    public void writeTime(Graphics pTime, int t){
        int hours = t / (60 * minute);
        int mins = t % (60 * minute) / minute;
        int seconds = t % (60*minute) % mins / second;
        
        switch (hours){
            case 0:
                digit0.paintIcon(this, pTime, 0, 0);
                break;
            case 1:
                digit1.paintIcon(this, pTime, 0, 0);
                break;
            case 2:
                digit2.paintIcon(this, pTime, 0, 0);
                break;
            case 3:
                digit3.paintIcon(this, pTime, 0, 0);
                break;
            case 4:
                digit4.paintIcon(this, pTime, 0, 0);
                break;
            case 5:
                digit5.paintIcon(this, pTime, 0, 0);
                break;
            case 6:
                digit6.paintIcon(this, pTime, 0, 0);
                break;
            case 7:
                digit7.paintIcon(this, pTime, 0, 0);
                break;
            case 8:
                digit8.paintIcon(this, pTime, 0, 0);
                break;
            case 9:
                digit9.paintIcon(this, pTime, 0, 0);
                break;
            default:
                break;
        }
        colon.paintIcon(this, pTime, 75, 0);
        
        if (mins >= 0 && mins < 10){
            digit0.paintIcon(this, pTime, 100, 0);
        }
        else if (mins >=10 && mins <20){
            digit1.paintIcon(this, pTime, 100, 0);
        }
        else if (mins >=20 && mins <30){
            digit2.paintIcon(this, pTime, 100, 0);
        }
        else if (mins >=30 && mins <40){
            digit3.paintIcon(this, pTime, 100, 0);
        }
        else if (mins >=40 && mins <50){
            digit4.paintIcon(this, pTime, 100, 0);
        }
        else{
            digit5.paintIcon(this, pTime, 100, 0);
        }
        mins /= 10;
            switch (mins){
                case 0:
                    digit0.paintIcon(this, pTime, 175, 0);
                    break;
                case 1:
                    digit1.paintIcon(this, pTime, 175, 0);
                    break;
                case 2:
                    digit2.paintIcon(this, pTime, 175, 0);
                    break;
                case 3:
                    digit3.paintIcon(this, pTime, 175, 0);
                    break;
                case 4:
                    digit4.paintIcon(this, pTime, 175, 0);
                    break;
                case 5:
                    digit5.paintIcon(this, pTime, 175, 0);
                    break;
                case 6:
                    digit6.paintIcon(this, pTime, 175, 0);
                    break;
                case 7:
                    digit7.paintIcon(this, pTime, 175, 0);
                    break;
                case 8:
                    digit8.paintIcon(this, pTime, 175, 0);
                    break;
                case 9:
                    digit9.paintIcon(this, pTime, 175, 0);
                    break;
                default:
                    break;
            }
            
        colon.paintIcon(this, pTime, 250, 0);
        
        if (seconds >= 0 && seconds < 10){
            digit0.paintIcon(this, pTime, 275, 0);
        }
        else if (seconds >=10 && seconds <20){
            digit1.paintIcon(this, pTime, 275, 0);
        }
        else if (seconds >=20 && seconds <30){
            digit2.paintIcon(this, pTime, 275, 0);
        }
        else if (seconds >=30 && seconds <40){
            digit3.paintIcon(this, pTime, 275, 0);
        }
        else if (seconds >=40 && seconds <50){
            digit4.paintIcon(this, pTime, 275, 0);
        }
        else{
            digit5.paintIcon(this, pTime, 275, 0);
        }
        seconds /= 10;
            switch (seconds){
                case 0:
                    digit0.paintIcon(this, pTime, 350, 0);
                    break;
                case 1:
                    digit1.paintIcon(this, pTime, 350, 0);
                    break;
                case 2:
                    digit2.paintIcon(this, pTime, 350, 0);
                    break;
                case 3:
                    digit3.paintIcon(this, pTime, 350, 0);
                    break;
                case 4:
                    digit4.paintIcon(this, pTime, 350, 0);
                    break;
                case 5:
                    digit5.paintIcon(this, pTime, 350, 0);
                    break;
                case 6:
                    digit6.paintIcon(this, pTime, 350, 0);
                    break;
                case 7:
                    digit7.paintIcon(this, pTime, 350, 0);
                    break;
                case 8:
                    digit8.paintIcon(this, pTime, 350, 0);
                    break;
                case 9:
                    digit9.paintIcon(this, pTime, 350, 0);
                    break;
                default:
                    break;
            }
    }
}