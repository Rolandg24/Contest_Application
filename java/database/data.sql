BEGIN TRANSACTION;
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO contests (contest_name, contest_description, contest_date_time, contest_location) 
VALUES 
('Global AI Summit', 'Conference on advancements in artificial intelligence.', '2024-04-10 09:00:00', 'Boston Tech Park, MA'),
('StartUp PitchFest', 'Event for startups to pitch to potential investors.', '2024-04-22 10:00:00', 'San Francisco Startup Hub, CA'),
('Eco Innovation Conference', 'Focus on sustainable technologies and green innovation.', '2024-05-05 09:30:00', 'Denver Green Center, CO'),
('Mobile Tech Expo', 'Exhibition of the latest in mobile technology.', '2024-05-20 10:00:00', 'Seattle Tech Fairgrounds, WA'),
('Digital Health Symposium', 'Exploring technology in healthcare.', '2024-06-15 09:00:00', 'Atlanta Medical Center, GA'),
('Cybersecurity Forum', 'Conference on the latest trends in cybersecurity.', '2024-06-30 10:00:00', 'New York Cyber Hub, NY'),
('Virtual Reality Showcase', 'Exhibition of VR technology and applications.', '2024-07-18 11:00:00', 'Los Angeles VR Arena, CA'),
('Fintech Leaders Summit', 'Meeting of minds in the financial technology sector.', '2024-08-05 09:00:00', 'Chicago Finance Center, IL'),
('Green Architecture Congress', 'Focus on sustainable building designs.', '2024-08-25 10:00:00', 'Miami Design Studio, FL'),
('Blockchain World Conference', 'Exploring the impact of blockchain technology.', '2024-09-10 09:30:00', 'Silicon Valley Tech Park, CA'),
('Robotics Revolution Event', 'Showcasing advancements in robotics.', '2024-09-25 10:00:00', 'Boston Robotics Lab, MA'),
('Future of Education Summit', 'Discussion on evolving educational technologies.', '2024-10-15 09:00:00', 'Stanford University, CA'),
('Tech Entrepreneurs Meetup', 'Networking event for tech entrepreneurs.', '2024-11-05 18:00:00', 'Austin Innovation Hub, TX'),
('Game Developers Conference', 'Annual meeting for game development professionals.', '2024-11-20 10:00:00', 'San Francisco Game Center, CA'),
('Space Exploration Forum', 'Discussions on the future of space travel.', '2024-12-10 09:00:00', 'Houston Space Center, TX'),
('Artificial Intelligence Expo', 'Showcase of AI technologies and applications.', '2025-01-20 10:00:00', 'Seattle Tech Expo, WA'),
('IoT Innovators Summit', 'Conference on Internet of Things advancements.', '2025-02-15 09:00:00', 'New York IoT Center, NY'),
('Sustainable Tech Symposium', 'Exploring eco-friendly technology solutions.', '2025-03-10 09:30:00', 'Denver Eco Tech Park, CO'),
('Quantum Computing Conference', 'Focus on the developments in quantum computing.', '2025-03-25 10:00:00', 'MIT Tech Lab, MA'),
('Augmented Reality Experience', 'Event showcasing AR technology.', '2025-04-15 11:00:00', 'Los Angeles Tech Arena, CA'),
('Data Science Summit', 'Conference on trends in data analysis and machine learning.', '2025-05-05 09:00:00', 'San Francisco Data Hub, CA'),
('Digital Marketing Workshop', 'Interactive workshop on digital advertising strategies.', '2025-05-20 10:00:00', 'Chicago Business Center, IL'),
('Healthcare Innovation Conference', 'Exploring new technologies in healthcare.', '2025-06-10 09:00:00', 'Johns Hopkins Center, MD'),
('E-commerce Summit', 'Event focusing on trends and innovations in online retail.', '2025-06-25 10:00:00', 'New York Commerce Hall, NY'),
('Tech for Good Forum', 'Discussions on using technology for social impact.', '2025-07-10 09:00:00', 'Silicon Valley Social Tech, CA');

