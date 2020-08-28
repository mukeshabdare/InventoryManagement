DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int NOT NULL,
  `category` text,
  `company` text,
  `product` text,
  `color` text,
  `description` text,
  `price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
)

LOCK TABLES `products` WRITE;

INSERT INTO `products` VALUES (1,'Mobiles','Apple','AP1','Black','Some description about AP1',70000,13,11),
(2,'Mobiles','Samsung','SP1','Grey','Some description about SP1',50000,2,2),
(3,'Mobiles','MI','MP1','Black','Some description about MP1',20000,9,35),
(4,'Computers','Intel','IL1','Grey','Some description about IL1',67000,0,106),
(5,'Computers','Intel','IL2','Black','Some description about IL2',74000,6,300),
(6,'Computers','Lenovo','LL1','Black','Some description about LL2',80000,10,138),
(7,'Television','LG','LT1','Black','Some description about LT1',42500,8,62),
(8,'Television','Samsung','ST1','Grey','Some description about ST1',58360,16,168);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;