CREATE TABLE IF NOT EXISTS `users_has_permissions` (
  `users_id` INT NOT NULL,
  `permissions_id` INT NOT NULL,
  PRIMARY KEY (`users_id`, `permissions_id`),
  INDEX `fk_users_has_permissions_permissions_idx` (`permissions_id` ASC) VISIBLE,
  INDEX `fk_users_has_permissions_users_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_has_permissions_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_permissions_permissions`
    FOREIGN KEY (`permissions_id`)
    REFERENCES `permissions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);