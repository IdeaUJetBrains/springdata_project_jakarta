create table DATE_AND_TIME
(
    id INT  primary key,
    local_time TIME,
    local_date DATE,
    local_date_time DATETIME,
    offset_time TIME,
    offset_date_time DATETIME,
    time_stamp TIMESTAMP
);


-- //////////////////////////////////////////////

create table ARRAY_TYPES_TABLE
(
    id INT  primary key,
    V_ARRAY_INT     INTEGER ARRAY default ARRAY[],
    V_ARRAY_VARCHAR VARCHAR(20) ARRAY[10]
);
create table BINARY_TYPES_TABLE
(
    id INT  primary key,
    V_BINARY              BINARY(10),
    V_VARBINARY           VARBINARY(255),
    V_BINARY_VARYING      VARBINARY(2),
    V_BLOB                BLOB,
    V_BLOB1               BLOB(1000),
    V_BLOB2               BLOB(1000),
    V_LONGVARBINARY       VARBINARY (256),
    V_BINARY_LARGE_OBJECT BLOB(1048576)
);
create table BIT_TYPES_TABLE
(
    id INT  primary key,
    V_BIT         BIT(1),
    V_BIT10       BIT(10),
    V_BIT_VARYING BIT VARYING(2)
);
create table BOOLEAN_TYPES_TABLE
(
    id INT  primary key,
    V_BOOLEAN BOOLEAN
);
create table CHARACTER_TYPES_TABLE
(
    id INT  primary key,
    V_CHAR         CHARACTER(255),
    V_VARCHAR      VARCHAR(255),
    V_CLOB         CLOB,
    V_LONGVARCHAR  VARCHAR(16777216),
    V_CLOB1        CLOB(30720),
    V_CLOB2        CLOB(1000),
    V_CHARACTER    CHARACTER(10),
    V_CHAR_VARYING VARCHAR(2)
);
create table DATE_TIME_TYPES_TABLE
(
    id INT  primary key,
    V_TIME                        TIME,
    V_TIME_WITHOUT_TIME_ZONE      TIME,
    V_TIME_WITH_TIME_ZONE         TIME WITH TIME ZONE,
    V_DATE                        DATE,
    V_TIMESTAMP_WITH_TIME_ZONE    TIMESTAMP WITH TIME ZONE,
    V_TIMESTAMP_WITHOUT_TIME_ZONE TIMESTAMP,
    V_TIMESTAMP                   TIMESTAMP
);
create table INTERVAL_TYPES_TABLE
(
    id INT  primary key,
    V_INTERVAL_HOUR_TO_MINUTE   INTERVAL HOUR TO MINUTE,
    V_INTERVAL_YEAR_TO_MONTH    INTERVAL YEAR TO MONTH,
    V_INTERVAL_YEAR             INTERVAL YEAR,
    V_INTERVAL_DAY_TO_HOUR      INTERVAL DAY TO HOUR,
    V_INTERVAL_MINUTE_TO_SECOND INTERVAL MINUTE TO SECOND,
    V_INTERVAL_INTERVAL_SECOND  INTERVAL SECOND
);

create table NUMERIC_TYPES_TABLE
(
    id INT  primary key,
    V_TINYINT tinyint,
    V_SMALLINT  smallint,
    V_INTEGER int,
    V_BIGINT bigint,
    V_NUMERIC numeric,
    V_DECIMAL decimal,
    V_DOUBLE double

);


create table NUMBERS_TABLE
(
    id INT  primary key,
    V_TINYINT tinyint,
    V_SMALLINT  smallint,
    V_INTEGER int,
    V_BIGINT bigint,
    V_NUMERIC numeric,
    V_DECIMAL decimal,
    V_DOUBLE double

);


create table OTHER_TYPES_TABLE
(
    id INT  primary key,
    V_OTHER OTHER
);






-- vvvvvvvvvvvvvvvvvvvvvv
create table TABLE_WITH_LISTENER
(
    ID         INTEGER not null
        primary key,
    TITLE      VARCHAR(255),
    AUTHOR     VARCHAR(255),
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP
);
create table STAR
(
    ID        INTEGER identity
        primary key,
    FIRSTNAME VARCHAR(20),
    LASTNAME  VARCHAR(20)
);
