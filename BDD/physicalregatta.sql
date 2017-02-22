-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 22, 2017 at 01:41 PM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.16-2+deb.sury.org~xenial+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `physicalregatta`
--

-- --------------------------------------------------------

--
-- Table structure for table `auditor`
--

CREATE TABLE `auditor` (
  `id` int(11) NOT NULL,
  `committee_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auditor`
--

INSERT INTO `auditor` (`id`, `committee_id`, `person_id`) VALUES
(1, 1, 14);

-- --------------------------------------------------------

--
-- Table structure for table `challenge`
--

CREATE TABLE `challenge` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `begin` datetime NOT NULL,
  `end` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `challenge`
--

INSERT INTO `challenge` (`id`, `name`, `begin`, `end`) VALUES
(1, 'Challenge d\'hiver', '2016-11-01 00:00:00', '2017-03-31 23:59:59'),
(2, 'Challenge d\'été', '2017-05-01 00:00:00', '2017-09-30 23:59:59');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `coef` float NOT NULL,
  `serie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`id`, `name`, `coef`, `serie_id`) VALUES
(1, 'Corsaire', 1, 1),
(2, 'Surprise', 1, 1),
(3, '8 mètres', 1, 1),
(4, 'Maraudeur', 1, 1),
(5, 'Figaro', 1, 1),
(6, 'Flying Fifteen', 1, 2),
(7, 'Soling', 1, 2),
(8, 'Star', 1, 2),
(9, 'Tempest', 1, 2),
(10, 'Yngling', 1, 2),
(11, '5.5', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `club`
--

CREATE TABLE `club` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `club`
--

INSERT INTO `club` (`id`, `name`) VALUES
(1, 'YC Val André'),
(2, 'YC Le Legué'),
(3, 'YC Saint Quay'),
(4, 'YC Binic');

-- --------------------------------------------------------

--
-- Table structure for table `committee`
--

CREATE TABLE `committee` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `committee`
--

INSERT INTO `committee` (`id`, `name`) VALUES
(1, 'Bretagne'),
(2, 'Normandie'),
(3, 'Ile de France'),
(4, 'Pays de la Loire');

-- --------------------------------------------------------

--
-- Table structure for table `crew`
--

CREATE TABLE `crew` (
  `entrant_id` int(11) NOT NULL,
  `sailboat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `entrant`
--

CREATE TABLE `entrant` (
  `id` int(11) NOT NULL,
  `ffv` tinyint(1) NOT NULL,
  `year_permit` int(4) NOT NULL,
  `birth` datetime NOT NULL,
  `person_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `entrant`
--

INSERT INTO `entrant` (`id`, `ffv`, `year_permit`, `birth`, `person_id`) VALUES
(1, 1, 2017, '1980-04-01 00:00:00', 1),
(2, 1, 2017, '1980-04-01 00:00:00', 2),
(3, 1, 2017, '1980-04-01 00:00:00', 3),
(4, 1, 2017, '1980-04-01 00:00:00', 4),
(5, 1, 2017, '1980-04-01 00:00:00', 5),
(6, 1, 2017, '1980-04-01 00:00:00', 6),
(7, 1, 2017, '1980-04-01 00:00:00', 7),
(8, 1, 2017, '1980-04-01 00:00:00', 8),
(9, 1, 2017, '1980-04-01 00:00:00', 9),
(10, 1, 2017, '1980-04-01 00:00:00', 10),
(11, 1, 2017, '1980-04-01 00:00:00', 11),
(12, 1, 2017, '1980-04-01 00:00:00', 12),
(13, 1, 2017, '1980-04-01 00:00:00', 13);

-- --------------------------------------------------------

--
-- Table structure for table `jury`
--

CREATE TABLE `jury` (
  `id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `club_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`id`, `person_id`, `club_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 4),
(5, 5, 3),
(6, 6, 2),
(7, 7, 3),
(8, 8, 2),
(9, 9, 2),
(10, 10, 1),
(11, 11, 2),
(12, 12, 4),
(13, 13, 3);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `firstname` varchar(150) NOT NULL,
  `lastname` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `firstname`, `lastname`, `email`, `password`) VALUES
(1, 'Marcel', 'Martin', 'marcel@martin.fr', 'abc'),
(2, 'Pierre', 'Letroc', 'pierre@letroc.fr', 'abc'),
(3, 'Roger', 'Le Jay', 'Roger@LeJay.fr', 'abc'),
(4, 'Hubert', 'de La Montagne', 'huber@deLaMontagne.fr', 'abc'),
(5, 'Etienne', 'LE Baux', 'Etienne@lebaux.fr', 'abc'),
(6, 'Emilie', 'du Port', 'Emilie@duPort.fr', 'abc'),
(7, 'Corentin', 'Quintin', 'Corentin@Quintin.fr', 'abc'),
(8, 'Clarisse', 'Le Fort', 'Clarisse@LeFort.fr', 'abc'),
(9, 'Hélène', 'De Carquefou', 'Hélène@DeCarquefou.fr', 'abc'),
(10, 'Camille', 'Gicquel', 'Camille@Gicquel.fr', 'abc'),
(11, 'René', 'La Poste', 'Rene@LaPoste.fr', 'abc'),
(12, 'Rémy', 'Bellamy', 'Remy@Bellamy.fr', 'abc'),
(13, 'Hector', 'Le Bel', 'Hector@LeBel.fr', 'abc'),
(14, 'Marcel', 'le Hegarat', 'Marcel@leHegarat.fr', 'abc');

