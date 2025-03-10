CREATE DATABASE testdb;
use testdb;

CREATE TABLE PRODUCT(
    release_name VARCHAR(255) NOT NULL,
    crq VARCHAR(55) PRIMARY KEY,
    status VARCHAR(255) NOT NULL,
    rating INT NOT NULL
);

INSERT INTO PRODUCT (release_name, crq, status, rating) VALUES ('Release A','CRQ011921','In Progress', 5);
INSERT INTO PRODUCT (release_name, crq, status, rating) VALUES ('Release B','CRQ013921','Progress', 3);

commit;
