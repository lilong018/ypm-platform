/*
 Navicat Premium Data Transfer

 Source Server         : 本地服务
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : platform_security

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 05/08/2020 11:36:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `"qrtz_blob_triggers_ibfk_1"` FOREIGN KEY () REFERENCES `"qrtz_triggers"` () ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `"qrtz_cron_triggers_ibfk_1"` FOREIGN KEY () REFERENCES `"qrtz_triggers"` () ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('platformScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('platformScheduler', 'TASK_1', 'DEFAULT', NULL, 'com.platform.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720031636F6D2E706C6174666F726D2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017307E440507874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000001740008706C6174666F726D74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('platformScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('platformScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('platformScheduler', 'DESKTOP-566LC7K1596590468585', 1596595137738, 15000);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `"qrtz_simple_triggers_ibfk_1"` FOREIGN KEY () REFERENCES `"qrtz_triggers"` () ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `"qrtz_simprop_triggers_ibfk_1"` FOREIGN KEY () REFERENCES `"qrtz_triggers"` () ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `"qrtz_triggers_ibfk_1"` FOREIGN KEY () REFERENCES `"qrtz_job_details"` () ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('platformScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', NULL, 1593567000000, -1, 5, 'PAUSED', 'CRON', 1593565301000, 0, NULL, 2, 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720031636F6D2E706C6174666F726D2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000017307E440507874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000001740008706C6174666F726D74000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES (1, 'testTask', 'platform', '0 0/30 * * * ?', 1, '参数测试', '2020-07-01 09:01:06');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log`  (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'spring bean名称',
  `params` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE,
  INDEX `job_id`(`job_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES (1, 1, 'testTask', 'platform', 0, NULL, 0, '2020-07-01 09:30:00');
INSERT INTO `schedule_job_log` VALUES (2, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-13 09:30:00');
INSERT INTO `schedule_job_log` VALUES (3, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-13 10:00:00');
INSERT INTO `schedule_job_log` VALUES (4, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-13 15:00:00');
INSERT INTO `schedule_job_log` VALUES (5, 1, 'testTask', 'platform', 0, NULL, 0, '2020-07-16 10:00:00');
INSERT INTO `schedule_job_log` VALUES (6, 1, 'testTask', 'platform', 0, NULL, 2, '2020-07-16 10:30:00');
INSERT INTO `schedule_job_log` VALUES (7, 1, 'testTask', 'platform', 0, NULL, 0, '2020-07-16 11:00:00');
INSERT INTO `schedule_job_log` VALUES (8, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-16 11:30:00');
INSERT INTO `schedule_job_log` VALUES (9, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-16 12:00:00');
INSERT INTO `schedule_job_log` VALUES (10, 1, 'testTask', 'platform', 0, NULL, 2, '2020-07-16 12:30:00');
INSERT INTO `schedule_job_log` VALUES (11, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-19 14:30:00');
INSERT INTO `schedule_job_log` VALUES (12, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-19 15:00:00');
INSERT INTO `schedule_job_log` VALUES (13, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-19 15:30:00');
INSERT INTO `schedule_job_log` VALUES (14, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-20 09:00:00');
INSERT INTO `schedule_job_log` VALUES (15, 1, 'testTask', 'platform', 0, NULL, 1, '2020-07-20 09:30:00');
INSERT INTO `schedule_job_log` VALUES (16, 1, 'testTask', 'platform', 0, NULL, 0, '2020-07-20 10:00:00');
INSERT INTO `schedule_job_log` VALUES (17, 1, 'testTask', 'platform', 0, NULL, 0, '2020-07-20 10:30:00');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `param_key`(`param_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', 0, '云存储配置信息');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, '有票么集团', 0, 0);
INSERT INTO `sys_dept` VALUES (2, 1, '长沙分公司', 1, 0);
INSERT INTO `sys_dept` VALUES (3, 1, '上海分公司', 2, 0);
INSERT INTO `sys_dept` VALUES (4, 3, '技术部', 0, 0);
INSERT INTO `sys_dept` VALUES (5, 3, '销售部', 1, 0);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典名称',
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典码',
  `value` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典值',
  `order_num` int(11) NULL DEFAULT 0 COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(4) NULL DEFAULT 0 COMMENT '删除标记  -1：已删除  0：正常',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `type`(`type`, `code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, '性别', 'sex', '0', '女', 0, NULL, 0);
INSERT INTO `sys_dict` VALUES (2, '性别', 'sex', '1', '男', 1, NULL, 0);
INSERT INTO `sys_dict` VALUES (3, '性别', 'sex', '2', '未知', 3, NULL, 0);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'admin', '修改密码', 'com.platform.modules.sys.controller.SysUserController.password()', '\"admin\"', 45, '0:0:0:0:0:0:0:1', '2020-07-01 09:23:39');
INSERT INTO `sys_log` VALUES (2, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":41,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"用户管理\",\"url\":\"modules/enterprise/enterprise.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 39, '0:0:0:0:0:0:0:1', '2020-07-08 16:50:28');
INSERT INTO `sys_log` VALUES (3, 'admin', '保存菜单', 'com.platform.modules.sys.controller.SysMenuController.save()', '{\"menuId\":46,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"客服管理\",\"type\":0,\"icon\":\"fa fa-user\",\"orderNum\":0}', 39, '0:0:0:0:0:0:0:1', '2020-07-13 09:39:06');
INSERT INTO `sys_log` VALUES (4, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":46,\"parentId\":46,\"parentName\":\"客服管理\",\"name\":\"企业管理\",\"url\":\"modules/enterprise/enterprise.html\",\"type\":1,\"icon\":\"\",\"orderNum\":0}', 42, '0:0:0:0:0:0:0:1', '2020-07-13 09:40:17');
INSERT INTO `sys_log` VALUES (5, 'admin', '保存角色', 'com.platform.modules.sys.controller.SysRoleController.save()', '{\"roleId\":1,\"roleName\":\"超级管理员\",\"deptId\":1,\"deptName\":\"有票么集团\",\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46],\"deptIdList\":[1,2,3,4,5],\"createTime\":\"Jul 13, 2020 9:41:44 AM\"}', 215, '0:0:0:0:0:0:0:1', '2020-07-13 09:41:45');
INSERT INTO `sys_log` VALUES (6, 'admin', '修改用户', 'com.platform.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@draftex\",\"mobile\":\"13612345678\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"有票么集团\"}', 59, '0:0:0:0:0:0:0:1', '2020-07-13 09:41:58');
INSERT INTO `sys_log` VALUES (7, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":46,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"客服\",\"url\":\"\",\"type\":0,\"icon\":\"fa fa-user\",\"orderNum\":0}', 32, '0:0:0:0:0:0:0:1', '2020-07-13 09:42:51');
INSERT INTO `sys_log` VALUES (8, 'admin', '保存菜单', 'com.platform.modules.sys.controller.SysMenuController.save()', '{\"menuId\":47,\"parentId\":46,\"parentName\":\"客服\",\"name\":\"企业管理\",\"url\":\"modules/enterprise/enterprise.html\",\"type\":1,\"orderNum\":0}', 34, '0:0:0:0:0:0:0:1', '2020-07-13 09:43:05');
INSERT INTO `sys_log` VALUES (9, 'admin', '删除菜单', 'com.platform.modules.sys.controller.SysMenuController.delete()', '41', 2, '0:0:0:0:0:0:0:1', '2020-07-13 09:43:32');
INSERT INTO `sys_log` VALUES (10, 'admin', '删除菜单', 'com.platform.modules.sys.controller.SysMenuController.delete()', '42', 96, '0:0:0:0:0:0:0:1', '2020-07-13 09:43:40');
INSERT INTO `sys_log` VALUES (11, 'admin', '删除菜单', 'com.platform.modules.sys.controller.SysMenuController.delete()', '43', 62, '0:0:0:0:0:0:0:1', '2020-07-13 09:43:48');
INSERT INTO `sys_log` VALUES (12, 'admin', '删除菜单', 'com.platform.modules.sys.controller.SysMenuController.delete()', '44', 98, '0:0:0:0:0:0:0:1', '2020-07-13 09:43:56');
INSERT INTO `sys_log` VALUES (13, 'admin', '删除菜单', 'com.platform.modules.sys.controller.SysMenuController.delete()', '45', 60, '0:0:0:0:0:0:0:1', '2020-07-13 09:44:03');
INSERT INTO `sys_log` VALUES (14, 'admin', '删除菜单', 'com.platform.modules.sys.controller.SysMenuController.delete()', '41', 85, '0:0:0:0:0:0:0:1', '2020-07-13 09:44:09');
INSERT INTO `sys_log` VALUES (15, 'admin', '保存菜单', 'com.platform.modules.sys.controller.SysMenuController.save()', '{\"menuId\":48,\"parentId\":47,\"parentName\":\"企业管理\",\"name\":\"新增\",\"type\":2,\"orderNum\":0}', 43, '0:0:0:0:0:0:0:1', '2020-07-13 09:44:44');
INSERT INTO `sys_log` VALUES (16, 'admin', '保存菜单', 'com.platform.modules.sys.controller.SysMenuController.save()', '{\"menuId\":49,\"parentId\":47,\"parentName\":\"企业管理\",\"name\":\"修改\",\"type\":2,\"orderNum\":0}', 47, '0:0:0:0:0:0:0:1', '2020-07-13 09:45:09');
INSERT INTO `sys_log` VALUES (17, 'admin', '保存菜单', 'com.platform.modules.sys.controller.SysMenuController.save()', '{\"menuId\":50,\"parentId\":47,\"parentName\":\"企业管理\",\"name\":\"查看\",\"perms\":\"\",\"type\":2,\"orderNum\":0}', 46, '0:0:0:0:0:0:0:1', '2020-07-13 09:46:20');
INSERT INTO `sys_log` VALUES (18, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":51,\"parentId\":46,\"parentName\":\"客服\",\"name\":\"银行管理\",\"url\":\"modules/bank/bank.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 31, '0:0:0:0:0:0:0:1', '2020-07-13 09:48:41');
INSERT INTO `sys_log` VALUES (19, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":50,\"parentId\":47,\"parentName\":\"企业管理\",\"name\":\"查看\",\"perms\":\"enterprise:enterprise.list:enterprise.view\",\"type\":2,\"orderNum\":0}', 34, '0:0:0:0:0:0:0:1', '2020-07-13 09:49:35');
INSERT INTO `sys_log` VALUES (20, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":50,\"parentId\":47,\"parentName\":\"企业管理\",\"name\":\"查看\",\"perms\":\"enterprise:enterprise:list,enterprise:enterprise:info\",\"type\":2,\"orderNum\":0}', 43, '0:0:0:0:0:0:0:1', '2020-07-13 09:50:11');
INSERT INTO `sys_log` VALUES (21, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":48,\"parentId\":47,\"parentName\":\"企业管理\",\"name\":\"新增\",\"perms\":\"enterprise:enterprise:save\",\"type\":2,\"orderNum\":0}', 47, '0:0:0:0:0:0:0:1', '2020-07-13 09:51:10');
INSERT INTO `sys_log` VALUES (22, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":49,\"parentId\":47,\"parentName\":\"企业管理\",\"name\":\"修改\",\"perms\":\"enterprise:enterprise:update\",\"type\":2,\"orderNum\":0}', 32, '0:0:0:0:0:0:0:1', '2020-07-13 09:51:30');
INSERT INTO `sys_log` VALUES (23, 'admin', '暂停定时任务', 'com.platform.modules.job.controller.ScheduleJobController.pause()', '[1]', 99, '0:0:0:0:0:0:0:1', '2020-07-20 10:34:59');
INSERT INTO `sys_log` VALUES (24, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":51,\"parentId\":46,\"parentName\":\"客服\",\"name\":\"银行管理\",\"url\":\"modules/bill/bill.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 38, '0:0:0:0:0:0:0:1', '2020-07-23 10:02:08');
INSERT INTO `sys_log` VALUES (25, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":51,\"parentId\":46,\"parentName\":\"客服\",\"name\":\"票据管理\",\"url\":\"modules/bill/bill.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', 45, '0:0:0:0:0:0:0:1', '2020-07-23 10:02:21');
INSERT INTO `sys_log` VALUES (26, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":52,\"parentId\":51,\"parentName\":\"票据管理\",\"name\":\"查看\",\"perms\":\"bill:bill:list,bill:bill:info\",\"type\":2,\"orderNum\":6}', 30, '0:0:0:0:0:0:0:1', '2020-07-23 10:02:39');
INSERT INTO `sys_log` VALUES (27, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":53,\"parentId\":51,\"parentName\":\"票据管理\",\"name\":\"新增\",\"perms\":\"bill:bill:save\",\"type\":2,\"orderNum\":6}', 34, '0:0:0:0:0:0:0:1', '2020-07-23 10:02:53');
INSERT INTO `sys_log` VALUES (28, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":54,\"parentId\":51,\"parentName\":\"票据管理\",\"name\":\"修改\",\"perms\":\"bill:bill:update\",\"type\":2,\"orderNum\":6}', 46, '0:0:0:0:0:0:0:1', '2020-07-23 10:03:09');
INSERT INTO `sys_log` VALUES (29, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":55,\"parentId\":51,\"parentName\":\"票据管理\",\"name\":\"删除\",\"perms\":\"bill:bill:delete\",\"type\":2,\"orderNum\":6}', 46, '0:0:0:0:0:0:0:1', '2020-07-23 10:03:21');
INSERT INTO `sys_log` VALUES (30, 'admin', '保存菜单', 'com.platform.modules.sys.controller.SysMenuController.save()', '{\"menuId\":56,\"parentId\":46,\"parentName\":\"客服\",\"name\":\"交易管理\",\"url\":\"modules/transaction/order.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":0}', 37, '0:0:0:0:0:0:0:1', '2020-07-28 10:24:00');
INSERT INTO `sys_log` VALUES (31, 'admin', '修改菜单', 'com.platform.modules.sys.controller.SysMenuController.update()', '{\"menuId\":56,\"parentId\":46,\"parentName\":\"客服\",\"name\":\"交易管理\",\"url\":\"modules/transaction/order.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":10}', 61, '0:0:0:0:0:0:0:1', '2020-07-28 10:24:15');
INSERT INTO `sys_log` VALUES (32, 'admin', '保存菜单', 'com.platform.modules.sys.controller.SysMenuController.save()', '{\"menuId\":57,\"parentId\":56,\"parentName\":\"交易管理\",\"name\":\"查看\",\"perms\":\"transaction:order:list,transaction:order:info\",\"type\":2,\"orderNum\":0}', 25, '0:0:0:0:0:0:0:1', '2020-07-28 10:25:19');
INSERT INTO `sys_log` VALUES (33, 'admin', '保存菜单', 'com.platform.modules.sys.controller.SysMenuController.save()', '{\"menuId\":58,\"parentId\":56,\"parentName\":\"交易管理\",\"name\":\"修改\",\"perms\":\"transaction:order:update\",\"type\":2,\"orderNum\":0}', 48, '0:0:0:0:0:0:0:1', '2020-07-28 10:25:52');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'fa fa-cog', 0);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员管理', 'modules/sys/user.html', NULL, 1, 'fa fa-user', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'modules/sys/role.html', NULL, 1, 'fa fa-user-secret', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', 'modules/sys/menu.html', NULL, 1, 'fa fa-th-list', 3);
INSERT INTO `sys_menu` VALUES (5, 1, 'SQL监控', 'druid/sql.html', NULL, 1, 'fa fa-bug', 4);
INSERT INTO `sys_menu` VALUES (6, 1, '定时任务', 'modules/job/schedule.html', NULL, 1, 'fa fa-tasks', 5);
INSERT INTO `sys_menu` VALUES (7, 6, '查看', NULL, 'sys:schedule:list,sys:schedule:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (8, 6, '新增', NULL, 'sys:schedule:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (9, 6, '修改', NULL, 'sys:schedule:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (10, 6, '删除', NULL, 'sys:schedule:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (11, 6, '暂停', NULL, 'sys:schedule:pause', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (12, 6, '恢复', NULL, 'sys:schedule:resume', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (13, 6, '立即执行', NULL, 'sys:schedule:run', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (14, 6, '日志列表', NULL, 'sys:schedule:log', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:perms', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:perms', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 1, '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'fa fa-sun-o', 6);
INSERT INTO `sys_menu` VALUES (29, 1, '系统日志', 'modules/sys/log.html', 'sys:log:list', 1, 'fa fa-file-text-o', 7);
INSERT INTO `sys_menu` VALUES (30, 1, '文件上传', 'modules/oss/oss.html', 'sys:oss:all', 1, 'fa fa-file-image-o', 6);
INSERT INTO `sys_menu` VALUES (31, 1, '部门管理', 'modules/sys/dept.html', NULL, 1, 'fa fa-file-code-o', 1);
INSERT INTO `sys_menu` VALUES (32, 31, '查看', NULL, 'sys:dept:list,sys:dept:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (33, 31, '新增', NULL, 'sys:dept:save,sys:dept:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (34, 31, '修改', NULL, 'sys:dept:update,sys:dept:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (35, 31, '删除', NULL, 'sys:dept:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (36, 1, '字典管理', 'modules/sys/dict.html', NULL, 1, 'fa fa-bookmark-o', 6);
INSERT INTO `sys_menu` VALUES (37, 36, '查看', NULL, 'sys:dict:list,sys:dict:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (38, 36, '新增', NULL, 'sys:dict:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (39, 36, '修改', NULL, 'sys:dict:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (40, 36, '删除', NULL, 'sys:dict:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (46, 0, '客服', '', NULL, 0, 'fa fa-user', 0);
INSERT INTO `sys_menu` VALUES (47, 46, '企业管理', 'modules/enterprise/enterprise.html', NULL, 1, NULL, 0);
INSERT INTO `sys_menu` VALUES (48, 47, '新增', NULL, 'enterprise:enterprise:save', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (49, 47, '修改', NULL, 'enterprise:enterprise:update', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (50, 47, '查看', NULL, 'enterprise:enterprise:list,enterprise:enterprise:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (51, 46, '票据管理', 'modules/bill/bill.html', NULL, 1, 'fa fa-file-code-o', 6);
INSERT INTO `sys_menu` VALUES (52, 51, '查看', NULL, 'bill:bill:list,bill:bill:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (53, 51, '新增', NULL, 'bill:bill:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (54, 51, '修改', NULL, 'bill:bill:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (55, 51, '删除', NULL, 'bill:bill:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (56, 46, '交易管理', 'modules/transaction/order.html', NULL, 1, 'fa fa-file-code-o', 10);
INSERT INTO `sys_menu` VALUES (57, 56, '查看', NULL, 'transaction:order:list,transaction:order:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (58, 56, '修改', NULL, 'transaction:order:update', 2, NULL, 0);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', NULL, 1, '2020-07-13 09:41:45');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色与部门对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (1, 1, 1);
INSERT INTO `sys_role_dept` VALUES (2, 1, 2);
INSERT INTO `sys_role_dept` VALUES (3, 1, 3);
INSERT INTO `sys_role_dept` VALUES (4, 1, 4);
INSERT INTO `sys_role_dept` VALUES (5, 1, 5);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 2);
INSERT INTO `sys_role_menu` VALUES (3, 1, 15);
INSERT INTO `sys_role_menu` VALUES (4, 1, 16);
INSERT INTO `sys_role_menu` VALUES (5, 1, 17);
INSERT INTO `sys_role_menu` VALUES (6, 1, 18);
INSERT INTO `sys_role_menu` VALUES (7, 1, 3);
INSERT INTO `sys_role_menu` VALUES (8, 1, 19);
INSERT INTO `sys_role_menu` VALUES (9, 1, 20);
INSERT INTO `sys_role_menu` VALUES (10, 1, 21);
INSERT INTO `sys_role_menu` VALUES (11, 1, 22);
INSERT INTO `sys_role_menu` VALUES (12, 1, 4);
INSERT INTO `sys_role_menu` VALUES (13, 1, 23);
INSERT INTO `sys_role_menu` VALUES (14, 1, 24);
INSERT INTO `sys_role_menu` VALUES (15, 1, 25);
INSERT INTO `sys_role_menu` VALUES (16, 1, 26);
INSERT INTO `sys_role_menu` VALUES (17, 1, 5);
INSERT INTO `sys_role_menu` VALUES (18, 1, 6);
INSERT INTO `sys_role_menu` VALUES (19, 1, 7);
INSERT INTO `sys_role_menu` VALUES (20, 1, 8);
INSERT INTO `sys_role_menu` VALUES (21, 1, 9);
INSERT INTO `sys_role_menu` VALUES (22, 1, 10);
INSERT INTO `sys_role_menu` VALUES (23, 1, 11);
INSERT INTO `sys_role_menu` VALUES (24, 1, 12);
INSERT INTO `sys_role_menu` VALUES (25, 1, 13);
INSERT INTO `sys_role_menu` VALUES (26, 1, 14);
INSERT INTO `sys_role_menu` VALUES (27, 1, 27);
INSERT INTO `sys_role_menu` VALUES (28, 1, 29);
INSERT INTO `sys_role_menu` VALUES (29, 1, 30);
INSERT INTO `sys_role_menu` VALUES (30, 1, 31);
INSERT INTO `sys_role_menu` VALUES (31, 1, 32);
INSERT INTO `sys_role_menu` VALUES (32, 1, 33);
INSERT INTO `sys_role_menu` VALUES (33, 1, 34);
INSERT INTO `sys_role_menu` VALUES (34, 1, 35);
INSERT INTO `sys_role_menu` VALUES (35, 1, 36);
INSERT INTO `sys_role_menu` VALUES (36, 1, 37);
INSERT INTO `sys_role_menu` VALUES (37, 1, 38);
INSERT INTO `sys_role_menu` VALUES (38, 1, 39);
INSERT INTO `sys_role_menu` VALUES (39, 1, 40);
INSERT INTO `sys_role_menu` VALUES (45, 1, 46);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '5f9c50b9d370e553b076ecf20870baab6dff1d061fb15868b62ca17f04b70a16', 'YzcmCZNvbXocrsz9dm8e', 'root@draftex', '13612345678', 1, 1, '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for tb_bank
-- ----------------------------
DROP TABLE IF EXISTS `tb_bank`;
CREATE TABLE `tb_bank`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标识',
  `type` int(2) NULL DEFAULT NULL COMMENT '账户类型 （1） 体现户 （2）签收户',
  `channelType` int(2) NULL DEFAULT NULL COMMENT '渠道类型 （1） 京东智票 （2）京东智付',
  `bankSource` int(2) NULL DEFAULT NULL COMMENT '银行新增来源 1)企业实名认证, (2)銀行卡管理打款',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称',
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行行号',
  `accountName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户行名称-同企业名称',
  `accountNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户账户',
  `occBankCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行编码',
  `occBankName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行名称',
  `occBankCnap` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行支行银联号',
  `occBankChildCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `occBankChildName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支行银行全称',
  `provinceId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份id',
  `provinceName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份名称',
  `cityId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市id',
  `cityName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `createTimeInMillis` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(2) NULL DEFAULT NULL COMMENT '认证状态 - (0)待鉴权 (1)审核不通过 (2)审核通过',
  `enterpriseId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_bank
-- ----------------------------
INSERT INTO `tb_bank` VALUES ('1', 1, 1, 1, '中国农业银行临沂分行', '11111', '有票么', '11111', '307', '山东', '31', '321', '231', '321', '321', '132', '231', '2020-07-13 14:57:12', 3, '1');
INSERT INTO `tb_bank` VALUES ('2', 1, 1, 1, '平安银行临沂分行', '22222', '有票么1', '11111', '307', '山东', '31', '321', '231', '321', '321', '132', '231', '2020-07-13 14:57:12', 3, '1');
INSERT INTO `tb_bank` VALUES ('3', 1, 1, 1, '平安银行临沂分行', '22222', '有票么1', '11111', '307', '山东', '31', '321', '231', '321', '321', '132', '231', '2020-07-13 14:57:12', 3, '2');

-- ----------------------------
-- Table structure for tb_bill
-- ----------------------------
DROP TABLE IF EXISTS `tb_bill`;
CREATE TABLE `tb_bill`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '票据id',
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '票号',
  `type` int(2) NULL DEFAULT NULL COMMENT '票据类型',
  `drawerName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出票人姓名',
  `draweeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收票人姓名',
  `acceptingBankName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '承兑银行名称',
  `acceptingBankNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '承兑银行行号',
  `acceptingBankType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '承兑银行类型',
  `amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '票面金额',
  `issueDate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签发日',
  `dueDate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '到期日',
  `coverFrontPictureUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '票据正面图URL',
  `coverBackPictures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '票据背面图URL',
  `channelType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '担保渠道',
  `transferBank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回款银行账户资讯',
  `endorseBank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '背书户银行资讯',
  `endorseCount` int(10) NULL DEFAULT NULL COMMENT '背书次数',
  `returnDrawerStatus` int(11) NULL DEFAULT NULL COMMENT '回出票人状态 |-1|取消/未知 |0|否/无 |1|是/有',
  `returnDraweeStatus` int(11) NULL DEFAULT NULL COMMENT '回收款人状态 |-1|取消/未知 |0|否/无 |1|是/有',
  `returnEndorsementStatus` int(11) NULL DEFAULT NULL COMMENT '回头背书状态 |-1|取消/未知 |0|否/无 |1|是/有',
  `doubleEndorsementStatus` int(11) NULL DEFAULT NULL COMMENT '重复背书状态 |-1|取消/未知 |0|否/无 |1|是/有',
  `pledgeStatus` int(11) NULL DEFAULT NULL COMMENT '质押状态 |-1|取消/未知 |0|否/无 |1|是/有',
  `guaranteeStatus` int(11) NULL DEFAULT NULL COMMENT '保证状态 |-1|取消/未知 |0|否/无 |1|是/有',
  `inconsistentStatus` int(11) NULL DEFAULT NULL COMMENT '上下不一致状态 |-1|取消/未知 |0|否/无 |1|是/有',
  `customDefect` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它瑕疵',
  `isDirectSell` bit(1) NULL DEFAULT NULL COMMENT '是否定向交易 true定向交易 false 非定向交易',
  `directBuyerAccount` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易对手账号（交易对手的手机号?） 若isDirectSell为true时，该值必填',
  `feeDeduction` int(11) NULL DEFAULT NULL COMMENT '每十万扣款意向价格',
  `status` int(2) NULL DEFAULT NULL COMMENT '票据状态',
  `createTimeInMillis` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `publisherId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卖方用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '票据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_bill
-- ----------------------------
INSERT INTO `tb_bill` VALUES ('1', '123456789456123', 1, '临沂兴业有限公司', '临沂尚进有限公司', '平安银行', '317', '1', '10000.00', '2020-05-10', '2020-11-10', NULL, NULL, '3', '1', '1', 1, 1, 1, 1, 1, 1, 1, 1, '1', b'1', '12345646', 1250, 1, '2020-07-23 10:20:42', '1');

-- ----------------------------
-- Table structure for tb_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `tb_enterprise`;
CREATE TABLE `tb_enterprise`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业姓名',
  `uscc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '统一社会信用代码-营业执照',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司详细地址',
  `businessLicenseUrl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照图片',
  `accountOpeningLicenseUrl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户许可证图片',
  `legalRepName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人姓名',
  `legalRepId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人身份证',
  `legalRepPhoneNo` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人手机号码',
  `legalRepIdPicFrontUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人身份证正面照片',
  `legalRepIdPicBackUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人身份证背面照片',
  `province` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `businessExpirationDate` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照到期时间',
  `idcardExpirationDate` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人身份证到期时间',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  `userId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `userAccount` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号-注册手机号',
  `operatorId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人员标识',
  `platformId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '平台ID',
  `roleType` int(2) NULL DEFAULT NULL COMMENT '用户角色 1：买方&卖方 2：卖方',
  `handlerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人姓名',
  `handlerId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人身份证号',
  `handlerPhoneNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人手机号',
  `handlerEmail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经办人邮箱地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_enterprise
-- ----------------------------
INSERT INTO `tb_enterprise` VALUES (1, '有票么', '91440300MA5ERB6G5P', '深圳市前海深港合作区前湾一路1号A栋201室（入驻深圳市前海商务秘书有限公司）', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595218606152&di=33c964c3d1dfb8499a3a2e2bdddd2084&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Fsmccloud%2Frecom%2F2015%2F10%2F09%2F144439030780697863.JPEG', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595217258127&di=2cd0fdb976d820c560266d6f4740f15d&imgtype=0&src=http%3A%2F%2Fimg2.jc001.cn%2Fimg%2F994%2F1530994%2F1304%2F13515a97358d5ea.jpg', '李四', '371311186902152665', '18686868686', 'https://up.enterdesk.com/edpic/28/bc/80/28bc80d62c84ea7797197a6d7cb03394.jpg', 'https://exp-picture.cdn.bcebos.com/7a3e980e7c75e5f4caa14cbeb1ceaad7736bbceb.jpg', NULL, NULL, NULL, NULL, '2020-07-13 15:32:47', '2020-07-13 15:32:50', NULL, NULL, NULL, NULL, '18886868686', '1', NULL, 1, '经办人', '371211186901112456', '18686868686', 'jingbanren@163.com');
INSERT INTO `tb_enterprise` VALUES (2, '同城票据网', '91440300MA5ERB6G52', '深圳市前海深港合作区前湾一路1号A栋201室（入驻深圳市前海商务秘书有限公司）', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595218606152&di=33c964c3d1dfb8499a3a2e2bdddd2084&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Fsmccloud%2Frecom%2F2015%2F10%2F09%2F144439030780697863.JPEG', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595217258127&di=2cd0fdb976d820c560266d6f4740f15d&imgtype=0&src=http%3A%2F%2Fimg2.jc001.cn%2Fimg%2F994%2F1530994%2F1304%2F13515a97358d5ea.jpg', '李四', '371311186902152665', '18686868686', 'https://up.enterdesk.com/edpic/28/bc/80/28bc80d62c84ea7797197a6d7cb03394.jpg', 'https://exp-picture.cdn.bcebos.com/7a3e980e7c75e5f4caa14cbeb1ceaad7736bbceb.jpg', NULL, NULL, NULL, NULL, '2020-07-13 15:32:47', '2020-07-13 15:32:50', NULL, NULL, NULL, NULL, '18886868686', '1', NULL, 1, '经办人', '371211186901112456', '18686868686', 'jingbanren@163.com');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标识',
  `category` int(2) NULL DEFAULT NULL COMMENT '订单类型（|1|入平台 |2|出平台 |3|财务）',
  `status` int(5) NULL DEFAULT NULL COMMENT '订单状态（|-1|已取消 |2|议价中 |3|议价成功 |4|议价被拒绝 |200|待打款 |201|待背书 |202|待签收 |203|待校验 |204|交易成功 |205|交易失败 |206|校验失敗）',
  `feeDeduction` double(10, 0) NULL DEFAULT NULL COMMENT '意向价格（每十万扣款）',
  `serviceFee` double(10, 0) NULL DEFAULT NULL COMMENT '平台服务费',
  `value` double(10, 0) NULL DEFAULT NULL COMMENT '订单价格（交易金额？）',
  `billId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '票据id',
  `platformId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '平台id',
  `buyerId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买方id',
  `directBuyerAccount` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买方账号？',
  `isDirectSell` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否定向交易',
  `redirectPayUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付地址（京东返回）',
  `reqNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求流水号',
  `transactionId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('10', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('11', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('2', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('3', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('4', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('5', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('6', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('7', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('8', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');
INSERT INTO `tb_order` VALUES ('9', 1, 1, 1500, 120, 150000, '1', '1', '1', '', '0', NULL, '12532651361', '1223212346123');

-- ----------------------------
-- Table structure for tb_platform
-- ----------------------------
DROP TABLE IF EXISTS `tb_platform`;
CREATE TABLE `tb_platform`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '平台id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '平台名称',
  `website` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络名称',
  `manager` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phoneNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联络电话',
  `status` int(5) NULL DEFAULT NULL COMMENT '平台状态（1：在线，2：离线）',
  `valid` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否为有效平台',
  `createTimeInMillis` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
