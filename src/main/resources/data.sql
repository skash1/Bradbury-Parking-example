INSERT INTO ACCOUNT (id, account_type, amount) VALUES (1, 'PARKING_OWNER', 1000);
INSERT INTO ACCOUNT (id, account_type, amount) VALUES (2, 'PARKING_OWNER', 20);
INSERT INTO ACCOUNT (id, account_type, amount) VALUES (3, 'USER', 400);
INSERT INTO ACCOUNT (id, account_type, amount) VALUES (4, 'USER', 500);
INSERT INTO ACCOUNT (id, account_type, amount) VALUES (5, 'USER', 600);

INSERT INTO BILLING_PLAN (id, name) VALUES (1, 'Usual billing plan');
INSERT INTO BILLING_PLAN (id, name) VALUES (2, 'Holiday BP');

INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (1, true, 0, 1, 'MINUTES', 30, 'MOTORCYCLE', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (2, true, 100, 2, 'MINUTES', 70, 'MOTORCYCLE', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (3, false, 70, 3, 'HOURS', 2, 'MOTORCYCLE', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (4, false, 80, 4, 'HOURS', 2147483647, 'MOTORCYCLE', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (5, true, 0, 1, 'MINUTES', 10, 'CAR', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (6, true, 300, 2, 'MINUTES', 50, 'CAR', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (7, false, 250, 3, 'HOURS', 2, 'CAR', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (8, false, 200, 4, 'HOURS', 2147483647, 'CAR', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (9, true, 0, 1, 'MINUTES', 20, 'TRUCK', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (10, true, 400, 2, 'MINUTES', 140, 'TRUCK', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (11, false, 150, 3, 'HOURS', 2, 'TRUCK', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (12, false, 130, 4, 'HOURS', 2147483647, 'TRUCK', 1);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (13, false, 1, 1, 'SECONDS', 2147483647, 'MOTORCYCLE', 2);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (14, false, 1, 1, 'SECONDS', 2147483647, 'CAR', 2);
INSERT INTO BILLING_PERIOD (id, account_whole_period, cost, index, unit, unit_number, transport_type, billing_plan_id) VALUES (15, false, 1, 1, 'SECONDS', 2147483647, 'TRUCK', 2);

INSERT INTO PARKING (id, `name`, billing_plan_id, owner_id) VALUES (1, 'Great Parking of Victoria', 1, 2);
INSERT INTO PARKING (id, `name`, billing_plan_id, owner_id) VALUES (2, 'South Lanes', 2, 1);

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
