-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 22-06-2018 a las 06:57:05
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basededatos_ferreteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomCliente` varchar(25) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `apeCliente` varchar(25) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `dniCliente` int(11) NOT NULL,
  `telCliente` int(11) DEFAULT NULL,
  `rucCliente` int(11) DEFAULT NULL,
  `dirCliente` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `emailCliente` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nomCliente`, `apeCliente`, `dniCliente`, `telCliente`, `rucCliente`, `dirCliente`, `emailCliente`) VALUES
('L', 'carlos', 'carlos', 124234, 123445, 1231243, 'las flores', 'gordohotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobantes`
--

CREATE TABLE `comprobantes` (
  `idComprobante` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fechaComprobante` text COLLATE utf8mb4_spanish_ci,
  `tipoComprobante` text COLLATE utf8mb4_spanish_ci,
  `numComprobante` int(11) DEFAULT NULL,
  `idCliente` char(6) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `comprobantes`
--

INSERT INTO `comprobantes` (`idComprobante`, `fechaComprobante`, `tipoComprobante`, `numComprobante`, `idCliente`) VALUES
('C', 'jueves 21 de junio de 2018', 'factura', 0, 'L');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecomprobantes`
--

CREATE TABLE `detallecomprobantes` (
  `idComprobante` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `idNotaPedido` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `montoTotal` double DEFAULT NULL,
  `montoIgv` double DEFAULT NULL,
  `montoNeto` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `detallecomprobantes`
--

INSERT INTO `detallecomprobantes` (`idComprobante`, `idNotaPedido`, `montoTotal`, `montoIgv`, `montoNeto`) VALUES
('C', '', 1600, 304, 1904);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallenotadepedidos`
--

CREATE TABLE `detallenotadepedidos` (
  `idProducto` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `idNotaPedido` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `unidadesNotaPedido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `idEmpleado` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomEmpleado` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `apeEmpleado` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `dniEmpleado` int(11) NOT NULL,
  `dirEmpleado` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `emailEmpleado` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT 'NO TIENE',
  `userEmpleado` char(10) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `claveEmpleado` char(10) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `cargoEmpleado` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`idEmpleado`, `nomEmpleado`, `apeEmpleado`, `dniEmpleado`, `dirEmpleado`, `emailEmpleado`, `userEmpleado`, `claveEmpleado`, `cargoEmpleado`) VALUES
('12', 'san', 'ca', 1235, 'l', 'NO TIENE', 'san', 'ca', 'empleado'),
('123', 'diego', 'santiago', 12232, 'las flores', 'gato@hotmail.com', 'diego', '1234', 'jefe'),
('12345', 'santiago', 'carlos', 123454, 'las flores', 'c@hotmail.com', 'carlitos', 'carlitos', 'gato'),
('E12346', 'Cesar', 'Matias', 12344, 'el valle', 'cesar234@hotmail.com', 'Cesar', '12344', 'empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guardarnotapedido`
--

CREATE TABLE `guardarnotapedido` (
  `cantidadProdu` double DEFAULT NULL,
  `descripProduc` varchar(25) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `precioProduc` double DEFAULT NULL,
  `valorProducto` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notadepedidos`
--

CREATE TABLE `notadepedidos` (
  `idNotaPedido` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `idEmpleado` char(6) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` char(6) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomProducto` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `stockProducto` int(11) DEFAULT NULL,
  `desProducto` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `precioUnitarioProducto` double DEFAULT NULL,
  `ubicacionProducto` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `tipoProducto` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nomProducto`, `stockProducto`, `desProducto`, `precioUnitarioProducto`, `ubicacionProducto`, `tipoProducto`) VALUES
('01', 'pico', 100, 'instrumento para excavar', 50, 'almacen', 'pico'),
('12', 'pala', 5, '', 100, 'bodega', 'pala'),
('14', 'llaves', 100, 'buenas llaves', 39, 'tienda', 'llaves'),
('25', 'cemento', 10, 'sirve para mezclar', 80.5, 'stock', 'mezcla');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `comprobantes`
--
ALTER TABLE `comprobantes`
  ADD PRIMARY KEY (`idComprobante`);

--
-- Indices de la tabla `detallecomprobantes`
--
ALTER TABLE `detallecomprobantes`
  ADD PRIMARY KEY (`idComprobante`) USING BTREE;

--
-- Indices de la tabla `detallenotadepedidos`
--
ALTER TABLE `detallenotadepedidos`
  ADD PRIMARY KEY (`idProducto`,`idNotaPedido`),
  ADD KEY `fk_PRODUCTOS_has_NOTADEPEDIDOS_NOTADEPEDIDOS1_idx` (`idNotaPedido`),
  ADD KEY `fk_PRODUCTOS_has_NOTADEPEDIDOS_PRODUCTOS1_idx` (`idProducto`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- Indices de la tabla `notadepedidos`
--
ALTER TABLE `notadepedidos`
  ADD PRIMARY KEY (`idNotaPedido`),
  ADD KEY `fk_NOTADEPEDIDOS_EMPLEADOS1_idx` (`idEmpleado`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallenotadepedidos`
--
ALTER TABLE `detallenotadepedidos`
  ADD CONSTRAINT `fk_PRODUCTOS_has_NOTADEPEDIDOS_NOTADEPEDIDOS1` FOREIGN KEY (`idNotaPedido`) REFERENCES `notadepedidos` (`idNotaPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_PRODUCTOS_has_NOTADEPEDIDOS_PRODUCTOS1` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `notadepedidos`
--
ALTER TABLE `notadepedidos`
  ADD CONSTRAINT `fk_NOTADEPEDIDOS_EMPLEADOS1` FOREIGN KEY (`idEmpleado`) REFERENCES `empleados` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
