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
