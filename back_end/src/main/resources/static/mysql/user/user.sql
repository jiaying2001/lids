CREATE TABLE `user` (
    `id` int PRIMARY KEY auto_increment,
    `username` varchar(255) NOT NULL UNIQUE,
    `password` varchar(255) Not Null
);