create table if not exists Ingredient
(
    id   varchar(36) not null primary key,
    name varchar(25) not null,
    type varchar(10) not null
);
create table if not exists Taco
(
    id        varchar(36) not null primary key,
    name      varchar(50) not null,
    createdAt timestamp   not null
);
create table if not exists Taco_Ingredients
(
    taco_id        varchar(36) not null,
    ingredients_id varchar(36) not null
);
alter table Taco_Ingredients
    add foreign key (taco_id) references Taco (id);
alter table Taco_Ingredients
    add foreign key (ingredients_id) references Ingredient (id);
create table if not exists Taco_Order
(
    id             varchar(36) not null primary key,
    deliveryName   varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity   varchar(50) not null,
    deliveryState  varchar(2)  not null,
    deliveryZip    varchar(10) not null,
    ccNumber       varchar(16) not null,
    ccExpiration   varchar(5)  not null,
    ccCVV          varchar(3)  not null,
    placedAt       timestamp   not null
);
create table if not exists Taco_Order_Tacos
(
    order_id varchar(36) not null,
    tacos_id  varchar(36) not null
);
alter table Taco_Order_Tacos
    add foreign key (order_id) references Taco_Order (id);
alter table Taco_Order_Tacos
    add foreign key (tacos_id) references Taco (id);