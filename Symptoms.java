package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.*;

public class Symptoms extends JPanel implements ActionListener{
    
    Finder find;
    ArrayList<Integer> symptomId;
    JButton[] buttonArray;
    int numberOfSymtomps;

    public Symptoms(int numberOfSymtomps, ArrayList<Integer> symptomId, Finder find)
    {
        this.find = find;
        this.symptomId = symptomId;
        this.numberOfSymtomps = numberOfSymtomps;
        buttonArray = new JButton[numberOfSymtomps];

        for(int i = 0; i < numberOfSymtomps; i++)
        {
            Connection connection = null;
            try {
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/maindb",
                    "yaseminakin", "xxx");
                PreparedStatement statement;
                ResultSet resultSet;
                statement = connection.prepareStatement("select * from symptoms where symptomid = ?");
                statement.setInt(1, symptomId.get(i));
                resultSet = statement.executeQuery();
                int code;
                String title;
                while (resultSet.next()) {
                    code = resultSet.getInt("symptomId");
                    title = resultSet.getString("symptomName");
                    JButton aButton = new JButton();
                    aButton.setText("" + code + " " + title);
                    aButton.setBounds(525, 160 + i*110 , 500, 100);
                    aButton.setBackground(new Color(72, 255, 186));
                    buttonArray[i] = aButton;
                    aButton.addActionListener(this);
                    this.add(aButton);
                }
            }
            catch (Exception exception) {
                System.out.println(exception);
            }   
        }

        JTextField textField = new JTextField("DIAGNOSELF");
        textField.setBackground(new Color(104, 213, 255));
        textField.setEditable(false);
        textField.setFont(new Font("Monospaced", Font.PLAIN, 100));
        textField.setBounds(0, 0, 1550, 100);
        textField.setHorizontalAlignment(JTextField.CENTER);

        this.add(textField);

        this.setBackground(new Color(104, 213, 255));
        this.setSize(1550, 838 + 100 * numberOfSymtomps);
        this.setLayout(null);
        this.setOpaque(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        //boolean add = true;
        
        for ( int i = 0; i < numberOfSymtomps; i ++ ) {
            /*for ( int j = 0; j < find.symptomIds.size(); j ++ ) {
                if (symptomId.get(i) == find.symptomIds.get(j) ) {
                    add = false;
                }
            }*/
            if (e.getSource() == buttonArray[i] ) {
                find.symptomIds.add(symptomId.get(i));
            }
        }
        this.removeAll();
        this.add(new BodyMap(this, find));
        revalidate();
        repaint();
    }
}