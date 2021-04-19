create table company (
	id bigint unsigned not null auto_increment, 
	name varchar(100),
	city varchar(200),
	primary key (id),
	unique key uk_company_name (name)
);

create table user (
	id bigint unsigned not null auto_increment, 
	firstName varchar(20),
	lastName varchar(20),
	primary key (id)
);

