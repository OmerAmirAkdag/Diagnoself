package gui;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class Finder {
    
    ArrayList<Integer> symptomIds;
    ArrayList<Integer> illnessIds;

    public Finder () {
        symptomIds = new ArrayList<>();
        illnessIds = new ArrayList<>();
    }

    public ArrayList<Integer> findIllnessesId ( ArrayList<Integer> symptomIds ) {

        Connection connection = null;
        try {
            // below two lines are used for connectivity
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/maindb",
                "yaseminakin", "xxx");
 
            PreparedStatement statement;
            ResultSet resultSet;
            
            for (int i = 0; i < symptomIds.size(); i++ ) {

                statement = connection.prepareStatement("select * from symptoms_illnesses where symptomid = ?");
                statement.setInt(1, symptomIds.get(i));
                resultSet = statement.executeQuery();
                int title;
                while (resultSet.next()) {
                    
                    title = resultSet.getInt("illnessid");
                    this.illnessIds.add(title);
                }
            } 
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        return illnessIds;
    }

    public void findIllnesses ( ArrayList <Integer> illnessIds ) {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/maindb",
                "yaseminakin", "xxx");

            PreparedStatement statement;
            ResultSet resultSet;
            
            for (int i = 0; i < illnessIds.size(); i++ ) {

                statement = connection.prepareStatement("select * from illnesses where illnessId = ?");
                statement.setInt(1, illnessIds.get(i));
                resultSet = statement.executeQuery();
                int code;
                String title;
                String description;
                while (resultSet.next()) {
                    code = resultSet.getInt("illnessId");
                    title = resultSet.getString("illnessName");
                    description = resultSet.getString("description");
                    System.out.println(code + "" + title + "" + description);
                }
            } 
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public ArrayList<Integer> getSymptomIds () {
        return this.symptomIds;
    }

    public static void main(String[] args) {
        Finder find = new Finder();
        System.out.println("Enter symptom ids: ");
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            Integer ids = scan.nextInt();
            find.symptomIds.add(ids);
        }
        find.findIllnesses(find.findIllnessesId(find.getSymptomIds()));
        scan.close();
    }
}
