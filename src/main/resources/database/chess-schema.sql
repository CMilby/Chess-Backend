/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:49:38 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-19 11:29:38
 */
SET DATABASE SQL SYNTAX ORA TRUE;

create table ACTIVE_GAMES (
	id 				VARCHAR2(100 CHAR),
	start_dttm 		DATE,
	game_format		VARCHAR2(100 CHAR),
	current_move	VARCHAR2(100 CHAR)
)

create table ACTIVE_GAMES_USER (
	game_id 		VARCHAR2(100 CHAR),
	user_id			NUMBER,
	color			VARCHAR2(100 CHAR)
)

create table COMPLETED_GAMES (
	id 				VARCHAR2(100 CHAR),
	start_dttm 		DATE,
	finished_dttm	DATE,
	winner			VARCHAR2(100 CHAR),
	game_format		VARCHAR2(100 CHAR)
)

create table COMPLETED_GAMES_USER (
	user_id			NUMBER,
	game_id			VARCHAR2(100 CHAR),
	color 			VARCHAR2(100 CHAR)
)