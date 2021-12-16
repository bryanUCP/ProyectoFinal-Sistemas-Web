-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyectosistemasweb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumnocuestionarios`
--

DROP TABLE IF EXISTS `alumnocuestionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnocuestionarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_alumno` int DEFAULT NULL,
  `id_cuestionario` int DEFAULT NULL,
  `puntaje` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_alumno` (`id_alumno`),
  KEY `id_cuestionario` (`id_cuestionario`),
  CONSTRAINT `alumnocuestionarios_ibfk_1` FOREIGN KEY (`id_alumno`) REFERENCES `alumnos` (`id`),
  CONSTRAINT `alumnocuestionarios_ibfk_2` FOREIGN KEY (`id_cuestionario`) REFERENCES `cuestionarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnocuestionarios`
--

LOCK TABLES `alumnocuestionarios` WRITE;
/*!40000 ALTER TABLE `alumnocuestionarios` DISABLE KEYS */;
INSERT INTO `alumnocuestionarios` VALUES (1,1,1,8),(2,2,4,0),(3,2,1,0),(4,3,1,0),(5,1,2,0),(6,1,3,0);
/*!40000 ALTER TABLE `alumnocuestionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `apellido` varchar(60) DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `clave` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'sebastian','rodriguez','sebas@gmail.com','12345'),(2,'omar','lizardi','omar@gmail.com','1223'),(3,'raul','apodaca','raul@gmail.com','445656'),(4,'rafael ','martinez perea','rafael@gmail.com','33445'),(5,'omar alejandro','werwer','sdf@sdfsdf','112233'),(6,'martin','ronzon','ronzon@gmail.com','1122334'),(7,'carla','castillo','carla@gmail.com','1234522');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `alumnosporcuestionario`
--

DROP TABLE IF EXISTS `alumnosporcuestionario`;
/*!50001 DROP VIEW IF EXISTS `alumnosporcuestionario`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `alumnosporcuestionario` AS SELECT 
 1 AS `ID_CUESTIONARIO`,
 1 AS `TITULO`,
 1 AS `vigencia`,
 1 AS `profesor`,
 1 AS `Numero_Alumnos`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cuestionarioalumnos`
--

DROP TABLE IF EXISTS `cuestionarioalumnos`;
/*!50001 DROP VIEW IF EXISTS `cuestionarioalumnos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `cuestionarioalumnos` AS SELECT 
 1 AS `IdAlumno`,
 1 AS `alumno`,
 1 AS `cuestionario`,
 1 AS `IdCuestionario`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `cuestionarios`
--

DROP TABLE IF EXISTS `cuestionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuestionarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_creacion` varchar(60) DEFAULT NULL,
  `vigencia` varchar(60) DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_profesor` (`id_profesor`),
  CONSTRAINT `cuestionarios_ibfk_1` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuestionarios`
--

LOCK TABLES `cuestionarios` WRITE;
/*!40000 ALTER TABLE `cuestionarios` DISABLE KEYS */;
INSERT INTO `cuestionarios` VALUES (1,'10 de diciembre','16 de diciembre',1,'base de datos'),(2,'11 de diciembre','13 de dicimebre',1,'sistemas operativos'),(3,'11 de diciembre','12 de diciembre',2,'matematicas discretas'),(4,'11 de diciembre','12 de diciembre',3,'1er parcial'),(6,'13 de diciembre 2021','14 de diciembre 2021',1,'servicio social'),(7,'13 de dicimebre 2021','16 de dicimebre 2021',1,'final'),(8,'13 de dicimebre 2021','16 de dicimebre 2021',1,'2 parcial'),(9,'24 de dicimebre 2021','26 de dicimebre 2021',1,'3er parcial');
/*!40000 ALTER TABLE `cuestionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `examen1`
--

DROP TABLE IF EXISTS `examen1`;
/*!50001 DROP VIEW IF EXISTS `examen1`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `examen1` AS SELECT 
 1 AS `contenido`,
 1 AS `puntaje`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preguntas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contenido` varchar(255) NOT NULL,
  `puntaje` int DEFAULT NULL,
  `id_cuestionario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cuestionario` (`id_cuestionario`),
  CONSTRAINT `preguntas_ibfk_1` FOREIGN KEY (`id_cuestionario`) REFERENCES `cuestionarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` VALUES (1,'¿cuantos años tienes?',0,1),(2,'¿cuantos hermanos tienes?',0,2),(3,'¿Cuanto es la raiz cuadrada de 28?',2,3),(4,'¿cuanto es 2 + 2?',2,4),(5,'¿cuanto es 34 x 5?',2,4),(6,'¿quien fue el creador de WWW?',2,4),(7,'¿cual es la raiz cuadrada de 27?',2,2),(8,'¿cual es la raiz cuadrada de 41?',2,2),(9,'¿cual es la raiz cuadrada de 56?',2,2),(10,'¿cual es la raiz cuadrada de 76?',2,2);
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `preguntasporcuestionario`
--

DROP TABLE IF EXISTS `preguntasporcuestionario`;
/*!50001 DROP VIEW IF EXISTS `preguntasporcuestionario`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `preguntasporcuestionario` AS SELECT 
 1 AS `id`,
 1 AS `Nombre_Cuestionario`,
 1 AS `vigencia`,
 1 AS `numero_de_pregunta`,
 1 AS `pregunta`,
 1 AS `puntaje`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `apellido` varchar(60) DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `clave` varchar(60) DEFAULT NULL,
  `experiencia` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Bryan ','Duran','bryan@hotmail.com','1234','base de datos'),(2,'Horus Alejandro','Cabrera','Cabrera@hotmail.com','3245','sistemas operativos'),(3,'rafael','rojano','rojano@gmail.com','12344','sistemas web'),(4,'freddy','castañeda','freddy@gmail.com','112233','servicio social');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuestas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contenido` varchar(255) DEFAULT NULL,
  `id_pregunta` int DEFAULT NULL,
  `id_alumno` int DEFAULT NULL,
  `puntaje` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pregunta` (`id_pregunta`),
  KEY `respuestas_ibfk_2_idx` (`id_alumno`),
  CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id`),
  CONSTRAINT `respuestas_ibfk_2` FOREIGN KEY (`id_alumno`) REFERENCES `alumnocuestionarios` (`id_alumno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas`
--

LOCK TABLES `respuestas` WRITE;
/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
INSERT INTO `respuestas` VALUES (1,'12',1,1,2),(2,'Tim berneslee',6,2,2),(3,'22',1,2,2);
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `respuestasporalumno`
--

DROP TABLE IF EXISTS `respuestasporalumno`;
/*!50001 DROP VIEW IF EXISTS `respuestasporalumno`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `respuestasporalumno` AS SELECT 
 1 AS `Nombre del alumno`,
 1 AS `nombre del cuestionario`,
 1 AS `numero de pregunta`,
 1 AS `Pregunta`,
 1 AS `respuesta`,
 1 AS `id_cuestionario`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `alumnosporcuestionario`
--

/*!50001 DROP VIEW IF EXISTS `alumnosporcuestionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `alumnosporcuestionario` AS select `alumnocuestionarios`.`id_cuestionario` AS `ID_CUESTIONARIO`,`cuestionarios`.`nombre` AS `TITULO`,`cuestionarios`.`vigencia` AS `vigencia`,`cuestionarios`.`id_profesor` AS `profesor`,count(`alumnocuestionarios`.`id_alumno`) AS `Numero_Alumnos` from (`cuestionarios` join `alumnocuestionarios`) where ((`cuestionarios`.`id` = `alumnocuestionarios`.`id_cuestionario`) and (`alumnocuestionarios`.`id_cuestionario` = `cuestionarios`.`id`)) group by `alumnocuestionarios`.`id_cuestionario` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cuestionarioalumnos`
--

/*!50001 DROP VIEW IF EXISTS `cuestionarioalumnos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cuestionarioalumnos` AS select `alu`.`id` AS `IdAlumno`,concat(`alu`.`nombre`,' ',`alu`.`apellido`) AS `alumno`,`cuestionarios`.`nombre` AS `cuestionario`,`cues`.`id_cuestionario` AS `IdCuestionario` from ((`alumnos` `alu` join `alumnocuestionarios` `cues`) join `cuestionarios`) where ((`alu`.`id` = `cues`.`id_alumno`) and (`cuestionarios`.`id` = `cues`.`id_cuestionario`)) order by `alu`.`apellido` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `examen1`
--

/*!50001 DROP VIEW IF EXISTS `examen1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `examen1` AS select `preguntas`.`contenido` AS `contenido`,`preguntas`.`puntaje` AS `puntaje` from `preguntas` where (`preguntas`.`id_cuestionario` = 3) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `preguntasporcuestionario`
--

/*!50001 DROP VIEW IF EXISTS `preguntasporcuestionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `preguntasporcuestionario` AS select `cuestionarios`.`id` AS `id`,`cuestionarios`.`nombre` AS `Nombre_Cuestionario`,`cuestionarios`.`vigencia` AS `vigencia`,`preguntas`.`id` AS `numero_de_pregunta`,`preguntas`.`contenido` AS `pregunta`,`preguntas`.`puntaje` AS `puntaje` from (`cuestionarios` join `preguntas`) where (`cuestionarios`.`id` = `preguntas`.`id_cuestionario`) order by `cuestionarios`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `respuestasporalumno`
--

/*!50001 DROP VIEW IF EXISTS `respuestasporalumno`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `respuestasporalumno` AS select concat(`alu`.`nombre`,' ',`alu`.`apellido`) AS `Nombre del alumno`,`cuestionarios`.`nombre` AS `nombre del cuestionario`,`pre`.`id` AS `numero de pregunta`,`pre`.`contenido` AS `Pregunta`,`res`.`contenido` AS `respuesta`,`cues`.`id_cuestionario` AS `id_cuestionario` from ((((`respuestas` `res` join `preguntas` `pre`) join `alumnos` `alu`) join `alumnocuestionarios` `cues`) join `cuestionarios`) where ((`pre`.`id` = `res`.`id_pregunta`) and (`res`.`id_alumno` = `alu`.`id`) and (`cues`.`id_alumno` = `alu`.`id`) and (`cues`.`id_cuestionario` = `pre`.`id_cuestionario`) and (`cuestionarios`.`id` = `cues`.`id_cuestionario`)) order by `pre`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-15 16:43:57
