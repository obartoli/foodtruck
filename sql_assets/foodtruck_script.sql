-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema foodtruck
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema foodtruck
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `foodtruck` ;
USE `foodtruck` ;

-- -----------------------------------------------------
-- Table `foodtruck`.`Family`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Family` (
  `family_id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`family_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Product` (
  `product_id` INT NOT NULL,
  `family_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `price` FLOAT NULL,
  `availability` VARCHAR(5) NULL,
  `stock` INT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`product_id`),
  INDEX `fk_Product_Family1_idx` (`family_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Type_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Type_user` (
  `type_user_id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`type_user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Type_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Type_address` (
  `type_address_id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`type_address_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Address` (
  `address_id` INT NOT NULL,
  `type_address_id` INT NOT NULL,
  `nbStreet` INT NULL,
  `street` VARCHAR(45) NULL,
  `zipCode` INT NULL,
  `city` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`address_id`),
  INDEX `fk_address_Type_address1_idx` (`type_address_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Company` (
  `company_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`company_id`),
  INDEX `fk_Company_address1_idx` (`address_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`User` (
  `user_id` INT NOT NULL,
  `type_user_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_User_Type_user1_idx` (`type_user_id` ASC),
  INDEX `fk_User_Company1_idx` (`company_id` ASC),
  INDEX `fk_User_address1_idx` (`address_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Status` (
  `status_id` INT NOT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`status_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Order` (
  `order_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  `date_command` DATE NULL,
  `date_delivery` DATE NULL,
  `total_price` FLOAT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_Order_User1_idx` (`user_id` ASC),
  INDEX `fk_Order_address1_idx` (`address_id` ASC),
  INDEX `fk_Order_Status1_idx` (`status_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Line_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Line_order` (
  `line_order_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity` INT NULL,
  `effective_price` FLOAT NULL,
  `total_price` FLOAT NULL,
  `rate` FLOAT NULL,
  PRIMARY KEY (`line_order_id`),
  INDEX `fk_Line_order_Order1_idx` (`order_id` ASC),
  INDEX `fk_Line_order_Product1_idx` (`product_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Meal` (
  `meal_id` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  `start` TIME NULL,
  `end` TIME NULL,
  PRIMARY KEY (`meal_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Post` (
  `post_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `body` VARCHAR(45) NULL,
  `image` VARCHAR(45) NULL,
  PRIMARY KEY (`post_id`),
  INDEX `fk_Post_User1_idx` (`user_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foodtruck`.`Family_has_Meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodtruck`.`Family_has_Meal` (
  `family_id` INT NOT NULL,
  `meal_id` INT NOT NULL,
  PRIMARY KEY (`family_id`, `meal_id`),
  INDEX `fk_Family_has_Meal_Meal1_idx` (`meal_id` ASC),
  INDEX `fk_Family_has_Meal_Family1_idx` (`family_id` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
