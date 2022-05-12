package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BodyMap extends JPanel implements ActionListener{
    
    Finder find;
    JButton[] buttons; 
    String thatSymptom;
    JTextField symptomEntry;
    JPanel parentPanel ;

    public BodyMap(JPanel panel, Finder find)
    {
        this.find = find;
        parentPanel = panel;
        buttons = new JButton[7];

        JButton headButton = new JButton();
        headButton.setIcon( new ImageIcon("head.jpg"));
        headButton.setFocusable(false);
        headButton.setBackground(new Color(72, 255, 186));
        headButton.setBounds(275, 213, 143, 90);
        headButton.setBorder(BorderFactory.createRaisedBevelBorder());
        headButton.addActionListener(this);
        buttons[0] = headButton;

        JButton upperBodyButton = new JButton();
        upperBodyButton.setIcon(new ImageIcon("upperBody.jpg"));
        upperBodyButton.setFocusable(false);
        upperBodyButton.setBounds(300, 302, 89, 166);
        upperBodyButton.setBackground(new Color(72, 255, 186));
        upperBodyButton.setBorder(BorderFactory.createRaisedBevelBorder());
        upperBodyButton.addActionListener(this);
        buttons[1] = upperBodyButton;

        JButton armsButton1 = new JButton();
        armsButton1.setIcon(new ImageIcon("leftHand.jpg"));
        armsButton1.setFocusable(false);
        armsButton1.setBounds(219, 302, 81, 241);
        armsButton1.setBackground(new Color(72, 255, 186));
        armsButton1.setBorder(BorderFactory.createRaisedBevelBorder());
        armsButton1.addActionListener(this);
        buttons[2] = armsButton1;

        JButton armsButton2 = new JButton();
        Icon icon = new ImageIcon("rightHand.jpg");
        armsButton2.setIcon(icon);
        armsButton2.setFocusable(false);
        armsButton2.setBounds(389, 302, 74, 235);
        armsButton2.setBackground(new Color(72, 255, 186));
        armsButton2.setBorder(BorderFactory.createRaisedBevelBorder());
        armsButton2.addActionListener(this);
        buttons[3] = armsButton2;

        JButton lowerBodyButton = new JButton();
        lowerBodyButton.setIcon(new ImageIcon("lowerBody.jpg"));
        lowerBodyButton.setFocusable(false);
        lowerBodyButton.setBounds(300, 468, 87, 259);
        lowerBodyButton.setBackground(new Color(72, 255, 186));
        lowerBodyButton.setBorder(BorderFactory.createRaisedBevelBorder());
        lowerBodyButton.addActionListener(this);
        buttons[4] = lowerBodyButton;

        JButton endButton = new JButton("FINISH");
        endButton.setFocusable(false);
        endButton.setBounds(1200, 600, 250, 150);
        endButton.setBackground(new Color(72, 255, 186));
        endButton.setBorder(BorderFactory.createRaisedBevelBorder());
        endButton.addActionListener(this);
        buttons[5] = endButton;

        JButton okeyButton = new JButton("OK");
        okeyButton.setFocusable(false);
        okeyButton.setBounds(1350, 300, 150, 100);
        okeyButton.setBackground(new Color(72, 255, 186));
        okeyButton.setBorder(BorderFactory.createRaisedBevelBorder());
        okeyButton.addActionListener(this);
        buttons[6] = okeyButton;
        
        symptomEntry = new JTextField("Please type your symptom.");
        symptomEntry.setBounds(850, 300, 500, 100);
        symptomEntry.setBackground(new Color(72, 255, 186));
        symptomEntry.setFont(new Font("Monospaced", Font.PLAIN, 30));
        symptomEntry.setEditable(true);

        JTextField textField = new JTextField("DIAGNOSELF");
        textField.setBackground(new Color(104, 213, 255));
        textField.setEditable(false);
        textField.setFont(new Font("Monospaced", Font.PLAIN, 100));
        textField.setBounds(0, 0, 1550, 100);
        textField.setHorizontalAlignment(JTextField.CENTER);
        

        this.setBackground(new Color(104, 213, 255));
        this.setSize(1550, 838);
        this.setLayout(null);
        this.setOpaque(true);
        this.add(headButton);
        this.add(upperBodyButton);
        this.add(armsButton1);
        this.add(armsButton2);
        this.add(lowerBodyButton);
        this.add(symptomEntry);
        this.add(okeyButton);
        this.add(endButton);
        this.add(textField);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == buttons[0])
        {   
            ArrayList<Integer> symptomIdsHead = new ArrayList<>();
            symptomIdsHead.add(1);
            symptomIdsHead.add(3);
            symptomIdsHead.add(5);
            symptomIdsHead.add(11);
            symptomIdsHead.add(13);
            symptomIdsHead.add(14);
            symptomIdsHead.add(15);
            symptomIdsHead.add(17);
            symptomIdsHead.add(18);
            symptomIdsHead.add(19);
            symptomIdsHead.add(20);
            symptomIdsHead.add(22);
            symptomIdsHead.add(24);
            symptomIdsHead.add(32);
            symptomIdsHead.add(34);
            symptomIdsHead.add(35);
            symptomIdsHead.add(36);
            symptomIdsHead.add(37);
            symptomIdsHead.add(38);
            this.removeAll();
            parentPanel.setPreferredSize(new Dimension(1538, 838 + 100 * symptomIdsHead.size())); 
            this.setSize(new Dimension(1538, 838 + 100 * symptomIdsHead.size()));
            this.add(new Symptoms(symptomIdsHead.size(), symptomIdsHead, find)); 
            revalidate();
            repaint();
        }
        if(e.getSource() == buttons[1])
        {
            ArrayList<Integer> symptomIdsBody = new ArrayList<>();
            symptomIdsBody.add(1);
            symptomIdsBody.add(2);
            symptomIdsBody.add(4);
            symptomIdsBody.add(5);
            symptomIdsBody.add(7);
            symptomIdsBody.add(11);
            symptomIdsBody.add(14);
            symptomIdsBody.add(15);
            symptomIdsBody.add(16);
            symptomIdsBody.add(17);
            symptomIdsBody.add(22);
            symptomIdsBody.add(25);
            symptomIdsBody.add(26);
            symptomIdsBody.add(29);
            symptomIdsBody.add(31);
            symptomIdsBody.add(32);
            symptomIdsBody.add(33);
            symptomIdsBody.add(34);
            this.removeAll();
            parentPanel.setPreferredSize(new Dimension(1538, 838 + 100 * symptomIdsBody.size()));
            this.setSize(new Dimension(1538, 838 + 100 * symptomIdsBody.size()));
            this.add(new Symptoms(symptomIdsBody.size(), symptomIdsBody, find));
            revalidate();
            repaint();
        }
        if(e.getSource() == buttons[2] || e.getSource() == buttons[3])
        {
            ArrayList<Integer> symptomIdsArms = new ArrayList<>();
            symptomIdsArms.add(1);
            symptomIdsArms.add(2);
            symptomIdsArms.add(4);
            symptomIdsArms.add(5);
            symptomIdsArms.add(6);
            symptomIdsArms.add(9);
            symptomIdsArms.add(11);
            symptomIdsArms.add(13);
            symptomIdsArms.add(14);
            symptomIdsArms.add(15);
            symptomIdsArms.add(16);
            symptomIdsArms.add(17);
            symptomIdsArms.add(22);
            symptomIdsArms.add(25);
            symptomIdsArms.add(31);
            symptomIdsArms.add(32);
            this.removeAll();
            parentPanel.setPreferredSize(new Dimension(1538, 838 + 100 * symptomIdsArms.size()));
            this.setSize(new Dimension(1538, 838 + 100 * symptomIdsArms.size()));
            this.add(new Symptoms(symptomIdsArms.size(), symptomIdsArms, find));
            revalidate();
            repaint();
        }
        if(e.getSource() == buttons[4])
        {
            ArrayList<Integer> symptomIdsLow = new ArrayList<>();
            symptomIdsLow.add(1);
            symptomIdsLow.add(2);
            symptomIdsLow.add(4);
            symptomIdsLow.add(5);
            symptomIdsLow.add(6);
            symptomIdsLow.add(9);
            symptomIdsLow.add(11);
            symptomIdsLow.add(12);
            symptomIdsLow.add(13);
            symptomIdsLow.add(14);
            symptomIdsLow.add(15);
            symptomIdsLow.add(16);
            symptomIdsLow.add(17);
            symptomIdsLow.add(21);
            symptomIdsLow.add(22);
            symptomIdsLow.add(23);
            symptomIdsLow.add(25);
            symptomIdsLow.add(27);
            symptomIdsLow.add(28);
            symptomIdsLow.add(30);
            symptomIdsLow.add(31);
            symptomIdsLow.add(31);
            this.removeAll();
            parentPanel.setPreferredSize(new Dimension(1538, 838 + 100 * symptomIdsLow.size()));
            this.setSize(new Dimension(1538, 838 + 100 * symptomIdsLow.size()));
            this.add(new Symptoms(symptomIdsLow.size(), symptomIdsLow, find));
            revalidate();
            repaint();
        }
        if(e.getSource() == buttons[5])
        {
            this.removeAll();
            this.add(new Illnesses(find));
            parentPanel.setPreferredSize(new Dimension(1538, 838 + 100 * find.illnessIds.size()));
            this.setSize(new Dimension(1538, 838 + 100 * find.illnessIds.size()));
            revalidate();
            repaint();
        }
        if(e.getSource() == buttons[6])
        {
            thatSymptom = symptomEntry.getText();

            /*for ( int i = 1; i <= find.symptomIds.size(); i++ ) {
                if (thatSymptom.equals(symptoms.name)) {
                    find.symptomIds.add(i);
                }
            }*/
            
        }
    }
}