drop table coffee if exists ;
create table coffee(
  id bigint auto_increment,
  name varchar(64) not null,
  price bigint not null,
  create_time timestamp ,
  update_time timestamp ,
  primary key(id)
);
insert into coffee(name,price,create_time,update_time) values ('latte',30,now(),now());
insert into coffee(name,price,create_time,update_time) values ('mocha',20,now(),now());