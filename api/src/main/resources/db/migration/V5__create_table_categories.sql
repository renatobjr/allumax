CREATE TABLE IF NOT EXISTS `categories` (
  `id` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL,
  `deleted_at` DATETIME NULL,
  `enable` TINYINT NULL DEFAULT 1,
  PRIMARY KEY (`id`));