package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class Illnesses extends JPanel implements ActionListener{

    JButton[] arr;
    Finder find;
    int sizz;
    ArrayList<Integer> illnessIds;
    public Illnesses(Finder find)
    {
        this.find = find;
        illnessIds = find.findIllnessesId(find.getSymptomIds());
        sizz = illnessIds.size();
        arr = new JButton[sizz];

        for(int i = 0; i < sizz; i++)
        {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/maindb",
                    "yaseminakin", "xxx");
                PreparedStatement statement;
                ResultSet resultSet;
                statement = connection.prepareStatement("select * from illnesses where illnessId = ?");
                statement.setInt(1, illnessIds.get(i));
                resultSet = statement.executeQuery();
                String title;
                while (resultSet.next()) {
                    title = resultSet.getString("illnessName");
                    JButton aButton = new JButton();
                    aButton.setText(title);
                    aButton.setBounds(525, 160 + i*110 , 500, 100);
                    aButton.setBackground(new Color(72, 255, 186));
                    arr[i] = aButton;
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
        this.setSize(1550, 838 + 100 * sizz);
        this.setLayout(null);
        this.setOpaque(true);
    }
    public void actionPerformed(ActionEvent e)
    {

        for ( int i = 0; i < sizz; i ++ ) {
            if ( e.getSource() == arr[i] ) {
                this.removeAll();
                this.add(new IllnessPage(find, illnessIds.get(i)));
                revalidate();
                repaint(); 
            }
        }
        
    }
}
