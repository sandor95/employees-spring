INSERT INTO EMPLOYEE (SURNAME, LASTNAME, LASTNAME2, DATE_OF_BIRTH)
VALUES ('Smith', 'John', 'Doe', '1985-03-15'),
       ('Johnson', 'Jane', NULL, '1990-07-20'),
       ('Williams', 'Michael', 'Lee', '1980-12-30'),
       ('Brown', 'Emily', NULL, '1995-01-05'),
       ('Davis', 'Chris', 'Jones', '1987-08-25');

INSERT INTO DEVICE (EMPLOYEE_ID, NAME, DETAILS)
VALUES (100, 'Laptop', 'Dell XPS 13'),
       (100, 'Smartphone', 'iPhone 12'),
       (100, 'Tablet', 'iPad Pro'),
       (100, 'Smartwatch', 'Apple Watch'),
       (100, 'Headphones', 'Bose Noise Cancelling');

INSERT INTO DEVICE (EMPLOYEE_ID, NAME, DETAILS)
VALUES (101, 'Laptop', 'MacBook Air');

INSERT INTO DEVICE (EMPLOYEE_ID, NAME, DETAILS)
VALUES (102, 'Laptop', 'Lenovo ThinkPad');

INSERT INTO DEVICE (EMPLOYEE_ID, NAME, DETAILS)
VALUES (103, 'Smartphone', 'Samsung Galaxy S21');

INSERT INTO DEVICE (EMPLOYEE_ID, NAME, DETAILS)
VALUES (104, 'Smartwatch', 'Garmin Fenix 6');