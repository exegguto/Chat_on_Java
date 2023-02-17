DROP SCHEMA IF EXISTS chat CASCADE;
CREATE SCHEMA IF NOT EXISTS chat;

CREATE TABLE IF NOT EXISTS chat.users (
	user_id SERIAL PRIMARY KEY,
	login VARCHAR ( 50 ) UNIQUE NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS chat.chatrooms (
    chat_id SERIAL PRIMARY KEY,
	chatroom_name VARCHAR ( 50 ) UNIQUE NOT NULL,
	owner INTEGER REFERENCES chat.users(user_id) NOT NULL
);

CREATE TABLE IF NOT EXISTS chat.messages (
    messages_id SERIAL PRIMARY KEY,
	author INTEGER REFERENCES chat.users(user_id) NOT NULL,
	room INTEGER REFERENCES chat.chatrooms(chat_id) NOT NULL,
	text TEXT NOT NULL,
    timestamp TIMESTAMP
);

-- DROP USER root;
-- CREATE USER root WITH LOGIN PASSWORD '21';