INSERT INTO participants (participant_name, participant_description, member_count, score, contest_id) 
VALUES
('Team Alpha', 'Innovative tech enthusiasts', 5, 85, 1),
('The Innovators', 'Creative problem solvers', 6, 90, 1),
('Visionary Minds', 'Forward-thinking creators', 4, 78, 1),
('Tech Titans', 'Experts in technology', 7, 92, 1),
('Brainstorm Brigade', 'Strategic thinkers', 5, 81, 1),
('Idea Innovators', 'Exceptional idea generators', 6, 88, 1),
('Creative Crusaders', 'Champions of creativity', 4, 75, 1),
('The Pioneers', 'Trailblazers in innovation', 7, 93, 1),
('Design Dynamos', 'Dynamic designers', 5, 84, 1),
('Future Forgers', 'Shapers of tomorrow', 6, 91, 1),
('Tech Trailblazers', 'Leaders in tech advancements', 4, 79, 1),
('Idea Architects', 'Builders of innovative concepts', 7, 95, 1),
('Innovation Inc.', 'Corporate innovators', 5, 80, 1),
('Creative Coders', 'Coding with creativity', 6, 87, 1),
('Tech Pioneers', 'Pioneering tech solutions', 4, 76, 1),
('Inventive Minds', 'Masters of invention', 7, 94, 1),
('Design Thinkers', 'Thinking in design', 5, 82, 1),
('Digital Dreamers', 'Dreaming in digital', 6, 89, 1),
('Creative Pioneers', 'Pioneering creativity', 4, 77, 1),
('Tech Transformers', 'Transforming technology', 7, 96, 1),
('Innovation Squad', 'Squad of innovators', 5, 83, 1),
('Code Crafters', 'Crafting code creatively', 6, 86, 1),
('Visionary Pioneers', 'Pioneers with vision', 4, 74, 1),
('Tech Trendsetters', 'Setting tech trends', 7, 97, 1),
('Innovative Explorers', 'Exploring innovation', 5, 85, 1),
('Quantum Questers', 'Pioneers in quantum computing', 4, 82, 2),
('Code Wizards', 'Magicians of the coding world', 5, 88, 2),
('Innovative Engineers', 'Engineering the future', 6, 91, 2),
('Digital Dynamos', 'Champions of the digital era', 7, 93, 2),
('Brainy Bunch', 'Intellectuals in technology', 5, 79, 2),
('Cybernetic Pioneers', 'Leaders in cybernetics', 6, 87, 2),
('Tech Titans II', 'Innovators in tech', 4, 74, 2),
('Creative Connectors', 'Connecting through creativity', 7, 96, 2),
('Visionary Virtuosos', 'Masters of innovation', 5, 85, 2),
('Future Fabricators', 'Fabricating a tech-forward future', 6, 90, 2),
('Data Dynasts', 'Rulers of the data realm', 4, 77, 2),
('Circuit Cerebrals', 'Brains behind the circuits', 7, 95, 2),
('Idea Incubators', 'Nurturing innovative ideas', 5, 80, 2),
('Tech Trailblazers II', 'Blazing trails in technology', 6, 89, 2),
('Creative Catalysts', 'Catalyzing creativity', 4, 76, 2),
('Innovation Infusion', 'Infusing innovation everywhere', 7, 94, 2),
('Silicon Savants', 'Savvy in silicon solutions', 5, 83, 2),
('Digital Disruptors', 'Disrupting the digital norm', 6, 86, 2),
('Creative Commanders', 'Commanding the creative front', 4, 78, 2),
('Tech Trailblazers III', 'Trailblazing tech trends', 7, 92, 2),
('Mindful Mavericks', 'Mavericks with a mindful approach', 5, 81, 2),
('Code Connoisseurs', 'Connoisseurs of clean code', 6, 84, 2),
('Visionary Vanguards', 'At the forefront of innovation', 4, 75, 2),
('Tech Transformers II', 'Transforming tech landscapes', 7, 97, 2),
('Innovative Impact', 'Making an innovative impact', 5, 82, 2),
('Innovative Testing Measures', 'Making an innovative impact', 5, 82, 4);

