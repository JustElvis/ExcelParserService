CREATE SCHEMA IF NOT EXISTS `students` DEFAULT CHARACTER SET utf8;
USE `students`;
SET NAMES utf8mb3;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
                            `id` bigint NOT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `last_name` varchar(255) DEFAULT NULL,
                            `age` int DEFAULT NULL,
                            `phone_number` varchar(255) DEFAULT NULL,
                            `email` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `login` varchar(50) DEFAULT NULL,
                              `password` varchar(500) DEFAULT NULL,
                              `role_id` bigint DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `login_UNIQUE` (`login`),
                              KEY `user_table_role_table_fk_idx` (`role_id`),
                              CONSTRAINT `user_table_role_table_fk` FOREIGN KEY (`role_id`) REFERENCES `role_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;


-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `role_table`;
CREATE TABLE `role_table` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) NOT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
