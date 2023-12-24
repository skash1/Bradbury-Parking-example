INSERT INTO ACCOUNT (id, account_type, amount) VALUES (1, 'PARKING_OWNER', 1000);
INSERT INTO ACCOUNT (id, account_type, amount) VALUES (2, 'PARKING_OWNER', 20);
INSERT INTO ACCOUNT (id, account_type, amount) VALUES (3, 'USER', 400);
INSERT INTO ACCOUNT (id, account_type, amount) VALUES (4, 'USER', 500);
INSERT INTO ACCOUNT (id, account_type, amount) VALUES (5, 'USER', 600);

INSERT INTO PARKING (id, `name`, owner_id) VALUES (1, 'Great Parking of Victoria', 2);
INSERT INTO PARKING (id, `name`, owner_id) VALUES (2, 'South Lanes', 1);

INSERT INTO PARK_PLACE (id, capacity_used, `size`, take_moment, parking_id) VALUES (1, 0, 'L', null, 1);
INSERT INTO PARK_PLACE (id, capacity_used, `size`, take_moment, parking_id) VALUES (2, 0, 'L', null, 1);
INSERT INTO PARK_PLACE (id, capacity_used, `size`, take_moment, parking_id) VALUES (3, 0, 'L', null, 1);
INSERT INTO PARK_PLACE (id, capacity_used, `size`, take_moment, parking_id) VALUES (4, 0, 'L', null, 1);

INSERT INTO PARK_PLACE (id, capacity_used, `size`, take_moment, parking_id) VALUES (5, 0, 'M', null, 2);
INSERT INTO PARK_PLACE (id, capacity_used, `size`, take_moment, parking_id) VALUES (6, 0, 'M', null, 2);
INSERT INTO PARK_PLACE (id, capacity_used, `size`, take_moment, parking_id) VALUES (7, 0, 'S', null, 2);
INSERT INTO PARK_PLACE (id, capacity_used, `size`, take_moment, parking_id) VALUES (8, 0, 'S', null, 2);

INSERT INTO TRANSPORT (id, transport_type, owner_id, park_place_id) VALUES (1, 'MOTORCYCLE', 3, null);
INSERT INTO TRANSPORT (id, transport_type, owner_id, park_place_id) VALUES (2, 'CAR', 3, null);
INSERT INTO TRANSPORT (id, transport_type, owner_id, park_place_id) VALUES (3, 'TRUCK', 4, null);
INSERT INTO TRANSPORT (id, transport_type, owner_id, park_place_id) VALUES (4, 'CAR', 5, null);

INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (1, true, 1, 10, 'CAR', 'MINUTES', 0, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (2, true, 10, 60, 'CAR', 'MINUTES', 300, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (3, false, 1, 3, 'CAR', 'HOURS', 250, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (4, false, 3, 24, 'CAR', 'HOURS', 200, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (5, false, 1, 365, 'CAR', 'DAYS', 780, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (6, true, 0, 30, 'MOTORCYCLE', 'MINUTES', 0, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (7, true, 30, 60, 'MOTORCYCLE', 'MINUTES', 200, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (8, false, 1, 6, 'MOTORCYCLE', 'HOURS', 190, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (9, false, 6, 24, 'MOTORCYCLE', 'HOURS', 140, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (10, false, 1, 365, 'MOTORCYCLE', 'DAYS', 690, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (11, true, 0, 10, 'TRUCK', 'MINUTES', 0, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (12, true, 10, 60, 'TRUCK', 'MINUTES', 300, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (13, false, 1, 3, 'TRUCK', 'HOURS', 270, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (14, false, 3, 24, 'TRUCK', 'HOURS', 240, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (15, false, 1, 365, 'TRUCK', 'DAYS', 1070, 1);

INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (16, true, 0, 10, 'CAR', 'MINUTES', 0, 2);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (17, true, 10, 60, 'CAR', 'MINUTES', 300, 2);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (18, false, 1, 3, 'CAR', 'HOURS', 250, 2);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (19, false, 3, 24, 'CAR', 'HOURS', 200, 2);

INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (20, false, 0, 60, 'CAR', 'SECONDS', 0, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (21, false, 0, 60, 'MOTORCYCLE', 'SECONDS', 0, 1);
INSERT INTO COST_RATE (id, account_whole_period, min_bound, max_bound, transport_type, unit, amount, parking_id) VALUES (22, false, 0, 60, 'TRUCK', 'SECONDS', 0, 1);

