package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.repositories.UserRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class ChatroomRepositoryJdbcImpl implements ChatroomRepository {
  private final Connection dataSource;
  private final UserRepository userRepository;
  private final String QUERY = "SELECT * FROM chat.chatrooms WHERE chat_id=?";

  public ChatroomRepositoryJdbcImpl(Connection dataSource, UserRepository user) {
    this.dataSource = dataSource;
    this.userRepository = user;
  }

  @Override
  public Optional<Chatroom> findById(Long id) throws SQLException {
    PreparedStatement query = dataSource.prepareStatement(QUERY);
    query.setLong(1, id);
    ResultSet resultSet = query.executeQuery();
    Chatroom chat = null;
    if (resultSet.next()) {
      chat = new Chatroom(
          resultSet.getLong("chat_id"), resultSet.getString("chatroom_name"), null, null);
    }
    return (Optional.ofNullable(chat));
  }
}
