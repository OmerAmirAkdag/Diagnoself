package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;


public class IllnessPage extends JPanel implements ActionListener{
    
    Finder find;
    JButton goBackButton;
    String fieldOfIllness;
    JTextField descriptionn;
    ArrayList<Integer>illnessId;
    


    public IllnessPage(Finder find, Integer integer)
    {
        this.find = find;
        illnessId = find.findIllnessesId(find.getSymptomIds());
        fieldOfIllness = "FIELD OF ILLNESS";

        goBackButton = new JButton("GO TO ILLNESSES PAGE");
        goBackButton.setFocusable(false);
        goBackButton.setBounds(50, 650, 200, 110);
        goBackButton.setBackground(new Color(72, 255, 186));
        goBackButton.setBorder(BorderFactory.createRaisedBevelBorder());
        goBackButton.addActionListener(this);

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/maindb",
                "yaseminakin", "xxx");

            PreparedStatement statement;
            ResultSet resultSet;
            
            for (int i = 0; i < illnessId.size(); i++ ) {

                statement = connection.prepareStatement("select * from illnesses where illnessId = ?");
                statement.setInt(1, illnessId.get(i));
                resultSet = statement.executeQuery();
                String description;
                while (resultSet.next()) {
                    description = resultSet.getString("description");
                    descriptionn = new JTextField(""+description);
                    descriptionn.setBackground(new Color(104, 213, 255));
                    descriptionn.setEditable(false);
                    descriptionn.setFont(new Font("Monospaced", Font.PLAIN, 12));
                    descriptionn.setBounds(250, 250, 1000, 150);
                    descriptionn.setHorizontalAlignment(JTextField.CENTER);
                }
            } 
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        
       /* JTextField field = new JTextField(fieldOfIllness);
        field.setBackground(new Color(104, 213, 255));
        field.setEditable(false);
        field.setFont(new Font("Monospaced", Font.PLAIN, 30));
        field.setBounds(1000, 600, 400, 150);
        field.setHorizontalAlignment(JTextField.CENTER);*/

        JTextField textField = new JTextField("DIAGNOSELF");
        textField.setBackground(new Color(104, 213, 255));
        textField.setEditable(false);
        textField.setFont(new Font("Monospaced", Font.PLAIN, 100));
        textField.setBounds(0, 0, 1550, 100);
        textField.setHorizontalAlignment(JTextField.CENTER);

        this.add(goBackButton);
        this.add(descriptionn);
        //this.add(field);
        this.add(textField);
        this.setBackground(new Color(104, 213, 255));
        this.setSize(1550, 838);
        this.setLayout(null);
        this.setOpaque(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        this.removeAll();
        this.add(new Illnesses(find));
        this.setSize(new Dimension(1538, 838 + 100 * find.illnessIds.size()));
        revalidate();
        repaint();
    }
}
