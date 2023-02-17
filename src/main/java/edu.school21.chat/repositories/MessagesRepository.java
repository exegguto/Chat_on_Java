package edu.school21.chat.repositories;

import edu.school21.chat.models.Messages;
import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository {
  Optional<Messages> findById(Long id) throws SQLException;
  void save(Messages message) throws SQLException;
  void update(Messages message) throws SQLException;
  SINGLE List<User> findAll(int page, int size);
}