INSERT INTO time_slots (contest_id, participant_id, time_slot)
VALUES
(1, 14, '08:00:00'),
(1, 24, '08:15:00'),
(1, 22, '08:30:00'),
(1, 2, '08:45:00'),
(1, 17, '09:00:00'),
(1, 5, '09:15:00'),
(1, 16, '09:30:00'),
(1, 7, '09:45:00'),
(1, 23, '10:00:00'),
(1, 10, '10:15:00'),
(1, 19, '10:30:00'),
(1, 8, '10:45:00'),
(1, 3, '11:00:00'),
(1, 6, '11:15:00'),
(1, 12, '11:30:00'),
(1, 4, '11:45:00'),
(1, 11, '12:00:00'),
(1, 15, '12:15:00'),
(1, 21, '12:30:00'),
(1, 25, '12:45:00'),
(1, 18, '13:00:00'),
(1, 20, '13:15:00'),
(1, 9, '13:30:00'),
(1, 1, '13:45:00'),
(1, 13, '14:00:00'),
(2, 8, '08:00:00'),
(2, 17, '08:15:00'),
(2, 4, '08:30:00'),
(2, 21, '08:45:00'),
(2, 14, '09:00:00'),
(2, 11, '09:15:00'),
(2, 25, '09:30:00'),
(2, 2, '09:45:00'),
(2, 5, '10:00:00'),
(2, 20, '10:15:00'),
(2, 3, '10:30:00'),
(2, 9, '10:45:00'),
(2, 15, '11:00:00'),
(2, 24, '11:15:00'),
(2, 1, '11:30:00'),
(2, 13, '11:45:00'),
(2, 19, '12:00:00'),
(2, 12, '12:15:00'),
(2, 7, '12:30:00'),
(2, 23, '12:45:00'),
(2, 6, '13:00:00'),
(2, 22, '13:15:00'),
(2, 18, '13:30:00'),
(2, 10, '13:45:00'),
(2, 16, '14:00:00'),
(1, 11, '14:15:00'),
(1, 18, '14:30:00'),
(1, 12, '14:45:00'),
(1, 21, '15:00:00'),
(1, 15, '15:15:00'),
(1, 2, '15:30:00'),
(1, 25, '15:45:00'),
(1, 23, '16:00:00'),
(1, 14, '16:15:00'),
(1, 5, '16:30:00'),
(1, 7, '16:45:00'),
(1, 3, '17:00:00'),
(1, 8, '17:15:00'),
(1, 19, '17:30:00'),
(1, 4, '17:45:00'),
(1, 6, '18:00:00'),
(1, 13, '18:15:00'),
(1, 10, '18:30:00'),
(1, 9, '18:45:00'),
(1, 16, '19:00:00'),
(1, 22, '19:15:00'),
(1, 20, '19:30:00'),
(1, 24, '19:45:00'),
(1, 17, '20:00:00'),
(1, 1, '20:15:00'),
(2, 9, '14:15:00'),
(2, 16, '14:30:00'),
(2, 4, '=14:45:00'),
(2, 19, '15:00:00'),
(2, 3, '15:15:00'),
(2, 22, '15:30:00'),
(2, 1, '15:45:00'),
(2, 13, '16:00:00'),
(2, 8, '16:15:00'),
(2, 20, '16:30:00'),
(2, 24, '16:45:00'),
(2, 14, '17:00:00'),
(2, 17, '17:15:00'),
(2, 10, '17:30:00'),
(2, 23, '17:45:00'),
(2, 6, '18:00:00'),
(2, 5, '18:15:00'),
(2, 18, '18:30:00'),
(2, 7, '18:45:00'),
(2, 2, '19:00:00'),
(2, 21, '19:15:00'),
(2, 11, '19:30:00'),
(2, 12, '19:45:00'),
(2, 15, '20:00:00'),
(2, 25, '20:15:00');

INSERT INTO overall_scores (contest_id, participant_id, overall_score)
VALUES
(1, 14, 90),
(1, 24, 42),
(1, 22, 73),
(1, 2, 15),
(1, 17, 88),
(1, 5, 57),
(1, 16, 64),
(1, 7, 29),
(1, 23, 51),
(1, 10, 19),
(1, 19, 36),
(1, 8, 78),
(1, 3, 90),
(1, 6, 64),
(1, 12, 27),
(1, 4, 45),
(1, 11, 83),
(1, 15, 21),
(1, 21, 50),
(1, 25, 94),
(1, 18, 13),
(1, 20, 72),
(1, 9, 31),
(1, 1, 60),
(1, 13, 47),
(2, 8, 82),
(2, 17, 39),
(2, 4, 76),
(2, 21, 12),
(2, 14, 65),
(2, 11, 32),
(2, 25, 91),
(2, 2, 8),
(2, 5, 74),
(2, 20, 55),
(2, 3, 17),
(2, 9, 69),
(2, 15, 38),
(2, 24, 83),
(2, 1, 20),
(2, 13, 44),
(2, 19, 75),
(2, 12, 23),
(2, 7, 62),
(2, 23, 29),
(2, 6, 50),
(2, 22, 88),
(2, 18, 15),
(2, 10, 64),
(2, 16, 42);

COMMIT TRANSACTION;