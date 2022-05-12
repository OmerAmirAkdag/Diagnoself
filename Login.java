package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JPanel implements ActionListener{

    Finder find;
    Component[] components;
    JButton endButton;
    JTextField username2;
    JTextField username;
    JTextField password2;
    JTextField password;
    JTextField textField;
    JLabel label;
    JScrollPane scrollPane;

    public Login()
    {
        find = new Finder();
        components = new Component[3];

        username2 = new JTextField("Username: ");
        username2.setHorizontalAlignment(JTextField.CENTER);
        username2.setFont(new Font("Monospaced", Font.PLAIN, 30));
        username2.setBackground(new Color(72, 255, 186));
        username2.setEditable(false);
        username2.setBounds(400, 300, 200, 100);
        
        username = new JTextField("");
        username.setEditable(true);
        username.setBackground(new Color(72, 255, 186));
        username.setFont(new Font("Monospaced", Font.PLAIN, 30));
        username.setBounds(650, 300, 200, 100);
        components[0] = username;

        password2 = new JTextField("Password: ");
        password2.setHorizontalAlignment(JTextField.CENTER);
        password2.setBackground(new Color(72, 255, 186));
        password2.setFont(new Font("Monospaced", Font.PLAIN, 30));
        password2.setEditable(false);
        password2.setBounds(400, 500, 200, 100);

        password = new JTextField("");
        password.setBackground(new Color(72, 255, 186));
        password.setFont(new Font("Monospaced", Font.PLAIN, 30));
        password.setEditable(true);
        password.setBounds(650, 500, 200, 100);
        components[1] = password;

        endButton = new JButton("Go to Body Map");
        endButton.setFocusable(false);
        endButton.setBounds(1200, 600, 200, 100);
        endButton.setBackground(new Color(72, 255, 186));
        endButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        endButton.addActionListener(this);
        components[2] = endButton;

        textField = new JTextField("DIAGNOSELF");
        textField.setBackground(new Color(104, 213, 255));
        textField.setEditable(false);
        textField.setFont(new Font("Monospaced", Font.PLAIN, 100));
        textField.setBounds(0, 0, 1550, 100);
        textField.setHorizontalAlignment(JTextField.CENTER);

        label = new JLabel();
        label.setSize(1550, 838);
        label.setBackground(new Color(104, 213, 255));
        label.setPreferredSize(new Dimension(1550, 838));
        label.setOpaque(true);
         
        label.add(textField);
        label.add(username2);
        label.add(username);
        label.add(password2);
        label.add(password);
        label.add(endButton);

        this.add(label);
        this.setLayout(null);
        this.setBackground(new Color(104, 213, 255));
        this.setOpaque(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == components[2])
        {
            this.removeAll();
            this.add(new BodyMap(this, find));
            revalidate();
            repaint(); 
        }
    }
}
