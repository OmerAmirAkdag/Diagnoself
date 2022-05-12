package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Framer extends JFrame implements ActionListener{

    JButton[] buttons = new JButton[2];
    JScrollPane scrollPane;
    JLabel label;
    
    public Framer()
    {
        JButton loginButton = new JButton("LOGIN");
        loginButton.setFocusable(false);
        loginButton.setBounds(575, 500, 400, 200);
        loginButton.setBackground(new Color(72, 255, 186));
        loginButton.setBorder(BorderFactory.createRaisedBevelBorder());
        buttons[0] = loginButton;
        loginButton.addActionListener(this);

        JButton signUpButton = new JButton("SIGN UP");
        signUpButton.setFocusable(false);
        signUpButton.setBounds(575, 250, 400, 200);
        signUpButton.setBackground(new Color(72, 255, 186));
        signUpButton.setBorder(BorderFactory.createRaisedBevelBorder());
        buttons[1] = signUpButton;
        signUpButton.addActionListener(this);

        JTextField textField = new JTextField("DIAGNOSELF");
        textField.setBackground(new Color(104, 213, 255));
        textField.setEditable(false);
        textField.setFont(new Font("Monospaced", Font.PLAIN, 100));
        textField.setBounds(0, 0, 1550, 100);
        textField.setHorizontalAlignment(JTextField.CENTER);

        label = new JLabel();
        label.setBackground(new Color(104, 213, 255));
        label.setSize(1550, 838);
        label.setPreferredSize(new Dimension(1550, 838));
        label.setForeground(Color.black);
        label.setOpaque(true);
        label.add(textField);
        label.add(signUpButton);
        label.add(loginButton);
        
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(label);

        this.add(scrollPane);
        this.setTitle("DIAGNOSELF"); 
        this.setVisible(true);
        this.setSize(1550, 838);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == buttons[0])
        {
            scrollPane.remove(label);
            JPanel loginPanel = new Login();
            loginPanel.setPreferredSize(new Dimension(1550, 838));
            scrollPane.setViewportView(loginPanel);
            revalidate();
            repaint(); 
        }
        else if(e.getSource() == buttons[1])
        {
            scrollPane.remove(label);;
            JPanel signUpPanel = new SignUp();
            signUpPanel.setPreferredSize(new Dimension(1550, 838));
            scrollPane.setViewportView(signUpPanel);
            revalidate();
            repaint();
        }
    }
}