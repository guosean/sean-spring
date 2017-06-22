-- 初始化

drop table employee if exists;
drop table holiday if exists;
drop table leave_holiday if exists;

-- 表结构

--员工信息表
CREATE TABLE employee (
id bigint generated by default as identity ,
staff_id INTEGER,
name varchar(20),
mobile varchar(20),
area varchar(20),
gender INTEGER,
is_valid INTEGER,
PRIMARY KEY (id)
);

--员工假期表
CREATE TABLE holiday (
id bigint generated by default as identity ,
staff_id INTEGER,
sick_num INTEGER,
annual_num INTEGER,
PRIMARY KEY (id)
);

--员工请假表
CREATE TABLE leave_holiday (
id bigint generated by default as identity ,
staff_id INTEGER,
start_date TIMESTAMP,
end_date TIMESTAMP,
day_num INTEGER,
type INTEGER,
area varchar(32),
PRIMARY KEY (id)
);


SET NAMES utf8;
insert into employee (id, staff_id, name, mobile, area, gender, is_valid) values('1','1','赵四','13111111111','北京','1','1');
/*insert into employee (id, staff_id, name, mobile, area, gender, is_valid) values('2','2','张三','15122222222','北京','1','1');
insert into employee (id, staff_id, name, mobile, area, gender, is_valid) values('3','3','李四','18910082222','上海','2','2');
insert into employee (id, staff_id, name, mobile, area, gender, is_valid) values('4','4','张方','15110072222','上海','1','1');
insert into employee (id, staff_id, name, mobile, area, gender, is_valid) values('5','5','小明','15110062222','上海','1','1');
insert into employee (id, staff_id, name, mobile, area, gender, is_valid) values('6','6','旺财','15110052222','上海','1','1');
insert into employee (id, staff_id, name, mobile, area, gender, is_valid) values('7','7','翠花','15110042222','上海','1','1');*/
insert into holiday (id, staff_id, sick_num, annual_num) values('1','1','10','10');
/*insert into holiday (id, staff_id, sick_num, annual_num) values('2','2','8','8');
insert into holiday (id, staff_id, sick_num, annual_num) values('3','3','6','10');
insert into holiday (id, staff_id, sick_num, annual_num) values('4','4','10','6');
insert into holiday (id, staff_id, sick_num, annual_num) values('5','5','10','10');
insert into holiday (id, staff_id, sick_num, annual_num) values('6','6','10','10');
insert into holiday (id, staff_id, sick_num, annual_num) values('7','7','10','1');*/
insert into leave_holiday (id, staff_id, start_date, end_date, day_num, type, area) values('1','2','2016-01-17 00:00:00','2016-01-19 00:00:00','2','1','北京');
/*insert into leave_holiday (id, staff_id, start_date, end_date, day_num, type, area) values('2','4','2016-03-06 00:00:00','2016-03-10 00:00:00','4','1','上海');
insert into leave_holiday (id, staff_id, start_date, end_date, day_num, type, area) values('3','2','2016-01-21 00:00:00','2016-01-22 00:00:00','2','2','北京');*/