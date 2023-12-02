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
('Innovative Explorers', 'Exploring innovation', 5, 85, 1);

COMMIT TRANSACTION;
