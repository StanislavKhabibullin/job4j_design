package jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class StatementDemo {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
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
        return DriverManager.getConnection(url, login, password);
    }

    public static String getTableScheme(Connection connection, String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try(ResultSet columns = metaData.getColumns(null, null,
                tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try(Connection connection = getConnection())  {
            try(Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "Create table if not exists demo_table(%s,%s);",
                        "id serial primary key",
                        "name varchar(50)"
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "demo_table"));
            }
        }
    }
}
