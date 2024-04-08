CREATE DATABASE `online_blood_bank_system` /*!40100 DEFAULT CHARACTER SET latin1 */;
 
USE `online_blood_bank_system`;
CREATE TABLE `blood_group` (
  `id` int(11) NOT NULL,
  `blood_group` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `blood_requirement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `contact_number` bigint(20) DEFAULT NULL,
  `hospital_name` varchar(255) DEFAULT NULL,
  `pin_code` int(11) DEFAULT NULL,
  `requister_name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `user_mailID` varchar(255) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;


CREATE TABLE `donor_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `donor_name` varchar(45) DEFAULT NULL,
  `contact_number` double DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `pin_code` int(11) DEFAULT NULL,
  `blood_group` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

CREATE TABLE `feedback_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `hospital_name` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

CREATE TABLE `hospital_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

CREATE TABLE `recipient_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `contact_number` bigint(20) DEFAULT NULL,
  `hospital_name` varchar(255) DEFAULT NULL,
  `pin_code` int(11) DEFAULT NULL,
  `requister_name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE `slot_booking` (
  `recipient_id` int(11) NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `donor_id` int(11) DEFAULT NULL,
  `hospital_name` varchar(255) DEFAULT NULL,
  `time_slot` varchar(255) DEFAULT NULL,
  `user_mailID` varchar(255) DEFAULT NULL,
  `donor_name` varchar(45) DEFAULT NULL,
  `recipient_name` varchar(45) DEFAULT NULL,
  `contact_number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`recipient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `state` (
  `state_id` int(11) NOT NULL,
  `state_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `contact_number` double DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pin_code` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;


