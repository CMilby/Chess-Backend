/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 14:49:38 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-04-20 19:20:39
 */
SET DATABASE SQL SYNTAX ORA TRUE;

create table ACTIVE_GAMES (
	id 				VARCHAR2(100 CHAR),
	start_dttm 		DATE,
	game_format		VARCHAR2(100 CHAR),
	current_move	VARCHAR2(100 CHAR)
)

create table ACTIVE_GAME_PLAYERS (
	game_id 		VARCHAR2(100 CHAR),
	player_id		NUMBER,
	color			VARCHAR2(100 CHAR)
)

create table FINISHED_GAMES (
	id 				VARCHAR2(100 CHAR),
	start_dttm 		DATE,
	finished_dttm	DATE,
	winner			VARCHAR2(100 CHAR),
	game_format		VARCHAR2(100 CHAR)
)

create table PLAYER_GAMES (
	player_id		NUMBER,
	game_id			VARCHAR2(100 CHAR),
	color 			VARCHAR2(100 CHAR)
)