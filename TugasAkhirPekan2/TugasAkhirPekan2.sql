-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Jun 2020 pada 18.05
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_hr`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retrieve_departement` (IN `depart_id` CHAR(50))  BEGIN
	SELECT * FROM departements WHERE departements.departement_id = depart_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_retrieve_region` (IN `reg_id` CHAR(50))  BEGIN
	SELECT * FROM regions WHERE region_id = reg_id;
END$$

--
-- Fungsi
--
CREATE DEFINER=`root`@`localhost` FUNCTION `fc_get_total_departements` (`keyword` VARCHAR(50)) RETURNS INT(11) BEGIN
	DECLARE hasil INT;
	SELECT COUNT(*) INTO hasil FROM departements
	WHERE departement_name LIKE CONCAT ('%',keyword,'%');
	
	RETURN hasil;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `fc_get_total_employee` (`keyword` INT) RETURNS INT(11) BEGIN
	DECLARE hasil int;
	SELECT COUNT(*) INTO hasil FROM employees 
	WHERE employees.employee_id LIKE CONCAT ('%',keyword,'%');
	RETURN hasil;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `fc_get_total_region` (`keyword` CHAR(50)) RETURNS INT(11) BEGIN
	DECLARE hasil INT;
	SELECT COUNT(*) INTO hasil FROM regions
	WHERE region_name LIKE CONCAT ('%',keyword,'%');
	
	RETURN hasil;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `accounts`
--

CREATE TABLE `accounts` (
  `id` varchar(4) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`) VALUES
('E011', 'yoseffebrianes', 'yoseffebrianes'),
('E012', 'martinsamuel', 'martinsamuel');

-- --------------------------------------------------------

--
-- Struktur dari tabel `countries`
--

