# ************************************************************
# Sequel Pro SQL dump
# Version 4004
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.24)
# Database: sql2
# Generation Time: 2013-12-10 21:18:01 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table aluno
# ------------------------------------------------------------

DROP TABLE IF EXISTS `aluno`;

CREATE TABLE `aluno` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;

INSERT INTO `aluno` (`id`, `nome`, `email`)
VALUES
	(1,'João da Silva','joao@dasilva.com'),
	(2,'Frederico José','fred@jose.com'),
	(3,'Alberto Santos','alberto@santos.com'),
	(4,'Renata Alonso','renata@alonso.com'),
	(5,'Paulo da Silva','paulo@dasilva.com');

/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table curso
# ------------------------------------------------------------

DROP TABLE IF EXISTS `curso`;

CREATE TABLE `curso` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;

INSERT INTO `curso` (`id`, `nome`)
VALUES
	(1,'SQL e banco de dados'),
	(2,'Desenvolvimento web com VRaptor'),
	(3,'Scrum e métodos ágeis'),
	(4,'PHP e MySql');

/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table exercicio
# ------------------------------------------------------------

DROP TABLE IF EXISTS `exercicio`;

CREATE TABLE `exercicio` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `secao_id` int(11) NOT NULL,
  `pergunta` text NOT NULL,
  `resposta_oficial` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `exercicio` WRITE;
/*!40000 ALTER TABLE `exercicio` DISABLE KEYS */;

INSERT INTO `exercicio` (`id`, `secao_id`, `pergunta`, `resposta_oficial`)
VALUES
	(1,1,'O que é um select?','Uma consulta que devolve resultados'),
	(2,1,'Como funciona um select?','select campos from tabela'),
	(3,2,'O que é um update?','serve pra alterar dados'),
	(4,2,'Perigos do update?','Nao pode esquecer de colocar where'),
	(5,3,'O que é um delete?','deleta uma linha do banco de dados'),
	(6,3,'Cuidados com ele?','nao pode esquecer do where'),
	(7,4,'o que eh um insert?','serve para inserir um dado no banco'),
	(8,4,'como funciona?','insert into (coluna1, coluna2) values (v1, v2)'),
	(9,5,'Como funciona a web?','requisicao e resposta'),
	(10,5,'Que linguagens posso ajudar?','varias, java, php, c#, etc'),
	(11,6,'O que eh MVC?','model view controller'),
	(12,6,'Frameworks que usam?','vraptor, spring mvc, struts, etc'),
	(13,7,'O que é a classe Result?','serve para lidar com o resultado'),
	(14,8,'O que é um interceptor?','eh como se fosse um filtro que eh executado antes'),
	(15,8,'quando usar?','tratamento de excecoes, conexao com o banco de dados'),
	(16,9,'o que eh iteracao','tempo que vc tem pra agregar valor'),
	(17,9,'qual tamanho bom?','de 2 a 4 semanas, segundo o scrum guide antigo'),
	(18,10,'o que sao retrospectiva?','reunioes onde a ideia eh melhorar o processo'),
	(19,10,'quando devemos fazer?','geralmente a cada iteracao'),
	(20,11,'o que eh a reuniao diaria?','uma pequena reuniao para informar a equipe sobre o andamento da iteracao'),
	(21,11,'quando fazemos?','uma vez por dia, em um horario fixo e pre definido'),
	(22,12,'o que eh kanban?','um metodo agil tb'),
	(23,12,'o que eh xp?','outro metodo agil'),
	(24,12,'tem outros?','lean, crystal, fdd'),
	(25,13,'o que eh a web?','eh a internet, ue'),
	(26,13,'como funciona a web?','requisicao e resposta'),
	(27,14,'o que eh o apache?','servidor que sabe trabalhar com HTTP'),
	(28,14,'java funciona?','sim, quando colocamos o tomcat junto com ele'),
	(29,15,'o que eh mysql','essa voce sabe, certo? :)'),
	(30,16,'o que eh deploy?','eh o processo de colocarmos a aplicacao no ar'),
	(31,16,'como faz?','em php, basta copiar os arquivos php, em java, basta copiar o jar');

