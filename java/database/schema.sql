BEGIN TRANSACTION;

DROP TABLE IF EXISTS overall_scores;
DROP TABLE IF EXISTS time_slots;
DROP TABLE IF EXISTS participants;
DROP TABLE IF EXISTS contests;
DROP TABLE IF EXISTS contest_categories;
DROP TABLE IF EXISTS users;

CREATE TABLE contest_categories (
	category_id SERIAL,
	category_name varchar(200),
	CONSTRAINT PK_category_id PRIMARY KEY (category_id)
);

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
	contest_description varchar(3000),
	contest_date_time varchar(500) NOT NULL,
	contest_location varchar(200) NOT NULL,
	category_id INTEGER,
	image_url varchar (1000),
	CONSTRAINT PK_contest_id PRIMARY KEY (contest_id),
	FOREIGN KEY (category_id) REFERENCES contest_categories(category_id)
);
CREATE TABLE participants (
	participant_id SERIAL,
	participant_name varchar(100) NOT NULL,
	participant_description varchar(3000),
	member_count INTEGER,
	score DECIMAL,
	contest_id INTEGER,
	image_url varchar (1000),
	votes INTEGER,
	CONSTRAINT PK_participant_id PRIMARY KEY (participant_id),
	FOREIGN KEY (contest_id) REFERENCES contests(contest_id)
);
CREATE TABLE time_slots (
	time_slot_id SERIAL,
	contest_id INTEGER,
	participant_id INTEGER,
	time_slot varchar(200),
	CONSTRAINT PK_time_slot_id PRIMARY KEY (time_slot_id),
	FOREIGN KEY (contest_id) REFERENCES contests(contest_id),
	FOREIGN KEY (participant_id) REFERENCES participants(participant_id)
);

CREATE TABLE overall_scores (
	overall_score_id SERIAL,
	contest_id INTEGER,
	participant_id INTEGER,
	overall_score INTEGER,
	CONSTRAINT PK_overall_score_id PRIMARY KEY (overall_score_id),
	FOREIGN KEY (contest_id) REFERENCES contests(contest_id),
	FOREIGN KEY (participant_id) REFERENCES participants(participant_id)
);


COMMIT TRANSACTION;