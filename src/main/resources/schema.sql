create table netology.customers
(
    id           serial primary key,
    name         varchar(50),
    surname      varchar(50),
    age          integer,
    phone_number varchar(90)
);

create table netology.orders
(
    id           serial primary key,
    date         date,
    customer_id  integer references netology.customers (id),
    product_name varchar(255),
    amount       integer
);