/*!40000 ALTER TABLE `exercicio` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table matricula
# ------------------------------------------------------------

DROP TABLE IF EXISTS `matricula`;

CREATE TABLE `matricula` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `aluno_id` int(11) NOT NULL,
  `curso_id` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `tipo` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;

INSERT INTO `matricula` (`id`, `aluno_id`, `curso_id`, `data`, `tipo`)
VALUES
	(1,1,1,'2013-11-25 16:16:05','PAGA_PF'),
	(2,2,1,'2013-05-25 16:16:25','PAGA_PJ'),
	(3,3,3,'2013-07-21 16:16:30','PAGA_PF'),
	(4,4,4,'2013-11-15 16:15:35','PAGA_PK'),
	(5,2,2,'2012-01-04 00:00:00','PAGA_PJ');

/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table nota
# ------------------------------------------------------------

DROP TABLE IF EXISTS `nota`;

CREATE TABLE `nota` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `resposta_id` int(11) DEFAULT NULL,
  `nota` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;

INSERT INTO `nota` (`id`, `resposta_id`, `nota`)
VALUES
	(1,1,8),
	(2,2,0),
	(3,3,7),
	(4,4,6),
	(5,5,9),
	(6,6,10),
	(7,7,4),
	(8,8,4),
	(9,9,7),
	(10,10,8),
	(11,11,6),
	(12,12,7),
	(13,13,4),
	(14,14,9),
	(15,15,3),
	(16,16,5),
	(17,17,5),
	(18,18,5),
	(19,19,6),
	(20,20,8),
	(21,21,8),
	(22,22,9),
	(23,23,10),
	(24,24,2),
	(25,25,0),
	(26,26,1),
	(27,27,4);

/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table resposta
# ------------------------------------------------------------

DROP TABLE IF EXISTS `resposta`;

CREATE TABLE `resposta` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `exercicio_id` int(11) DEFAULT NULL,
  `aluno_id` int(11) DEFAULT NULL,
  `resposta_dada` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `resposta` WRITE;
/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;

INSERT INTO `resposta` (`id`, `exercicio_id`, `aluno_id`, `resposta_dada`)
VALUES
	(1,1,1,'uma selecao'),
	(2,2,1,'ixi, nao sei'),
	(3,3,1,'alterar dados'),
	(4,4,1,'eskecer o where e alterar tudo'),
	(5,5,1,'apagar coisas'),
	(6,6,1,'tb nao pode eskecer o where'),
	(7,7,1,'inserir dados'),
	(8,1,2,'buscar dados'),
	(9,2,2,'select campos from tabela'),
	(10,3,2,'alterar coisas'),
	(11,4,2,'ixi, nao sei'),
	(12,16,3,'tempo pra fazer algo'),
	(13,17,3,'1 a 4 semanas'),
	(14,18,3,'melhoria do processo'),
	(15,19,3,'todo dia'),
	(16,20,3,'reuniao de status'),
	(17,21,3,'todo dia'),
	(18,22,3,'o quadro branco'),
	(19,23,3,'um metodo agil'),
	(20,24,3,'tem varios outros'),
	(21,25,4,'eh a internet'),
	(22,26,4,'browser faz requisicao, servidor manda resposta'),
	(23,27,4,'eh o servidor que lida com http'),
	(24,28,4,'nao sei'),
	(25,29,4,'banco de dados!'),
	(26,30,4,'eh colocar a app na internet'),
	(27,31,4,'depende da tecnologia, mas geralmente eh levar pra um servidor que ta na internet');

/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table secao
# ------------------------------------------------------------

DROP TABLE IF EXISTS `secao`;

CREATE TABLE `secao` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `curso_id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL DEFAULT '',
  `explicacao` text NOT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `secao` WRITE;
/*!40000 ALTER TABLE `secao` DISABLE KEYS */;

INSERT INTO `secao` (`id`, `curso_id`, `titulo`, `explicacao`, `numero`)
VALUES
	(1,1,'Aprendendo o SELECT','explicacao do capitulo Aprendendo o SELECT',1),
	(2,1,'Aprendendo o UPDATE','explicacao do capitulo Aprendendo o UPDATE',2),
	(3,1,'Aprendendo o DELETE','explicacao do capitulo Aprendendo o DELETE',3),
	(4,1,'Aprendendo o INSERT','explicacao do capitulo Aprendendo o INSERT',4),
	(5,2,'O que é a Web?','explicacao do capitulo O que é a Web?',1),
	(6,2,'Entendendo o MVC','explicacao do capitulo Entendendo o MVC',2),
	(7,2,'O objeto Result','explicacao do capitulo O objeto Result',3),
	(8,2,'Interceptor','explicacao do capitulo Interceptor',4),
	(9,3,'Planejando a iteração','explicacao do capitulo Planejando a iteração',1),
	(10,3,'Retrospectivas','explicacao do capitulo Retrospectivas',2),
	(11,3,'Reunião Diária','explicacao do capitulo Reunião Diária',3),
	(12,3,'Kanban e XP','explicacao do capitulo Kanban e XP',4),
	(13,4,'Introdução a Web','explicacao do capitulo Introdução a Web',1),
	(14,4,'O servidor Apache','explicacao do capitulo O servidor Apache',2),
	(15,4,'Lidando com o MySql','explicacao do capitulo Lidando com o MySql',3),
	(16,4,'Instalando a aplicação','explicacao do capitulo Instalando a aplicação',4);

/*!40000 ALTER TABLE `secao` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
