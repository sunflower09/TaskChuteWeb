create table message(id integer primary key, message varchar(128));

create table task(
	id integer auto_increment primary key,
	complete boolean,
	task_type char(2),
	section char(1),
	title varchar(1024), 
	repeat boolean, 
	start_time timestamp, 
	end_time timestamp,
	actual_minute integer,
	);