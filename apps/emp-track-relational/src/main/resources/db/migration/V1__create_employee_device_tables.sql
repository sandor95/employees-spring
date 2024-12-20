CREATE TABLE EMPLOYEE
(
    ID            BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'Employee ID',
    SURNAME       VARCHAR(50) NOT NULL COMMENT 'Employee surname',
    LASTNAME      VARCHAR(50) NOT NULL COMMENT 'Employee last name',
    LASTNAME2     VARCHAR(50) COMMENT 'Optional second last name',
    DATE_OF_BIRTH DATE        NOT NULL COMMENT 'Employee date of birth'
) AUTO_INCREMENT = 100;

CREATE TABLE DEVICE
(
    ID          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'Device ID',
    EMPLOYEE_ID BIGINT       NOT NULL COMMENT 'Employee ID',
    NAME        VARCHAR(100) NOT NULL COMMENT 'Device name',
    DETAILS     VARCHAR(255) COMMENT 'Device details',
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID) ON DELETE CASCADE
) AUTO_INCREMENT = 100;