/*
 * @Author: Craig Milby 
 * @Date: 2019-04-20 13:51:20 
 * @Last Modified by: Craig Milby
 * @Last Modified time: 2019-05-18 09:23:51
 */

insert into role ( id, role_name ) values ( 1, 'ROLE_ADMIN' );
insert into role ( id, role_name ) values ( 2, 'ROLE_USER' );

insert into user ( id, username, email, password, first_name, last_name ) values ( 1, 'cmilby', 'craig@craig-chess.com', '$2a$11$iZ5HjYJZgPms1yLuzbPpqegYQnrPztSjcQrVh4MNCkV3UNr6pBHgO', 'Craig', 'Milby' );
insert into user ( id, username, email, password, first_name, last_name ) values ( 2, 'admin', 'admin@craig-chess.com', '$2a$11$7I.ggoCJTbtZrpRBDxfubuqaK5qBoItpidt/XPNapKkz3ffGb/Fga', 'Admin', 'Admin' );
insert into user ( id, username, email, password, first_name, last_name ) values ( 3, 'user', 'user@craig-chess.com', '$2a$11$fMw4XkMacaKBe3o6J7LicuRJeWtuJRZFpsRBfnppGzEwCz4EIS0ya', 'User', 'User' );

insert into user_role ( user_id, role_id ) values ( 1, 1 );
insert into user_role ( user_id, role_id ) values ( 2, 1 );
insert into user_role ( user_id, role_id ) values ( 3, 2 );