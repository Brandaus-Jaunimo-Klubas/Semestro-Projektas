-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2016 at 01:48 PM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `registras`
--

-- --------------------------------------------------------

--
-- Table structure for table `apziura`
--

DROP TABLE IF EXISTS `apziura`;
CREATE TABLE IF NOT EXISTS `apziura` (
  `pavadinimas` varchar(255) NOT NULL,
  `pav_kita` varchar(255) DEFAULT NULL,
  `rezultatai` varchar(255) DEFAULT NULL,
  `pazeidimo_puse` varchar(255) DEFAULT NULL,
  `pazeidimo_lokalizacija` varchar(255) DEFAULT NULL,
  `pazeidimas_apima` varchar(255) DEFAULT NULL,
  `balso_klosciu_judrumas` tinyint(1) DEFAULT NULL,
  `keratoze` tinyint(1) DEFAULT NULL,
  `randas` tinyint(1) DEFAULT NULL,
  `egzofitiniai_pozymiai_yra` tinyint(1) DEFAULT NULL,
  `egzo_pozymiai_kokie` varchar(255) DEFAULT NULL,
  `stenoze_yra` tinyint(1) DEFAULT NULL,
  `stenoze_laipsnis` varchar(255) DEFAULT NULL,
  `kita` varchar(255) DEFAULT NULL,
  `duomenys_atitinka_kt` tinyint(1) DEFAULT NULL,
  `jei_neatitinka_duom_kt` varchar(255) DEFAULT NULL,
  `kaklo_limf_kt` tinyint(1) DEFAULT NULL,
  `jei_limf_stebimi` varchar(255) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `asmens_kodas` varchar(255) NOT NULL,
  KEY `pavadinimas` (`pavadinimas`),
  KEY `vezio_nr` (`asmens_kodas`),
  KEY `pazeidimo_puse` (`pazeidimo_puse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `apziura`
--

INSERT INTO `apziura` (`pavadinimas`, `pav_kita`, `rezultatai`, `pazeidimo_puse`, `pazeidimo_lokalizacija`, `pazeidimas_apima`, `balso_klosciu_judrumas`, `keratoze`, `randas`, `egzofitiniai_pozymiai_yra`, `egzo_pozymiai_kokie`, `stenoze_yra`, `stenoze_laipsnis`, `kita`, `duomenys_atitinka_kt`, `jei_neatitinka_duom_kt`, `kaklo_limf_kt`, `jei_limf_stebimi`, `data`, `asmens_kodas`) VALUES
('Firbroskopija', NULL, 'nosiaryklės masės', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2009-10-29', '45402060950'),
('Fibroskopija', NULL, 'be recidyvo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2010-04-12', '45402060950'),
('Fibroskopija', NULL, 'be recidyvo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2010-08-23', '45402060950'),
('Fibroskopija', NULL, 'be recidyvo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2011-01-10', '45402060950'),
('Fibroskopija', NULL, 'be recidyvo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2012-04-16', '45402060950'),
('Kaklo echoskopija', NULL, 'n.y', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2009-11-11', '45402060950'),
('VLS', NULL, 'antgerklio deš pusė padengta grubletu audiniu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-08-17', '35209270701'),
('VLS', NULL, 'ANT RAIŠČIO FIBRINAS ARBA KERATOZES', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-10-12', '35209270701'),
('Biopsija', NULL, 'PLOKŠČIU LASTELIU KARCINOMA , RECIDYVAS', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-10-12', '35209270701'),
('VLS', NULL, 'asfsrdrde', 'kairė', 'Valekula, Stemplės įeiga', 'daugiau nei 1 substritį', 1, 1, 0, 1, 'dfdgdrfgdrfdr', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2016-05-01', '49504220551'),
('Fibroskopija', NULL, 'efefdrffa', 'dešinę', 'Choana, Nosies prieangis, Apatinė kriauklė', '1 subsritį', NULL, NULL, 1, 1, 'fgtftgtfgr', 0, NULL, 'uyhtgrfds', NULL, NULL, NULL, NULL, '2016-05-05', '49504220551'),
('Galvos ir kaklo KT', 'dewfgrtgtrghrtghrt', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'lkjhgfdytfrd', 0, NULL, '2016-05-22', '49504220551'),
('VLS', NULL, NULL, NULL, NULL, NULL, 0, 0, 0, 0, NULL, 0, NULL, NULL, 0, NULL, 0, NULL, '2016-05-22', '49504220574');

-- --------------------------------------------------------

--
-- Table structure for table `apžiūros_pav`
--

DROP TABLE IF EXISTS `apžiūros_pav`;
CREATE TABLE IF NOT EXISTS `apžiūros_pav` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `apžiūros_pav`
--

INSERT INTO `apžiūros_pav` (`name`) VALUES
('Audiograma'),
('Biopsija'),
('Bronchoskopija'),
('Faringoskopija'),
('Fibroskopija'),
('Galvos ir kaklo KT'),
('Galvos ir kaklo MRT'),
('Gastroskopija'),
('HPV testas'),
('Kaklo apžiūra, palpacija'),
('Kaklo echoskopija'),
('Kita'),
('Odontologo apžiūra'),
('Otoskopija'),
('PET/KT'),
('Pilvo organų echoskopija'),
('Plaučių rentgenologinis tyrimas'),
('Rijimo įvertinimas'),
('Rinoskopija'),
('VLS');

-- --------------------------------------------------------

--
-- Table structure for table `difirencijacija`
--

DROP TABLE IF EXISTS `difirencijacija`;
CREATE TABLE IF NOT EXISTS `difirencijacija` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `difirencijacija`
--

INSERT INTO `difirencijacija` (`name`) VALUES
('G1'),
('G2'),
('G3'),
('G4'),
('GX');

-- --------------------------------------------------------

--
-- Table structure for table `gretutines_ligos`
--

DROP TABLE IF EXISTS `gretutines_ligos`;
CREATE TABLE IF NOT EXISTS `gretutines_ligos` (
  `pavadinimas` varchar(255) NOT NULL,
  `rodiklis` varchar(255) NOT NULL,
  `rodiklis_kita` varchar(255) DEFAULT NULL,
  `paciento_asmens_kodas` varchar(255) NOT NULL,
  KEY `paciento_asmens_kodas` (`paciento_asmens_kodas`),
  KEY `rodiklis` (`rodiklis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `gretutines_ligos`
--

INSERT INTO `gretutines_ligos` (`pavadinimas`, `rodiklis`, `rodiklis_kita`, `paciento_asmens_kodas`) VALUES
('Cukrinis Diabetas', 'Gliukozė', NULL, '45402060950'),
('Širdies nepakankamumas', 'Širdies išmetimo frakcija', NULL, '35209270701');

-- --------------------------------------------------------

--
-- Table structure for table `gydymas`
--

DROP TABLE IF EXISTS `gydymas`;
CREATE TABLE IF NOT EXISTS `gydymas` (
  `pavadinimas` varchar(255) NOT NULL,
  `operacinis_aprasymas` varchar(255) DEFAULT NULL,
  `sarginis_l_m` tinyint(1) DEFAULT NULL,
  `l_m_gr_paz` varchar(255) DEFAULT NULL,
  `l_m_gr_nepaz` varchar(255) DEFAULT NULL,
  `l_m_paz_teig` varchar(255) DEFAULT NULL,
  `l_m_nepaz_tieg` varchar(255) DEFAULT NULL,
  `limfanodektomija` tinyint(1) DEFAULT NULL,
  `limfo_gr_paz` varchar(255) DEFAULT NULL,
  `limfo_gr_nepaz` varchar(255) DEFAULT NULL,
  `limfo_gr_paz_teig` varchar(255) DEFAULT NULL,
  `limfo_gr_nepaz_teig` varchar(255) DEFAULT NULL,
  `tipas` varchar(255) DEFAULT NULL,
  `aprasymas` mediumtext,
  `ar_taikyta_limf` tinyint(1) DEFAULT NULL,
  `sumine_doze` int(11) DEFAULT NULL,
  `frakcijos` int(11) DEFAULT NULL,
  `cetuksimabas` tinyint(1) DEFAULT NULL,
  `cisplatina` tinyint(1) DEFAULT NULL,
  `docetakselis` tinyint(1) DEFAULT NULL,
  `paklitakselis` tinyint(1) DEFAULT NULL,
  `5_fu` tinyint(1) DEFAULT NULL,
  `kiti_vaistai` mediumtext,
  `kursu_skaicius` int(11) DEFAULT NULL,
  `kiekis` int(11) DEFAULT NULL,
  `data_nuo` date DEFAULT NULL,
  `data_iki` date DEFAULT NULL,
  `asmens_kodas` varchar(255) NOT NULL,
  `gydymas_baigtas` tinyint(1) DEFAULT NULL,
  KEY `tipas` (`tipas`),
  KEY `pavadinimas` (`pavadinimas`),
  KEY `asmens_kodas` (`asmens_kodas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `gydymas`
--

INSERT INTO `gydymas` (`pavadinimas`, `operacinis_aprasymas`, `sarginis_l_m`, `l_m_gr_paz`, `l_m_gr_nepaz`, `l_m_paz_teig`, `l_m_nepaz_tieg`, `limfanodektomija`, `limfo_gr_paz`, `limfo_gr_nepaz`, `limfo_gr_paz_teig`, `limfo_gr_nepaz_teig`, `tipas`, `aprasymas`, `ar_taikyta_limf`, `sumine_doze`, `frakcijos`, `cetuksimabas`, `cisplatina`, `docetakselis`, `paklitakselis`, `5_fu`, `kiti_vaistai`, `kursu_skaicius`, `kiekis`, `data_nuo`, `data_iki`, `asmens_kodas`, `gydymas_baigtas`) VALUES
('Chirurginis', 'Koaguliaciniu lazeriu pašalinta vizualiai sveikų audinių ribose.', 0, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2009-11-16', NULL, '45402060950', NULL),
('Spindulinis', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Adjuvantinis', NULL, 0, 60, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2010-01-01', '2010-02-01', '45402060950', NULL),
('Chirurginis', 'DALINIS Antgerklio pašalinimas CO2 lazeriu ENDOLARINGINĖ  DALINĖ LARINGEKTOMIJA', 1, 'III, IIB', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-08-30', NULL, '35209270701', NULL),
('Chirurginis', 'Antgerklio pašalinimas CO2 lazeriu\r\nENDOLARINGINĖ DALINĖ  LARINGEKTOMIJA\r\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-10-30', NULL, '35209270701', NULL),
('Biologinė terapija', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Adjuvantinis', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'asdfghjk,jhgfdsz,jhgfdsa', 12, NULL, '2016-05-11', '2016-05-20', '49504220551', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `gydymo_pav`
--

DROP TABLE IF EXISTS `gydymo_pav`;
CREATE TABLE IF NOT EXISTS `gydymo_pav` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `gydymo_pav`
--

INSERT INTO `gydymo_pav` (`name`) VALUES
('Biologinė terapija'),
('Biospindulinis'),
('Chemospindulinis'),
('Chemoterapija'),
('Chirurginis'),
('Kitas'),
('Paliatyvus'),
('Spindulinis');

-- --------------------------------------------------------

--
-- Table structure for table `komplikacijos`
--

DROP TABLE IF EXISTS `komplikacijos`;
CREATE TABLE IF NOT EXISTS `komplikacijos` (
  `kokios` varchar(255) NOT NULL,
  `kokios_kita` varchar(255) DEFAULT NULL,
  `data` date NOT NULL,
  `asmens_kodas` varchar(255) NOT NULL,
  KEY `vezio_nr` (`asmens_kodas`),
  KEY `kokios` (`kokios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `komplikacijos`
--

INSERT INTO `komplikacijos` (`kokios`, `kokios_kita`, `data`, `asmens_kodas`) VALUES
('Kita', 'Springimas', '2010-03-01', '45402060950'),
('Kita', 'Springimas', '2015-08-20', '35209270701');

-- --------------------------------------------------------

--
-- Table structure for table `komplikacijos_kokios`
--

DROP TABLE IF EXISTS `komplikacijos_kokios`;
CREATE TABLE IF NOT EXISTS `komplikacijos_kokios` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `komplikacijos_kokios`
--

INSERT INTO `komplikacijos_kokios` (`name`) VALUES
('Disfragija'),
('Kita'),
('Kraujavimas'),
('Kserostomija'),
('Masyvus kraujavimas'),
('Minkštųjų audinių nekrozė'),
('Osteonekrozė');

-- --------------------------------------------------------

--
-- Table structure for table `lytis`
--

DROP TABLE IF EXISTS `lytis`;
CREATE TABLE IF NOT EXISTS `lytis` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `lytis`
--

INSERT INTO `lytis` (`name`) VALUES
('Moteris'),
('Vyras');

-- --------------------------------------------------------

--
-- Table structure for table `mdk`
--

DROP TABLE IF EXISTS `mdk`;
CREATE TABLE IF NOT EXISTS `mdk` (
  `isvados` longtext NOT NULL,
  `data` date NOT NULL,
  `asmens_kodas` varchar(255) NOT NULL,
  `data_nuo` date DEFAULT NULL,
  `data_iki` date DEFAULT NULL,
  KEY `vezio_nr` (`asmens_kodas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- --------------------------------------------------------

--
-- Table structure for table `metastaziu_tipas`
--

DROP TABLE IF EXISTS `metastaziu_tipas`;
CREATE TABLE IF NOT EXISTS `metastaziu_tipas` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `metastaziu_tipas`
--

INSERT INTO `metastaziu_tipas` (`name`) VALUES
('Galvos smegenys'),
('Kepenys'),
('Kita'),
('Plaučiai');

-- --------------------------------------------------------

--
-- Table structure for table `morfologija`
--

DROP TABLE IF EXISTS `morfologija`;
CREATE TABLE IF NOT EXISTS `morfologija` (
  `name` varchar(255) CHARACTER SET utf16 NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `morfologija`
--

INSERT INTO `morfologija` (`name`) VALUES
('adenokarcinoma'),
('kita'),
('limfoma'),
('melanoma'),
('plokščialąstė karcinoma'),
('sarkoma');

-- --------------------------------------------------------

--
-- Table structure for table `pacientas`
--

DROP TABLE IF EXISTS `pacientas`;
CREATE TABLE IF NOT EXISTS `pacientas` (
  `vardas` varchar(255) CHARACTER SET utf16 NOT NULL,
  `pavarde` varchar(255) CHARACTER SET utf16 NOT NULL,
  `asmens_kodas` varchar(255) CHARACTER SET utf16 NOT NULL,
  `gimimo_data` date DEFAULT NULL,
  `amzius` int(11) DEFAULT NULL,
  `adresas` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `telefono_nr` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `lytis` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `alkoholis` tinyint(1) DEFAULT NULL,
  `rukymas` tinyint(1) DEFAULT NULL,
  `profesija` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `pirmasis_kreipimasis` date DEFAULT NULL,
  `paskutinis_apsilankymas` date DEFAULT NULL,
  `veziu_sk` int(11) DEFAULT NULL,
  `alergija` varchar(255) DEFAULT NULL,
  `mirties_data` date DEFAULT NULL,
  `mirties_priezastis` varchar(255) DEFAULT NULL,
  `isgyvenimo_trukme` int(11) DEFAULT NULL,
  `gydymo_pabaiga` date DEFAULT NULL,
  `gydymo_pradzia` date DEFAULT NULL,
  PRIMARY KEY (`asmens_kodas`),
  KEY `lytis` (`lytis`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pacientas`
--

INSERT INTO `pacientas` (`vardas`, `pavarde`, `asmens_kodas`, `gimimo_data`, `amzius`, `adresas`, `telefono_nr`, `lytis`, `alkoholis`, `rukymas`, `profesija`, `pirmasis_kreipimasis`, `paskutinis_apsilankymas`, `veziu_sk`, `alergija`, `mirties_data`, `mirties_priezastis`, `isgyvenimo_trukme`, `gydymo_pabaiga`, `gydymo_pradzia`) VALUES
('Antanas', 'Aldonis', '34607020296', NULL, 0, 'Vilkaviškis, Npriklausomyb?s 78-21', NULL, 'Vyras', 0, 1, 'Sargas', NULL, NULL, 1, NULL, NULL, NULL, 0, NULL, NULL),
('Vitas', 'Baltrušaitis', '35209270701', '1952-09-27', 58, 'sakiu raj matuliu km', '861879279', 'Vyras', 0, 1, 'KASKADININKAS', '2015-08-14', NULL, 1, 'Kiaušinio baltymui', NULL, NULL, NULL, '2015-10-30', '2015-08-30'),
('Angelė', 'Burinskienė', '45402060950', '1954-02-06', 62, 'Šlienava, kauno raj', '430063', 'Moteris', 1, 1, 'Pardavėja', '2009-05-13', NULL, 1, 'Jodas', NULL, NULL, NULL, '2010-02-01', '2009-11-16'),
('Dovil?', 'Gedminait?', '49504220551', '1995-04-22', 21, 'Kaunas', '863162553', 'Moteris', 0, 0, 'Studentas', '2016-05-15', NULL, 0, NULL, NULL, NULL, 0, NULL, NULL),
('Vardas', 'Pavarde', '49504220574', NULL, 0, NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, 0, NULL, NULL, NULL, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `paieska`
--

DROP TABLE IF EXISTS `paieska`;
CREATE TABLE IF NOT EXISTS `paieska` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `gydymas` varchar(255) NOT NULL,
  `apziura` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `paieska`
--

INSERT INTO `paieska` (`id`, `name`, `gydymas`, `apziura`) VALUES
(1, '49504220551', 'Chirurginis', 'Pilvo organu echoskopija');

-- --------------------------------------------------------

--
-- Table structure for table `recidyvo_tipas`
--

DROP TABLE IF EXISTS `recidyvo_tipas`;
CREATE TABLE IF NOT EXISTS `recidyvo_tipas` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `recidyvo_tipas`
--

INSERT INTO `recidyvo_tipas` (`name`) VALUES
('Izoliuotas limfmazgių'),
('Lokalus');

-- --------------------------------------------------------

--
-- Table structure for table `rodiklis_ligos`
--

DROP TABLE IF EXISTS `rodiklis_ligos`;
CREATE TABLE IF NOT EXISTS `rodiklis_ligos` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `rodiklis_ligos`
--

INSERT INTO `rodiklis_ligos` (`name`) VALUES
('Gliukozė'),
('Kita'),
('Kreateninas'),
('Širdies išmetimo frakcija');

-- --------------------------------------------------------

--
-- Table structure for table `spind_tipas`
--

DROP TABLE IF EXISTS `spind_tipas`;
CREATE TABLE IF NOT EXISTS `spind_tipas` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `spind_tipas`
--

INSERT INTO `spind_tipas` (`name`) VALUES
('Adjuvantinis'),
('Indukcinis');

-- --------------------------------------------------------

--
-- Table structure for table `sritis`
--

DROP TABLE IF EXISTS `sritis`;
CREATE TABLE IF NOT EXISTS `sritis` (
  `name` varchar(255) CHARACTER SET utf16 NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sritis`
--

INSERT INTO `sritis` (`name`) VALUES
('Burnaryklės navikas C10'),
('Burnos dugno C04'),
('Dantenos piktybinis navikas C03'),
('Galvos, veido ir kaklo jungiamasis ir minkštieji audiniai C49.0'),
('Gerklaryklės C13'),
('Gerklų apatinė dalis  C32.2'),
('Gerklų piktybinis navikas C32'),
('Gerklų viršutinė dalis C32.1'),
('Gomurio C05'),
('Kaukolės ir veido kaulai C41.0'),
('Kiti odos piktybiniai navikai C44'),
('Kitos liežuvio dalies C02'),
('Kitų burnos dalių C06'),
('Kitų ir nepatikslintų lūpos, burnos ertmės ir ryklės dalių piktybinis navikas C14'),
('Kitų ir netiksliai apibrėžtų lokalizacijų piktybinis navikas C76'),
('Kitų lokolizacijų piktybinis navikas 76.0'),
('Kitų seilių liaukų C08'),
('Kriaušinės kišenės C12'),
('Liežuvio šaknies C01'),
('Lūpos C00'),
('Metastazinis ir nepatikslintas limfmazgių piktybinis navikas C77'),
('Migdolo (ne ryklės ir ne liežuvio migdolų) C09'),
('Navikas be pirminio židinio C80'),
('Nosiaryklės C11'),
('Nosies ertmės ir vidurinės ausies piktybinis navikas C30'),
('Odos piktybinė melanoma C43'),
('Paausinės eilių liaukos C07'),
('Prienosinių ančių piktybinis navikas C31'),
('Skydliaukės piktybinis navikas C73'),
('Tikrasis balso aparatas C32.0');

-- --------------------------------------------------------

--
-- Table structure for table `stadija`
--

DROP TABLE IF EXISTS `stadija`;
CREATE TABLE IF NOT EXISTS `stadija` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `stadija`
--

INSERT INTO `stadija` (`name`) VALUES
('IA'),
('IB'),
('II'),
('III'),
('IVA'),
('IVB'),
('IVC');

-- --------------------------------------------------------

--
-- Table structure for table `tnm`
--

DROP TABLE IF EXISTS `tnm`;
CREATE TABLE IF NOT EXISTS `tnm` (
  `name` varchar(100) CHARACTER SET utf16 NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tnm`
--

INSERT INTO `tnm` (`name`) VALUES
('1'),
('2'),
('3'),
('4'),
('is'),
('X');

-- --------------------------------------------------------

--
-- Table structure for table `tnm_raide`
--

DROP TABLE IF EXISTS `tnm_raide`;
CREATE TABLE IF NOT EXISTS `tnm_raide` (
  `name` varchar(100) CHARACTER SET utf16 NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tnm_raide`
--

INSERT INTO `tnm_raide` (`name`) VALUES
('c'),
('p'),
('r');

-- --------------------------------------------------------

--
-- Table structure for table `vezys`
--

DROP TABLE IF EXISTS `vezys`;
CREATE TABLE IF NOT EXISTS `vezys` (
  `numeris` varchar(255) DEFAULT NULL,
  `sritis` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `diferencijacija` varchar(255) DEFAULT NULL,
  `stadija` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `morfologija` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `morfo_kita` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `M_kodas` int(11) DEFAULT NULL,
  `cTNM` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `pTNMRL` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `laikas_be_ligos` int(11) DEFAULT NULL,
  `progresavimas` tinyint(1) DEFAULT NULL,
  `laikas_be_progresavimo` int(11) DEFAULT NULL,
  `paciento_asmens_kodas` varchar(255) CHARACTER SET utf16 NOT NULL,
  `skundo_pav` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `skundo_trukme` int(11) DEFAULT NULL,
  `metastazes_yra` tinyint(1) DEFAULT NULL,
  `metastazes_tipas` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `metastazes_data` date DEFAULT NULL,
  `recidyvas_yra` tinyint(1) DEFAULT NULL,
  `recidyvo_tipas` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `recidyvo_data` date DEFAULT NULL,
  KEY `sritis` (`sritis`),
  KEY `diferencijacija` (`diferencijacija`),
  KEY `stadija` (`stadija`),
  KEY `morfologija` (`morfologija`),
  KEY `paciento_asmens_kodas` (`paciento_asmens_kodas`),
  KEY `metasztazes_tipas` (`metastazes_tipas`),
  KEY `recidyvo_tipas` (`recidyvo_tipas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vezys`
--

INSERT INTO `vezys` (`numeris`, `sritis`, `diferencijacija`, `stadija`, `morfologija`, `morfo_kita`, `M_kodas`, `cTNM`, `pTNMRL`, `laikas_be_ligos`, `progresavimas`, `laikas_be_progresavimo`, `paciento_asmens_kodas`, `skundo_pav`, `skundo_trukme`, `metastazes_yra`, `metastazes_tipas`, `metastazes_data`, `recidyvas_yra`, `recidyvo_tipas`, `recidyvo_data`) VALUES
('I', 'Nosiaryklės C11', 'G3', 'II', 'kita', 'plokščių ląstelių neragėjimas', 80703, 't3n0m0', 't3n0m0', NULL, NULL, NULL, '45402060950', 'Dešinės ausies užgulimas', 12, 0, NULL, NULL, 0, NULL, NULL),
('I', 'Burnaryklės navikas C10', 'G3', 'IA', 'plokščialąstė karcinoma', 'a', 80713, 'ct1n0m0', 'pt1n0m0r0', NULL, NULL, NULL, '35209270701', 'skauda gerklę', 12, 0, NULL, NULL, 1, 'Izoliuotas limfmazgių', '2015-10-12'),
('1', 'Kaukolės ir veido kaulai C41.0', 'G4', 'IVA', 'sarkoma', NULL, 4786, 'ct2n1m3', 'pt1n4m3r1l4', NULL, NULL, NULL, '49504220551', 'nosies užsikimšimas', 12, 0, NULL, NULL, 1, 'Izoliuotas limfmazgių', '2016-05-20');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `apziura`
--
ALTER TABLE `apziura`
  ADD CONSTRAINT `apziura_ibfk_1` FOREIGN KEY (`asmens_kodas`) REFERENCES `pacientas` (`asmens_kodas`);

--
-- Constraints for table `gretutines_ligos`
--
ALTER TABLE `gretutines_ligos`
  ADD CONSTRAINT `gretutines_ligos_ibfk_2` FOREIGN KEY (`rodiklis`) REFERENCES `rodiklis_ligos` (`name`),
  ADD CONSTRAINT `gretutines_ligos_ibfk_3` FOREIGN KEY (`paciento_asmens_kodas`) REFERENCES `pacientas` (`asmens_kodas`);

--
-- Constraints for table `gydymas`
--
ALTER TABLE `gydymas`
  ADD CONSTRAINT `gydymas_ibfk_3` FOREIGN KEY (`asmens_kodas`) REFERENCES `pacientas` (`asmens_kodas`);

--
-- Constraints for table `komplikacijos`
--
ALTER TABLE `komplikacijos`
  ADD CONSTRAINT `komplikacijos_ibfk_1` FOREIGN KEY (`kokios`) REFERENCES `komplikacijos_kokios` (`name`),
  ADD CONSTRAINT `komplikacijos_ibfk_2` FOREIGN KEY (`asmens_kodas`) REFERENCES `pacientas` (`asmens_kodas`);

--
-- Constraints for table `mdk`
--
ALTER TABLE `mdk`
  ADD CONSTRAINT `mdk_ibfk_1` FOREIGN KEY (`asmens_kodas`) REFERENCES `pacientas` (`asmens_kodas`);

--
-- Constraints for table `pacientas`
--
ALTER TABLE `pacientas`
  ADD CONSTRAINT `pacientas_ibfk_1` FOREIGN KEY (`lytis`) REFERENCES `lytis` (`name`);

--
-- Constraints for table `vezys`
--
ALTER TABLE `vezys`
  ADD CONSTRAINT `vezys_ibfk_12` FOREIGN KEY (`paciento_asmens_kodas`) REFERENCES `pacientas` (`asmens_kodas`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
