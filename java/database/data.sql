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
 '2024-04-10', 'Columbus, OH', 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702572051/contests_app/artwgdrgwzmqo8kmdunt.png'),
('Tech Elevator Capstone Expo', 'The Tech Elevator Capstone Expo is the culminating event of the 14-week coding BootCamp, where Tech Elevator students showcase their skills and accomplishments through the presentation of full-stack web applications. In this intensive final project, students are divided into teams, each tasked with conceiving, designing, and implementing a comprehensive web application within a tight two-week timeframe. The expo serves as a platform for students to demonstrate their proficiency in various programming languages, frameworks, and technologies learned throughout the BootCamp. Attendees have the opportunity to witness firsthand the innovative solutions and creative applications developed by these teams, highlighting the practical application of their newly acquired coding and development skills. The Capstone Expo not only celebrates the students'' journey and achievements but also provides a valuable opportunity for networking and interaction within the tech community.',
 '2024-12-15', 'Columbus, OH', 4, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571835/contests_app/ktvqg0r4scfywcrdvvxg.jpg');

INSERT INTO participants (participant_name, participant_description, member_count, score, contest_id, image_url, votes) 
VALUES 
('The Electric Echoes', 'An innovative indie rock band known for their electrifying performances and unique soundscapes.', 4, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591931/contests_app/vux5zvgvujivtoiiswve.png', 0),
('Jazz Junction', 'A group of seasoned jazz musicians blending classic and modern jazz styles.', 5, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591931/contests_app/t9zfvwbd8sqzfhybdkx1.png', 0),
('Harmony Hive', 'A dynamic pop band with catchy tunes and vibrant stage presence.', 6, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591931/contests_app/raedvvyme90hxwtq9g8o.png', 0),
('Bluegrass Rebels', 'A bluegrass band with a contemporary twist, known for their soulful melodies.', 3, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591931/contests_app/kw2kmwlngscaa6ruz5jt.png', 0),
('The Velvet Suns', 'A rock band with a flair for dramatic, high-energy performances.', 5, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591932/contests_app/wbsu2y8jne2zgoubb7rb.png', 0),
('Sonic Synthesis', 'An experimental band merging electronic and acoustic sounds.', 4, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591932/contests_app/kabthcahkf78znaktxvb.png', 0),
('The Groove Makers', 'A funk band known for their groovy basslines and infectious rhythms.', 6, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591932/contests_app/rbyvt7nipymkg6dglh9y.png', 0),
('Lyrical Legends', 'A hip-hop group with sharp lyrics and powerful beats.', 2, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591932/contests_app/tjjx62kd6pxd2o3idnxz.png', 0),
('The Serene Strings', 'A classical ensemble bringing a fresh perspective to traditional compositions.', 4, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591932/contests_app/g8faazstxjmbc0gnjt33.png', 0),
('Rhythm Raiders', 'A reggae band infusing classic reggae with modern influences.', 5, NULL, 1, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702591932/contests_app/ejbgnstvwfocrcvq5jy4.png', 0),
('Team Alpha', NULL, 3, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571601/contests_app/kqbspfgkoggg8nnh70ak.jpg', 0),
('Team Bravo', NULL, 3, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571600/contests_app/jrhf2g5wsib5stmcamkb.jpg', 0),
('Team Charlie', NULL, 3, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571600/contests_app/g3uvqmme5c4omfwknxmc.jpg', 0),
('Team Delta', NULL, 3, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571600/contests_app/sz0gadwoh54pewozi4vb.jpg', 0),
('Team Echo', NULL, 3, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571599/contests_app/dfjsdgn9naxazo0yddxc.jpg', 0),
('Team Foxtrot', NULL, 4, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571601/contests_app/l9m7pwdao7p99tvdllwp.jpg', 0),
('Team Golf', NULL, 3, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571599/contests_app/n1gzunq8q3vqba54vv7t.jpg', 0),
('Team Hotel', NULL, 4, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571602/contests_app/gagaanoeekiidvkkzvd6.jpg', 0),
('Team India', NULL, 4, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571599/contests_app/qmv2mxt0gepfu1givmkw.jpg', 0),
('Team Juliett', NULL, 4, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571601/contests_app/xjh7n8sccfzgu9yvu9ap.jpg', 0),
('Team Kilo', NULL, 4, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571598/contests_app/qeylvflhw0upghzyjb5f.jpg', 0),
('Team Lima', NULL, 4, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571599/contests_app/fqmapky5k2u3uhzgkqti.jpg', 0),
('Team Mike', NULL, 3, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571600/contests_app/azoyemvpw7vclafw5xmf.jpg', 0),
('Team November', NULL, 4, NULL, 2, 'https://res.cloudinary.com/dmptbrbof/image/upload/v1702571601/contests_app/ohtyo50lybvwzyqxxyoa.jpg', 0);

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

COMMIT TRANSACTION;