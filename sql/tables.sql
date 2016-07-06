CREATE TABLE `dynaflow`.`items_master` (
  `id` BIGINT NOT NULL,
  `part_id` VARCHAR(100) NULL,
  `price` FLOAT NULL,
  `duty` FLOAT NULL,
  `discount` FLOAT NULL,
  `family_code` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;