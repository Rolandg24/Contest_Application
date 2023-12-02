BEGIN TRANSACTION;
DROP TABLE IF EXISTS participants;
DROP TABLE IF EXISTS contests;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE contests (
	contest_id SERIAL,
	contest_name varchar(100) NOT NULL,
	contest_description varchar(300),
	contest_date_time TIMESTAMPTZ NOT NULL,
	contest_location varchar(200) NOT NULL,
	CONSTRAINT PK_contest_id PRIMARY KEY (contest_id)
);
CREATE TABLE participants (
	participant_id SERIAL,
	participant_name varchar(100) NOT NULL,
	participant_description varchar(300),
	member_count INTEGER,
	score DECIMAL,
	contest_id INTEGER,
	CONSTRAINT PK_participant_id PRIMARY KEY (participant_id),
	FOREIGN KEY (contest_id) REFERENCES contests(contest_id)
);

COMMIT TRANSACTION;