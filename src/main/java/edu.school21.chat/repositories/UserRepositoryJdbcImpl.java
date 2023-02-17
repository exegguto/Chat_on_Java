package edu.school21.chat.repositories;

import edu.school21.chat.models.User;
import java.sql.*;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {
  private final Connection dataSource;
  private final String QUERY = "SELECT * FROM chat.users WHERE user_id=?";

  public UserRepositoryJdbcImpl(Connection dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Optional<User> findById(Long id) throws SQLException {
    PreparedStatement query = dataSource.prepareStatement(QUERY);
    query.setLong(1, id);
    ResultSet resultSet = query.executeQuery();
    User user = null;
    if (resultSet.next()) {
      user = new User(resultSet.getLong("user_id"), resultSet.getString("login"),
          resultSet.getString("password"), null, null);
    }
    return (Optional.ofNullable(user));
  }
}
