CREATE TABLE `harvester_conf` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `user_id` int NOT NULL UNIQUE ,
    `offset` int DEFAULT 0,
    `path` varchar(255) NOT NULL,
    `file_format` varchar(128) NOT NULL,
);