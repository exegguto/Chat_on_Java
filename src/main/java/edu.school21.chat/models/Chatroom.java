package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
  private Long id;
  private String name;
  private User creator;
  private List<Messages> messages = null;

  public Chatroom(Long id, String name, User creator, List<Messages> messages) {
    this.id = id;
    this.name = name;
    this.creator = creator;
    this.messages = messages;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "{id=" + id + ", name=\"" + name + "\", owner=" + creator + ", messages=" + messages
        + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, creator);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Chatroom chat = (Chatroom) obj;
    return id == chat.id && name.equals(chat.name) && creator.equals(chat.creator);
  }
}
