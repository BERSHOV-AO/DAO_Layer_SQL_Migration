-- changeset 1
create table netology.customers
(
    id           serial primary key,
    name         varchar(50),
    surname      varchar(50),
    age          integer,
    phone_number varchar(90)
);

-- changeset 2
create table netology.orders
(
    id           serial primary key,
    date         date,
    customer_id  integer references netology.customers (id),
    product_name varchar(255),
    amount       integer
);

-- changeset 3
insert into netology.customers (name, surname, age, phone_number)
values ('Aleksey', 'Ivanov', 30, '8950000001');
insert into netology.customers (name, surname, age, phone_number)
values ('Victor', 'Petrov', 32, '8950000002');
insert into netology.customers (name, surname, age, phone_number)
values ('Svata', 'Makarova', 27, '8950000003');
insert into netology.customers (name, surname, age, phone_number)
values ('aleksey', 'Safonov', 34, '8950000004');

-- changeset 3
insert into netology.orders (date, customer_id, product_name, amount)
values (current_date, 1, 'sneakers', 1200);
insert into netology.orders (date, customer_id, product_name, amount)
values (current_date, 2, 'boots', 1500);
insert into netology.orders (date, customer_id, product_name, amount)
values (current_date, 3, 't-shirt', 900);
insert into netology.orders (date, customer_id, product_name, amount)
values (current_date, 4, 'peaked cap', 500);