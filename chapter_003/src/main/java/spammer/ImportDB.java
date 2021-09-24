package spammer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static jdbc.StatementDemo.getTableScheme;

public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(s -> {
                var mas = s.split(";");
                users.add(new User(mas[0], mas[1]));
            });
        }
        return users;
    }

    public void createTable(Connection connect) {
        try (Statement statement = connect.createStatement()) {
            String sql = String.format(
                    "Create table if not exists users(%s,%s,%s);",
                    "id serial primary key",
                    "name varchar(50)",
                    "email varchar(50)"
            );
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cn = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
           createTable(cn);
            for (User user
                    :users) {
                try (PreparedStatement statement = cn.prepareStatement("INSERT into users(name, email) VALUES(?,?)")) {
                    statement.setString(1, user.name);
                    statement.setString(2, user.email);
                    statement.execute();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("C:\\projects\\job4j_design\\chapter_003\\src\\main\\resources\\app.properties")) {
            cfg.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImportDB db = new ImportDB(cfg, "C:\\projects\\job4j_design\\chapter_003\\dump.txt");
        db.save(db.load());
    }
}
