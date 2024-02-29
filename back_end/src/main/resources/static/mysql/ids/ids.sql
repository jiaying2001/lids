CREATE TABLE `ids` (
    `ids_id` int primary key auto_increment,
    `data_source` varchar(128) not null comment 'indicates where the date from - a process in a OS' ,
    `type` varchar(128) not null comment 'indicates which method applied in the ids',
    `access_type` int not null comment 'public or private access',
);

create table `user_ids` (
    `user_ids_id` int primary key auto_increment,
    `user_id` int not null,
    `ids_id` int not null,
);