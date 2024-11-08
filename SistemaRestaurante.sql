CREATE DATABASE reservation_system;
USE reservation_system;

-- Table for clients
CREATE TABLE Clients (
    client_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL
);

-- Table for tables in the restaurant
CREATE TABLE Tables (
    table_id INT AUTO_INCREMENT PRIMARY KEY,
    number INT NOT NULL,
    capacity INT NOT NULL
);

-- Table for reservations
CREATE TABLE Reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    table_id INT NOT NULL,
    reservation_datetime DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'Pending',
    FOREIGN KEY (client_id) REFERENCES Clients(client_id),
    FOREIGN KEY (table_id) REFERENCES Tables(table_id)
);