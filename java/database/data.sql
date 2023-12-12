BEGIN TRANSACTION;
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO contest_categories (category_name)
VALUES
('Band'),
('Sports'),
('Academic'),
('Coding'),
('Startup Pitches');

INSERT INTO contests (contest_name, contest_description, contest_date_time, contest_location, category_id, image_url) 
VALUES 
('Columbus Area Band Contest', 'The Columbus Area Band Contest is an exhilarating music competition celebrating the vibrant and diverse local band scene in Columbus, Ohio. This event brings together a wide array of musical talents, from emerging garage bands to more established groups, showcasing a variety of genres including rock, jazz, indie, and more. Participants will compete for the title of "Columbus''s Best Band," along with other exciting prizes. Each band will have a set time to perform their best pieces in front of an enthusiastic audience and a panel of esteemed judges from the music industry. In addition to the musical performances, the event will feature local food trucks, merchandise stalls, and interactive booths, making it a perfect outing for music lovers of all ages.',
 '2024-04-10', 'Columbus, OH', 1, null);

INSERT INTO participants (participant_name, participant_description, member_count, score, contest_id, image_url) 
VALUES 
('The Electric Echoes', 'An innovative indie rock band known for their electrifying performances and unique soundscapes.', 4, NULL, 1, null),
('Jazz Junction', 'A group of seasoned jazz musicians blending classic and modern jazz styles.', 5, NULL, 1, null),
('Harmony Hive', 'A dynamic pop band with catchy tunes and vibrant stage presence.', 6, NULL, 1, null),
('Bluegrass Rebels', 'A bluegrass band with a contemporary twist, known for their soulful melodies.', 3, NULL, 1, null),
('The Velvet Suns', 'A rock band with a flair for dramatic, high-energy performances.', 5, NULL, 1, null),
('Sonic Synthesis', 'An experimental band merging electronic and acoustic sounds.', 4, NULL, 1, null),
('The Groove Makers', 'A funk band known for their groovy basslines and infectious rhythms.', 6, NULL, 1, null),
('Lyrical Legends', 'A hip-hop group with sharp lyrics and powerful beats.', 2, NULL, 1, null),
('The Serene Strings', 'A classical ensemble bringing a fresh perspective to traditional compositions.', 4, NULL, 1, null),
('Rhythm Raiders', 'A reggae band infusing classic reggae with modern influences.', 5, NULL, 1, null);

INSERT INTO time_slots (contest_id, participant_id, time_slot)
VALUES
(1, 1, '08:00:00'),
(1, 2, '09:00:00'),
(1, 3, '10:00:00'),
(1, 4, '11:00:00'),
(1, 5, '12:00:00'),
(1, 6, '13:00:00'),
(1, 7, '14:00:00'),
(1, 8, '15:00:00'),
(1, 9, '16:00:00'),
(1, 10, '17:00:00');


-- INSERT INTO overall_scores (contest_id, participant_id, overall_score)
-- VALUES
-- (1, 14, 90)


COMMIT TRANSACTION;