package jdbc;


import java.io.*;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException {
        try(Statement statement = connection.createStatement()) {
            String sql =
                    "Create table if not exists "
                            + tableName
                            + "(%s,%s);";
            statement.execute(sql);
        }
    }

    public void dropTable(String tableName) throws SQLException {
        try(Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DROP table " + tableName
            );
            statement.execute(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try(Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "ALTER TABLE " + tableName + "ADD COLUMN" + columnName + type
            );
            statement.execute(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try(Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "ALTER TABLE " + tableName + "DROP COLUMN" + columnName
            );
            statement.execute(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try(Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "ALTER TABLE " + tableName + "REnAMe COLUMN" + columnName + " TO " + newColumnName
            );
            statement.execute(sql);
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        FileInputStream in = new FileInputStream("my.properties");
        Properties properties1 = new Properties();
        properties1.load(in);
        TableEditor editor = new TableEditor(properties1);
        editor.createTable("testTablik");
        editor.addColumn("testTablik", "name", "varchar(20)");
        System.out.println(editor.getScheme("testTablik"));


    }
}