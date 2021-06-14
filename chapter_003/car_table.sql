CREATE TABLE carBody(
	id serial primary key,
	name varchar(35)
);
CREATE TABLE carEngine(
	id serial primary key,
	name varchar(35)
);
CREATE TABLE transmission(
	id serial primary key,
	name varchar(35)
);
CREATE TABLE car(
	id serial primary key,
	name varchar(35),
	eng_id INT REFERENCES carEngine(id),
	body_id INT REFERENCES carBody(id),
	trans_id INT REFERENCES transmission(id)
);

INSERT INTO transmission (name) VALUES
('automat'),
('mechanick'),
('robotik'),
('variator');

INSERT INTO carBody (name) VALUES
('miniven'),
('cabrick'),
('sedan'),
('hatch');

INSERT INTO carEngine (name) VALUES
('diesel'),
('electro'),
('gasoline')
;

INSERT INTO car(name, eng_id, body_id, trans_id) VAlUES 
 	('solaris', 1, 2, 3),
	('elantra', 2, 4, 1),
	('lada', 3, 1, 3),
	('Niva', 3, 2, 3),
	('ZAZ', 1, 2, 2),
	('LAZ', 3, 4, 3),
	('IZ', 2, 2, 3),
	('UAZ', 1, 3, 1),
	('HUNTER', 1, 3, 4),
	('Cerato', 2, 2, 1);


1) Вывести список всех машин и все привязанные к ним детали.

SELECT * FROM car as s JOIN
	transmission as ts on s.trans_id = ts.id
	JOIN
	carBody as cs on s.body_id = cs.id
	JOIN
	carEngine as ce on s.eng_id = ce.id;

2) Вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине, кузова, двигатели, коробки передач.
SELECT * FROM transmission as s LEFt JOIN car as cs on s.id = cs.trans_id where cs.trans_id is null
 ;

SELECT * FROM carEngine as s LEFt JOIN car as cs on s.id = cs.eng_id where cs.eng_id is null
 ;

SELECT * FROM carBody as s LEFt JOIN car as cs on s.id = cs.body_id where cs.body_id is null
 ;