package jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static jdbc.StatementDemo.getTableScheme;

public class PrepareStatementDemo {
    private Connection connection;

    public PrepareStatementDemo() throws SQLException, ClassNotFoundException {
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "A9637529669";
        connection = DriverManager.getConnection(url, login, password);
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "Create table if not exists cities_2(%s,%s,%s);",
                    "id serial primary key",
                    "name varchar(50)",
                    "population INTEGER"
            );
            statement.execute(sql);
            System.out.println(getTableScheme(connection, "cities_2"));
        }
    }

    public void insert(City city) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "insert into cities_2(name, population) values (?, ?)"
        )) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
        }
    }

    public boolean update(City city) throws SQLException {
        boolean result = false;
        try (PreparedStatement statement
                     = connection.prepareStatement("update cities_2 set name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;

        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from cities_2 where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from cities_2")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PrepareStatementDemo test = new PrepareStatementDemo();
        City city = new City(1, "Yaroslavl", 12000000);
        test.insert(city);
        test.delete(1);
        test.update(city);
        List<City> cityList = test.findAll();
        for (City town
                :cityList) {
            System.out.println(town);
        }

    }

}
