CREATE DATABASE IF NOT EXISTS rent_db;
USE rent_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    role ENUM('admin', 'tenant', 'landlord') NOT NULL
);

CREATE TABLE properties (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address TEXT,
    rent_amount DOUBLE NOT NULL,
    landlord_id INT NOT NULL,
    FOREIGN KEY (landlord_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE rent_payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tenant_id INT NOT NULL,
    property_id INT NOT NULL,
    amount_paid DOUBLE NOT NULL,
    payment_date DATETIME NOT NULL DEFAULT NOW() ,
    FOREIGN KEY (tenant_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (property_id) REFERENCES properties(id) ON DELETE CASCADE
);

INSERT INTO users (username, password, role)
VALUES ('admin', 'admin123', 'admin');

select *  from users;

show databases


