package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/enterprise";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static String[] getRandomNameAndSurname() {
        String[] nameAndSurname = new String[2];

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Rasgele bir kayıt seçen SQL sorgusu
            String sql = "SELECT name, surname FROM namesurname ORDER BY RAND() LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                nameAndSurname[0] = rs.getString("name");
                nameAndSurname[1] = rs.getString("surname");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameAndSurname;
    }
}
