-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2023 at 06:26 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `empmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `EmpID` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Phone_no` varchar(15) NOT NULL,
  `Email` varchar(60) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Salary` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`EmpID`, `Name`, `Phone_no`, `Email`, `Address`, `Salary`) VALUES
(101, 'Raj', '1234567890', 'Raj@gmail.com', 'Mumbai', '36000.0'),
(102, 'Abhishek', '4567891238', 'abhishek@gmail.com', 'Mumbai', '35000.0'),
(103, 'Rohan', '1597534698', 'Rohan@gmail.com', 'Panvel', '25000.0'),
(105, 'Rahul', '123654789', 'Rahul@gmail.com', 'Nerul', '50000.0'),
(106, 'Rohit', '1486257923', 'Rohit@gmail.com', 'Kalyan', '45000.0'),
(107, 'Kaif', '0123456789', 'kaif@gmail.com', 'Mumbra', '48000.0');

-- --------------------------------------------------------

--
-- Table structure for table `sal`
--

CREATE TABLE `sal` (
  `EmpID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Monthly_sal` float NOT NULL,
  `Working_hours` int(11) NOT NULL,
  `Overtime_hours` int(11) NOT NULL,
  `Overtime_sal` float NOT NULL,
  `Overtime_cal` float NOT NULL,
  `Actual_sal` float NOT NULL,
  `Annual_sal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sal`
--

INSERT INTO `sal` (`EmpID`, `Name`, `Monthly_sal`, `Working_hours`, `Overtime_hours`, `Overtime_sal`, `Overtime_cal`, `Actual_sal`, `Annual_sal`) VALUES
(101, 'Raj', 30000, 8, 2, 500, 1000, 31000, 360000),
(103, 'Rohan', 25000, 8, 2, 1000, 2000, 27000, 300000),
(105, 'rahul', 50000, 8, 2, 1000, 2000, 52000, 600000),
(106, 'Rohit', 45000, 8, 2, 1000, 2000, 47000, 540000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Phone_no` varchar(15) NOT NULL,
  `Email` varchar(60) NOT NULL,
  `Privilege` varchar(50) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `Username`, `Phone_no`, `Email`, `Privilege`, `Password`) VALUES
(2, 'Shoaib', '7719895668', 'shoaibnaik2511@gmail.com', 'Admin', '12345'),
(3, 'Raj', '1234567890', 'Raj@gmail.com', 'Employee', '54321'),
(6, 'Ismail', '9082220439', 'imshaikh@gmail.com', 'Admin', '32145'),
(9, 'Abhishek', '4567891238', 'abhishek@gmail.com', 'Employee', '65432'),
(12, 'Rohan', '1539514698', 'rohan@gmail.com', 'Employee', '789654'),
(15, 'Rahul', '123654789', 'Rahul@gmail.com', 'Employee', '7412'),
(18, 'Rohit', '1486257923', 'Rohit@gmail.com', 'Employee', '7456'),
(21, 'Kaif', '0123456789', 'kaif@gmail.com', 'Employee', '1587'),
(22, 'Kaif', '0123456789', 'kaif@gmail.com', 'Employee', '1587'),
(23, 'Kaif', '0123456789', 'kaif@gmail.com', 'Employee', '1587');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`EmpID`);

--
-- Indexes for table `sal`
--
ALTER TABLE `sal`
  ADD PRIMARY KEY (`EmpID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
