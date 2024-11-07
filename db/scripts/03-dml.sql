INSERT INTO kyndryl.category (id,name) VALUES (0,'Sin categoria');
INSERT INTO kyndryl.category (name) VALUES ('Abarrotes');
INSERT INTO kyndryl.category (name) VALUES ('Servicios');
INSERT INTO kyndryl.category (name) VALUES ('Tecnología');

INSERT INTO kyndryl.product (name,category) VALUES ('Arroz',(SELECT id FROM kyndryl.category WHERE name='Abarrotes'));
INSERT INTO kyndryl.product (name,category) VALUES ('Arriendo de herramientas',(SELECT id FROM kyndryl.category WHERE name='Servicios'));
INSERT INTO kyndryl.product (name,category) VALUES ('Laptop',(SELECT id FROM kyndryl.category WHERE name='Tecnología'));
