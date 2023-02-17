package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
  private Long id;
  private String login;
  private String password;
  private List<Chatroom> createdRooms;
  private List<Chatroom> rooms;

  public User(
      Long id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> rooms) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.createdRooms = createdRooms;
    this.rooms = rooms;
  }

  public List<Chatroom> getAutorRooms() {
    return rooms;
  }

  public Long getId() {
    return id;
  }

  public void getAutoRooms(List<Chatroom> rooms) {
    this.rooms = rooms;
  }

  @Override
  public String toString() {
    return "{"
        + "id=" + id + ", login=\"" + login + "\", password=\"" + password
        + "\",createdRooms=" + createdRooms + ",rooms=" + rooms + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, password);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    User user = (User) obj;
    return id == user.id && login.equals(user.login) && password.equals(user.password);
  }
}
