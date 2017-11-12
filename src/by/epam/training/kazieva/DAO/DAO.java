package by.epam.training.kazieva.DAO;

import by.epam.training.kazieva.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private final static String JDBCDriver ="com.mysql.jdbc.Driver";
    private final static String URL="jdbc:mysql://localhost:3306/java_task3";
    private final static String USER = "admin";
    private final static String PASSWORD = "admin";
    private final static int NAME_INDEX = 1;
    private final static int SURNAME_INDEX = 2;
    private final static int PHONE_INDEX = 3;
    private final static int EMAIL_INDEX = 4;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBCDriver);
        return DriverManager.getConnection(URL, USER , PASSWORD);
    }

    public static List<Person> searchByNameAndSurname(String name, String surname) throws SQLException, ClassNotFoundException {
        List<Person> personList = new ArrayList<Person>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT name, surname, phone, email from persons WHERE (name =? && surname=?)");
        ) {
            ps.setString(NAME_INDEX, name);
            ps.setString(SURNAME_INDEX, surname);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String personName = resultSet.getString(NAME_INDEX);
                String personSurname = resultSet.getString(SURNAME_INDEX);
                String personPhone = resultSet.getString(PHONE_INDEX);
                String personEmail = resultSet.getString(EMAIL_INDEX);
                personList.add(new Person(personName, personSurname, personPhone, personEmail));
            }
            return personList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return personList;
    }
}