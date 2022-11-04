CREATE TABLE users
(
    id BIGINT auto_increment primary key,
    name varchar(100),
    email varchar(200),
    fk_phoneId bigint,
    fk_vaultId bigint,
    FOREIGN KEY (fk_phoneId) REFERENCES super_key.phones(id),
    FOREIGN KEY (fk_vaultId) REFERENCES super_key.vault(id)
);

CREATE TABLE profiles
(
    id BIGINT auto_increment primary key,
    name varchar(100),
    description varchar(300),
    code varchar(10),
    fk_vaultId bigint,
    FOREIGN KEY (fk_vaultId) REFERENCES super_key.vault(id)
);

CREATE TABLE features
(
    id BIGINT auto_increment primary key,
    name varchar(100),
    description varchar(300),
    fk_vaultId bigint,
    FOREIGN KEY (fk_vaultId) REFERENCES super_key.vault(id)
)
