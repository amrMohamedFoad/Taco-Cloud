create table if not exists Ingredient (
  id varchar(4) not null,
  name varchar(25) not null,
  type ENUM('WRAP', 'PROTEIN', 'VEGGIES', 'CHEESE', 'SAUCE'),
  PRIMARY KEY (id)
);
create table if not exists Taco (
  id identity,
  name varchar(50) not null,
  created_At timestamp not null,
  PRIMARY KEY (id)
);
create table if not exists Taco_Ingredients (
  taco bigint not null,
  ingredient varchar(4) not null
);

alter table Taco_Ingredients
    add foreign key (taco) references Taco(id);

alter table Taco_Ingredients
    add foreign key (ingredient) references Ingredient(id);

create table if not exists Taco_Order (
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(10) not null,
    delivery_Zip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null,
    placedAt timestamp not null,
    PRIMARY KEY (id)
);
create table if not exists Taco_Order_Tacos (
  tacoOrder bigint not null,
  taco bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (tacoOrder) references Taco_Order(id);

alter table Taco_Order_Tacos
    add foreign key (taco) references Taco(id);
