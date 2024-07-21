create database invoice;
use invoice;

show tables;
describe invoice_type;
desc invoice;
describe payment_provider;
describe payment;

-- MySQL dump 10.13  Distrib 8.2.0, for Linux (x86_64)
--
-- Host: localhost    Database: invoice
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice`
(
    `id`              varchar(255) COLLATE utf8mb4_unicode_ci               NOT NULL,
    `created_by`      varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `created_at`      datetime(6)                             DEFAULT NULL,
    `status_record`   enum ('ACTIVE','INACTIVE') COLLATE utf8mb4_unicode_ci NOT NULL,
    `updated_at`      datetime(6)                             DEFAULT NULL,
    `updated_by`      varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `amount`          decimal(38, 2)                                        NOT NULL,
    `description`     varchar(100) COLLATE utf8mb4_unicode_ci               NOT NULL,
    `due_date`        date                                                  NOT NULL,
    `invoice_number`  varchar(100) COLLATE utf8mb4_unicode_ci               NOT NULL,
    `paid`            bit(1)                                                NOT NULL,
    `id_invoice_type` varchar(255) COLLATE utf8mb4_unicode_ci               NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKco4sbxv9cj2oevm6cdpq76ffb` (`id_invoice_type`),
    CONSTRAINT `FKco4sbxv9cj2oevm6cdpq76ffb` FOREIGN KEY (`id_invoice_type`) REFERENCES `invoice_type` (`id`),
    CONSTRAINT `invoice_chk_1` CHECK ((`amount` >= 0))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice_type`
--

DROP TABLE IF EXISTS `invoice_type`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_type`
(
    `id`            varchar(255) COLLATE utf8mb4_unicode_ci               NOT NULL,
    `created_by`    varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `created_at`    datetime(6)                             DEFAULT NULL,
    `status_record` enum ('ACTIVE','INACTIVE') COLLATE utf8mb4_unicode_ci NOT NULL,
    `updated_at`    datetime(6)                             DEFAULT NULL,
    `updated_by`    varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `code`          varchar(100) COLLATE utf8mb4_unicode_ci               NOT NULL,
    `name`          varchar(100) COLLATE utf8mb4_unicode_ci               NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment`
(
    `id`                 varchar(255) COLLATE utf8mb4_unicode_ci               NOT NULL,
    `created_by`         varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `created_at`         datetime(6)                             DEFAULT NULL,
    `status_record`      enum ('ACTIVE','INACTIVE') COLLATE utf8mb4_unicode_ci NOT NULL,
    `updated_at`         datetime(6)                             DEFAULT NULL,
    `updated_by`         varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `amount`             decimal(38, 2)                                        NOT NULL,
    `transaction_time`   datetime(6)                                           NOT NULL,
    `id_virtual_account` varchar(255) COLLATE utf8mb4_unicode_ci               NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKptriq88d7e8io9mhri8p10cq0` (`id_virtual_account`),
    CONSTRAINT `FKptriq88d7e8io9mhri8p10cq0` FOREIGN KEY (`id_virtual_account`) REFERENCES `virtual_account` (`id`),
    CONSTRAINT `payment_chk_1` CHECK ((`amount` >= 0))
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payment_provider`
--

DROP TABLE IF EXISTS `payment_provider`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_provider`
(
    `id`            varchar(255) COLLATE utf8mb4_unicode_ci               NOT NULL,
    `created_by`    varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `created_at`    datetime(6)                             DEFAULT NULL,
    `status_record` enum ('ACTIVE','INACTIVE') COLLATE utf8mb4_unicode_ci NOT NULL,
    `updated_at`    datetime(6)                             DEFAULT NULL,
    `updated_by`    varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `code`          varchar(100) COLLATE utf8mb4_unicode_ci               NOT NULL,
    `logo`          varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `name`          varchar(100) COLLATE utf8mb4_unicode_ci               NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `virtual_account`
--

DROP TABLE IF EXISTS `virtual_account`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `virtual_account`
(
    `id`                   varchar(255) COLLATE utf8mb4_unicode_ci                         NOT NULL,
    `created_by`           varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `created_at`           datetime(6)                             DEFAULT NULL,
    `status_record`        enum ('ACTIVE','INACTIVE') COLLATE utf8mb4_unicode_ci           NOT NULL,
    `updated_at`           datetime(6)                             DEFAULT NULL,
    `updated_by`           varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `account_number`       varchar(255) COLLATE utf8mb4_unicode_ci                         NOT NULL,
    `company_id`           varchar(255) COLLATE utf8mb4_unicode_ci                         NOT NULL,
    `virtual_account_type` enum ('CLOSED','INSTALLMENT','OPEN') COLLATE utf8mb4_unicode_ci NOT NULL,
    `id_invoice`           varchar(255) COLLATE utf8mb4_unicode_ci                         NOT NULL,
    `id_payment_provider`  varchar(255) COLLATE utf8mb4_unicode_ci                         NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKbbdwdxpgdisiikyyhf2xteblc` (`id_invoice`),
    KEY `FKt3t7f64hvgk4xjblsovqqkpll` (`id_payment_provider`),
    CONSTRAINT `FKbbdwdxpgdisiikyyhf2xteblc` FOREIGN KEY (`id_invoice`) REFERENCES `invoice` (`id`),
    CONSTRAINT `FKt3t7f64hvgk4xjblsovqqkpll` FOREIGN KEY (`id_payment_provider`) REFERENCES `payment_provider` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2024-07-21  5:59:15