-- --------------------------------------------------------

--
-- Table structure for table `regatta`
--

CREATE TABLE `regatta` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `date` datetime NOT NULL,
  `challenge_id` int(11) NOT NULL,
  `jury_id` int(11) DEFAULT NULL,
  `auditor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `regatta`
--

INSERT INTO `regatta` (`id`, `name`, `date`, `challenge_id`, `jury_id`, `auditor_id`) VALUES
(3, 'Les régates de la baie de Saint Brieuc', '2017-02-15 09:00:00', 1, NULL, NULL),
(6, 'Les 3 jours d’Armor', '2017-02-01 09:00:00', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(11) NOT NULL,
  `regatta_id` int(11) NOT NULL,
  `sailboat_id` int(11) NOT NULL,
  `report_id` int(11) DEFAULT NULL,
  `skipper` int(11) NOT NULL,
  `point` int(11) NOT NULL DEFAULT '0',
  `valid` tinyint(1) DEFAULT NULL,
  `realtime` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `regatta_id`, `sailboat_id`, `report_id`, `skipper`, `point`, `valid`, `realtime`) VALUES
(2, 3, 1, NULL, 1, 3, 1, 0),
(3, 3, 2, NULL, 2, 2, 1, 0),
(4, 3, 3, NULL, 3, 4, 1, 0),
(5, 3, 4, NULL, 4, 1, 1, 0),
(6, 3, 5, NULL, 5, 10, 1, 0),
(7, 3, 6, NULL, 6, 5, 1, 0),
(8, 3, 7, NULL, 7, 10, 1, 0),
(9, 3, 8, NULL, 8, 10, 1, 0),
(10, 3, 9, NULL, 9, 2, 1, 0),
(11, 3, 10, NULL, 10, 1, 1, 0),
(12, 3, 11, NULL, 11, 4, 1, 0),
(13, 3, 12, NULL, 12, 3, 1, 0),
(14, 3, 13, NULL, 13, 5, 1, 0),
(41, 6, 1, NULL, 1, 2, 1, 0),
(42, 6, 2, NULL, 2, 1, 1, 0),
(43, 6, 3, NULL, 3, 3, 1, 0),
(44, 6, 4, NULL, 4, 8, 1, 0),
(45, 6, 5, NULL, 5, 4, 1, 0),
(46, 6, 6, NULL, 6, 6, 1, 0),
(47, 6, 7, NULL, 7, 5, 1, 0),
(48, 6, 8, NULL, 8, 7, 1, 0),
(49, 6, 9, NULL, 9, 1, 1, 0),
(50, 6, 10, NULL, 10, 2, 1, 0),
(51, 6, 11, NULL, 11, 3, 1, 0),
(52, 6, 12, NULL, 12, 5, 1, 0),
(53, 6, 13, NULL, 13, 4, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `id` int(11) NOT NULL,
  `code` varchar(4) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`id`, `code`, `name`) VALUES
(1, 'DNC', 'N’a pas pris le départ (n’est pas venu sur la zone de course)'),
(2, 'DNS', 'N’a pas pris le départ dans les temps'),
(3, 'OCS', 'Départ prématuré sous pavillon P ou I'),
(4, 'ZFP', 'Départ prématuré, pénalité de 20\r\n% (départ sous pavillon Z)'),
(5, 'BFD', 'Départ prématuré sous pavillon noir = disqualifié'),
(6, 'DNF', 'N’a pas fini'),
(7, 'RAF', 'A abandonné après avoir fini (pour les gens fair-play)'),
(8, 'DSQ', 'Disqualification'),
(9, 'DNE', 'Disqualification qui ne peut être retirée (faute grave genre tricherie)'),
(10, 'DGM', 'Disqualification qui ne peut être retirée (faute grave genre tricherie)');

-- --------------------------------------------------------

--
-- Table structure for table `sailboat`
--

CREATE TABLE `sailboat` (
  `id` int(11) NOT NULL,
  `num_sail` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sailboat`
--

INSERT INTO `sailboat` (`id`, `num_sail`, `owner_id`, `class_id`) VALUES
(1, 7, 1, 4),
(2, 22, 2, 4),
(3, 1478, 3, 4),
(4, 199, 4, 4),
(5, 12, 5, 4),
(6, 13, 6, 4),
(7, 1, 7, 4),
(8, 25, 8, 4),
(9, 14, 9, 1),
(10, 2, 10, 1),
(11, 10, 11, 1),
(12, 23, 12, 1),
(13, 24, 13, 1);

