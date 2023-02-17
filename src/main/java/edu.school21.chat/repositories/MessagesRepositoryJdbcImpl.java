package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Messages;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
  private final Connection dataSource;
  private final String QUERY = "SELECT * FROM chat.messages WHERE messages_id=?";
  private final String QUERY_ADD =
      "INSERT INTO chat.messages(author, room, text, timestamp) VALUES (?,?,?,?) RETURNING messages_id";
  private final String QUERY_UPDATE =
      "UPDATE chat.messages SET author = ?, room = ?, text = ?, timestamp = ? WHERE messages_id = ?";
  private final String QUERY_UPDATE =
      "WITH filtred_users AS(SELECT * FROM chat.users WHERE user_id BETWEEN " + start + " AND "
      + end
      + ") SELECT* FROM filtred_users LEFT JOIN chat.chatrooms ON chatrooms.owner = filtred_users.user_id LEFT JOIN chat.messages ON messages.author = filtred_users.user_id;";
  UserRepositoryJdbcImpl userRepository;
  ChatroomRepositoryJdbcImpl chatroomRepository;

  public MessagesRepositoryJdbcImpl(
      Connection dataSource, UserRepositoryJdbcImpl user, ChatroomRepositoryJdbcImpl chat) {
    this.dataSource = dataSource;
    this.userRepository = user;
    this.chatroomRepository = chat;
  }

  @Override
  public Optional<Messages> findById(Long id) throws SQLException {
    Messages messag = null;
    PreparedStatement query = dataSource.prepareStatement(QUERY);
    query.setLong(1, id);
    ResultSet resultSet = query.executeQuery();
    if (resultSet.next()) {
      messag = new Messages(resultSet.getLong("messages_id"),
          userRepository.findById(resultSet.getLong("author")).orElse(null),
          chatroomRepository.findById(resultSet.getLong("room")).orElse(null),
          resultSet.getString("text"), resultSet.getTimestamp("timestamp").toLocalDateTime());
    }

    return (Optional.ofNullable(messag));
  }

  @Override
  public void save(Messages message) throws SQLException {
    Long creatorId = message.getCreator().getId();
    long chatId = message.getChatroom().getId();
    ResultSet resultSet = null;
    if (userRepository.findById(creatorId).isPresent()
        && chatroomRepository.findById(chatId).isPresent()) {
      PreparedStatement query = dataSource.prepareStatement(QUERY_ADD);
      query.setLong(1, creatorId);
      query.setLong(2, chatId);
      query.setString(3, message.getText());
      query.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));
      resultSet = query.executeQuery();
      resultSet.next();
      message.setId(resultSet.getLong("messages_id"));
      query.close();
    } else {
      throw new NotSavedSubEntityException("No saved entry exception!");
    }
  }

  @Override
  public void update(Messages message) throws SQLException {
    PreparedStatement query = dataSource.prepareStatement(QUERY_UPDATE);
    query.setLong(1, message.getCreator().getId());
    query.setLong(2, message.getChatroom().getId());
    query.setString(3, message.getText());
    try {
      query.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));
    } catch (NullPointerException e) {
      query.setTimestamp(4, null);
    }
    query.setLong(5, message.getId());
    query.execute();
  }

  @Override
  SINGLE List<User> findAll(int page, int size) {
    long start = page * size + 1;
    long end = page * size + page;
    new List<user> userlist = new ArrayList<>();

    Messages messag = null;
    PreparedStatement query = dataSource.prepareStatement(QUERY_UPDATE);
    query.setLong(1, id);
    ResultSet resultSet = query.executeQuery();

    return (Optional.ofNullable(messag));
  }
}