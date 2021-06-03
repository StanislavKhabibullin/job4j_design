create table sellers(
		id serial primary key,
		name text,
        salary integer,
        birth date);

insert into sellers(name, salary, birth) values('Bill', 1500, 1982/11/21);
insert into sellers(name, salary, birth) values('Bill', 1500, 1982.11.21);
insert into sellers(name, salary, birth) values('Bill', 1500, 1982.21.11);
insert into sellers(name, salary, birth) values('Bill', 1500, 1982.01.11);
insert into sellers(name, salary, birth) values('Bill', 1500, 1982, 01, 11);
insert into sellers(name, salary, birth) values('Bill', 1500, 1982,01,11);
insert into sellers(name, salary, birth) values('Bill', 1500, 19820111);
insert into sellers(name, salary, birth) values('Bill', 1500, 1982\01\11);
insert into sellers(name, salary, birth) values('Bill', 1500, 1982-01-11);
insert into sellers(name, salary, birth) values('Bill', 1500, 1982:01:11);
insert into sellers(name, salary, birth) values('Bill', 1500, '1982-01-11');
insert into sellers(name, salary, birth) values('John', 1700, '1981-02-14');
insert into sellers(name, salary, birth) values('Ann', 1900, '1980-02-28');
select * from sellers;
update sellers set birth = '1986-10-25';
select * from sellers;
delete from sellers;
select * from sellers;
