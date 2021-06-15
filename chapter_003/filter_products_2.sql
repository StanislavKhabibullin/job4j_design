CREATE TABLE type (
	id int primary key,
        name varchar(50)
);
CREATE TABLE product (
	id int primary key,
        name varchar(50),
	type_id INT REFERENCES type(id),
	expired_data date,
	price float
);

insert into type VALUES
	(1, 'сырный продукт'),
	(2, 'бакалея'),
	(3, 'заморозка'),
	(4, 'сладости');
INSERT INTO product VALUES 
	(1, 'сыр', 1, '2021-07-12', 100.12),
	(2, 'молоко', 1, '2021-09-12', 70.12),
	(3, 'макароны', 2, '2021-09-02', 50),
	(4, 'рис', 2, '2021-09-10', 60.88),
	(5, 'перловка', 2, '2021-09-10', 25.15),
	(6, 'брокколи', 3, '2021-08-12', 105.12),
	(7, 'цветная капуста', 3, '2021-08-12', 103.18),
	(8, 'мороженное', 4, '2021-07-12', 70.12),
	(9, 'конфеты', 4, '2021-12-12', 30.12),
	(10, 'сырные палочки', 4, '2021-12-10', 40.12),
	(11, 'сырное лакомство', 4, '2021-12-19', 80.12);


select * from product
  JOIN type p on product.type_id = p.id
 where p.name='сыр'; 

select * from product
  where name LIKE('%морожен%'); 

Запрос продуктов с истекшим сроком годности
SELECT * FROM product 
	where expired_date < NOW(); 

Максимальная стоимость продукта:
SELECT product.name, price FROM product
WHERE
price = (SELECT MAX(price) FROM product) ;


5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
SELECT p.name, COUNT(product.name) FROM product as p
JOIN type as t ON
p.type_id = t.id
group by t.name;


6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT * FROM product as p
JOIN type as t ON
p.type_id = t.id
where t.name = 'молоко' OR 
t.name = 'сыр'
;

7

SELECT p.name, COUNT(product.name) FROM product as p
JOIN type as t ON
p.type_id = t.id
group by t.name
having COUNT(p.name) < 10;


8. Вывести все продукты и их тип.
SELECT * FROM product as p
JOIN type as t ON
p.type_id = t.id;


	