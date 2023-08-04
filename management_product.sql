-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 04 août 2023 à 13:44
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `miniprojet_elkhaldi`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` varchar(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sexe` varchar(20) NOT NULL,
  `tClient` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `datenaissance` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `adresse`, `ville`, `email`, `sexe`, `tClient`, `tel`, `datenaissance`) VALUES
('aibfua1', 'Es-sabiri', 'soufiane', 'rue 13,angers', 'angers', 'sabiri@gmail.com', 'Homme', 'fidéle', '0699887766', '22/04/2001'),
('alalsa1', 'Es-salhi', 'salh', 'rue 2, sale', 'taza', 'salhi1@gmail.com', 'Homme', 'fidéle', '0612121212', '13/03/2023'),
('CF6023521', 'el-messbli', 'imad', 'lkalaa,bouhouda,taounate', 'taounate', 'imad@gmail.com', 'Homme', 'fidéle', '0612341221', '01/03/1995'),
('CP6347111', 'slaoui', 'ali', 'ktema,el-houceima', 'el-houceima', 'slaoui@gamil.com', 'Homme', 'Potentiel', '061231212', '14/03/1988'),
('sarals1', 'el-alaoui', 'sara', 'rue enajjah fes', 'fes', 'alaoui@gmail.com', 'Femme', 'Potentiel', '06333225', '23/11/1997');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `numf` int(11) NOT NULL,
  `idCl` varchar(20) NOT NULL,
  `nomcplt` varchar(70) NOT NULL,
  `nomP` varchar(40) NOT NULL,
  `qteV` double NOT NULL,
  `dateVendre` varchar(60) NOT NULL,
  `montant` double DEFAULT NULL,
  `dateGarantie` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`numf`, `idCl`, `nomcplt`, `nomP`, `qteV`, `dateVendre`, `montant`, `dateGarantie`) VALUES
(1, 'CP6347111', 'slaoui', 'banane', 60, '14/03/2023', 540, '14/03/2027'),
(4, 'cp6347111', 'slaoui ali', 'pomme', 20, '14/03/2023', 140, '14/03/2035'),
(5, 'aibfua1', 'Es-sabiri soufiane', 'banane', 300, '15/03/2023', 2700, '14/03/2027');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `idP` varchar(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `unitee` varchar(15) NOT NULL,
  `QteP` double NOT NULL,
  `prixAchat` float NOT NULL,
  `prixVendre` float NOT NULL,
  `dateP` varchar(60) NOT NULL,
  `dateE` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idP`, `nom`, `unitee`, `QteP`, `prixAchat`, `prixVendre`, `dateP`, `dateE`) VALUES
('1', 'Stylo', 'unité', 1000, 1.5, 2, '06/03/2023', '20/03/2023'),
('3', 'oil', 'Litre', 300, 20, 30, '01/03/2023', '23/04/2025'),
('4', 'pomme', 'KG', 800, 5, 7, '05/03/2023', '21/03/2023'),
('55', 'tomate', 'KG', 600, 4, 5, '10/03/2023', '20/03/2023'),
('66', 'sucre', 'Paquet', 1000, 10, 13, '22/09/2022', '06/03/2023'),
('77', 'clavier', 'unité', 100, 50, 60, '22/03/2014', '22/03/2023');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`numf`) USING BTREE,
  ADD UNIQUE KEY `numf_2` (`numf`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD UNIQUE KEY `idP` (`idP`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `numf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
