CREATE TABLE departments(
    id int primary key,
	name varchar(30)
);

CREATE TABLE emploees(
    id int primary key,
	name varchar(30),
	dep_id int REFERENCES departments(id)
);

insert into departments  VALUES 
(1, 'финансовый'),
(2, 'лизинговый'),
(3, 'страхования'),
(4, 'АХУ'),
(5, 'рогаИкопыта');


insert into emploees  VALUES 
(1, 'Petrov', 1),
(2, 'Ivanov', 2),
(3, 'Sidorov', 2),
(4, 'Iliasov', 1),
(5, 'Rizih', 3),
(6, 'Kolib', 3),
(7, 'Oves', 4),
(8, 'АХУlov', 1);

2. Выполнить запросы с left, rigth, full, cross соединениями

select * from emploees s CROSS JOIN departments p;
select * from departments s LEFT JOIN emploees p
on s.id = p.dep_id;
select * from emploees s RIGHT JOIN departments p
on p.id = s.dep_id;


3. Используя left join найти департаменты, у которых нет работников

select s.name, COUNT(p.name) from departments s LEFT JOIN emploees p on s.id = p.dep_id
group by s.name
having COUNT(p.name) = 0;
Запросы с LEFT и RIGht, которые дают одинаковый результат:

4. Используя left и right join написать запросы, которые давали бы одинаковый результат. 

select * from departments s LEFT JOIN emploees p
on s.id = p.dep_id;

select * from emploees s RIGHT JOIN departments p
on p.id = s.dep_id;

5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары

CREATE TABLE teens(
	id serial primary key,
	name varchar(50),
	gender varchar(30));

insert into teens(name, gender) VAlues
	('Alex', 'male'),
	('Alexey', 'male')
	('Aleksa', 'female')
	('Mary', 'female')
	('Tolik', 'male')
	('Anton', 'male');

select m1.name, m2.name from teens m1 CROSS JOIN teens m2 
where m1.gender <> m2.gender;


