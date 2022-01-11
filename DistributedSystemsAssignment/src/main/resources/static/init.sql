--Change ER diagram to include sumbitted
--Dont forget to remake the ER diagram!
--DONT FORGET TO RE RE REMAKE THE ER DIAGRAM :(!

DROP TABLE IF EXISTS `application`;

CREATE TABLE `application` (
 `id` int(10) NOT NULL AUTO_INCREMENT,
 `first_name` varchar(50) DEFAULT NULL,
 `last_name` varchar(50) DEFAULT NULL,
 `email` varchar(50) DEFAULT NULL,
 `date_of_birth` DATETIME,
 `id_number` varchar(50) DEFAULT NULL,
 `AFM` varchar(50) DEFAULT NULL,
 `AMKA` varchar(50) DEFAULT NULL,
 `marital_status` varchar(50) DEFAULT NULL,
 `primary_nationality` varchar(50) DEFAULT NULL,
 `city_of_residence` varchar(50) DEFAULT NULL,
 `unemployment_start_date` DATETIME,
 `income` float(10) DEFAULT 0,
 `submitted` BOOLEAN,
 `validated` BOOLEAN,
 `approved` BOOLEAN,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `unemployed`;

CREATE TABLE `unemployed` (
 `id` int(10) NOT NULL AUTO_INCREMENT,
 `first_name` varchar(50) DEFAULT NULL,
 `last_name` varchar(50) DEFAULT NULL,
 `email` varchar(50) DEFAULT NULL,
 `city_of_residence` varchar(50) DEFAULT NULL,
 `AFM` varchar(50) DEFAULT NULL,
 `AMKA` varchar(50) DEFAULT NULL,
 `unemployment_sdate` DATETIME,
 `date_of_birth` DATETIME,
 `id_number` varchar(50) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` boolean DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);
 
CREATE TABLE `authorities` (
  `authority_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`authority_id`)
);
 
CREATE TABLE `users_authorities` (
  `user_id` int(10) NOT NULL,
  `authority_id` int(10) NOT NULL,
  KEY `user_fk_idx` (`user_id`),
  KEY `authority_fk_idx` (`authority_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`authority_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

INSERT INTO `application` VALUES (NULL,"Argiris","Tsopanopoulos","tsopan@gmail.com","1982-06-24","AM784567","45678654","1994062412486","Single","Greek","Sepolia","2021-08-24",1006.86,0,0,0);
INSERT INTO `application` VALUES (NULL,"Aggelos","Stammou","AngelStan@hotmail.com","1995-03-14","AM471541","45194546","1994031422788","Married","Greek","Petralona","2021-03-11",1889.86,1,0,0);
INSERT INTO `application` VALUES (NULL,"Dimitra","Papavasileiou","Dimi82@gmail.com","1982-06-25","AM456767","14778656","1982062514786","Married","Greek","Peroupoli","2021-04-21",1106.86,1,1,0);

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
   ('Argiris', '$2a$12$tJF12GKRnBpFZqYo5Top3.GnWgKR7Xhm9IcGfyvDZybiLc8VzPqiO', 1),
   ('root', '$2a$12$TwApuqoafyZYQ/dY/Oskpeiyhpj5ATPT6azTfjb9No2W7oDuVJT/S', 1),
   ('vasilis', '$2a$12$AV6St8whDsHoOxaYIef3n.M0WbpC9UJCXofy2ZMzTR.3CN7UuY43C', 1),
   ('georgia', '$2a$12$CGPw0xNZpIw5sLmN1ZH53uJEQKpW2IniAlSx0zdn8noM6HvkF7F0y', 1),
   ('despoina', '$2a$12$.A3wb3LsEPuHGD6iRFdoUeFNIJSsQkiTu611fbq/Q8aQfON5tmJnS', 1);

INSERT INTO `authorities` (`name`) VALUES ('USER');
INSERT INTO `authorities` (`name`) VALUES ('ADMIN');

INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (1, 1); -- user patrick has role USER
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (2, 2); -- user has role ADMIN
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (3, 2); -- user has role ADMIN
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (4, 2); -- user has role ADMIN
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (5, 2); -- user has role ADMIN

INSERT INTO `unemployed` VALUES (NULL, "Panagiotis", "Georgidis", "Pangeo@hotmail.com", "Kamatero","24587549","1504199516578","2014-06-15","1995-04-15","AM1547");
INSERT INTO `unemployed` VALUES (NULL, "Pantelis", "Panopoulos", "aggelsta@gmail.com", "Kallithea","78113654","1908197866514","2019-09-07","1978-08-19","AM2748");
INSERT INTO `unemployed` VALUES (NULL, "Eudokia", "Aggelidou", "aggelsta@gmail.com", "Piraia","21657985","2712198274578","2017-06-25","1982-12-27","AM1864");
INSERT INTO `unemployed` VALUES (NULL, "Aikaterini", "Papastamathi", "aggelsta@hotmail.com", "Menidi","11487522","3007198516693","2018-06-17","1985-07-30","AM2154");
INSERT INTO `unemployed` VALUES (NULL, "Dhmitra", "Velou", "aggelsta@gmail.com", "Nea Smirni","96354478","1601199417871","2015-06-19","1994-01-16","AM2287");

COMMIT;

--Ignore this
/*CREATE TABLE IF NOT EXISTS `user` (
 `username` varchar(50) NOT NULL DEFAULT "error",
 `password` varchar(100) NOT NULL,
 `enabled` tinyint(1) NOT NULL,
 PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `authorities` (
 `username` varchar(50) NOT NULL,
 `authority` varchar(50) NOT NULL,
 UNIQUE KEY `ix_auth_username` (`username`,`authority`),
 CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/

--passwords are in order:
--123456789
--123456!
--123456@
--123456#
--123456%
--https://bcrypt-generator.com/