INSERT INTO treatment (duration_in_minutes,price,name) VALUES (10,3,'Head Wash');
INSERT INTO treatment (duration_in_minutes,price,name) VALUES (30,10,'Haircut');
INSERT INTO treatment (duration_in_minutes,price,name) VALUES (10,5,'Beard Trim');
INSERT INTO appointment (customer_name, phone_number, treatment_id, reserve_start, reserve_finish) VALUES ('Nikos Papadopoulos', '6912345678', 2, '2026-10-27 10:00:00', '2026-10-27 10:30:00');
INSERT INTO appointment (customer_name, phone_number, treatment_id, reserve_start, reserve_finish) VALUES ('Giorgos Ioannou', '6987654321', 3, '2026-10-27 10:30:00', '2026-10-27 10:40:00');
INSERT INTO appointment (customer_name, phone_number, treatment_id, reserve_start, reserve_finish) VALUES ('Maria Kosta', '6944556677', 1, '2026-10-28 12:00:00', '2026-10-28 12:10:00');