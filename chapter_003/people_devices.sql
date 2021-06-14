create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into people(name) values ('Аня');
insert into people(name) values ('Ваня');
insert into people(name) values ('Боря');

insert into devices(name, price) values ('Phone', 7990.2);
insert into devices(name, price) values ('TV', 21987.5);
insert into devices(name, price) values ('Washing maschine', 35555);
insert into devices(name, price) values ('Audio_column', 3777.9);

insert into devices_people(people_id, device_id) values (10, 9);
insert into devices_people(people_id, device_id) values (10, 11);
insert into devices_people(people_id, device_id) values (10, 12);

insert into devices_people(people_id, device_id) values (11, 9);
insert into devices_people(people_id, device_id) values (11, 10);
insert into devices_people(people_id, device_id) values (11, 12);

insert into devices_people(people_id, device_id) values (12, 9);
insert into devices_people(people_id, device_id) values (12, 10);
insert into devices_people(people_id, device_id) values (12, 11);
insert into devices_people(people_id, device_id) values (12, 12);

средняя цена устройств для человека:

select s.name, avg(ss.price) from devices as ss
		 JOIN devices_people ns on ss.id = ns.device_id
         JOIN people s on s.id = ns.people_id
		 group by s.name;

условие с ограничением стоимости:

select s.name, avg(ss.price) from devices as ss
		 JOIN devices_people ns on ss.id = ns.device_id
         JOIN people s on s.id = ns.people_id
		 group by s.name
		 having avg(ss.price) > 12000;

Средние цены на устройства

select ss.name, avg(ss.price) from devices as ss
		 JOIN devices_people ns on ss.id = ns.device_id
         JOIN people s on s.id = ns.people_id
		 group by ss.name;
		 


