-- BEGIN
DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    price integer NOT NULL
);

-- END
