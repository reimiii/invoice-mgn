create database invoice;
use invoice;

create table payment_provider
(
    id   varchar(36),
    code varchar(100) not null,
    name varchar(100) not null,
    primary key (id),
    constraint payment_provider_unique unique (code)
);

select *
from payment_provider;

drop table payment_provider;

create table invoice_type
(
    id varchar(36),
    primary key (id)
);

create table invoice
(
    id varchar(36),
    primary key (id)
);

create table virtual_account
(
    id varchar(36),
    primary key (id)
);
