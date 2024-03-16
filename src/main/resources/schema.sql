CREATE TABLE
    tasks (
        id INT AUTO_INCREMENT PRIMARY KEY,
        description VARCHAR(250),
        status INT,
        creation_date DATE
    );

-- Crear la tabla Persona
CREATE TABLE
    persona (
        id INT AUTO_INCREMENT PRIMARY KEY,
        telefono VARCHAR(255),
        nombre VARCHAR(255),
        apellido VARCHAR(255),
        dni VARCHAR(20)
    );