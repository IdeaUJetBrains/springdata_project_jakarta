
CREATE TABLE ENTITYBUSVERSION
(
    EID INT not null PRIMARY KEY,
    VERSION INT,
    NATID VARCHAR(255) constraint "ENTITYBUSVERSION_pk" unique,
    BUSID INT

);

create table MYBUS
(
    ID  INT identity primary key
);


alter table ENTITYBUSVERSION
    add constraint ENTITYBUSVERSION_MYBUS_ID_FK
        foreign key (BUSID) references MYBUS;


-- =====================================
INSERT INTO MYBUS  VALUES('1111');
INSERT INTO MYBUS VALUES('2222');

INSERT INTO ENTITYBUSVERSION  VALUES('1',11, '111', '1111');
INSERT INTO ENTITYBUSVERSION VALUES('2', 22, '222', '2222');
