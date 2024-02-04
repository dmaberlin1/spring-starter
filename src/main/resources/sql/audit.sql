ALTER TABLE users
add COLUMN created_at TIMESTAMP;

alter table users
add column modified_at timestamp;

ALTER TABLE users
add COLUMN created_by varchar(32);

alter table users
add column modified_by varchar(32);

