# Chat on Java in console

In this chat, user can create or choose an existing chatroom. Each chatroom can have several users exchanging messages.

Key domain models which both SQL tables and Java classes must be implemented for are:

- User
    -	User ID
    - Login
    -	Password
    -	List of created rooms
    -	List of chatrooms where a user socializes
- Chatroom
    -	Chatroom id
    - Chatroom name
    - Chatroom owner
    - List of messages in a chatroom
- Message
    - Message id
    - Message author
    - Message room
    - Message text
    - Message date/time

```
$ java Program
Enter a message ID
-> 5
Message : {
  id=5,
  author={id=7,login=“user”,password=“user”,createdRooms=null,rooms=null},
  room={id=8,name=“room”,creator=null,messages=null},
  text=“message”,
  dateTime=01/01/01 15:69
}
```
