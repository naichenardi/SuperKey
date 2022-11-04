CREATE TABLE vault(
         id BIGINT auto_increment primary key,
         name varchar(100),
         code varchar(200),
         fk_account_id bigint,
         FOREIGN KEY (fk_account_id) REFERENCES super_key.accounts(id)
)