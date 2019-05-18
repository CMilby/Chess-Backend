/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 13:51:23 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 09:22:22
 */

 SET DATABASE SQL SYNTAX ORA TRUE;

create table ROLE (
	id 			NUMBER NOT NULL,
	role_name 	VARCHAR2(100 CHAR) NOT NULL
)

create table USER (
	id				NUMBER NOT NULL,
	username 		VARCHAR2(100 CHAR) NOT NULL,
	email 			VARCHAR2(200 CHAR) NOT NULL,
	password 		VARCHAR2(500 CHAR) NOT NULL,
	first_name 		VARCHAR2(100 CHAR),
	last_name 		VARCHAR2(100 CHAR),
)

create table USER_ROLE (
	user_id 	NUMBER NOT NULL,
	role_id 	NUMBER NOT NULL
);