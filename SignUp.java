package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JPanel implements ActionListener{
    
    Finder find;
    JTextField username2;
    JTextField username;
    JTextField password2;
    JTextField password;
    JTextField name;
    JTextField name2;
    JTextField age2;
    JTextField age;
    ButtonGroup group;
    ButtonGroup group2;
    JButton endButton;
    JRadioButton female, male, pregnant, notPregnant;
    JScrollPane scrollPane;

    public SignUp()
    {
        find = new Finder();
        this.setLayout(null);
        female = new JRadioButton("Female");
        female.setBounds(900, 300, 200, 100);
        female.setBackground(new Color(104, 213, 255));
        female.setFocusable(false);
        female.setFont(new Font("Monospaced", Font.PLAIN, 30));
        female.addActionListener(this);

        male = new JRadioButton("Male");
        male.setBounds(1100, 300, 200, 100);
        male.addActionListener(this);
        male.setFocusable(false);
        male.setFont(new Font("Monospaced", Font.PLAIN, 30));
        male.setBackground(new Color(104, 213, 255));

        pregnant = new JRadioButton("Pregnant");
        pregnant.setFocusable(false);
        pregnant.setBounds(900, 500, 200, 100);
        pregnant.addActionListener(this);
        pregnant.setFont(new Font("Monospaced", Font.PLAIN, 30));
        pregnant.setBackground(new Color(104, 213, 255));

        notPregnant = new JRadioButton("Not Pregnant");
        notPregnant.setFocusable(false);
        notPregnant.setFont(new Font("Monospaced", Font.PLAIN, 30));
        notPregnant.setBounds(1100, 500, 300, 100);
        notPregnant.addActionListener(this);
        notPregnant.setBackground(new Color(104, 213, 255));

        endButton = new JButton("Go to Body Map");
        endButton.setFocusable(false);
        endButton.setBounds(1200, 650, 200, 100);
        endButton.setBackground(new Color(72, 255, 186));
        endButton.setBorder(BorderFactory.createRaisedBevelBorder());
        endButton.addActionListener(this);

        group = new ButtonGroup();
        group2 = new ButtonGroup();

        group.add(female);
        group.add(male);
        group2.add(pregnant);
        group2.add(notPregnant);
        
        name2 = new JTextField("Name and Surname: ");
        name2.setHorizontalAlignment(JTextField.CENTER);
        name2.setBounds(100, 150, 300, 100);
        name2.setFont(new Font("Monospaced", Font.PLAIN, 20));
        name2.setBackground(new Color(72, 255, 186));
        name2.setEditable(false);

        name = new JTextField();
        name.setFont(new Font("Monospaced", Font.PLAIN, 20));
        name.setBounds(400, 150, 300, 100);
        name.setBackground(new Color(72, 255, 186));
        name.setEditable(true);
        
        age2 = new JTextField("Age: ");
        age2.setHorizontalAlignment(JTextField.CENTER);
        age2.setBounds(100, 300, 300, 100);
        age2.setFont(new Font("Monospaced", Font.PLAIN, 20));
        age2.setBackground(new Color(72, 255, 186));
        age2.setEditable(false);

        age = new JTextField();
        age.setFont(new Font("Monospaced", Font.PLAIN, 20));
        age.setBounds(400, 300, 300, 100);
        age.setBackground(new Color(72, 255, 186));
        age.setEditable(true);
        
        username2 = new JTextField("Username: ");
        username2.setHorizontalAlignment(JTextField.CENTER);
        username2.setBounds(100, 450, 300, 100);
        username2.setFont(new Font("Monospaced", Font.PLAIN, 20));
        username2.setBackground(new Color(72, 255, 186));
        username2.setEditable(false);
        
        username = new JTextField();
        username.setEditable(true);
        username.setBackground(new Color(72, 255, 186));
        username.setBounds(400, 450, 300, 100);
        username.setFont(new Font("Monospaced", Font.PLAIN, 20));

        password2 = new JTextField("Password: ");
        password2.setHorizontalAlignment(JTextField.CENTER);
        password2.setBounds(100, 600, 300, 100);
        password2.setBackground(new Color(72, 255, 186));
        password2.setFont(new Font("Monospaced", Font.PLAIN, 20));
        password2.setEditable(false);
        
        password = new JTextField();
        password.setBackground(new Color(72, 255, 186));
        password.setBounds(400, 600, 300, 100);
        password.setFont(new Font("Monospaced", Font.PLAIN, 20));
        password.setEditable(true);

        JTextField textField = new JTextField("DIAGNOSELF");
        textField.setBackground(new Color(104, 213, 255));
        textField.setEditable(false);
        textField.setFont(new Font("Monospaced", Font.PLAIN, 100));
        textField.setBounds(0, 0, 1550, 100);
        textField.setHorizontalAlignment(JTextField.CENTER);

        this.add(textField);
        this.add(endButton);
        this.add(female);
        this.add(male);
        this.add(age);
        this.add(username2);
        this.add(username);
        this.add(password2);
        this.add(password);
        this.add(age2);
        this.add(name);
        this.add(name2);
        this.setBackground(new Color(104, 213, 255));
        this.setOpaque(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == female)
        {
            this.add(notPregnant);
            this.add(pregnant);
            repaint();
        }
        if(e.getSource() == male)
        {
            this.remove(notPregnant);
            this.remove(pregnant);
            repaint();
        }
        if(e.getSource() == endButton)
        {
            this.removeAll();
            this.add(new BodyMap(this,find));
            repaint();
        }
    }
}
