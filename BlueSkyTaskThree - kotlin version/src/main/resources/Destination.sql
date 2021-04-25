
CREATE TABLE `user` (
  `UID` varchar(50) NOT NULL,
  `Title` varchar(50) DEFAULT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Position` varchar(50) DEFAULT NULL,
  `Address` varchar(50) NOT NULL,
  `Mobile` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Company_Name` varchar(50) NOT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `group` (
  `GID` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `usergroup` (
  `Id` varchar(100) NOT NULL,
  `UID` varchar(100) NOT NULL,
  `GID` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `usergroup_ibfk_1` (`UID`),
  KEY `usergroup_ibfk_2` (`GID`),
  CONSTRAINT `usergroup_ibfk_1` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`),
  CONSTRAINT `usergroup_ibfk_2` FOREIGN KEY (`GID`) REFERENCES `group` (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
