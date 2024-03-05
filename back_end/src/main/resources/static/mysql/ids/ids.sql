CREATE TABLE `ids` (
    `ids_id` int primary key auto_increment,
    `os` varchar(12) not null,
    `app_name` varchar(12) not null,
    `access_type` int not null comment 'public or private access',
    `type_name` varchar(128) not null comment 'indicates which method applied in the ids',
    `type_code` int not null
);

create table `user_ids` (
    `user_ids_id` int primary key auto_increment,
    `user_id` int not null,
    `ids_id` int not null
);