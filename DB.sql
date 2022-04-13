-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Apr 13, 2022 at 10:02 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emailproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `emails`
--

CREATE TABLE `emails` (
  `id` bigint(20) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `sender_id` bigint(20) DEFAULT NULL,
  `sent_emails` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `emails`
--

INSERT INTO `emails` (`id`, `body`, `created_at`, `status`, `subject`, `sender_id`, `sent_emails`) VALUES
(1, 'The project is in progress.', '2022-02-01 11:25:38.000000', NULL, 'Projet', 1, 2),
(2, 'Explore code and developers on GitHub today, Feb 21.', '2021-02-01 19:24:42.000000', NULL, 'GitHub', 1, 4),
(3, 'Your job alert for java Software developer', '2021-03-02 19:31:56.000000', NULL, 'Linkedin', 2, 8),
(4, 'Newest job openings from top companies just for you', '2022-04-14 19:33:12.000000', NULL, 'Monster', 1, 7),
(5, 'Hi,\nWe’re looking for Graduates for our offices in different locations across India. \n\nRequirements Details: BE/ BTech/ MCA', '2022-02-20 19:33:12.000000', NULL, 'Siemens', 2, 3),
(6, 'We\'re so proud of you for setting your sights high and making every effort to achieve that goal. We wish you good luck. Keep going!', '2022-02-10 19:38:20.000000', 0, 'Edubridge', 9, 6),
(7, 'Hi Customer,\r\nUse the OTP 9017 to change your Email.\r\nThe code is valid for 15 minutes and can be used only once.', '2022-02-12 19:38:20.000000', NULL, 'BigBasket', 16, 5),
(8, 'Explore top Indian banks under one fund', '2020-02-01 19:40:29.000000', NULL, 'Paytm Money', 1, 1),
(9, 'Dear Learner,\r\nThanks for being our student. It has been a great experience teaching you. We would love to know what you felt about the Course. Do you mind sparing just a few minutes to leave a review?\r\n\r\nYou can leave your feedback by visiting the link h', '2022-02-25 19:37:09.000000', NULL, 'EduBridge', 1, 7),
(11, 'time to build a resume effectively!', '2022-01-10 19:40:29.000000', NULL, 'Medium', 1, 5),
(18, 'qwe', '2022-04-13 13:21:29.000000', NULL, 'qwe', 1, 2),
(19, 'demo', '2022-04-13 13:28:08.000000', NULL, 'test', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `email_receivers`
--

CREATE TABLE `email_receivers` (
  `email_id` bigint(20) NOT NULL,
  `receiver_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `email_receivers`
--

INSERT INTO `email_receivers` (`email_id`, `receiver_id`) VALUES
(1, 1),
(2, 1),
(19, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `sender`
--

CREATE TABLE `sender` (
  `sender_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sender`
--

INSERT INTO `sender` (`sender_id`) VALUES
(1),
(2),
(3);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `contact_number`, `email`, `first_name`, `last_name`, `password`, `active`, `roles`) VALUES
(1, '+91 7894135369', 'nk@gmail.com', 'Nitya', 'Kosti', 'pass', b'0', NULL),
(2, '+91 4556122389', 'yh@gmail.com', 'Harshad', 'Yatonde', 'pass', b'0', NULL),
(3, '+91 77778945112', 'pb@gmail.com', 'Pankaj', 'Bhanu', 'pass', b'0', NULL),
(4, '+91 7080908596', 'pc@gmail.com', 'Parag', 'Choudhari', 'pass', b'0', NULL),
(5, '+91 9978776532', 'cm@gmail.com', 'Mrunali', 'Chandavar', 'pass', b'0', NULL),
(6, '+91 8877994455', 'bk@gmail.com', 'Bani', 'Kapoor', 'pass', b'0', NULL),
(7, '+91 7899874506', 'ss@gmail.com', 'Sapana', 'Sood', 'pass', b'0', NULL),
(8, '+91 7804500012', 'sc@gmail.com', 'Chandni', 'Sanam', 'pass', b'0', NULL),
(9, '+91 8483828180', 'mp@gmail.com', 'Manoj', 'Panchgalle', 'pass', b'0', NULL),
(10, '+91 9594939291', 'ar@gmail.com', 'Akanksha', 'Reddy', 'pass', b'0', NULL),
(11, '+91 9080704561', 'vp@gmail.com', 'Vaibhavi', 'Patil', 'pass', b'0', NULL),
(16, '+91 9008780845', 'vp@gmail.com', 'Vishakha', 'Phirke', 'pass', b'0', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `emails`
--
ALTER TABLE `emails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKedttyua18b6fd9d65ab4va4j4` (`sender_id`),
  ADD KEY `FK3qh1q45fhktus3u8j8if34n9o` (`sent_emails`);

--
-- Indexes for table `email_receivers`
--
ALTER TABLE `email_receivers`
  ADD PRIMARY KEY (`email_id`,`receiver_id`),
  ADD KEY `FKrxjc4as2atj3t165gjgw7o5u0` (`receiver_id`);

--
-- Indexes for table `sender`
--
ALTER TABLE `sender`
  ADD PRIMARY KEY (`sender_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emails`
--
ALTER TABLE `emails`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `sender`
--
ALTER TABLE `sender`
  MODIFY `sender_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `emails`
--
ALTER TABLE `emails`
  ADD CONSTRAINT `FK3qh1q45fhktus3u8j8if34n9o` FOREIGN KEY (`sent_emails`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKedttyua18b6fd9d65ab4va4j4` FOREIGN KEY (`sender_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `email_receivers`
--
ALTER TABLE `email_receivers`
  ADD CONSTRAINT `FKrxjc4as2atj3t165gjgw7o5u0` FOREIGN KEY (`receiver_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKta7v1l6ypbbb7dcxytb246nq2` FOREIGN KEY (`email_id`) REFERENCES `emails` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
