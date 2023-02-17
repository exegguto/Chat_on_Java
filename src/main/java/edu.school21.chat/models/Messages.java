package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Messages {
  private Long id;
  private User creator;
  private Chatroom room;
  private String text;
  private LocalDateTime dateTime;

  public Messages(Long id, User creator, Chatroom room, String text, LocalDateTime dateTime) {
    this.id = id;
    this.creator = creator;
    this.room = room;
    this.text = text;
    this.dateTime = dateTime;
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setText(String text) {
    this.text = text;
  }

  public User getCreator() {
    return creator;
  }

  public Chatroom getChatroom() {
    return room;
  }

  public String getText() {
    return text;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  @Override
  public String toString() {
    return "Message : {\n"
        + "  id=" + id + ",\n  creator=" + creator + ",\n  chatroom=" + room + ",\n  text=\"" + text
        + "\",\n  dateTime=" + dateTime.format(DateTimeFormatter.ofPattern("MM/MM/yy HH:mm"))
        + "\n}";
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creator, room, text, dateTime);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Messages message = (Messages) obj;
    return id == message.id && creator.equals(message.creator) && room.equals(message.room)
        && text.equals(message.text) && dateTime.equals(message.dateTime);
  }
}
