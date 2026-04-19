1. Crear la base de datos en MySQL
2. Ejecutar el script create_db.sql
3. Configurar usuario y contraseña en persistence.xml
4. Ejecutar el proyecto

SQL

CREATE DATABASE alexander_paltas_u1;

USE alexander_paltas_u1;

CREATE TABLE alexander_paltas_u1 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    gramaje INT,
    precio DOUBLE,
    termino VARCHAR(50)
);
