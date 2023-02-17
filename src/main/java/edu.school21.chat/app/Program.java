package edu.school21.chat.models;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.repositories.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Program {
  static final String DB_URL = "jdbc:postgresql://localhost/postgres";
  static final String USER = "postgres";
  static final String PASS = "";
  private static final String SCHEMA = "/resources/schema.sql";
  private static final String DATA = "/resources/data.sql";
  private static Connection connection = null;

  public static void main(String[] argv) {
    try {
      connection = connect();

      UserRepositoryJdbcImpl userRepository = new UserRepositoryJdbcImpl(connection);
      ChatroomRepositoryJdbcImpl chatRepository =
          new ChatroomRepositoryJdbcImpl(connection, userRepository);
      MessagesRepository messagRepository =
          new MessagesRepositoryJdbcImpl(connection, userRepository, chatRepository);

      Optional<Messages> messageOptional = messagRepository.findById(5L);
      if (messageOptional.isPresent()) {
        Messages message = messageOptional.get();
        message.setText("Bye");
        message.setDateTime(null);
        messagRepository.update(message);
        System.out.println("Date update");
      }

      if (connection != null)
        connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (NotSavedSubEntityException e) {
      System.out.println(e);
    }
  }

  private static void createTable() throws SQLException {
    try {
      createTable(connection, SCHEMA);
      System.out.println("Shema added in database");
      createTable(connection, DATA);
      System.out.println("Data added in database");
    } catch (FileNotFoundException e) {
      System.out.println("File no found");
    }
  }

  private static void createTable(Connection conn, String filename)
      throws FileNotFoundException, SQLException {
    String file = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
        + File.separator + filename;
    Scanner scaner = new Scanner(new File(file)).useDelimiter(";");
    Statement st = conn.createStatement();
    while (scaner.hasNext()) st.execute(scaner.next().trim());
    st.close();
  }

  private static Connection connect() throws SQLException {
    return HikariConnect().getConnection();
  }

  private static HikariDataSource HikariConnect() {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setJdbcUrl(DB_URL);
    hikariConfig.setUsername(USER);
    hikariConfig.setPassword(PASS);
    hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
    hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

    return (new HikariDataSource(hikariConfig));
  }
}