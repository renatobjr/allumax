CREATE TABLE IF NOT EXISTS `profiles` (
  `id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `fullname` VARCHAR(255) NULL,
  `phone` VARCHAR(45) NULL,
  `bio` VARCHAR(255) NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL,
  `deleted_at` DATETIME NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_profiles_users_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_profiles_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);