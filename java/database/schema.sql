BEGIN TRANSACTION;
DROP TABLE IF EXISTS schedules_participants;
DROP TABLE IF EXISTS schedules;
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
	contest_date_time varchar(500) NOT NULL,
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
CREATE TABLE schedules (
	schedule_id SERIAL,
	contest_id INTEGER,
	CONSTRAINT PK_schedule_id PRIMARY KEY (schedule_id),
	FOREIGN KEY (contest_id) REFERENCES contests(contest_id)
);
CREATE TABLE schedules_participants (
	time_slot_id SERIAL,
	schedule_id INTEGER,
	participant_id INTEGER,
	time_slot varchar(200),
	CONSTRAINT PK_time_slot_id PRIMARY KEY (time_slot_id),
	FOREIGN KEY (schedule_id) REFERENCES schedules(schedule_id),
	FOREIGN KEY (participant_id) REFERENCES participants(participant_id)
);


COMMIT TRANSACTION;