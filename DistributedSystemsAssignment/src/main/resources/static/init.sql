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
 `photo` varchar(50),
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

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
   ('Argiris', '$2a$12$tJF12GKRnBpFZqYo5Top3.GnWgKR7Xhm9IcGfyvDZybiLc8VzPqiO', 1),
   ('root', '$2a$12$TwApuqoafyZYQ/dY/Oskpeiyhpj5ATPT6azTfjb9No2W7oDuVJT/S', 1),
   ('vasilis', '$2a$12$AV6St8whDsHoOxaYIef3n.M0WbpC9UJCXofy2ZMzTR.3CN7UuY43C', 1),
   ('georgia', '$2a$12$CGPw0xNZpIw5sLmN1ZH53uJEQKpW2IniAlSx0zdn8noM6HvkF7F0y', 1),
   ('despoina', '$2a$12$.A3wb3LsEPuHGD6iRFdoUeFNIJSsQkiTu611fbq/Q8aQfON5tmJnS', 1),
   ('dimitris', '$2a$12$xwU55dsm.biLndIlbvZP8umyGuCToJyXpJTd8eWIkUNyCzEjPEpk.', 1),
   ('maria', '$2a$12$LkBkfYgdogEWZ3miBW4p..fD3F3O9zQbYPtdauwSSxhfk.4tZMOoa', 1);

INSERT INTO `authorities` (`name`) VALUES ('USER');
INSERT INTO `authorities` (`name`) VALUES ('ADMIN');
INSERT INTO `authorities` (`name`) VALUES ('OAED');
INSERT INTO `authorities` (`name`) VALUES ('OASA');

INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (1, 1); -- user has role USER
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (2, 2); -- user has role ADMIN
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (3, 2); -- user has role ADMIN
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (4, 2); -- user has role ADMIN
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (5, 2); -- user has role ADMIN
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (6, 3); -- user has role OAED
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (7, 4); -- user has role OASA

INSERT INTO `unemployed` VALUES (NULL, "Panagiotis", "Georgidis", "Pangeo@hotmail.com", "Kamatero","24587549","1504199516578","2014-06-15","1995-04-15","AM1547");
INSERT INTO `unemployed` VALUES (NULL, "Pantelis", "Panopoulos", "aggelsta@gmail.com", "Kallithea","78113654","1908197866514","2019-09-07","1978-08-19","AM2748");
INSERT INTO `unemployed` VALUES (NULL, "Eudokia", "Aggelidou", "aggelsta@gmail.com", "Piraia","21657985","2712198274578","2017-06-25","1982-12-27","AM1864");
INSERT INTO `unemployed` VALUES (NULL, "Aikaterini", "Papastamathi", "aggelsta@hotmail.com", "Menidi","11487522","3007198516693","2018-06-17","1985-07-30","AM2154");
INSERT INTO `unemployed` VALUES (NULL, "Dhmitra", "Velou", "aggelsta@gmail.com", "Nea Smirni","96354478","1601199417871","2015-06-19","1994-01-16","AM2287");

COMMIT;

--passwords are in order:
--123456789
--123456!
--123456@
--123456#
--123456%
--123456^
--123456&
--https://bcrypt-generator.com/