INSERT INTO contacts VALUES (1, 'James', 'Carter');
INSERT INTO contacts VALUES (2, 'Helen', 'Leary');
INSERT INTO contacts VALUES (3, 'Linda', 'Douglas');
INSERT INTO contacts VALUES (4, 'Rafael', 'Ortega');
INSERT INTO contacts VALUES (5, 'Henry', 'Stevens');
INSERT INTO contacts VALUES (6, 'Sharon', 'Jenkins');

INSERT INTO specialties VALUES (1, 'food_vendor');
INSERT INTO specialties VALUES (2, 'inventory_vendor');
INSERT INTO specialties VALUES (3, 'temp_agency');

INSERT INTO contact_specialties VALUES (2, 1);
INSERT INTO contact_specialties VALUES (3, 2);
INSERT INTO contact_specialties VALUES (3, 3);
INSERT INTO contact_specialties VALUES (4, 2);
INSERT INTO contact_specialties VALUES (5, 1);

INSERT INTO types VALUES (1, 'early-morning');
INSERT INTO types VALUES (2, '9-12');
INSERT INTO types VALUES (3, '12-3');
INSERT INTO types VALUES (4, '3-6');
INSERT INTO types VALUES (5, '6-9');
INSERT INTO types VALUES (6, 'late-night');

INSERT INTO employees VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT INTO employees VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT INTO employees VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT INTO employees VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
INSERT INTO employees VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
INSERT INTO employees VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
INSERT INTO employees VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT INTO employees VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
INSERT INTO employees VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT INTO employees VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

INSERT INTO employEvents VALUES (1, 'Leo', '2010-09-07', 1, 1);
INSERT INTO employEvents VALUES (2, 'Basil', '2012-08-06', 6, 2);
INSERT INTO employEvents VALUES (3, 'Rosy', '2011-04-17', 2, 3);
INSERT INTO employEvents VALUES (4, 'Jewel', '2010-03-07', 2, 3);
INSERT INTO employEvents VALUES (5, 'Iggy', '2010-11-30', 3, 4);
INSERT INTO employEvents VALUES (6, 'George', '2010-01-20', 4, 5);
INSERT INTO employEvents VALUES (7, 'Samantha', '2012-09-04', 1, 6);
INSERT INTO employEvents VALUES (8, 'Max', '2012-09-04', 1, 6);
INSERT INTO employEvents VALUES (9, 'Lucky', '2011-08-06', 5, 7);
INSERT INTO employEvents VALUES (10, 'Mulligan', '2007-02-24', 2, 8);
INSERT INTO employEvents VALUES (11, 'Freddy', '2010-03-09', 5, 9);
INSERT INTO employEvents VALUES (12, 'Lucky', '2010-06-24', 2, 10);
INSERT INTO employEvents VALUES (13, 'Sly', '2012-06-08', 1, 10);

INSERT INTO employeeShifts VALUES (1, 7, '2013-01-01', 'rabies shot');
INSERT INTO employeeShifts VALUES (2, 8, '2013-01-02', 'rabies shot');
INSERT INTO employeeShifts VALUES (3, 8, '2013-01-03', 'neutered');
INSERT INTO employeeShifts VALUES (4, 7, '2013-01-04', 'spayed');
