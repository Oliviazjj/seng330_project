INSERT INTO users VALUES (1, 'admin', 'admin','user1@gmail.com');
INSERT INTO users VALUES (2, 'op', 'po','user2@gmail.com');

INSERT INTO events VALUES(1,'birthdayParty', 100, '2017-09-07', 'greenSalad','steak','vanillaIceCream','GF',1);
INSERT INTO events VALUES(2,'conference', 100, '2017-09-07', 'gardenSalad','burger','cocoIceCream','GF',2);

INSERT INTO food VALUES (1, 'banana', '2017-09-07', 'vegetable', 20);
INSERT INTO food VALUES (2, 'tomato', '2017-09-07', 'fruit', 20);
INSERT INTO food VALUES (3, 'potato', '2017-09-07', 'vegetable', 20);


INSERT INTO inventory VALUES (1, 'chair', '2017-09-07', 'equipment', 20);
INSERT INTO inventory VALUES (2, 'table', '2017-09-07', 'equipment', 20);
INSERT INTO inventory VALUES (3, 'red wine', '2017-09-07', 'wine', 20);



INSERT INTO contacts VALUES (1, 'James', 'Carter', 'james@gmail.com');
INSERT INTO contacts VALUES (2, 'Helen', 'Leary','leary@gmail.com');
INSERT INTO contacts VALUES (3, 'Linda', 'Douglas','douglas@gmail.com');
INSERT INTO contacts VALUES (4, 'Rafael', 'Ortega','ortega@gmail.com');
INSERT INTO contacts VALUES (5, 'Henry', 'Stevens','henry@gmail.com');
INSERT INTO contacts VALUES (6, 'Sharon', 'Jenkins','jenkins@gmail.com');

INSERT INTO specialties VALUES (1, 'food_vendor');
INSERT INTO specialties VALUES (2, 'inventory_vendor');
INSERT INTO specialties VALUES (3, 'temp_agency');

INSERT INTO contact_specialties VALUES (2, 1);
INSERT INTO contact_specialties VALUES (3, 2);
INSERT INTO contact_specialties VALUES (3, 3);
INSERT INTO contact_specialties VALUES (4, 2);
INSERT INTO contact_specialties VALUES (5, 1);

INSERT INTO types VALUES (1, 'company indoor event');
INSERT INTO types VALUES (2, 'customer outdoor event');
INSERT INTO types VALUES (3, 'company outdoor event');
INSERT INTO types VALUES (4, 'customer outdoor event');
INSERT INTO types VALUES (5, 'other');

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
INSERT INTO employEvents VALUES (2, 'Basil', '2012-08-06', 2, 2);
INSERT INTO employEvents VALUES (3, 'Rosy', '2011-04-17', 1, 3);
INSERT INTO employEvents VALUES (4, 'Jewel', '2010-03-07', 2, 3);
INSERT INTO employEvents VALUES (5, 'Iggy', '2010-11-30', 2, 4);
INSERT INTO employEvents VALUES (6, 'George', '2010-01-20', 1, 5);
INSERT INTO employEvents VALUES (7, 'Samantha', '2012-09-04', 2, 6);
INSERT INTO employEvents VALUES (8, 'Max', '2012-09-04', 1, 6);
INSERT INTO employEvents VALUES (9, 'Lucky', '2011-08-06', 2, 7);
INSERT INTO employEvents VALUES (10, 'Mulligan', '2007-02-24', 1, 8);
INSERT INTO employEvents VALUES (11, 'Freddy', '2010-03-09', 2, 9);
INSERT INTO employEvents VALUES (12, 'Lucky', '2010-06-24', 2, 10);
INSERT INTO employEvents VALUES (13, 'Sly', '2012-06-08', 1, 10);

INSERT INTO employeeShifts VALUES (1, 7, '2013-01-01', 'rabies shot');
INSERT INTO employeeShifts VALUES (2, 8, '2013-01-02', 'rabies shot');
INSERT INTO employeeShifts VALUES (3, 8, '2013-01-03', 'neutered');
INSERT INTO employeeShifts VALUES (4, 7, '2013-01-04', 'spayed');
