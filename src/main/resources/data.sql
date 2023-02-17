-- SELECT * FROM chat.users
-- SELECT * FROM chat.chatrooms
-- SELECT * FROM chat.messages

INSERT INTO chat.users (login, password)
 VALUES ('ivan1', '000000');
 INSERT INTO chat.users (login, password)
 VALUES ('ivan2', '000000');
 INSERT INTO chat.users (login, password)
 VALUES ('ivan3', '000000');
 INSERT INTO chat.users (login, password)
 VALUES ('ivan4', '000000');
 INSERT INTO chat.users (login, password)
 VALUES ('ivan5', '000000');
 INSERT INTO chat.users (login, password)
 VALUES ('ivan6', '000000');
 INSERT INTO chat.users (login, password)
 VALUES ('user', 'user');
 INSERT INTO chat.users (login, password)
 VALUES ('ivan8', '000000');
 INSERT INTO chat.users (login, password)
 VALUES ('ivan9', '000000');
 
 INSERT INTO chat.chatrooms (chatroom_name, owner)
 VALUES ('room1', '2');
 INSERT INTO chat.chatrooms (chatroom_name, owner)
 VALUES ('room2', '1');
 INSERT INTO chat.chatrooms (chatroom_name, owner)
 VALUES ('room3', '3');
  INSERT INTO chat.chatrooms (chatroom_name, owner)
 VALUES ('room4', '2');
 INSERT INTO chat.chatrooms (chatroom_name, owner)
 VALUES ('room5', '1');
 INSERT INTO chat.chatrooms (chatroom_name, owner)
 VALUES ('room6', '3');
  INSERT INTO chat.chatrooms (chatroom_name, owner)
 VALUES ('room7', '2');
 INSERT INTO chat.chatrooms (chatroom_name, owner)
 VALUES ('room', '7');
 INSERT INTO chat.chatrooms (chatroom_name, owner)
 VALUES ('room9', '3');
 
 INSERT INTO chat.messages (author, room, text, timestamp)
 VALUES (1, 1, 'bingo', '1988-08-25 23:50:01');
 INSERT INTO chat.messages (author, room, text, timestamp)
 VALUES (2, 1, 'bingo_2 user', '1989-03-26 23:50:01');
 INSERT INTO chat.messages (author, room, text, timestamp)
 VALUES (3, 2, 'bingo_3', '1999-08-25 23:50:01');
