-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PowerCards
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PowerCards
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PowerCards` DEFAULT CHARACTER SET utf8 ;
USE `PowerCards` ;

-- -----------------------------------------------------
-- Table `PowerCards`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PowerCards`.`Persona` (
  `nickname` VARCHAR(250) NOT NULL,
  `contraseña` VARCHAR(250) NULL,
  `rol` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`nickname`),
  UNIQUE INDEX `usuario_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PowerCards`.`Juego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PowerCards`.`Juego` (
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `total_cartas` INT NOT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PowerCards`.`Sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PowerCards`.`Sala` (
  `id` INT NOT NULL,
  `Juego_nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Sala_Juego1_idx` (`Juego_nombre` ASC) VISIBLE,
  CONSTRAINT `fk_Sala_Juego1`
    FOREIGN KEY (`Juego_nombre`)
    REFERENCES `PowerCards`.`Juego` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PowerCards`.`Contiene`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PowerCards`.`Contiene` (
  `Persona_nickname` VARCHAR(250) NOT NULL,
  `Sala_id` INT NOT NULL,
  PRIMARY KEY (`Persona_nickname`, `Sala_id`),
  INDEX `fk_Persona_has_Sala_Sala1_idx` (`Sala_id` ASC) VISIBLE,
  INDEX `fk_Persona_has_Sala_Persona_idx` (`Persona_nickname` ASC) VISIBLE,
  CONSTRAINT `fk_Persona_has_Sala_Persona`
    FOREIGN KEY (`Persona_nickname`)
    REFERENCES `PowerCards`.`Persona` (`nickname`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Persona_has_Sala_Sala1`
    FOREIGN KEY (`Sala_id`)
    REFERENCES `PowerCards`.`Sala` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PowerCards`.`Carta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PowerCards`.`Carta` (
  `idCarta` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `ataque` INT NULL,
  `defensa` INT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `Juego_nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCarta`, `Juego_nombre`),
  UNIQUE INDEX `idCarta_UNIQUE` (`idCarta` ASC) VISIBLE,
  INDEX `fk_Carta_Juego1_idx` (`Juego_nombre` ASC) VISIBLE,
  CONSTRAINT `fk_Carta_Juego1`
    FOREIGN KEY (`Juego_nombre`)
    REFERENCES `PowerCards`.`Juego` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
