insert into users(name) values ('Stanislav');
insert into role(name) values ('admin');
insert into users(name, users_id_role) values ('Stanislav', 1);
insert into rules(name) values ('Egipt');
insert into rules(name) values ('Russia');
insert into rules_role(relus_id, role_id) values (1,1);
insert into rules_role(relus_id, role_id) values (2,1);
insert into item(name, item_id_users) values ('Java', 1);
insert into item(name, item_id_users) values ('JavaScript', 1);
insert into comments(name, comments_id_item) values ('difficult', 3);
insert into comments(name, comments_id_item) values ('variable', 3);
insert into comments(name, comments_id_item) values ('unknown', 4);
insert into attachs(name, attacha_id_item) values ('think', 3);
insert into attachs(name, attacha_id_item) values ('think_for_you', 3);
insert into attachs(name, attacha_id_item) values ('think_for_you', 4);
insert into category(name) values ('Universe');
insert into item(name, item_id_users, categoryy_id_item) values ('Java', 1, 1);
insert into state(name) values ('Korolev');
insert into item(name, state_id_item) values ('Java', 1);





