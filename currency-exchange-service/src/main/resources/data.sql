create table if not exists exchange_value (
    id int auto_increment primary key,
    currency_from varchar(255),
    currency_to varchar(255),
    conversion_multiple double ,
    port int
);

insert into exchange_value(id, currency_from, currency_to, conversion_multiple, port) values (1000, 'VND', 'USD', 27, 0);
insert into exchange_value(id, currency_from, currency_to, conversion_multiple, port) values (1001, 'EUR', 'USD', 28, 0);
insert into exchange_value(id, currency_from, currency_to, conversion_multiple, port) values (1002, 'AUD', 'USD', 29, 0);