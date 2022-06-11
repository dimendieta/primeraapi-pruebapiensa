CREATE TABLE IF NOT EXISTS Usuario(
    id SERIAL,
    username VARCHAR (100) NOT NULL,
    password VARCHAR (100) NOT NULL,
    PRIMARY KEY (id)

    );


CREATE TABLE IF NOT EXISTS Docente(
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  direccion VARCHAR (100) NOT NULL,
  correo VARCHAR (100) NOT NULL,

  PRIMARY KEY (id)

  );

CREATE TABLE IF NOT EXISTS Tarea (
    id SERIAL,
    descripcion VARCHAR (100) NOT NULL,
    dificultad VARCHAR (100) NOT NULL ,
    docente_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (docente_id) REFERENCES Docente (id)
    );

CREATE TABLE IF NOT EXISTS Deporte(
    id SERIAL,
    name VARCHAR (100) NOT NULL,
    hora VARCHAR (100) NOT NULL,
    cancha VARCHAR (100) NOT NULL,

    PRIMARY KEY (id)

    );