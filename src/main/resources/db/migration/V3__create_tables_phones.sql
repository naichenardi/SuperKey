CREATE TABLE phones
(
    id BIGINT auto_increment primary key,
    country_code varchar(5),
    regional_code varchar(4),
    phone varchar(15)
);