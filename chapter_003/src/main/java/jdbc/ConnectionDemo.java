package jdbc;


import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

        public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "";
        String login = "";
        String password = "";

        try (FileReader fileReader = new FileReader("app.properties")) {
            BufferedReader bf = new BufferedReader(fileReader);
            String mas = bf.readLine();
           while (mas != null) {
              var scratch = mas.split(" = ");
               if (scratch[0].equals("url")) {
                   url = scratch[1];
               }
               if (scratch[0].equals("login")) {
                   login = scratch[1];
               }
               if (scratch[0].equals("password")) {
                   password = scratch[1];
               }
               mas = bf.readLine();

           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());

        }
    }
}
