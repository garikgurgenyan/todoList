--create table

CREATE TABLE `todolist` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `note` varchar(100) NOT NULL,
   `deadline` date NOT NULL,
   `status` bit(1) DEFAULT b'0',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 
--insert data
INSERT INTO `todolist` 
VALUES 
(1,'Перемещение поля. Замени поля isManAnya и isManRoma полем man в нужном классе.','2016-02-15','\0')
,(2,'Извлечение класса.','2016-02-16','\0')
,(3,'Добавь класс Address в пакет user.','2015-02-02','')
,(4,'Перенеси поля country, city и house в новый класс.','2016-01-01','')
,(5,'Добавь сеттеры и геттеры для них.','2016-10-20','\0')
,(6,'Перепиши класс User, используя поле класса Address address.','2016-01-01','')
,(7,'Встраивание класса. Класс House почти ничего не делает, избавься от него.','2015-02-02','')
,(8,'Сокрытие делегирования.','2016-01-01','')
,(9,'Добавь в класс User метод getBoss().','2016-01-01','')
,(10,'Перепиши реализацию метода getBoosName(User user) класса UserHelper.','2016-01-01','');