CREATE TABLE IF NOT EXISTS `users` (
  `id` INT NOT NULL,
  `username` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `account_non_expired` TINYINT NOT NULL DEFAULT 1,
  `account_non_locked` TINYINT NOT NULL DEFAULT 1,
  `credentials_non_expired` TINYINT NOT NULL DEFAULT 1,
  `enable` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`));