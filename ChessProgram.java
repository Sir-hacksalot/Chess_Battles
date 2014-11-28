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

    private JPanel boardPanel;
    
    protected static JPanel p1TimePanel = new JPanel();
    protected static JPanel p2TimePanel  = new JPanel();
    
    protected static Graphics g1 = p1TimePanel.getGraphics();
    protected static Graphics g2 = p2TimePanel.getGraphics();
    
    private JTextField winner;
    private JTextField playerTurn;
    private JLabel title;
    private JButton button; //temporary
    private JButton button2; //temporary
    
    private Clock clock1;
    private Clock clock2;

    
    public static void main(String[] args) {
        ChessProgram frame = new ChessProgram();
        frame.setSize(1500,1000);
        frame.setVisible(true);
        frame.createGUI();
    }
    
    public void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        p1TimePanel.setSize(new Dimension(500,100));
        p1TimePanel.setBackground(Color.white);
        window.add(p1TimePanel);
        
        p2TimePanel.setSize(new Dimension(500,100));
        p2TimePanel.setBackground(Color.white);
        window.add(p2TimePanel);
        
        button = new JButton("start");
        button.addActionListener(this);
        window.add(button);
        
        button2 = new JButton ("stop");
        button.addActionListener(this);
        window.add(button2);
        
        int time = Integer.parseInt(JOptionPane.showInputDialog("Enter the "
                + "amount of time each player will have (in min):"));
        clock1 = new Clock(time, 1);
        clock2 = new Clock(time, 2);
        clock1.displayTime(g1, p1TimePanel);
        clock2.displayTime(g2, p2TimePanel);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source == button){
        clock1.startClock();
        }
        else {
        clock1.stopClock();
        }
    }
}