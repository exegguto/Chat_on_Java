package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import java.sql.SQLException;
import java.util.Optional;

public interface ChatroomRepository {
  Optional<Chatroom> findById(Long id) throws SQLException;
}
