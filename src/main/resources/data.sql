insert into users (username, password, enabled) values ('user1', 'pass1', true);
insert into users (username, password, enabled) values ('user2', 'pass2', false);
insert into users (username, password, enabled) values ('user3', 'pass3', false);

insert into authorities (username, authority) values ('user', 'ROLE_ADMIN');