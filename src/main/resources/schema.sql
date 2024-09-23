CREATE DATABASE  IF NOT EXISTS `product`;
USE `product`;
--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `sub_category` varchar(255) DEFAULT NULL,
  `price` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `created_dt` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
); 

