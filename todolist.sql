CREATE TABLE `todolist` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `note` varchar(100) NOT NULL,
   `deadline` date NOT NULL,
   `status` bit(1) DEFAULT b'0',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8