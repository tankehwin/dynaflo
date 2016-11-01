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
  `latest_date_purchased` datetime NULL,
  `supplier` VARCHAR(100) NULL,
  `item_reference` VARCHAR(100) NULL,
  `equipment_package_reference` VARCHAR(100) NULL,
  `graco_reference` VARCHAR(100) NULL,
  `graco_fam_type` VARCHAR(100) NULL,
  `graco_fam_discount` FLOAT NULL,
  `graco_std_discount` FLOAT NULL,
  `graco_std_discount_code` VARCHAR(50) NULL,
  `brand` VARCHAR(30) NULL,
  `supplier_code` VARCHAR(100) NULL,
  PRIMARY KEY (`part_number`))
ENGINE = InnoDB;


CREATE TABLE login_master (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(20),
	password varchar(30),
	acc_type varchar(10),
	date_created datetime,
	date_updated datetime
);

CREATE TABLE brands_master (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(30),
	freight_charges varchar(5),
	expiry_date varchar(20),
	exchange_rate varchar(50),
	date_created datetime,
	date_updated datetime
);

insert into login_master(name,password,acc_type,date_created,date_updated)values('admin','admin','admin',now(),now());
insert into login_master(name,password,acc_type,date_created,date_updated)values('normal','normal','normal',now(),now());

-- once initial import is done, run the line below to populate brands_master
insert into brands_master(name) select distinct brand from items_master;


		
