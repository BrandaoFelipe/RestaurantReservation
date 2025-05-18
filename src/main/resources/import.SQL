-- Clientes
INSERT INTO tb_client (name, cpf, email, phone_number) VALUES ('Maria Silva', '123.456.789-00', 'maria@email.com', '11999998888');
INSERT INTO tb_client (name, cpf, email, phone_number) VALUES ('João Souza', '987.654.321-00', 'joao@email.com', '11888887777');

-- Mesas do restaurante
INSERT INTO tb_restaurant_table (table_number, capacity) VALUES (1, 4);
INSERT INTO tb_restaurant_table (table_number, capacity) VALUES (2, 2);
INSERT INTO tb_restaurant_table (table_number, capacity) VALUES (3, 6);

-- Reservas
INSERT INTO tb_reservation (begin_reservation, end_reservation, number_of_people, client_id) VALUES ('2025-05-15 19:00:00', '2025-05-15 21:00:00', 2, 1);

INSERT INTO tb_reservation (begin_reservation, end_reservation, number_of_people, client_id) VALUES ('2025-05-16 20:00:00', '2025-05-16 22:00:00', 4, 2);

-- Associações reserva/mesa
INSERT INTO tb_table_reservation (reservation_id, restaurant_table_id) VALUES (1, 2);
INSERT INTO tb_table_reservation (reservation_id, restaurant_table_id) VALUES (2, 1);
INSERT INTO tb_table_reservation (reservation_id, restaurant_table_id) VALUES (2, 3);

--Criação de usuarios
INSERT INTO tb_user (name, email, password) VALUES ('lotr', 'lotr@gmail.com', '$2a$10$So43N763dyUlDNLg06nfJO1boel./NDjLdjHhkW13.ldaGSgywBLC'); --123lotr
INSERT INTO tb_user (name, email, password) VALUES ('Alicio Black', 'black@gmail.com', '$2a$10$ddU12S3pehDptZJ5M4QubOvPVTSszhF31gMwzRYgkwzrc6P0u0mF.');--123black

--Criação de roles
INSERT INTO tb_role (user_role) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (user_role) VALUES ('ROLE_USER');

--Associação de user_id com roles_id
INSERT INTO tb_user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_roles (user_id, role_id) VALUES (2, 2);
