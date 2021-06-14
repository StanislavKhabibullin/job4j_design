create table users( 
	id serial primary key,
        name varchar(2000),
	users_id_role int references role(id); 
 	 );
create table role(
	id serial primary key,
	name varchar(2000)
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
	name varchar(2000),
	item_id_users int references users(id); 
	categoryy_id_item int references category(id); 
	state_id_item int references state(id); 
	);

create table comments(
	id serial primary key,
	name varchar(200),
	comments_id_item int references item(id); 
	);
	
create table attachs(
	id serial primary key,
	name varchar(200),
	attacha_id_item int references item(id); 
	);

create table category(
	id serial primary key,
	name varchar(200),
	);

create table state(
	id serial primary key,
	name varchar(200),
	);
