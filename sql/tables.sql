CREATE TABLE items_master (
  `part_number` VARCHAR(100) NULL,
  `description` VARCHAR(200) NULL,
  `add_info_1` VARCHAR(500) NULL,
  `add_info_2` VARCHAR(500) NULL,
  `add_info_3` VARCHAR(500) NULL,
  `duties` FLOAT NULL,
  `selling_price` FLOAT NULL,
  `lead_time_aro` BIGINT NOT NULL,
  `dynaflo_discount_code` VARCHAR(50) NULL,
  `old_part_number` VARCHAR(100) NULL,
  `latest_date_purchased` date NULL,
  `supplier` VARCHAR(100) NULL,
  `item_reference` VARCHAR(100) NULL,
  `equipment_package_reference` VARCHAR(100) NULL,
  `graco_reference` VARCHAR(100) NULL,
  `graco_fam_type` VARCHAR(100) NULL,
  `graco_fam_discount` FLOAT NULL,
  `graco_std_discount` FLOAT NULL,
  `graco_std_discount_code` VARCHAR(50) NULL,
  `supplier_code` VARCHAR(100) NULL,
  PRIMARY KEY (`part_number`))
ENGINE = InnoDB;








		
