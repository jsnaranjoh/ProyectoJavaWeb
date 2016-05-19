-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.0.17-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para bdproyectojavaweb
CREATE DATABASE IF NOT EXISTS `bdproyectojavaweb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bdproyectojavaweb`;


-- Volcando estructura para tabla bdproyectojavaweb.colabora
CREATE TABLE IF NOT EXISTS `colabora` (
  `junior` int(11) NOT NULL,
  `proyecto` int(11) NOT NULL,
  `horasdedicadas` int(11) NOT NULL,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL,
  PRIMARY KEY (`junior`,`proyecto`),
  KEY `FK_colabora_proyecto` (`proyecto`),
  CONSTRAINT `FK_colabora_junior` FOREIGN KEY (`junior`) REFERENCES `junior` (`cedula`),
  CONSTRAINT `FK_colabora_proyecto` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.colabora: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `colabora` DISABLE KEYS */;
INSERT INTO `colabora` (`junior`, `proyecto`, `horasdedicadas`, `fechainicio`, `fechafin`) VALUES
	(84940812, 501, 0, '2016-01-01', '2016-05-31'),
	(596518122, 501, 0, '2016-01-01', '2016-05-31');
/*!40000 ALTER TABLE `colabora` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.fase
CREATE TABLE IF NOT EXISTS `fase` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.fase: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
INSERT INTO `fase` (`codigo`, `nombre`) VALUES
	(1001, 'Análisis'),
	(1002, 'Diseño'),
	(1003, 'Codificación'),
	(1004, 'Pruebas');
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.gradoacademico
CREATE TABLE IF NOT EXISTS `gradoacademico` (
  `numero` int(11) NOT NULL,
  `ingeniero` int(11) NOT NULL,
  `nivel` varchar(50) NOT NULL,
  `lugar` varchar(50) NOT NULL,
  `aniotitulacion` int(4) NOT NULL,
  `tituloobtenido` varchar(50) NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `FK_gradoacademico_ingsoftware` (`ingeniero`),
  CONSTRAINT `FK_gradoacademico_ingsoftware` FOREIGN KEY (`ingeniero`) REFERENCES `ingsoftware` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.gradoacademico: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `gradoacademico` DISABLE KEYS */;
INSERT INTO `gradoacademico` (`numero`, `ingeniero`, `nivel`, `lugar`, `aniotitulacion`, `tituloobtenido`) VALUES
	(3131, 54117430, 'maestria', 'Universidad de la Sabana', 2000, 'Maestro en Diseño y Gestion de Procesos'),
	(354353, 4760491, 'universidad', 'Universidad Santiago de Cali', 2005, 'Ing. de Sistemas'),
	(424323, 641500199, 'universidad', 'Universidad de Medellin', 2003, 'Ing. de Software'),
	(454353, 54117430, 'universidad', 'Universidad del Valle', 1996, 'Ing. de Sistemas'),
	(897677, 641500199, 'maestria', 'Universidad del Valle', 2006, 'Maestro en Desarrollo de Software'),
	(4131232, 54117430, 'secundaria', 'I. E. Tulio Enrique Tascon', 1990, 'Bachiller Comercial'),
	(6456545, 84940812, 'secundaria', 'I. E. Carlos Arturo Cabal', 2010, 'Bachiller'),
	(9877977, 596518122, 'secundaria', 'Colegio Gimnasio Central del Valle', 2008, 'Bachiller');
/*!40000 ALTER TABLE `gradoacademico` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.ingsoftware
CREATE TABLE IF NOT EXISTS `ingsoftware` (
  `cedula` int(11) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `edad` int(3) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `fechanacimiento` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL,
  `celular` int(11) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `fechaingreso` date NOT NULL,
  `antiguedad` int(3) NOT NULL,
  `clave` varchar(50) NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.ingsoftware: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `ingsoftware` DISABLE KEYS */;
INSERT INTO `ingsoftware` (`cedula`, `nombres`, `apellidos`, `edad`, `sexo`, `fechanacimiento`, `email`, `telefono`, `celular`, `direccion`, `fechaingreso`, `antiguedad`, `clave`) VALUES
	(4760491, 'Alberto', 'Sandoval', 37, 'M', '1979-03-15', 'alberto.sandoval@java.com', 3098390, 319685172, 'Cra 45 # 12-22', '2012-02-29', 4, 'b1f37ec94d5ce01b55b89cec07183cef'),
	(54117430, 'Andres', 'Perez', 45, 'M', '1971-01-23', 'andres.perez@java.com', 6369321, 317019515, 'Cll 1 # 70-87', '2011-07-01', 4, 'b1f37ec94d5ce01b55b89cec07183cef'),
	(84940812, 'Lina', 'Arce', 23, 'F', '1993-04-29', 'lina.arce@java.com', 6754304, 311715702, 'Cll 6 # 15-09', '2013-01-13', 3, 'b1f37ec94d5ce01b55b89cec07183cef'),
	(596518122, 'Pablo', 'Martinez', 26, 'M', '1990-02-20', 'pablo.martinez@java.com', 8909437, 312392827, 'Cra 30 # 13-47', '2012-01-17', 4, 'b1f37ec94d5ce01b55b89cec07183cef'),
	(641500199, 'Ximena', 'Gomez', 33, 'F', '1983-01-01', 'ximena.gomez@java.com', 9016356, 319751406, 'Cll 97 # 45-65', '2013-05-23', 2, 'b1f37ec94d5ce01b55b89cec07183cef');
/*!40000 ALTER TABLE `ingsoftware` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.ingsoftwarelenguajeprog
CREATE TABLE IF NOT EXISTS `ingsoftwarelenguajeprog` (
  `cedula` int(11) NOT NULL,
  `lenguajeprog` varchar(50) NOT NULL,
  PRIMARY KEY (`cedula`,`lenguajeprog`),
  CONSTRAINT `FK_ingsoftwarelenguajeprog_ingsoftware` FOREIGN KEY (`cedula`) REFERENCES `ingsoftware` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.ingsoftwarelenguajeprog: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `ingsoftwarelenguajeprog` DISABLE KEYS */;
INSERT INTO `ingsoftwarelenguajeprog` (`cedula`, `lenguajeprog`) VALUES
	(4760491, 'Java'),
	(4760491, 'JavaScript'),
	(54117430, 'Java'),
	(54117430, 'PHP'),
	(84940812, 'Java'),
	(596518122, 'Java'),
	(641500199, 'Java');
/*!40000 ALTER TABLE `ingsoftwarelenguajeprog` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.ingsoftwaresgbd
CREATE TABLE IF NOT EXISTS `ingsoftwaresgbd` (
  `cedula` int(11) NOT NULL,
  `sgbd` varchar(50) NOT NULL,
  PRIMARY KEY (`cedula`,`sgbd`),
  CONSTRAINT `FK_ingsoftwaresgbd_ingsoftware` FOREIGN KEY (`cedula`) REFERENCES `ingsoftware` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.ingsoftwaresgbd: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `ingsoftwaresgbd` DISABLE KEYS */;
INSERT INTO `ingsoftwaresgbd` (`cedula`, `sgbd`) VALUES
	(4760491, 'MySQL'),
	(54117430, 'MySQL'),
	(54117430, 'PostgreSQL'),
	(84940812, 'MySQL'),
	(84940812, 'PostgreSQL'),
	(596518122, 'MySQL'),
	(641500199, 'MySQL');
/*!40000 ALTER TABLE `ingsoftwaresgbd` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.ingsoftwaresistemaoperativo
CREATE TABLE IF NOT EXISTS `ingsoftwaresistemaoperativo` (
  `cedula` int(11) NOT NULL,
  `sistemaoperativo` varchar(50) NOT NULL,
  PRIMARY KEY (`cedula`,`sistemaoperativo`),
  CONSTRAINT `FK_ingsoftwaresistemaoperativo_ingsoftware` FOREIGN KEY (`cedula`) REFERENCES `ingsoftware` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.ingsoftwaresistemaoperativo: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `ingsoftwaresistemaoperativo` DISABLE KEYS */;
INSERT INTO `ingsoftwaresistemaoperativo` (`cedula`, `sistemaoperativo`) VALUES
	(4760491, 'Mac OS'),
	(54117430, 'Debian'),
	(54117430, 'Windows'),
	(84940812, 'Windows'),
	(596518122, 'Ubuntu'),
	(641500199, 'Windows');
/*!40000 ALTER TABLE `ingsoftwaresistemaoperativo` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.jefe
CREATE TABLE IF NOT EXISTS `jefe` (
  `cedula` int(11) NOT NULL,
  `presupuesto` int(11) NOT NULL,
  PRIMARY KEY (`cedula`),
  CONSTRAINT `FK_jefe_ingsoftware` FOREIGN KEY (`cedula`) REFERENCES `ingsoftware` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.jefe: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `jefe` DISABLE KEYS */;
INSERT INTO `jefe` (`cedula`, `presupuesto`) VALUES
	(54117430, 100000000);
/*!40000 ALTER TABLE `jefe` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.junior
CREATE TABLE IF NOT EXISTS `junior` (
  `cedula` int(11) NOT NULL,
  `horastrabajoxdia` int(2) NOT NULL,
  PRIMARY KEY (`cedula`),
  CONSTRAINT `FK_junior_ingsoftware` FOREIGN KEY (`cedula`) REFERENCES `ingsoftware` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.junior: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `junior` DISABLE KEYS */;
INSERT INTO `junior` (`cedula`, `horastrabajoxdia`) VALUES
	(84940812, 8),
	(596518122, 6);
/*!40000 ALTER TABLE `junior` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.proyecto
CREATE TABLE IF NOT EXISTS `proyecto` (
  `codigo` int(11) NOT NULL,
  `lider` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `areaaplicacion` varchar(50) NOT NULL,
  `fechaingreso` date NOT NULL,
  `fechaasignacion` date NOT NULL,
  `fechaprevistaliberacion` date NOT NULL,
  `versionprograma` varchar(10) NOT NULL,
  `costototal` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_proyecto_senior` (`lider`),
  CONSTRAINT `FK_proyecto_senior` FOREIGN KEY (`lider`) REFERENCES `senior` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.proyecto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` (`codigo`, `lider`, `nombre`, `areaaplicacion`, `fechaingreso`, `fechaasignacion`, `fechaprevistaliberacion`, `versionprograma`, `costototal`) VALUES
	(501, 4760491, 'Facturación', 'Ventas', '2016-02-20', '2016-02-22', '2016-09-10', '1.0', 20000000),
	(750, 641500199, 'SGP (Sistema de Gestión de Personal)', 'Recursos Humanos', '2016-05-01', '2016-05-08', '2016-09-26', '0.0', 32300000);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.proyectolenguajeprog
CREATE TABLE IF NOT EXISTS `proyectolenguajeprog` (
  `codigo` int(11) NOT NULL,
  `lenguajeprog` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`,`lenguajeprog`),
  CONSTRAINT `FK_proyectolenguajeprog_proyecto` FOREIGN KEY (`codigo`) REFERENCES `proyecto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.proyectolenguajeprog: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `proyectolenguajeprog` DISABLE KEYS */;
INSERT INTO `proyectolenguajeprog` (`codigo`, `lenguajeprog`) VALUES
	(501, 'HTML5'),
	(501, 'Java'),
	(501, 'JavaScript'),
	(750, 'HTML5'),
	(750, 'Java'),
	(750, 'JavaScript');
/*!40000 ALTER TABLE `proyectolenguajeprog` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.proyectosgbd
CREATE TABLE IF NOT EXISTS `proyectosgbd` (
  `codigo` int(11) NOT NULL,
  `sgbd` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`,`sgbd`),
  CONSTRAINT `FK_proyectosgbd_proyecto` FOREIGN KEY (`codigo`) REFERENCES `proyecto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.proyectosgbd: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `proyectosgbd` DISABLE KEYS */;
INSERT INTO `proyectosgbd` (`codigo`, `sgbd`) VALUES
	(501, 'MySQL'),
	(750, 'PostgreSQL');
/*!40000 ALTER TABLE `proyectosgbd` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.proyectosistemaoperativo
CREATE TABLE IF NOT EXISTS `proyectosistemaoperativo` (
  `codigo` int(11) NOT NULL,
  `sistemaoperativo` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`,`sistemaoperativo`),
  CONSTRAINT `FK_proyectosistemaoperativo_proyecto` FOREIGN KEY (`codigo`) REFERENCES `proyecto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.proyectosistemaoperativo: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `proyectosistemaoperativo` DISABLE KEYS */;
INSERT INTO `proyectosistemaoperativo` (`codigo`, `sistemaoperativo`) VALUES
	(501, 'Debian'),
	(750, 'MAC OS'),
	(750, 'Windows');
/*!40000 ALTER TABLE `proyectosistemaoperativo` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.requisito
CREATE TABLE IF NOT EXISTS `requisito` (
  `codigo` int(11) NOT NULL,
  `proyecto` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_requisito_proyecto` (`proyecto`),
  CONSTRAINT `FK_requisito_proyecto` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.requisito: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `requisito` DISABLE KEYS */;
INSERT INTO `requisito` (`codigo`, `proyecto`, `descripcion`, `tipo`, `estado`) VALUES
	(2615, 501, 'Cambio de campos.', 'Calidad', 'No implementado'),
	(3127, 750, 'Registrar empleados.', 'Funcional', 'No implementado');
/*!40000 ALTER TABLE `requisito` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.requisitohistorial
CREATE TABLE IF NOT EXISTS `requisitohistorial` (
  `codigo` int(11) NOT NULL,
  `requisito` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_requisitohistorial_requisito` (`requisito`),
  CONSTRAINT `FK_requisitohistorial_requisito` FOREIGN KEY (`requisito`) REFERENCES `requisito` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.requisitohistorial: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `requisitohistorial` DISABLE KEYS */;
INSERT INTO `requisitohistorial` (`codigo`, `requisito`, `descripcion`, `tipo`, `estado`) VALUES
	(1234, 2615, 'Agregar campos.', 'Funcional', 'Implementado'),
	(5678, 3127, 'Acceso a registro.', 'Funcional', 'Implementado');
/*!40000 ALTER TABLE `requisitohistorial` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.seencuentraen
CREATE TABLE IF NOT EXISTS `seencuentraen` (
  `proyecto` int(11) NOT NULL,
  `fase` int(11) NOT NULL,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL,
  PRIMARY KEY (`proyecto`,`fase`),
  KEY `FK_seencuentraen_fase` (`fase`),
  CONSTRAINT `FK_seencuentraen_fase` FOREIGN KEY (`fase`) REFERENCES `fase` (`codigo`),
  CONSTRAINT `FK_seencuentraen_proyecto` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.seencuentraen: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `seencuentraen` DISABLE KEYS */;
INSERT INTO `seencuentraen` (`proyecto`, `fase`, `fechainicio`, `fechafin`) VALUES
	(501, 1003, '2016-04-30', '2016-07-13'),
	(750, 1001, '2016-05-01', '2016-06-15');
/*!40000 ALTER TABLE `seencuentraen` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.seminario
CREATE TABLE IF NOT EXISTS `seminario` (
  `numero` int(11) NOT NULL,
  `ingeniero` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `lugar` varchar(50) NOT NULL,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `FK_seminario_ingsoftware` (`ingeniero`),
  CONSTRAINT `FK_seminario_ingsoftware` FOREIGN KEY (`ingeniero`) REFERENCES `ingsoftware` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.seminario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `seminario` DISABLE KEYS */;
INSERT INTO `seminario` (`numero`, `ingeniero`, `nombre`, `lugar`, `fechainicio`, `fechafin`) VALUES
	(4312, 54117430, 'Liderazgo en proyectos.', 'Me da igual', '2016-05-01', '2016-05-08'),
	(41234, 84940812, 'Buenas prácticas de software.', 'Cualquier parte', '2016-05-01', '2016-05-08'),
	(7651801, 4760491, 'Agilismo', 'Ola k ase', '2016-05-01', '2016-05-08');
/*!40000 ALTER TABLE `seminario` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.senior
CREATE TABLE IF NOT EXISTS `senior` (
  `cedula` int(11) NOT NULL,
  `proyectosquelidera` int(2) NOT NULL,
  PRIMARY KEY (`cedula`),
  CONSTRAINT `FK_senior_ingsoftware` FOREIGN KEY (`cedula`) REFERENCES `ingsoftware` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.senior: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `senior` DISABLE KEYS */;
INSERT INTO `senior` (`cedula`, `proyectosquelidera`) VALUES
	(4760491, 0),
	(641500199, 0);
/*!40000 ALTER TABLE `senior` ENABLE KEYS */;


-- Volcando estructura para tabla bdproyectojavaweb.solicitud
CREATE TABLE IF NOT EXISTS `solicitud` (
  `numero` int(11) NOT NULL,
  `requisito` int(11) NOT NULL,
  `verificador` int(11) NOT NULL,
  `solicitante` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `origen` varchar(100) NOT NULL,
  `estado` varchar(10) NOT NULL,
  `prioridadsolicitante` int(11) NOT NULL,
  `prioridadrealizacion` int(11) NOT NULL,
  `fechaultimaactualizacion` date NOT NULL,
  `release` varchar(50) NOT NULL,
  `esfuerzo` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `comentarios` varchar(200) NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `FK_solicitud_requisito` (`requisito`),
  KEY `FK_solicitud_jefe` (`verificador`),
  KEY `FK_solicitud_ingsoftware` (`solicitante`),
  CONSTRAINT `FK_solicitud_ingsoftware` FOREIGN KEY (`solicitante`) REFERENCES `ingsoftware` (`cedula`),
  CONSTRAINT `FK_solicitud_jefe` FOREIGN KEY (`verificador`) REFERENCES `jefe` (`cedula`),
  CONSTRAINT `FK_solicitud_requisito` FOREIGN KEY (`requisito`) REFERENCES `requisito` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdproyectojavaweb.solicitud: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` (`numero`, `requisito`, `verificador`, `solicitante`, `tipo`, `titulo`, `fecha`, `origen`, `estado`, `prioridadsolicitante`, `prioridadrealizacion`, `fechaultimaactualizacion`, `release`, `esfuerzo`, `descripcion`, `comentarios`) VALUES
	(4012, 2615, 54117430, 84940812, 'Cambio', 'Corrección del requisito', '2016-05-01', '', 'Evaluado', 1, 2, '2016-04-24', '1.0', 1, 'Posible mala redacción del requisito.', ''),
	(5312, 2615, 54117430, 596518122, 'Eliminación', 'Eliminación del requisito', '2016-05-01', '', 'Verificado', 1, 1, '2016-05-01', '1.0', 2, 'Innecesario requisito.', 'ola k ase'),
	(6123, 3127, 54117430, 84940812, 'Ampliación', 'Ampliación del requisito', '2016-05-01', '', 'Aprobado', 1, 1, '2016-04-24', '1.0', 3, 'Validación de campos.', '');
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
