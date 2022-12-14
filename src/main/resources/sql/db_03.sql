-- ----------------------------
-- Table structure for t_new_order_0000
-- ----------------------------
DROP TABLE IF EXISTS `t_new_order_0000`;
CREATE TABLE `t_new_order_0000`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `user_id`   varchar(128) DEFAULT NULL,
    `order_id`  varchar(128) DEFAULT NULL,
    `user_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1239 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_new_order_0001
-- ----------------------------
DROP TABLE IF EXISTS `t_new_order_0001`;
CREATE TABLE `t_new_order_0001`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `user_id`   varchar(128) DEFAULT NULL,
    `order_id`  varchar(128) DEFAULT NULL,
    `user_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1239 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order_0000
-- ----------------------------
DROP TABLE IF EXISTS `t_order_0000`;
CREATE TABLE `t_order_0000`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `user_id`   bigint(32) DEFAULT NULL,
    `order_id`  bigint(32) DEFAULT NULL,
    `user_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=450 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order_0001
-- ----------------------------
DROP TABLE IF EXISTS `t_order_0001`;
CREATE TABLE `t_order_0001`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `user_id`   bigint(32) DEFAULT NULL,
    `order_id`  bigint(32) DEFAULT NULL,
    `user_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1026 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_0000
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0000`;
CREATE TABLE `t_user_0000`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `user_id`     varchar(128) NOT NULL,
    `user_name`   varchar(255) DEFAULT NULL,
    `user_out_id` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_0001
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0001`;
CREATE TABLE `t_user_0001`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `user_id`     varchar(128) NOT NULL,
    `user_name`   varchar(255) DEFAULT NULL,
    `user_out_id` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_0002
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0002`;
CREATE TABLE `t_user_0002`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `user_id`     varchar(128) NOT NULL,
    `user_name`   varchar(255) DEFAULT NULL,
    `user_out_id` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_0003
-- ----------------------------
DROP TABLE IF EXISTS `t_user_0003`;
CREATE TABLE `t_user_0003`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `user_id`     varchar(128) NOT NULL,
    `user_name`   varchar(255) DEFAULT NULL,
    `user_out_id` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;