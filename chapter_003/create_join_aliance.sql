CREATE table Dogs_rate (
	id int primary key,
	size varchar(15)
)
CREATE table Dogs_breed (
	id int primary key,
	breed varchar(30),
	size_id int REFERENCES dogs_rate(id) 
)
 insert into dogs_rate
 VALUES (1, 'small_breed');
 insert into dogs_rate
 VALUES
 (2, 'medium_breed'),
 (3, 'large_breed');
insert into dogs_breed
VALUES
(1, 'shepfherd', 2),
(2, 'chihuahua', 1),
(3, 'husky', 2),
(4, 'mastif', 3),
(5, 'alabay', 3);

select * from dogs_breed inner join dogs_rate p on dogs_breed.size_id = p.id;
select pp.breed, p.size from dogs_breed as pp inner join dogs_rate as p on pp.size_id = p.id;
select pp.breed, p.size, p.id from dogs_breed as pp inner join dogs_rate as p on pp.size_id = p.id;