-- --------------------------------------------------------

--
-- Table structure for table `secretary`
--

CREATE TABLE `secretary` (
  `id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `serie`
--

CREATE TABLE `serie` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serie`
--

INSERT INTO `serie` (`id`, `name`) VALUES
(1, 'Habitables'),
(2, 'Quillards de sport');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auditor`
--
ALTER TABLE `auditor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `person_id` (`person_id`),
  ADD KEY `committee_id` (`committee_id`,`person_id`);

--
-- Indexes for table `challenge`
--
ALTER TABLE `challenge`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id`),
  ADD KEY `serie_id` (`serie_id`);

--
-- Indexes for table `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `committee`
--
ALTER TABLE `committee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `crew`
--
ALTER TABLE `crew`
  ADD PRIMARY KEY (`entrant_id`,`sailboat_id`),
  ADD KEY `crew_sailboat` (`sailboat_id`);

--
-- Indexes for table `entrant`
--
ALTER TABLE `entrant`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `person_id` (`person_id`),
  ADD KEY `sailboat_id` (`person_id`);

--
-- Indexes for table `jury`
--
ALTER TABLE `jury`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `person_id_2` (`person_id`),
  ADD KEY `person_id` (`person_id`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `person_id_2` (`person_id`),
  ADD KEY `person_id` (`person_id`,`club_id`),
  ADD KEY `owner_club` (`club_id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `regatta`
--
ALTER TABLE `regatta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `challenge_id` (`challenge_id`),
  ADD KEY `jury_id` (`jury_id`,`auditor_id`),
  ADD KEY `regatta_auditor` (`auditor_id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `regatta_id_2` (`regatta_id`,`sailboat_id`),
  ADD KEY `regatta_id` (`regatta_id`,`sailboat_id`,`skipper`),
  ADD KEY `register_entrant` (`skipper`),
  ADD KEY `register_sailboat` (`sailboat_id`),
  ADD KEY `report_id` (`report_id`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sailboat`
--
ALTER TABLE `sailboat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `owner_id` (`owner_id`,`class_id`),
  ADD KEY `sailboat_class` (`class_id`);

--
-- Indexes for table `secretary`
--
ALTER TABLE `secretary`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `person_id` (`person_id`),
  ADD KEY `person_id_2` (`person_id`);

--
-- Indexes for table `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `auditor`
--
ALTER TABLE `auditor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `challenge`
--
ALTER TABLE `challenge`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `club`
--
ALTER TABLE `club`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `committee`
--
ALTER TABLE `committee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `entrant`
--
ALTER TABLE `entrant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `jury`
--
ALTER TABLE `jury`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `regatta`
--
ALTER TABLE `regatta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `sailboat`
--
ALTER TABLE `sailboat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `secretary`
--
ALTER TABLE `secretary`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `serie`
--
ALTER TABLE `serie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `auditor`
--
ALTER TABLE `auditor`
  ADD CONSTRAINT `auditor_committee` FOREIGN KEY (`committee_id`) REFERENCES `committee` (`id`),
  ADD CONSTRAINT `auditor_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_serie` FOREIGN KEY (`serie_id`) REFERENCES `serie` (`id`);

--
-- Constraints for table `crew`
--
ALTER TABLE `crew`
  ADD CONSTRAINT `crew_entrant` FOREIGN KEY (`entrant_id`) REFERENCES `entrant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `crew_sailboat` FOREIGN KEY (`sailboat_id`) REFERENCES `sailboat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `entrant`
--
ALTER TABLE `entrant`
  ADD CONSTRAINT `entrant_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `jury`
--
ALTER TABLE `jury`
  ADD CONSTRAINT `jury_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `owner`
--
ALTER TABLE `owner`
  ADD CONSTRAINT `owner_club` FOREIGN KEY (`club_id`) REFERENCES `club` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `owner_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `regatta`
--
ALTER TABLE `regatta`
  ADD CONSTRAINT `regatta_auditor` FOREIGN KEY (`auditor_id`) REFERENCES `auditor` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `regatta_challenge` FOREIGN KEY (`challenge_id`) REFERENCES `challenge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `regatta_jury` FOREIGN KEY (`jury_id`) REFERENCES `jury` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `register`
--
ALTER TABLE `register`
  ADD CONSTRAINT `register_entrant` FOREIGN KEY (`skipper`) REFERENCES `entrant` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `register_regatta` FOREIGN KEY (`regatta_id`) REFERENCES `regatta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `register_report` FOREIGN KEY (`report_id`) REFERENCES `report` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `register_sailboat` FOREIGN KEY (`sailboat_id`) REFERENCES `sailboat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sailboat`
--
ALTER TABLE `sailboat`
  ADD CONSTRAINT `sailboat_class` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `sailboat_owner` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `secretary`
--
ALTER TABLE `secretary`
  ADD CONSTRAINT `secretary_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
