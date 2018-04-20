insert into users(id, name, email, password, regdate) values (3, 'kim sungpark', 'urstory@gmail.com', '{bcrypt}$2a$10$YawlEecaIvN5xMW7886JhOj6Iuy..f.XfoGy8/vJCW/5iRQlP3pzy', now());
insert into users(id, name, email, password, regdate) values (4, 'lee', 'lee@gmail.com', '{bcrypt}$2a$10$YawlEecaIvN5xMW7886JhOj6Iuy..f.XfoGy8/vJCW/5iRQlP3pzy', now());
insert into users(id, name, email, password, regdate) values (5, 'choi', 'choi@gmail.com', '{bcrypt}$2a$10$YawlEecaIvN5xMW7886JhOj6Iuy..f.XfoGy8/vJCW/5iRQlP3pzy', now());
-- insert into users(id, name, email, password, regdate) values (6, 'han', 'han@gmail.com', '1234', now());
-- insert into users(id, name, email, password, regdate) values (7, 'han', 'han@gmail.com', '1234', now());
insert into user_roles(id, user_id, role_name) values (1, 3, 'USER');
insert into user_roles(id, user_id, role_name) values (2, 3, 'ADMIN');
insert into user_roles(id, user_id, role_name) values (3, 4, 'USER');
insert into user_roles(id, user_id, role_name) values (4, 5, 'USER');
