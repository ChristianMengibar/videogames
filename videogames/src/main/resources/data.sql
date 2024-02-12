INSERT INTO category (uuid, category_name, multiplayer)
VALUES (uuid(), 'Shooter', 'Yes');

INSERT INTO category (uuid, category_name, multiplayer)
VALUES (uuid(), 'Sports', 'Yes');

INSERT INTO category (uuid, category_name, multiplayer)
VALUES (uuid(), 'Adventures', 'No');

INSERT INTO product (uuid, name, platform, launch , rating, description, price)
VALUES (uuid(), 'Fortnite', 'Multiplataforma', '21 Julio 2017', 74, 'Es un shooter gratuito', 'Free');

INSERT INTO product (uuid, name, platform, launch , rating, description, price)
VALUES (uuid(), 'EA FC 24', 'Multiplataforma', '29 Septiembre 2023', 78, 'Juego de futbol de toda la vida', 79.99);

INSERT INTO product (uuid, name, platform, launch , rating, description, price)
VALUES (uuid(), 'God Of War Ragnarok', 'Multiplataforma', '9 Noviembre 2022', 98, 'Juego de aventuras', 79.99);

INSERT INTO user_ (email, password)
VALUES ('user', 'a')