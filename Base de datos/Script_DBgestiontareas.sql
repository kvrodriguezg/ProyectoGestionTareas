CREATE DATABASE dbgestiontareas;
USE dbgestiontareas;

#Tabla usuarios.
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    rol VARCHAR(255) NOT NULL
);

#Ingreso de datos en tabla usuarios.
INSERT INTO usuarios (username, password, rol)
VALUES
    ('usuario1', '$2y$10$nJc5mtxBcz.xflACKZJxeexgO0QCaIocXnVSIDAAcCLj8YY7/g.vO','Usuario'),
    ('usuario2', '$2y$10$qd8B61YhT1Lh7RBHTm5JXO6M4k0ijxkcMUJcWItNaDYI/7MQ7rGVK','Usuario'),
    ('admin', '$2y$10$MmopIenbE16YLJlWpgjhQeJOCmlQbiMNxfZftVDycQR19tPbUGJNm','Administrativo');

#Tabla tareas.
CREATE TABLE tareas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha VARCHAR(100),
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

#Ingreso de datos en tabla tareas.
INSERT INTO tareas (nombre, descripcion, fecha, usuario_id)
VALUES
    ('Tarea 1', 'Descripción de la tarea 1.', '2023-09-01', 1),
    ('Tarea 2', 'Descripción de la tarea 2.', '2023-09-03', 1),
    ('Tarea 3', 'Descripción de la tarea 3.', '2023-09-02', 2);