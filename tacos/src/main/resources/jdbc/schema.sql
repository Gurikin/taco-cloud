create table if not exists Ingredient (
    id varchar(36) not null primary key,
    name varchar(25) not null,
    type varchar(10) not null,
    created_at timestamp not null default now()
);

create table if not exists Taco (
    id bigserial not null primary key,
    name varchar(50) not null,
    created_at timestamp not null default now()
);

create table if not exists Taco_Ingredients (
    taco_id bigint not null,
    ingredients_id varchar(36) not null
);

alter table
    Taco_Ingredients
add
    foreign key (taco_id) references Taco (id);

alter table
    Taco_Ingredients
add
    foreign key (ingredients_id) references Ingredient (id);

create table if not exists Taco_Order (
    id bigserial not null primary key,
    `name` varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    `state` varchar(2) not null,
    zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    created_at timestamp not null default now()
);

create table if not exists Taco_Order_Tacos (
    order_id bigint not null,
    tacos_id bigint not null
);

alter table
    Taco_Order_Tacos
add
    foreign key (order_id) references Taco_Order (id);

alter table
    Taco_Order_Tacos
add
    foreign key (tacos_id) references Taco (id);

CREATE TABLE users (
    id bigserial not null primary key,
    created_at timestamp,
    city varchar(255),
    full_name varchar(255),
    `password` varchar(255),
    phone_number varchar(255),
    `state` varchar(255),
    street varchar(255),
    username varchar(255) not null,
    zip varchar(255)
);