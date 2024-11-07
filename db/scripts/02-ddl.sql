CREATE TABLE kyndryl.category (
    id serial primary key,
    name varchar(255) not null
);

CREATE TABLE kyndryl.product (
    id serial primary key,
    name varchar(255) not null,
    category int4 references kyndryl.category(id)
);

CREATE INDEX prod_cate_idx on kyndryl.product(category);
CREATE INDEX cate_name_idx on kyndryl.category(name);

