CREATE TABLE `user_info` (
     user_info_id int PRIMARY KEY AUTO_INCREMENT,
     user_id int NOT NULL UNIQUE,
     first_name varchar(128) DEFAULT "",
     last_name varchar(128) DEFAULT "",
     avatar varchar(255) DEFAULT "",
     job varchar(128) DEFAULT "",
     organization varchar(128) DEFAULT "",
     email varchar(128) DEFAULT "",
     introduction varchar(255) DEFAULT "",
     personal_website varchar(255) DEFAULT "",
     phone varchar(18) DEFAULT "",
     register_date datetime DEFAULT CURRENT_TIMESTAMP
);