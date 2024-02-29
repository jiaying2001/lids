CREATE TABLE `user_role` (
    `user_role_id` int PRIMARY KEY AUTO_INCREMENT,
    `user_id` int NOT NULL UNIQUE,
    `role_id` int NOT NULL UNIQUE
);