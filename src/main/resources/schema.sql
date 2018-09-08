drop table bank_account if exists;

drop table child if exists;

drop table entity_with_composite_key if exists;

drop table parent if exists;

drop table toy if exists;

drop table user if exists;

drop table друг if exists;

drop table ученик if exists;

drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence
  start with 1
  increment by 1;

create table bank_account (
  id        bigint not null,
  user_id   bigint,
  available bool,
  primary key (id)
);

create table child (
  id        bigint not null,
  age       smallint,
  parent_id bigint,
  primary key (id)
);

create table entity_with_composite_key (
  key1 bigint not null,
  key2 bigint not null,
  primary key (key1, key2)
);

create table parent (
  id   bigint not null,
  name varchar(255),
  primary key (id)
);

create table toy (
  id       bigint not null,
  child_id bigint,
  primary key (id)
);

create table user (
  id bigint not null,
  name varchar(255),
  primary key (id)
);

create table друг (
  id bigint not null,
  primary key (id)
);

create table ученик (
  id             bigint not null,
  возраст        integer,
  название_школы varchar(255),
  друг           bigint,
  primary key (id)
);

alter table bank_account
  add constraint user_id_fk
foreign key (user_id)
references user;

alter table child
  add constraint parent_id_fk
foreign key (parent_id)
references parent;

alter table toy
  add constraint child_id_fk
foreign key (child_id)
references child;

alter table ученик
  add constraint friend_fk
foreign key (друг)
references друг;
