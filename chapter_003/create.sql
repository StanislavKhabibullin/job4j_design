create table users( id serial primary key, name varchar(2000) );
create table role(
	id serial primary key,
	name varchar(2000),
	users_id int references users(id)
);
create table rules(
	id serial primary key,
	name varchar(2000)
);
create table rules_role(
	id serial primary key,
	relus_id int references rules(id),
	role_id int references role(id)
	);
create table item(
	id serial primary key,
	name varchar(2000)
	);
alter table users add column
users_id int references item(id);  
create table comments(
	id serial primary key,
	name varchar(200)
	);
	
alter table item add column
item_id int references comments(id);  	
create table attachs(
	id serial primary key,
	name varchar(200)
	);
alter table item add column
itemid int references attachs(id);  
create table category(
	id serial primary key,
	name varchar(200),
	category_id int references item(id)
	);
create table state(
	id serial primary key,
	name varchar(200),
	state_id int references item(id)
	);
alter table users add column
users_id_role int references role(id); 
alter table item add column
item_id_users int references users(id); 
alter table attachs add column
attacha_id_item int references item(id); 
alter table item add column
categoryy_id_item int references category(id); 
alter table item add column
state_id_item int references state(id); 