CREATE TABLE `countries` (
  `id` varchar(4) NOT NULL,
  `name` varchar(20) NOT NULL,
  `region` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `countries`
--

INSERT INTO `countries` (`id`, `name`, `region`) VALUES
('C001', 'Indonesia', 'R001'),
('C002', 'England', 'R003'),
('C003', 'Japan', 'R001'),
('C004', 'United States', 'R005'),
('C005', 'Korea', 'R001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `departements`
--

CREATE TABLE `departements` (
  `id` varchar(4) NOT NULL,
  `name` varchar(20) NOT NULL,
  `manager` varchar(4) NOT NULL,
  `location` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `departements`
--

INSERT INTO `departements` (`id`, `name`, `manager`, `location`) VALUES
('D001', 'ADD 1', 'E004', 'L002'),
('D002', 'ADD 2', 'E011', 'L002'),
('D003', 'ADD', 'E003', 'L002'),
('D004', 'Marcom', 'E040', 'L002'),
('D005', 'Human Resource', 'E021', 'L002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `employees`
--

CREATE TABLE `employees` (
  `id` varchar(4) NOT NULL,
  `first_name` varchar(10) NOT NULL,
  `last_name` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `hire_date` date NOT NULL,
  `job` varchar(4) NOT NULL,
  `salary` int(10) NOT NULL,
  `commision_pct` float NOT NULL,
  `manager` varchar(4) NOT NULL,
  `departement` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `employees`
--

INSERT INTO `employees` (`id`, `first_name`, `last_name`, `email`, `phone_number`, `hire_date`, `job`, `salary`, `commision_pct`, `manager`, `departement`) VALUES
('E001', 'Sjafril', 'Effendi', 'Sjafrilsum@gmail.com', '81002568121', '1999-12-25', 'J001', 200000000, 0, 'E001', 'D001'),
('E002', 'Herry', 'Anty', 'herryanti@gmail.com', '81002568122', '1999-12-25', 'J002', 40000000, 0, 'E001', 'D001'),
('E003', 'Marlina', 'Manohara', 'marlinaman@gmail.com', '81002568123', '1999-12-25', 'J003', 20000000, 0.3, 'E002', 'D003'),
('E004', 'Adi', 'Subagiyo', 'adisubagiyo@gmail.co', '81002568124', '1999-12-25', 'J004', 15000000, 0, 'E003', 'D001'),
('E005', 'Dave', 'Erliando', 'daverliando@gmail.co', '81002568125', '1999-12-25', 'J005', 8000000, 0, 'E004', 'D001'),
('E006', 'Joko', 'Sentosa', 'jokosentosa@gmail.co', '81002568126', '1999-12-25', 'J005', 8000000, 0, 'E004', 'D001'),
('E007', 'Aji', 'Pangestu', 'ajipangestu@gmail.co', '81002568127', '1999-12-25', 'J005', 8000000, 0, 'E004', 'D001'),
('E008', 'Agustinus', 'Renaldy', 'agustinusre@gmail.co', '81002568128', '2000-01-02', 'J005', 8000000, 0, 'E011', 'D002'),
('E009', 'Andri', 'Sugiono', 'andris@gmail.com', '81002568129', '2000-01-02', 'J005', 8000000, 0, 'E011', 'D002'),
('E010', 'Marshall', 'Christiant', 'marschris@gmail.com', '81002568130', '1999-12-25', 'J004', 15000000, 0, 'E016', 'D004'),
('E011', 'Yosef', 'Febrianes', 'yfebrianes@gmail.com', '81002568131', '1999-12-25', 'J004', 15000000, 0, 'E003', 'D002'),
('E012', 'Martin', 'Samuel', 'marsam@gmail.com', '81002568132', '2000-01-02', 'J003', 8000000, 0.2, 'E011', 'D002'),
('E013', 'Charolline', 'Mayliana', 'cmc@gmail.com', '81002568133', '2000-01-02', 'J005', 8000000, 0, 'E011', 'D002'),
('E014', 'Billy', 'Christian', 'billgong@gmail.com', '81002568134', '2000-01-02', 'J005', 8000000, 0, 'E010', 'D004'),
('E015', 'Nikyta', 'Philipus', 'nikytaa@gmail.com', '81002568135', '2000-01-02', 'J005', 8000000, 0, 'E010', 'D004'),
('E016', 'Vina', 'Panduwinat', 'vinpan@gmail.com', '81002568136', '1999-12-25', 'J003', 200000000, 0.1, 'D003', 'D003'),
('E017', 'Cindy', 'Grace', 'cge@gmail.com', '81002568137', '1999-12-28', 'J005', 8000000, 0, 'E010', 'D004'),
('E018', 'Sylvia', 'Emanuela', 'sylviaem@gmail.com', '81002568138', '1999-12-27', 'J005', 8000000, 0, 'E010', 'D004'),
('E019', 'Elisabeth', 'Cornelia', 'ecm@gmail.com', '81002568139', '1999-12-27', 'J005', 8000000, 0, 'E010', 'D004'),
('E020', 'Melody', 'Effendy', 'mellody@gmail.com', '81002568140', '1999-12-27', 'J005', 8000000, 0, 'E010', 'D004');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jobs`
--

CREATE TABLE `jobs` (
  `id` varchar(4) NOT NULL,
  `title` varchar(10) NOT NULL,
  `min_salary` int(10) NOT NULL,
  `max_salary` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jobs`
--

INSERT INTO `jobs` (`id`, `title`, `min_salary`, `max_salary`) VALUES
('J001', 'applicatio', 10000, 15000),
('J002', 'Talent acq', 9000, 14000),
('J003', 'sales', 4000, 12000),
('J004', 'Trhnical C', 10000, 15000),
('J005', 'IT Trainer', 8000, 14000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `job_historys`
--

CREATE TABLE `job_historys` (
  `employee` varchar(4) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `job` varchar(4) NOT NULL,
  `departement` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `job_historys`
--

INSERT INTO `job_historys` (`employee`, `start_date`, `end_date`, `job`, `departement`) VALUES
('E001', '0000-00-00', '0000-00-00', 'J001', ''),
('E002', '0000-00-00', '0000-00-00', 'J002', ''),
('E003', '0000-00-00', '0000-00-00', 'J003', 'D003'),
('E004', '0000-00-00', '0000-00-00', 'J004', 'D001'),
('E005', '0000-00-00', '0000-00-00', 'J005', 'D001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `locations`
--

CREATE TABLE `locations` (
  `id` varchar(4) NOT NULL,
  `street_address` varchar(20) NOT NULL,
  `postal_code` varchar(5) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state_province` varchar(20) NOT NULL,
  `country` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `locations`
--

INSERT INTO `locations` (`id`, `street_address`, `postal_code`, `city`, `state_province`, `country`) VALUES
('L001', 'Ciremai Raya no 16 (', '57882', 'Osaka', 'Osaka', 'C003'),
('L002', 'Yos Sudarso no 8', '89434', 'Jakarta', 'Jakarta', 'C001'),
('L003', 'Cipto no 4', '72019', 'Busan', 'Busan', 'C005'),
('L004', 'Kasepuhan no 2', '45017', 'London', 'West England', 'C002'),
('L005', 'Kembar no 1', '39328', 'Canbera', 'South Australia', 'C004');

-- --------------------------------------------------------

--
-- Struktur dari tabel `regions`
--

CREATE TABLE `regions` (
  `id` varchar(4) NOT NULL,
  `name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `regions`
--

INSERT INTO `regions` (`id`, `name`) VALUES
('01', 'Asia'),
('R002', 'Africa'),
('R003', 'Europe'),
('R004', 'Australia'),
('R005', 'America');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`),
  ADD KEY `region_id` (`region`);

--
-- Indeks untuk tabel `departements`
--
ALTER TABLE `departements`
  ADD PRIMARY KEY (`id`),
  ADD KEY `manager_id` (`manager`),
  ADD KEY `location_id` (`location`);

--
-- Indeks untuk tabel `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD KEY `job_id` (`job`),
  ADD KEY `manager_id` (`manager`),
  ADD KEY `departement_id` (`departement`),
  ADD KEY `employee_id` (`id`);

--
-- Indeks untuk tabel `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `job_historys`
--
ALTER TABLE `job_historys`
  ADD PRIMARY KEY (`employee`),
  ADD KEY `job_id` (`job`),
  ADD KEY `departement_id` (`departement`);

--
-- Indeks untuk tabel `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `country_id` (`country`);

--
-- Indeks untuk tabel `regions`
--
ALTER TABLE `regions`
  ADD PRIMARY KEY (`id`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `accounts`
--
ALTER TABLE `accounts`
  ADD CONSTRAINT `test` FOREIGN KEY (`id`) REFERENCES `employees` (`id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `countries`
--
ALTER TABLE `countries`
  ADD CONSTRAINT `countries_ibfk_1` FOREIGN KEY (`region`) REFERENCES `regions` (`id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `departements`
--
ALTER TABLE `departements`
  ADD CONSTRAINT `departements_ibfk_1` FOREIGN KEY (`location`) REFERENCES `locations` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `departements_ibfk_2` FOREIGN KEY (`manager`) REFERENCES `employees` (`id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`job`) REFERENCES `jobs` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`departement`) REFERENCES `departements` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `employees_ibfk_3` FOREIGN KEY (`manager`) REFERENCES `employees` (`id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `job_historys`
--
ALTER TABLE `job_historys`
  ADD CONSTRAINT `job_historys_ibfk_1` FOREIGN KEY (`job`) REFERENCES `jobs` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `job_historys_ibfk_2` FOREIGN KEY (`employee`) REFERENCES `employees` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `job_historys_ibfk_3` FOREIGN KEY (`departement`) REFERENCES `departements` (`id`);

--
-- Ketidakleluasaan untuk tabel `locations`
--
ALTER TABLE `locations`
  ADD CONSTRAINT `locations_ibfk_1` FOREIGN KEY (`country`) REFERENCES `countries` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
