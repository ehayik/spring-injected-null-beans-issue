CREATE TABLE IF NOT EXISTS `users` (
  `user_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(45) NOT NULL UNIQUE ,
  `user_password` VARCHAR(45) NOT NULL,
  `user_enabled`BOOLEAN NOT NULL,
  PRIMARY KEY (`user_id`));