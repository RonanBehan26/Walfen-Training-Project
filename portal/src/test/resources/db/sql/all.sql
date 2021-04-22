delete from company;
delete from user;
delete from address;
delete from employee;

insert into company (id, name, city) values (1, 'Company 1', 'Krakow');
insert into company (id, name, city) values (2, 'Company 2', 'Cork');
insert into company (id, name, city) values (3, 'Company 3', 'Madrid');

insert into user (id, first_name, last_name) values (1, 'John', 'Burke');
insert into user (id, first_name, last_name) values (2, 'Pat', 'Glen');
insert into user (id, first_name, last_name) values (3, 'Jane', 'Doe');

insert into address (id, street, city, country) values (1, 'Cahirdown', 'Listowel', 'Ireland');
insert into address (id, street, city, country) values (2, 'Palace', 'Cork', 'Ireland');
insert into address (id, street, city, country) values (3, 'Grafton', 'Dublin', 'Ireland');

insert into employee (id, first_name, last_name, company, position) values (1, 'John', 'Burke', 'Google', 'Manager');
insert into employee (id, first_name, last_name, company, position) values (2, 'Pat', 'Glen', 'Amazon', 'Clerk');
insert into employee (id, first_name, last_name, company, position) values (3, 'Jane', 'Doe', 'Facebook', 'Director');


